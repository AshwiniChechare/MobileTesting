package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.time.Duration;

import static base.AndroidBaseClass.driver;

public class LoginPage {

    public void enterUserName(AndroidDriver driver,String username)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='test-Username']")).sendKeys(username);
    }
    public void enterpassword(AndroidDriver driver,String password)
    {
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='test-Password']")).sendKeys(password);
    }
    public void clickloginbutton(AndroidDriver driver)
    {
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
    }
}
