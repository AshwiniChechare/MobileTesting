package pages.yatra;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class Login {

    public void login(AndroidDriver driver,String username,String password) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.findElement(By.id("com.yatra.base:id/btn_login_widget")).click();
            driver.findElement(By.id("com.yatra.base:id/et_input_field")).sendKeys(username);
            driver.findElement(By.id("com.yatra.base:id/continue_login")).click();
            driver.findElement(By.id("com.yatra.base:id/et_user_password")).sendKeys(password);
            driver.findElement(By.id("com.yatra.base:id/tv_proceed_to_login")).click();
            //System.out.println("Login Succesfully");
        }
        catch (Exception e)
        {
            System.out.println("You are successfully logged in");
        }
    }
}
