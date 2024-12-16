package com.example.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static java.lang.System.getenv;

public class SampleAppTest {
    private AppiumDriverLocalService server;
    private AppiumDriver driver;

    @BeforeClass
    private void setUp() {
        String platform = getenv("APPIUM_DRIVER");
        platform = platform == null ? "ANDROID" : platform.toUpperCase();
        String path = System.getProperty("user.dir");
        System.out.println("Current working directory: " + path);

        if (platform.equals("ANDROID")) {
            var options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setDeviceName("Android")
                    .setUdid("emulator-5554")
                    .setAutomationName("UIAutomator2")
                    .setApp(Paths.get(path).resolve("ApiDemos-debug.apk").toString());

            server = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                    .usingPort(4724));
            server.start();
            driver = new AndroidDriver(server, options);

            ((InteractsWithApps) driver).activateApp("io.appium.android.apis");
        } else {
            var options = new XCUITestOptions()
                    .setPlatformName("iOS")
                    .setPlatformVersion("18.1")
                    .setAutomationName("XCuiTest")
                    .setDeviceName("iPhone 16")
                    .setApp(Paths.get(path).resolve("TestApp.app.zip").toString());

            server = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort());
            server.start();
            driver = new IOSDriver(server, options);
        }
    }

    @Test
    public void textFieldTest() {
        // TODO initialise PageView and set "text" to its textField
        PageView pageView = new PageView(driver);
        String setText = "text";
        pageView.setTextField(setText);

        // TODO assert that textField equals to "text"
        String textField = pageView.getTextField();
        assert textField.equals(setText) : "Failed assertion";
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (server != null) {
            server.stop();
        }
    }
}
