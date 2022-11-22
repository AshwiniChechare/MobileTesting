package pages.yatra;

import com.aventstack.extentreports.gherkin.model.And;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BusBooking {

    public void clickOnBusIcon(AndroidDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Buses']")).click();
        Thread.sleep(3000);

    }

    public void clickOnLeavingFrom(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("com.yatra.base:id/tv_source")).click();
    }

    public void selectFromCity(AndroidDriver driver, String fromcity) throws InterruptedException {
        driver.findElement(By.id("com.yatra.base:id/ed_editSearch")).sendKeys(fromcity);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + fromcity + "']")).click();
        //Thread.sleep(3000);
    }

    public void clickOnGoingCity(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("com.yatra.base:id/tv_destination")).click();
    }

    public void selectGoingCity(AndroidDriver driver, String goingCity) throws InterruptedException {
        driver.findElement(By.id("com.yatra.base:id/ed_editSearch")).sendKeys(goingCity);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + goingCity + "']")).click();
        Thread.sleep(3000);
    }

    public void dateSelection(AndroidDriver driver) throws InterruptedException {
        driver.findElement(By.id("com.yatra.base:id/tv_today")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"18 November 2022\"]")).click();
    }

    public void destinationSelection(AndroidDriver driver, String city) throws InterruptedException {
        try {
            selectGoingCity(driver, city);
        } catch (Exception e) {
            clickOnGoingCity(driver);
            selectGoingCity(driver, city);
        }
    }

    public void clickOnFindBuses(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("com.yatra.base:id/btn_find_buses")).click();
    }

    public void selectBus(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]")).click();

    }

    public void selectSeat(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(10000);
        List<WebElement> seats = driver.findElements(By.id("com.yatra.base:id/lin_cell_container"));
        System.out.println(seats.size());
        for (int i = 0; i < seats.size(); i++) {
            if (seats.get(i).isEnabled()) {
                seats.get(i).click();
                Thread.sleep(4000);
                break;
            }
        }
    }

    public void clickproceedButton(AndroidDriver driver) throws InterruptedException {
        driver.findElement(By.id("com.yatra.base:id/btn_proceed")).click();
        try {
            driver.findElement(By.id("android:id/button1")).click();
        } catch (Exception e) {
            System.out.println("Data is okay");

        }

    }

    public void clickOnBoarding(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")).click();
        Thread.sleep(2000);
        try {
            driver.findElement(By.id("com.yatra.base:id/img_help")).click();
        }catch(Exception e)
        {
            System.out.println("No need to click here");
        }
        driver.findElement(By.id("com.yatra.base:id/spinner_title")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Mr']")).click();
        driver.findElement(By.id("com.yatra.base:id/ed_text_full_name")).sendKeys("Dinesh Parate");
        driver.findElement(By.id("com.yatra.base:id/spinner_age")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='17 Yrs.']")).click();
        driver.findElement(By.id("com.yatra.base:id/btn_proceed")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("com.yatra.base:id/btn_pay")).click();
    }
}
