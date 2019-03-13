package spaceNeedle;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class SetupEnvironment {

    private static AppiumDriver driver;

    public static void setup_environment() throws Exception {
        File app = downloadApk();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("deviceName", "Samsung Galaxy S8");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("launchTimeout", "20000");
        capabilities.setCapability("adbPort", "5037");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        WebDriverRunner.setWebDriver(driver);
    }

    private static File downloadApk()   {
        File apk = new File("C:\\Users\\user\\IdeaProjects\\selenide-appium\\src\\source\\app-release.apk");
        return apk;
    }
}
