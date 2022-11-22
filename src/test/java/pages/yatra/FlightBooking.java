package pages.yatra;

import com.aventstack.extentreports.gherkin.model.And;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import static base.BaseClass.driver;

public class FlightBooking {




    public void selectDestination(AndroidDriver driver, String fromText, String destcity) throws InterruptedException {
        if (fromText == destcity) {
            System.out.println("City is already selected in from Text");
        } else {
            try {
                driver.findElement(By.id("com.yatra.base:id/dest_citycode_textview")).click();
                driver.findElement(By.id("com.yatra.base:id/edit_location_search_in_actionbar")).sendKeys(destcity);
                Thread.sleep(4000);
                driver.findElement(By.xpath("//android.widget.TextView[@text='" + destcity + "']")).click();

            } catch (Exception e) {
                Thread.sleep(4000);
                driver.findElement(By.id("com.yatra.base:id/image_cancel_in_actionbar")).click();
                driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@text='RECENT SEARCHES']/parent::android.widget.LinearLayout/following-sibling::android.widget.RelativeLayout/android.widget.TextView[@text='" + destcity + "']")).click();
            }

        }
    }

    public void clickOnFlights(AndroidDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Flights']")).click();
        driver.findElement(By.id("com.yatra.base:id/rb_one_way")).click();
    }

    public void clickOnFromCity(AndroidDriver driver) {
        driver.findElement(By.id("com.yatra.base:id/org_citycode_textview")).click();
    }

    public void selectFrom(AndroidDriver driver, String fromText) throws InterruptedException {
        try {
            driver.findElement(By.xpath("//android.widget.EditText[@text='Enter city or airport name']")).sendKeys(fromText);
            Thread.sleep(4000);
            driver.findElement(By.xpath("//android.widget.TextView[@text='" + fromText + "']")).click();

        } catch (Exception e) {
            Thread.sleep(4000);
            driver.findElement(By.id("com.yatra.base:id/image_cancel_in_actionbar")).click();
            driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@text='RECENT SEARCHES']/parent::android.widget.LinearLayout/following-sibling::android.widget.RelativeLayout/android.widget.TextView[@text='" + fromText + "']")).click();

        }
    }

    public void enterfromCityName(AndroidDriver driver, String fromText) throws InterruptedException {
        selectFrom(driver, fromText);
    }

    public void enterDestinationcityName(AndroidDriver driver, String fromText, String destcity) throws InterruptedException {
        selectDestination(driver, fromText, destcity);
    }

    public void selectDate() throws InterruptedException {
        Date date = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
        String strDate = formatter.format(date);
        System.out.println(strDate);
        Thread.sleep(2000);
        driver.findElement(By.id("com.yatra.base:id/departuredate_linearlayout")).click();

        //driver.findElement(AppiumBy.accessibilityId("09 November 2022 selected")).click();
        //driver.findElement(By.xpath("//android.view.View[@content-desc=\""+strDate+" selected\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.yatra.base:id/btn_ok")).click();

        SimpleDateFormat formatter12 = new SimpleDateFormat("dd MMMM yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 2);
        String result = formatter12.format(cal.getTime());
        Thread.sleep(2000);
        driver.findElement(By.id("com.yatra.base:id/flight_booking_add_return_date_button")).click();
        driver.findElement(By.id("com.yatra.base:id/btn_ok")).click();
        System.out.println(result);
    }

    public void selectTraveller(AndroidDriver driver, int adultCount, int childerncount, int infantcount) {
        driver.findElement(By.id("com.yatra.base:id/tv_heading_travellers")).click();
        for (int i = 1; i <= adultCount; i++) {
            driver.findElement(By.id("com.yatra.base:id/img_adult_increment")).click();
        }
        for (int i = 0; i < childerncount; i++) {
            driver.findElement(By.id("com.yatra.base:id/img_adult_increment")).click();
        }
        for (int i = 0; i < infantcount; i++) {
            driver.findElement(By.id("com.yatra.base:id/img_infant_increment")).click();
        }
        driver.findElement(By.id("com.yatra.base:id/btn_done_select_travellers_dialog")).click();
    }


    public void clickonClass(AndroidDriver driver) throws InterruptedException {
        driver.findElement(By.id("com.yatra.base:id/ll_flight_booking_class")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Economy']")).click();
    }

    public void clickOnSearchFlight(AndroidDriver driver) {
        driver.findElement(By.id("com.yatra.base:id/search_button")).click();
    }

    public void clickonFlight(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(10000);
        /*driver.findElement(By.id("com.yatra.base:id/rl_close")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("//android.widget.LinearLayout[@resource-id='com.yatra.base:id/time_relativelayout'][2]")).click();
        Thread.sleep(5000);*/
        driver.findElement(By.className("android.widget.Button")).click();
    }

    public void proceedButton(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.className("android.widget.Button")).click();
        Thread.sleep(5000);
        try
        {
            driver.findElement(By.id("android:id/button1")).click();
            driver.findElement(By.className("android.widget.Button")).click();
        }
        catch(Exception e)
        {
            driver.findElement(By.className("android.widget.Button")).click();
        }
        driver.findElement(By.id("com.yatra.base:id/risk_travel_button")).click();
    }

    public void enterDetails(AndroidDriver driver, String fname, String lname) throws InterruptedException {
        driver.findElement(By.id("com.yatra.base:id/rb_title_mr")).click();
        //Thread.sleep(3000);
        driver.findElement(By.id("com.yatra.base:id/editFirstNameInRowPassDetailBody")).click();
        driver.findElement(By.xpath("//android.widget.AutoCompleteTextView[@resource-id='com.yatra.base:id/edit_text']")).sendKeys(fname);
        driver.findElement(By.xpath("//android.widget.AutoCompleteTextView[@text='Last Name']")).sendKeys(lname);
        driver.navigate().back();
        driver.findElement(By.id("com.yatra.base:id/proceed_button")).click();
        driver.findElement(By.id("com.yatra.base:id/btn_continue")).click();
    }
}

