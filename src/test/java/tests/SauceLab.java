package tests;

import base.AndroidBaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddToCart;
import pages.BookOrder;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ReadConfig;

import java.time.Duration;

import static base.AndroidBaseClass.driver;

public class SauceLab {

    //public AndroidDriver driver;
    ReadConfig readConfig = new ReadConfig();

    @BeforeTest
    public void setupDriverServer() {
        try {
            AndroidBaseClass.setup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void login() {
        LoginPage login = new LoginPage();
        login.enterUserName(driver, readConfig.getUsername());
        login.enterPassword(driver, readConfig.getPassword());
        login.clickLoginButton(driver);
    }

    @Test(priority = 1)
    public void addToCart() {
        AddToCart add = new AddToCart();
        add.scrollToProduct(driver, readConfig.getSearchProductName());
        add.goToCart(driver, readConfig.getSearchProductName());
    }

    @Test(priority = 2)
    public void bookOrder() throws InterruptedException {
        BookOrder bookorder = new BookOrder();
        bookorder.clickCheckOut(driver);
        bookorder.fillAddressDetails(driver, readConfig.getFirstName(), readConfig.getLastName(), readConfig.getPincode());
        bookorder.clickToContinue(driver);
        bookorder.confirmOrder(driver);
        Thread.sleep(6000);
    }

    @Test(priority = 3)
    public void logout() {
        LogoutPage logout = new LogoutPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logout.clickOnTapMenu(driver);
        logout.clickOnLogout(driver);
    }

}
