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
import utilities.ReadConfig;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {

    public static AndroidDriver driver;
    static ReadConfig readConfig;

    public static AndroidDriver setup() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 XL API 33");
        caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\Dinesh.P\\MobileTesting\\app\\yatra-com-14-6-0.apk");
       // caps.setCapability("appPackage", "com.yatra.base");
      //  caps.setCapability("appActivity", "com.yatra.base.activity.HomeActivity");
        caps.setCapability("enableMultiWindows", true);
        caps.setCapability(MobileCapabilityType.FULL_RESET, false);
        caps.setCapability(MobileCapabilityType.NO_RESET, true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, caps);
        //driver = new AppiumDriver<MobileElement>(url, caps);
        return driver;


    }


    public static void tearDown() {
        driver.quit();
    }

}
