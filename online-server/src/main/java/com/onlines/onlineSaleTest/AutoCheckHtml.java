package com.onlines.onlineSaleTest;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;
import com.microsoft.playwright.options.LoadState;
import com.onlines.mapper.OnlinesPatrolMapper;
import com.onlines.onlineSaleTest.util.DingUtil;
import com.onlines.onlineSaleTest.util.ImageComp;
import com.onlines.onlineSaleTest.util.JDBCUtil;
import com.onlines.onlineSaleTest.util.MyRetry;
import com.onlines.pojo.OnlinesPatrol;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ResponseBody;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static io.qameta.allure.Allure.attachment;


/**
 * zhangdexi
 * 监控：主要页面白页、无法打开等异常
 */
//@Listeners({TestReport.class})
//@ContextConfiguration(locations = "classpath:mybatis.xml")
@SpringBootTest(classes = com.onlines.onlineSaleTest.AutoCheckHtml.class)
public class AutoCheckHtml {//extends AbstractTestNGSpringContextTests {
    ImageComp imageComp = new ImageComp();
    DingUtil dingUtil = new DingUtil();


    private static OnlinesPatrolMapper onlinesPatrolMapper=SpringWrapper.getBean(OnlinesPatrolMapper.class);

    private Playwright playwright = Playwright.create();

    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
    BrowserContext context = browser.newContext(new Browser.NewContextOptions()
            .setUserAgent("dj_jyptqa_monitor Mozilla/5.0 (Linux; Android 8.0; Pixel 2 Build/OPD3.170816.012) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3765.0 Mobile Safari/537.36")
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
    @Test(priority = 0, description = "遍历页面可用状态", dataProvider = "HtmlDataTest", retryAnalyzer = MyRetry.class)
    public void testHtmlServiceability(int id, String htmlinfo, String title, String url) throws FileNotFoundException {
        page.navigate(url);
        long currentTimeMillis = System.currentTimeMillis();
        // 获取当前工作目录
        String userDir = System.getProperty("user.dir");
        String imageName = htmlinfo.concat("_").concat(Long.toString(currentTimeMillis));
        // 使用String的concat()方法拼接路径
        String imagePath = userDir.concat(File.separator).concat("online-images").concat(File.separator).concat(imageName).concat(".png");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(imagePath)));
        System.out.println("页面id=" + id);
        System.out.println("页面title=" + page.title());
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
                System.out.println("pic2地址------------" + pic2);
                String result = null;
                try {
                    result = imageComp.compareImage(pic2, pic1);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                int xiangsi = Integer.parseInt(result);
                if (xiangsi > 20) {
                    Assert.assertTrue(true);
                    System.out.println("图片对比相似率大于20:" + xiangsi);
                } else {
                    System.out.println(onlinesPatrol.getId());
                    System.out.println("图片对比相似率小于20:" + xiangsi);
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
//    @AfterMethod
//    public void getRunTime(ITestListener tr) {
//        //  TestListener ll;
//        //tr.onTestSuccess();
//
//
//    }



    @DataProvider
    public Object[][] PicData() {
        return new Object[][]{

                {"D:\\test.jpg", "D:\\33333.jpg"}
        };
    }

    @DataProvider
    public Object[][] HtmlData() {
//        JSONArray jsonArray = DconfUtil.getServiceToPriceUnit();
//        Object[][] pageData = new Object[jsonArray.size()][];
//        try {
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int i=0;i< jsonArray.size();i++) {
//                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
//                pageData[i]=new Object[3];
//                pageData[i][0]=(String) jsonObject.get("htmlInfo");
//                pageData[i][1]=(String) jsonObject.get("title");
//                pageData[i][2]=(String) jsonObject.get("url");
////                String htmlInfo = (String) jsonObject.get("htmlInfo");
////                String title = (String) jsonObject.get("title");
////                String url = (String) jsonObject.get("url");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        jdbcUtil.getConnection();

//        List<OnlinesPatrol> onlinesPatrols = onlinesPatrolMapper.selectDate();
//        if (onlinesPatrols == null) {
//            return null;
//        }
//        Object[][] pageData = new Object[onlinesPatrols.size()][4];
//        for (int i = 0; i < onlinesPatrols.size(); i++) {
//            OnlinesPatrol onlinesPatrol = onlinesPatrols.get(i);
//            System.out.println("map数据2====：" + onlinesPatrol.getHtmlinfo());
//            System.out.println("map数据3====：" + onlinesPatrol.getTitle());
//            System.out.println("map数据4====：" + onlinesPatrol.getUrl());
//            System.out.println("map数据1====：" + onlinesPatrol.getId());
//            pageData[i][0] = onlinesPatrol.getId();
//            pageData[i][1] = onlinesPatrol.getHtmlinfo();
//            pageData[i][2] = onlinesPatrol.getTitle();
//            pageData[i][3] = onlinesPatrol.getUrl();
//
//        }
//        return pageData;
        return null;
    }


    @DataProvider
    public Object[][] HtmlDataTest() {
        return new Object[][]{
                {1, "百度一下页面", "百度一下", "https://www.baidu.com/"},
        };
    }

    @DataProvider
    public Object[][] LoginHtmlData() {
        return new Object[][]{

        };
    }
}
