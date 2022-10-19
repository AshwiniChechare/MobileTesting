package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ObjectsRepo;
import utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidBaseClass extends ObjectsRepo {
    public static AndroidDriver driver;
    static ReadConfig readConfig;

    //@BeforeClass(alwaysRun = true)
    public static AndroidDriver setup() throws MalformedURLException {
        readConfig = new ReadConfig();
        DesiredCapabilities caps = new DesiredCapabilities();
        // String url = readConfig.geturl();
        String devicename = readConfig.getDeviceName();
        String version = readConfig.getVersion();
        String appname = readConfig.getAppName();

        File appDir = new File("apps");
        File app = new File(appDir, appname);

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
        caps.setCapability("enableMultiWindows", true);
        caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\Dinesh.P\\MobileTesting\\app\\SauceLabs.2.7.1.apk");
        caps.setCapability("appWaitActivity", "com.swaglabsmobileapp.MainActivity");
        caps.setCapability(MobileCapabilityType.FULL_RESET, false);
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, caps);

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
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/report/HtmlReport" + timeStamp + ".html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static void close(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                MediaEntityModelProvider ssimg = AndroidBaseClass.getScreenshotss(result.getName());
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
    public void tearDown()
    {
        driver.quit();
    }

}
