package pages.yatra;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import static base.BaseClass.driver;

public class HotelsBooking {
    public void clickOnHotelsIcon(AndroidDriver driver, String city) throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Hotels']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.yatra.base:id/dest_hotel_cityname_textview")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.yatra.base:id/edit_location_search_in_actionbar")).sendKeys("Manali");
        driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@text='Cities']/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView[contains(@text," + city + ")]")).click();

        driver.findElement(By.id("com.yatra.base:id/layout_manage_guest")).click();
        driver.findElement(By.id("com.yatra.base:id/done_button")).click();
        selectDate(driver);
        driver.findElement(By.id("com.yatra.base:id/search_button")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.yatra.base:id/sort_price_layout")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id\n" +
                "='com.yatra.base:id/ll_hotel_srp_item'][1]")).click();
        driver.findElement(By.id("com.yatra.base:id/proceed_button")).click();
        driver.findElement(By.xpath("//android.widget.Button")).click();
        driver.findElement(By.id("com.yatra.base:id/proceed_button")).click();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void enterDetails(AndroidDriver driver, String fname, String lname) throws InterruptedException {
        driver.findElement(By.id("com.yatra.base:id/rb_title_mr")).click();
        //Thread.sleep(3000);
        driver.findElement(By.id("com.yatra.base:id/editFirstNameInRowPassDetailBody")).click();
        driver.findElement(By.xpath("//android.widget.AutoCompleteTextView[@resource-id='com.yatra.base:id/edit_text']")).sendKeys(fname);
        driver.findElement(By.xpath("//android.widget.AutoCompleteTextView[@text='Last Name']")).sendKeys(lname);
        driver.navigate().back();
        driver.findElement(By.id("com.yatra.base:id/proceed_button")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Debit Card']")).click();
    }

    public void selectDate(AndroidDriver driver) throws InterruptedException {

        Date date = new Date();

        SimpleDateFormat formatter12 = new SimpleDateFormat("dd MMMM yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 30);
        String result = formatter12.format(cal.getTime());
        Thread.sleep(2000);
        System.out.println(result);
        driver.findElement(By.id("com.yatra.base:id/check_in_date_relativelayout")).click();
        Thread.sleep(2000);
        try {
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"" + result + "\"]")).click();
        }
        catch(Exception e)
        {
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"" + result + " selected\"]")).click();

        }
        Thread.sleep(2000);
            driver.findElement(By.id("com.yatra.base:id/btn_ok")).click();
        }

    }
