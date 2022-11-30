package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.ObjectsRepo;
import utilities.ReadConfig;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass extends ObjectsRepo {

    public static AndroidDriver driver;
    public static ReadConfig readConfig;

    public static AndroidDriver setup() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 XL API 31");
        caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\Dinesh.P\\MobileTesting\\app\\yatra-com-14-6-0.apk");
        // caps.setCapability("appPackage", "com.yatra.base");
        //  caps.setCapability("appActivity", "com.yatra.base.activity.HomeActivity");
        caps.setCapability("enableMultiWindows", true);
        caps.setCapability(MobileCapabilityType.FULL_RESET, false);
        caps.setCapability(MobileCapabilityType.NO_RESET, true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new    AndroidDriver(url, caps);
        //driver = new AppiumDriver<MobileElement>(url, caps);
        return driver;


    }

    public static MediaEntityModelProvider getScreenshotss(String name) {
        MediaEntityModelProvider mediaModel = null;
        String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        try {
            mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mediaModel;
    }

    public static void startReport() {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/HtmlReport" + timeStamp + ".html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static void close(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                MediaEntityModelProvider ssimg = BaseClass.getScreenshotss(result.getName());
                test.fail(result.getName() + " TestCase Failed", ssimg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getName() + "Testcase Pass.");
        }


    }

    public static void endReport() {
        extent.flush();

    }

    public static void tearDown() {
        driver.quit();
    }


}
