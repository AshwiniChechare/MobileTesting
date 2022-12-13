package pages.yatra;

import com.aventstack.extentreports.gherkin.model.And;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CabRideBooking {


    public void clickOnCabsIcon(AndroidDriver driver) throws InterruptedException {
        driver.findElement(By.id("com.yatra.base:id/iv_right_arrow")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Cabs/Rides']")).click();
        Thread.sleep(5000);

    }
    public void selectPickuPoint(AndroidDriver driver,String cityname) throws InterruptedException {
        driver.findElement(By.id("com.yatra.base:id/pickup_detailed_address")).click();
        driver.findElement(By.id("com.yatra.base:id/locationSearchField")).sendKeys(cityname);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+cityname+"']")).click();
    }
    public void selectDropPoint(AndroidDriver driver,String cityname) throws InterruptedException {
        driver.findElement(By.id("com.yatra.base:id/drop_detailed_address")).click();
        driver.findElement(By.id("com.yatra.base:id/locationSearchField")).sendKeys(cityname);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+cityname+"']")).click();

    }
    public void selectPickupDate(AndroidDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Pickup Date']")).click();
        String result=selectDate(driver);
        pickUpDate(driver,result);
        Thread.sleep(3000);
        driver.findElement(By.id("com.yatra.base:id/btn_ok")).click();
        pickUptime(driver,"8","35","PM");
        Thread.sleep(3000);
    }
    public void pickUptime(AndroidDriver driver,String hour,String minutes,String zone)
    {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Pickup Time']")).click();
        driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\""+hour+"\"]")).click();
        driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\""+minutes+"\"]")).click();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='"+zone+"']")).click();
        driver.findElement(By.id("android:id/button1")).click();
    }
    public String selectDate(AndroidDriver driver) throws InterruptedException {
        Date date = new Date();
        SimpleDateFormat formatter12 = new SimpleDateFormat("dd MMMM yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 30);
        String result = formatter12.format(cal.getTime());
        Thread.sleep(2000);
        return result;
    }

    public void pickUpDate(AndroidDriver driver,String result)
    {
        try {
            driver.findElement(By.xpath("//android.view.View[@content-desc=\""+result+"\"]")).click();
        }
        catch (Exception e)
        {
            driver.findElement(By.xpath("//android.view.View[@content-desc=\""+result+" selected\"]")).click();
        }
    }

    public void clickOnSearchButton(AndroidDriver driver)
    {
        driver.findElement(By.className("android.widget.Button")).click();
    }

    public void clickOnBookingCar(AndroidDriver driver)
    {
        driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]")).click();
    }

    public void scrollToButton(AndroidDriver driver)
    {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"BOOK\"))"));
    }
    public void clickOnBookButton(AndroidDriver driver) throws InterruptedException {
        driver.findElement(By.id("com.yatra.base:id/proceedButton")).click();
        Thread.sleep(10000);
    }

    public void enterDetails(AndroidDriver driver, String fname, String lname) throws InterruptedException {
        driver.findElement(By.id("com.yatra.base:id/rb_title_mr")).click();
        //Thread.sleep(3000);
        driver.findElement(By.id("com.yatra.base:id/editFirstNameInRowPassDetailBody")).click();
        driver.findElement(By.xpath("//android.widget.AutoCompleteTextView[@resource-id='com.yatra.base:id/edit_text']")).sendKeys(fname);
        driver.findElement(By.xpath("//android.widget.AutoCompleteTextView[@text='Last Name']")).sendKeys(lname);
        driver.navigate().back();
        driver.findElement(By.id("com.yatra.base:id/proceed_button")).click();
        //driver.findElement(By.id("com.yatra.base:id/btn_continue")).click();
    }


    public void clickToAirport(AndroidDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"AirPort Transfer\"]/android.widget.TextView")).click();
        Thread.sleep(5000);
    }

    public void pickupLocation(AndroidDriver driver)
    {
        driver.findElement(By.id("com.yatra.base:id/pickup_location_container")).click();
        driver.findElement(By.className("android.widget.EditText")).sendKeys("Nagpur");
        driver.findElement(By.xpath("//*[contains(@text,'Sonegaon')]")).click();
    }

    public void dropLocation(AndroidDriver driver)
    {
        driver.findElement(By.id("com.yatra.base:id/drop_location_container")).click();
        driver.findElement(By.className("android.widget.EditText")).sendKeys("Nagpur Bus stand");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Nagpur Bus Stand']")).click();
    }

    public void clickOnSearchCab(AndroidDriver driver) throws InterruptedException {
        driver.findElement(By.className("android.widget.Button")).click();
        Thread.sleep(5000);
    }

    public void clickOnDebitCard(AndroidDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Debit Card']")).click();
        Thread.sleep(5000);
    }
}
