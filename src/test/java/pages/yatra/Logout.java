package pages.yatra;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Logout {

    public void logout(AndroidDriver driver)
    {
        driver.findElement(AppiumBy.accessibilityId("My Account")).click();
        driver.findElement(By.id("com.yatra.base:id/txt_my_profile")).click();
        driver.findElement(By.id("com.yatra.base:id/tv_logout")).click();
    }
}
