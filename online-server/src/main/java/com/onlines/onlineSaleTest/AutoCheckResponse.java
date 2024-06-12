package com.onlines.onlineSaleTest;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;
import com.microsoft.playwright.options.LoadState;
import com.onlines.listeners.MyReporter;
import com.onlines.mapper.CaseResponseMapper;
import com.onlines.mapper.OnlinesPatrolMapper;
import com.onlines.pojo.OnlinesPatrol;
import com.onlines.utils.DingUtil;
import com.onlines.utils.FeishuUtil;
import com.onlines.utils.MyRetry;
import com.onlines.utils.WechatUtil;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
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

import static io.qameta.allure.Allure.attachment;

@Listeners({MyReporter.class})
@SpringBootTest(classes = com.onlines.onlineSaleTest.AutoCheckHtml.class)
public class AutoCheckResponse {

    private static OnlinesPatrolMapper onlinesPatrolMapper = SpringWrapper.getBean(OnlinesPatrolMapper.class);
    private static CaseResponseMapper caseResponseMapper = SpringWrapper.getBean(CaseResponseMapper.class);
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
        page.waitForLoadState(LoadState.NETWORKIDLE); // 资源下载完毕
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(htmlinfo + ".png")));
        System.out.println("页面id=" + id);
        Assert.assertEquals(page.title(), title);
        attachment("H5页面信息截图", new FileInputStream(htmlinfo + ".png"));


        }


}
