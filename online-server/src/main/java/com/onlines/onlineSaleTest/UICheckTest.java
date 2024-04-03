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
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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
@ContextConfiguration(locations = "classpath:mybatis.xml")
//@ContextConfiguration(locations = "classpath:context.xml")
@Test
public class UICheckTest extends AbstractTestNGSpringContextTests {//extends AbstractTestNGSpringContextTests {
    ImageComp imageComp = new ImageComp();
    String yuming = "http://localhost:9091/patrol/onlines/images?images=";
    private Playwright playwright = Playwright.create();
    Page page;
    private static OnlinesPatrolMapper onlinesPatrolMapper=SpringWrapper.getBean(OnlinesPatrolMapper.class);
    @BeforeClass
    public void beforeClass() {
        onlinesPatrolMapper= com.onlines.onlineSaleTest.SpringWrapper.getBean(OnlinesPatrolMapper.class);
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setUserAgent("dj_jyptqa_monitor Mozilla/5.0 (Linux; Android 8.0; Pixel 2 Build/OPD3.170816.012) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3765.0 Mobile Safari/537.36")
                .setViewportSize(411, 731)
                .setDeviceScaleFactor(1.0)
                .setIsMobile(true)
                .setHasTouch(true)
                .setLocale("zh-CN")
                .setGeolocation(new Geolocation(30.228932, 120.12792))
                .setPermissions(Arrays.asList("geolocation")));
         page = context.newPage();
    }
    @Description("遍历页面可用状态")
    @Attachment
    @Test(priority = 0, description = "遍历页面可用状态", dataProvider = "HtmlDataTest")
    public void testHtmlServiceability(int id, String htmlinfo, String title, String url) throws FileNotFoundException {
        System.out.println("测试test");
        page.navigate(url);

        long currentTimeMillis = System.currentTimeMillis();
//        String imagePath =  System.getProperty("user.dir") + "/online-images/" + htmlinfo + "_" + currentTimeMillis + ".png";
        // 获取当前工作目录
        String userDir = System.getProperty("user.dir");
        // 使用String的concat()方法拼接路径
        String imageName = htmlinfo.concat("_").concat(Long.toString(currentTimeMillis));
        String imagePath = userDir.concat(File.separator).concat("online-images").concat(File.separator).concat(htmlinfo).concat("_").concat(Long.toString(currentTimeMillis)).concat(".png");

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(imagePath)));
        OnlinesPatrol onlinesPatrol= onlinesPatrolMapper.selectByPrimaryKey(id);
        System.out.println("数据库查询" + onlinesPatrol);
        if (onlinesPatrol != null) {
            System.out.println("基准图地址------------" + onlinesPatrol.getDatumAddress());
            if (onlinesPatrol.getDatumAddress() == null) {
                onlinesPatrol.setDatumAddress(imageName);
                onlinesPatrol.setDatumCreatetime(new Date());
                onlinesPatrolMapper.updateByPrimaryKey(onlinesPatrol);
            } else {
                String pic2 = userDir.concat(File.separator).concat("online-images").concat(File.separator).concat(onlinesPatrol.getDatumAddress()).concat(".png");//线上运行获取图片地址
                System.out.println("pic2------------" + pic2);
                String result = null;
                try {
                    String pic1 = imagePath;
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
        // 断言title
        Assert.assertEquals(page.title(), title);
    }

    @DataProvider
    public Object[][] HtmlDataTest() {
        return new Object[][]{
//                {1, "百度一下", "百度一下", "https://www.baidu.com/"},
        };
    }

}
