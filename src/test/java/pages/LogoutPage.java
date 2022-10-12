package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LogoutPage {

    public void clickontapmenu(AndroidDriver driver)
    {
        driver.findElement(By.xpath("\t\n" +
                "//android.view.ViewGroup[@content-desc='test-Menu']")).click();
    }
    public void clickonLogout(AndroidDriver driver)
    {
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='test-LOGOUT']")).click();
    }
}
