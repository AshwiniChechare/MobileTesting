package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

import java.time.Duration;

public class BookOrder {

    public void clickCheckOut(AndroidDriver driver)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='test-CHECKOUT']")).click();
    }
    public void fillAddressDetails(AndroidDriver driver,String fname,String lname,String pincode)
    {
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.EditText[@content-desc=\"test-First Name\"]")).sendKeys(fname);
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.EditText[@content-desc=\"test-Last Name\"]")).sendKeys(lname);
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='test-Zip/Postal Code']")).sendKeys(pincode);
        driver.hideKeyboard();

    }
    public void clickToContinue(AndroidDriver driver)
    {
        driver.findElement(AppiumBy.accessibilityId("test-CONTINUE")).click();
    }

    public void confirmOrder(AndroidDriver driver)
    {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(description(\"test-FINISH\"))"));
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")).click();
    }
}
