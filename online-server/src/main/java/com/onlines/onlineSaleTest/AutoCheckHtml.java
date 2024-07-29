package com.onlines.onlineSaleTest;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;
import com.microsoft.playwright.options.LoadState;
import com.onlines.controller.OnlinesSaleController;
import com.onlines.listeners.MyReporter;
import com.onlines.mapper.CaseResponseMapper;
import com.onlines.mapper.OnlinesPatrolMapper;
import com.onlines.pojo.CaseResponse;
import com.onlines.utils.*;
import com.onlines.pojo.OnlinesPatrol;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static io.qameta.allure.Allure.attachment;


/**
 * 自动化巡检核心方法
 */
@Listeners({MyReporter.class})
public class AutoCheckHtml {
    private static final Logger logger= LoggerFactory.getLogger(OnlinesSaleController.class);
    ImageComp imageComp = new ImageComp();
    private static OnlinesPatrolMapper onlinesPatrolMapper = SpringWrapper.getBean(OnlinesPatrolMapper.class);
    private static CaseResponseMapper caseResponseMapper = SpringWrapper.getBean(CaseResponseMapper.class);
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeClass
    public void beforeClass(){
        logger.info("创建playwright浏览器对象");
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
    }

    @AfterClass
    public void afterClass(){
        logger.info("销毁browser浏览器对象");
        browser.close();
        logger.info("销毁playwright浏览器对象");
        playwright.close();
    }

    @BeforeMethod
    void createContextAndPage() {
        logger.info("创建newContext对象");
        context = browser.newContext(new Browser.NewContextOptions()
                .setUserAgent("online_inspection_tracker Mozilla/5.0 (Linux; Android 8.0; Pixel 2 Build/OPD3.170816.012) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3765.0 Mobile Safari/537.36")
                .setViewportSize(411, 731)
                .setDeviceScaleFactor(1.0)
                .setIsMobile(true)
                .setHasTouch(true)
                .setLocale("zh-CN")
                .setGeolocation(new Geolocation(30.228932, 120.12792))
                .setPermissions(Arrays.asList("geolocation")));
        logger.info("创建newPage()对象");
        page = context.newPage();
    }

    @AfterMethod
    public void getRunTime(ITestResult tr) {
        logger.info("endTime --------------");
        int id;
        id = (int) tr.getParameters()[0];
        //响应时间
        long time = tr.getEndMillis() - tr.getStartMillis();
        logger.info("响应时间：" + time);
        int case_id = (int) tr.getParameters()[0];

        long caseResult = tr.getStatus();
        if (tr.getStatus() == 2) {
            String failed_reason = tr.getThrowable().toString();
            saveCaseRes(case_id, time, caseResult, failed_reason);
            logger.info("case用例执行失败");
        }else{
            saveCaseRes(case_id, time, caseResult, "");
            logger.info("case用例执行成功");
        }

        logger.info("销毁page对象");
        page.close();
        logger.info("销毁context对象");
        context.close();
    }

    @Description("遍历页面可用状态")
    @Test(priority = 0, description = "遍历页面可用状态", dataProvider = "HtmlData", retryAnalyzer = MyRetry.class)
    public void testHtmlServiceability(int id, String htmlinfo, String title, String url, String dingKey, String wechatKey, String feishuKey) throws FileNotFoundException, UnknownHostException {
        page.navigate(url);
        long currentTimeMillis = System.currentTimeMillis();
        // 获取当前工作目录
        String userDir = System.getProperty("user.dir");
        String imageName = title.concat("_").concat(Long.toString(currentTimeMillis));
        logger.info("基准值地址"+imageName);
        // 使用String的concat()方法拼接路径
        String imagePath = userDir.concat(File.separator).concat("online-images").concat(File.separator).concat(imageName).concat(".png");
        page.waitForLoadState(LoadState.NETWORKIDLE); // 资源下载完毕
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(imagePath)));
        Assert.assertEquals(page.title(), title);
        attachment("H5页面信息截图", new FileInputStream(imagePath));

        //TODO存库
        OnlinesPatrol onlinesPatrol = onlinesPatrolMapper.selectByPrimaryKey(id);
        if (onlinesPatrol != null) { // 若无基准值
            if (onlinesPatrol.getDatumAddress() == null) {
                onlinesPatrol.setDatumAddress(imageName);
                onlinesPatrol.setDatumCreatetime(new Date());
                onlinesPatrolMapper.updateByPrimaryKey(onlinesPatrol);
            } else {
                String pic1 = imagePath;  // 本次图片
                logger.info("图片1的地址"+pic1);
                // 基准值图片
                String pic2 = userDir.concat(File.separator).concat("online-images").concat(File.separator).concat(onlinesPatrol.getDatumAddress()).concat(".png");//线上运行获取图片地址
                logger.info("图片2的地址"+pic2);
                String result = null;
                try {
                    result = imageComp.compareImage(pic2, pic1);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                int xiangsi = Integer.parseInt(result);
                if (xiangsi > 60) {
                    Assert.assertTrue(true);
                    logger.info("图片对比相似率大于60:" + xiangsi);
                } else {
                    String ip = InetAddress.getLocalHost().getHostAddress();
                    logger.info("服务器IP地址：" + ip);
//                    http://localhost:9091/patrol/onlines/images?imageName=%E7%99%BE%E5%BA%A6%E4%B8%80%E4%B8%8B%E5%93%88%E5%93%88%E5%95%8A_1714287034960
                    String picUrl = "http://" + ip + ":9091/patrol/onlines/images?imageName=" + imageName;
                    DingUtil.sendMsgPic(url, id, picUrl, title, dingKey);
                    WechatUtil.sendMsgPic(url, id, picUrl, title, wechatKey);
                    FeishuUtil.sendMsgPic(url, id, picUrl, title, feishuKey);
                    logger.info("图片对比相似率小于60:" + xiangsi);
                }
            }
        }
    }

    private void saveCaseRes(long case_id, long time, long caseResult, String failed_reason) {
        CaseResponse caseResponse = new CaseResponse();
        caseResponse.setCaseId(case_id);
        caseResponse.setResponseTime(time);
        caseResponse.setStates(caseResult);
        caseResponse.setFailedReason(failed_reason);
        caseResponse.setCreateTime(new Date());
        caseResponseMapper.insert(caseResponse);
    }

    @DataProvider
    public Object[][] HtmlData() {
        List<OnlinesPatrol> onlinesPatrols = onlinesPatrolMapper.selectDate();
        if (onlinesPatrols == null) {
            return null;
        }
        Object[][] pageData = new Object[onlinesPatrols.size()][7];
        for (int i = 0; i < onlinesPatrols.size(); i++) {
            OnlinesPatrol onlinesPatrol = onlinesPatrols.get(i);
            pageData[i][0] = onlinesPatrol.getId();
            pageData[i][1] = onlinesPatrol.getHtmlinfo();
            pageData[i][2] = onlinesPatrol.getTitle();
            pageData[i][3] = onlinesPatrol.getUrl();
            pageData[i][4] = onlinesPatrol.getDingKey();
            pageData[i][5] = onlinesPatrol.getWechatKey();
            pageData[i][6] = onlinesPatrol.getFeishuKey();
        }
        return pageData;
//        return null;
    }


    @DataProvider
    public Object[][] HtmlDataTest() {
        return new Object[][]{
                {1, "手机网易网", "手机网易网", "https://www.163.com/", null, null, null },
        };
    }

}
