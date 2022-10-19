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
  public void goToCart(AndroidDriver driver,String text)
    {
        List<WebElement> ele=driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]"));
        ele.get(0).click();
        ele.get(1).click();
        ele.get(2).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        /*List<WebElement> eleprices=driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc='test-Price']/"));
        double sum=0;
        for( int i=0;i<eleprices.size()-1;i++)
        {
            //String value=eleprices.get(i).getAttribute("content-desc");
            //sum=sum+Double.parseDouble(value);
            System.out.println(eleprices.get(i).getAttribute("text"));

        }
        System.out.print(sum);*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]")).click();
    }
}
