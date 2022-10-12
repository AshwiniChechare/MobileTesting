package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class AddToCart {

    public void scrollToProduct(AndroidDriver driver,String text)
    {
        System.out.println(text);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
    }
//Test.allTheThings() T-Shirt (Red)
  public void goToAddToCart(AndroidDriver driver,String text)
    {
        List<WebElement> ele=driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]"));
        ele.get(2).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]")).click();
    }
}
