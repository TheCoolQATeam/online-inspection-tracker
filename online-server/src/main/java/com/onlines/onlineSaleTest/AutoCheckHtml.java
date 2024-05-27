package com.onlines.onlineSaleTest;

import com.alibaba.fastjson.JSONArray;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;
import com.microsoft.playwright.options.LoadState;
import com.onlines.listeners.MyReporter;
import com.onlines.mapper.OnlinesPatrolMapper;
import com.onlines.utils.*;
import com.onlines.pojo.OnlinesPatrol;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
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
import java.util.Map;

import static io.qameta.allure.Allure.attachment;


/**
 * 自动化巡检核心方法
 */
@Listeners({ MyReporter.class })
@SpringBootTest(classes = com.onlines.onlineSaleTest.AutoCheckHtml.class)
public class AutoCheckHtml {
    ImageComp imageComp = new ImageComp();
    DingUtil dingUtil = new DingUtil();


    private static OnlinesPatrolMapper onlinesPatrolMapper = SpringWrapper.getBean(OnlinesPatrolMapper.class);

    private Playwright playwright = Playwright.create();

    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
    BrowserContext context = browser.newContext(new Browser.NewContextOptions()
            .setUserAgent("online_inspection_tracker Mozilla/5.0 (Linux; Android 8.0; Pixel 2 Build/OPD3.170816.012) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3765.0 Mobile Safari/537.36")
//            .setViewportSize(360, 640)
            .setViewportSize(411, 731)
//            .setDeviceScaleFactor(2.625)
            .setDeviceScaleFactor(1.0)
            .setIsMobile(true)
            .setHasTouch(true)
            .setLocale("zh-CN")
            .setGeolocation(new Geolocation(30.228932, 120.12792))
            .setPermissions(Arrays.asList("geolocation")));
    Page page = context.newPage();

    @Description("遍历页面可用状态")
    @Attachment
    @Test(priority = 0, description = "遍历页面可用状态", dataProvider = "HtmlData", retryAnalyzer = MyRetry.class)
    public void testHtmlServiceability(int id, String htmlinfo, String title, String url, String dingKey, String wechatKey, String feishuKey) throws FileNotFoundException, UnknownHostException {
        page.navigate(url);
        long currentTimeMillis = System.currentTimeMillis();
        // 获取当前工作目录
        String userDir = System.getProperty("user.dir");
        String imageName = title.concat("_").concat(Long.toString(currentTimeMillis));
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
                // 基准值图片
                String pic2 = userDir.concat(File.separator).concat("online-images").concat(File.separator).concat(onlinesPatrol.getDatumAddress()).concat(".png");//线上运行获取图片地址
                String result = null;
                try {
                    result = imageComp.compareImage(pic2, pic1);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                int xiangsi = Integer.parseInt(result);
                if (xiangsi > 60) {
                    Assert.assertTrue(true);
                    System.out.println("图片对比相似率大于60:" + xiangsi);
                } else {
                    String ip = InetAddress.getLocalHost().getHostAddress();
                    System.out.println("服务器IP地址：" + ip);
//                    http://localhost:9091/patrol/onlines/images?imageName=%E7%99%BE%E5%BA%A6%E4%B8%80%E4%B8%8B%E5%93%88%E5%93%88%E5%95%8A_1714287034960
                    String picUrl = "http://" + ip + ":9091/patrol/onlines/images?imageName=" + imageName;
                    DingUtil.sendMsgPic(url, id, picUrl, title, dingKey);
                    WechatUtil.sendMsgPic(url, id, picUrl, title, wechatKey);
                    FeishuUtil.sendMsgPic(url, id, picUrl, title, feishuKey);
                    System.out.println("图片对比相似率小于60:" + xiangsi);
                }
            }
        }
    }

    @AfterMethod
    public void getRunTime(ITestResult tr) {
        System.out.println("endTime --------------");
        int id;
        id = (int) tr.getParameters()[0];
        //响应时间
        long time = tr.getEndMillis() - tr.getStartMillis();
        System.out.println("响应时间：" + time);
        //執行結果
        JDBCUtil jdbcUtil = new JDBCUtil();
        jdbcUtil.getConnection();
        List<Map<String, Object>> result = jdbcUtil.queryForMapList("select id  from onlinespatrol where id  =" + id);
        for (Map<String, Object> map : result) {
            for (Map.Entry<String, Object> m : map.entrySet()) {
                System.out.println("-----------" + m.getValue());
                //用例序列号
                long case_id = (Integer) m.getValue();
                int caseResult = tr.getStatus();
                if (tr.getStatus() == 2) {
                    String failed_reason = tr.getThrowable().toString();
                    System.out.println("----" + failed_reason);
                    String query = "insert into case_response (case_id,response_time,states,failed_reason) values(?,?,?,?)";
                    Object[] params = {case_id, time, caseResult, failed_reason};
                    jdbcUtil.update(query, params);
                }
                String query = "insert into case_response (case_id,response_time,states) values(?,?,?)";
                Object[] params = {case_id, time, caseResult};
                jdbcUtil.update(query, params);
            }
        }
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
            System.out.println("map数据2====：" + onlinesPatrol.getHtmlinfo());
            System.out.println("map数据3====：" + onlinesPatrol.getTitle());
            System.out.println("map数据4====：" + onlinesPatrol.getUrl());
            System.out.println("map数据1====：" + onlinesPatrol.getId());
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
//                {1, "百度一下页面", "百度一下22", "https://www.baidu.com/", null, null, null },
        };
    }

    @DataProvider
    public Object[][] LoginHtmlData() {
        return new Object[][]{

        };
    }
}
