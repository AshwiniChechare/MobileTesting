package pages.yatra;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class HotelsBooking {
    public void clickOnHotelsIcon(AndroidDriver driver,String city) throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Hotels']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.yatra.base:id/dest_hotel_cityname_textview")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.yatra.base:id/edit_location_search_in_actionbar")).sendKeys("Manali");
        driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@text='Cities']/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView[contains(@text,"+city+")]")).click();

        driver.findElement(By.id("com.yatra.base:id/layout_manage_guest")).click();
        driver.findElement(By.id("com.yatra.base:id/done_button")).click();
        driver.findElement(By.id("com.yatra.base:id/search_button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("com.yatra.base:id/sort_tv4")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id\n" +
                "='com.yatra.base:id/ll_hotel_srp_item'][1]")).click();
        driver.findElement(By.id("com.yatra.base:id/proceed_button")).click();
        driver.findElement(By.xpath("//android.widget.Button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
}
