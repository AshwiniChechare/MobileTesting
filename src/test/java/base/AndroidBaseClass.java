package base;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ReadConfig;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidBaseClass {
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
        caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\Dinesh.P\\MobileTesting\\app\\flipkart.apk");
        caps.setCapability(MobileCapabilityType.FULL_RESET, false);
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        URL url=new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, caps);

        //driver = new AppiumDriver<MobileElement>(url, caps);
        return driver;
    }

    public void preset() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        if(driver.findElement(By.xpath("//android.widget.TextView[@text='English'][1]")).isDisplayed())
        {
            driver.findElement(By.xpath("//android.widget.TextView[@text='English'][1]")).click();
            driver.findElement(By.id("com.flipkart.android:id/select_btn")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //driver.findElement(By.id("com.google.android.gms:id/cancel")).click();
            driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Phone Number']")).sendKeys("9356736962");
            //driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Email ID']")).sendKeys("dineshparate25@gmail.com");
            driver.findElement(By.id("com.flipkart.android:id/button")).click();
            /* driver.findElement(By.id("com.flipkart.android:id/phone_input")).sendKeys("9356736962");
            driver.findElement(By.id("com.flipkart.android:id/button")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.findElement(By.id("com.flipkart.android:id/tv_left_cta")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Password\"]")).sendKeys("G00gle@1234");
            driver.findElement(By.id("com.flipkart.android:id/button")).click();*/
        }
        //else if()

    }

}
