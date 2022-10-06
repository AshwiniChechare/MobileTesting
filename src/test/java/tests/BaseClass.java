package tests;

import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class BaseClass {
    AppiumDriver driver;

    @BeforeTest
    public void setup(){
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            //caps.setCapability("platformName","ANDROID");
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 XL API 31 2");
            //caps.setCapability(MobileCapabilityType.UDID, "");
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 99999);
            //caps.setCapability(MobileCapabilityType.APP, "");
            //caps.setCapability("appPackage", "");
            //caps.setCapability("appActivity", "");
            caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
            //caps.setCapability(MobileCapabilityType.BROWSER_VERSION, "");
            caps.setCapability(MobileCapabilityType.FULL_RESET, false);
            caps.setCapability(MobileCapabilityType.NO_RESET, true);

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver(url, caps);
            //driver = new AndroidDriver<MobileElement>(url, caps);
        }
        catch(Exception e)
        {
            System.out.println("Cause is:"+e.getCause());
            System.out.println("Message is"+e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void sampleTest()
    {
        System.out.println("I am inside sample test");
    }

    @AfterTest
    public void teardown()
    {
    }
}
