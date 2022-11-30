package pages.yatra;

import com.aventstack.extentreports.gherkin.model.And;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TrainsBooking {

    public void linkAccount(AndroidDriver driver) {
        try {
            driver.findElement(By.id("com.yatra.base:id/tv_link_now")).click();
            driver.findElement(By.id("com.yatra.base:id/et_user_id")).sendKeys("yawarish12");
            driver.findElement(By.id("com.yatra.base:id/btn_positive")).click();
        } catch (Exception e) {
            System.out.println("Already account is linked");
        }
    }

    public void trainBooking(AndroidDriver driver, String fromcity, String destination) throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Trains']")).click();
        linkAccount(driver);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Leaving From']")).click();
        driver.findElement(By.id("com.yatra.base:id/ed_editSearch")).sendKeys(fromcity);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + fromcity + "']")).click();
        selectDestination(driver, destination);
        driver.findElement(By.id("com.yatra.base:id/tv_today")).click();
        Thread.sleep(3000);
        selectDate(driver);
        driver.findElement(By.id("com.yatra.base:id/linear_preferred_container")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Sleeper (SL)']")).click();
        driver.findElement(By.id("com.yatra.base:id/btn_find_buses")).click();
        Thread.sleep(3000);
        selectTrain(driver);
        selectSeat(driver);
        Thread.sleep(3000);
        fillUpBookingData(driver);
    }

    public void selectTrain(AndroidDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]")).click();
        try {
            driver.findElement(By.id("android:id/button1")).click();
        } catch (Exception e) {
            System.out.println("Trains booking");
        }
    }

    public void selectSeat(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.yatra.base:id/lin_selected_date_container']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout")).click();
    }

    public void selectDestination(AndroidDriver driver, String destcity) throws InterruptedException {
        try {
            driver.findElement(By.xpath("//android.widget.TextView[@text='Going To']")).click();
            driver.findElement(By.id("com.yatra.base:id/ed_editSearch")).sendKeys(destcity);
            driver.hideKeyboard();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Mumbai')]")).click();
        } catch (Exception e) {
            driver.findElement(By.id("com.yatra.base:id/ed_editSearch")).sendKeys(destcity);
            driver.hideKeyboard();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Mumbai')]")).click();
        }
    }

    public void selectDate(AndroidDriver driver) throws InterruptedException {
        Date date = new Date();
        SimpleDateFormat formatter12 = new SimpleDateFormat("dd MMMM yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 30);
        String result = formatter12.format(cal.getTime());
        Thread.sleep(2000);
        System.out.println(result);
        Thread.sleep(2000);
        try {
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"" + result + "\"]")).click();
        } catch (Exception e) {
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"" + result + " selected\"]")).click();

        }
        Thread.sleep(2000);
    }

    public void fillUpBookingData(AndroidDriver driver) throws InterruptedException {
        try {
            driver.findElement(By.id("com.yatra.base:id/img_help")).click();
        } catch (Exception e) {
            System.out.println("No need to click here");
        }
        driver.findElement(By.id("com.yatra.base:id/spinner_title")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Mr']")).click();
        driver.findElement(By.id("com.yatra.base:id/ed_text_full_name")).sendKeys("afourtech Pvt Ltd");
        driver.findElement(By.id("com.yatra.base:id/spinner_age")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='17 Yrs.']")).click();
        driver.findElement(By.id("com.yatra.base:id/spinner_seat_pref")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Upper']")).click();
        driver.findElement(By.id("com.yatra.base:id/et_address")).sendKeys("STERLING TOWERS , Office 501, 5th Floor");
        driver.findElement(By.id("com.yatra.base:id/et_street")).sendKeys("Pan Card Club Rd");
        driver.findElement(By.id("com.yatra.base:id/et_colony")).sendKeys("Baner");
        driver.findElement(By.id("com.yatra.base:id/et_pincode")).sendKeys("411045");
        Thread.sleep(3000);
        driver.findElement(By.id("com.yatra.base:id/et_state")).sendKeys("Maharashtra ");
        driver.findElement(By.id("com.yatra.base:id/et_city_name")).sendKeys("Pune");
        driver.findElement(By.id("com.yatra.base:id/et_post_office")).sendKeys("Pune");
        driver.findElement(By.id("com.yatra.base:id/btn_proceed")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.yatra.base:id/btn_proceed")).click();
        driver.findElement(By.id("com.yatra.base:id/btn_pay")).click();
        Thread.sleep(10000);
    }
}
