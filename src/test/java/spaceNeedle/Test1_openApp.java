package spaceNeedle;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumDriver;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test1_openApp {

    private AppiumDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        SetupEnvironment.setup_environment();
    }


    @Test
    public void test_01_confirmCameraUsePopup() throws InterruptedException {
        // confirm camera use - check results
        $(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
       // $(By.id("android:id/navigationBarBackground")).shouldBe(visible);
        $$("android.widget.TextView").shouldHaveSize(3);
    }

    @Test
    public void test_02_goToSecondPage() throws InterruptedException {
        // click arrow forward on the first guide img - check results
        $$("android.widget.TextView").get(2).click();
        $$("android.widget.TextView").get(0).shouldHave(Condition.text("GET STARTED"));
    }

    @Test
    public void test_03_goBack_toFirstPage() throws InterruptedException {
        // click arrow back on the second guide img
        $$("android.widget.TextView").get(1).click();
      //  $(By.id("android:id/navigationBarBackground")).shouldBe(visible);
        $$("android.widget.TextView").shouldHaveSize(3);
    }



    @AfterClass
    public static void closeAppiumDriver()   {
        close();
    }
        //$(By.xpath(".//*[@text='Drag and Drop']")).click();

       /* new TouchAction(driver)
                .press((PointOption) $(By.id("io.appium.android.apis:id/drag_dot_1")).toWebElement())
                //.waitAction(1000)
                .perform();

        new TouchAction(driver)
                .moveTo((PointOption) $(By.id("io.appium.android.apis:id/drag_dot_2")).toWebElement())
                .release()
                //.waitAction(1000)
                .perform();

        $(By.id("io.appium.android.apis:id/drag_result_text")).shouldHave(text("Dropped!"));*/
}



