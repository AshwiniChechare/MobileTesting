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
        caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\Dinesh.P\\MobileTesting\\app\\SauceLabs.2.7.1.apk");
        caps.setCapability("appWaitActivity","com.swaglabsmobileapp.MainActivity");
        caps.setCapability(MobileCapabilityType.FULL_RESET, false);
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        URL url=new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, caps);

        //driver = new AppiumDriver<MobileElement>(url, caps);
        return driver;
    }



}
