package tests;

import base.AndroidBaseClass;
import com.aventstack.extentreports.Status;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.AddToCart;
import pages.BookOrder;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ReadConfig;

import java.time.Duration;

import static base.AndroidBaseClass.driver;
import static utilities.ObjectsRepo.extent;

public class SauceLab extends AndroidBaseClass {

    //public AndroidDriver driver;
    ReadConfig readConfig = new ReadConfig();
    String arr[] = {"Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie"};

    @BeforeTest
    public void report() {
        AndroidBaseClass.startReport();
    }

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
        test = extent.createTest("LoginTest");
        LoginPage login = new LoginPage();
        login.enterUserName(driver, readConfig.getUsername());
        test.log(Status.INFO, "User enter username");
        login.enterPassword(driver, readConfig.getPassword());
        test.log(Status.INFO, "User enter password");
        login.clickLoginButton(driver);
        test.log(Status.INFO, "click on login button");
    }

    @Test(priority = 1)
    public void addToCart() {
        test = extent.createTest("AddToCartTest");
        AddToCart add = new AddToCart();
        add.scrollToProduct(driver, readConfig.getSearchProductName());
        test.log(Status.INFO, "Scroll to particular productName");
        add.goToCart(driver, readConfig.getSearchProductName());
        test.log(Status.INFO, "Go to Cart");
    }

    @Test(priority = 2)
    public void bookOrder() throws InterruptedException {
        test = extent.createTest("BookOrderTest");
        BookOrder bookorder = new BookOrder();
        double sum = bookorder.getProductValue(driver, arr);
        Thread.sleep(5000);
        bookorder.clickCheckOut(driver);
        test.log(Status.INFO, "Click to Check out button");
        bookorder.fillAddressDetails(driver, readConfig.getFirstName(), readConfig.getLastName(), readConfig.getPincode());
        test.log(Status.INFO, "Fill address details for book order");
        bookorder.clickToContinue(driver);
        test.log(Status.INFO, "Click to continue for book order");
        Thread.sleep(5000);
        bookorder.assertionCheck(sum);
        test.log(Status.INFO, "Check the assertion");
        bookorder.confirmOrder(driver);
        test.log(Status.INFO, "Click to Confirm Order to book order");
        Thread.sleep(6000);
    }

    @Test(priority = 3)
    public void logout() {
        test = extent.createTest("LogoutTest");
        LogoutPage logout = new LogoutPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logout.clickOnTapMenu(driver);
        test.log(Status.INFO, "Click to Tap menu");
        logout.clickOnLogout(driver);
        test.log(Status.INFO, "Click to Tap menu log out button");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        AndroidBaseClass.close(result);
    }

    @AfterTest
    public void closeReport() {
        AndroidBaseClass.endReport();
    }

    @AfterTest
    public void tearDow() {
        AndroidBaseClass.tearDown();
    }

}