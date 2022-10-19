package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AndroidActions;

import java.time.Duration;

import static base.AndroidBaseClass.driver;

public class BookOrder extends AndroidActions {
    double sum = 0;
    double actualp_price;
    String p_price = null;

    public double converstionofStringToDouble(String value) {
        double actualp_price = Double.parseDouble(value.substring(1));
        return actualp_price;
    }

    public double getProductValue(AndroidDriver driver, String arr[]) throws InterruptedException {

        WebElement ele=null;
        for (int i = 0; i < arr.length; i++) {
            try {
                 ele = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[@text='" + arr[i] + "']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup[2]/android.widget.TextView"));
                p_price = ele.getText();
                actualp_price = converstionofStringToDouble(p_price);
                sum = sum + actualp_price;
                System.out.println(actualp_price);
            } catch (Exception e) {
                driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + arr[i] + "\"))"));
                Thread.sleep(10000);
                ele = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[@text='" + arr[i] + "']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup[2]/android.widget.TextView"));
                //Thread.sleep(5000);
                p_price = ele.getText();
                actualp_price = converstionofStringToDouble(p_price);
                sum = sum + actualp_price;
                System.out.println(actualp_price);

            }
        }
        System.out.println(sum);
        return sum;
        //android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[@text='Sauce Labs Bolt T-Shirt']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup[2]/android.widget.TextView
    }

    public void clickCheckOut(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(description(\"test-CHECKOUT\"))"));

        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='test-CHECKOUT']")).click();
    }

    public void fillAddressDetails(AndroidDriver driver, String fname, String lname, String pincode) {
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.EditText[@content-desc=\"test-First Name\"]")).sendKeys(fname);
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.EditText[@content-desc=\"test-Last Name\"]")).sendKeys(lname);
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='test-Zip/Postal Code']")).sendKeys(pincode);
        driver.hideKeyboard();

    }

    public void clickToContinue(AndroidDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("test-CONTINUE")).click();
    }

    public void assertionCheck(double actualsum) {

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(textContains(\"Item total:\"))"));
        WebElement ele = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.TextView[5]"));
        String total = ele.getText();
        double totalvalue = Double.parseDouble(total.substring(13));
        System.out.println(totalvalue);
        try
        {
            Assert.assertEquals(actualsum,totalvalue);
            System.out.println("assertion passed");
            System.out.println("individual product sum value :"+actualsum+" total value :"+totalvalue);
        }
        catch (Exception e)
        {
            System.out.println("assertion failed");
        }

    }

    public void confirmOrder(AndroidDriver driver) {

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(description(\"test-FINISH\"))"));

        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")).click();
    }
}
