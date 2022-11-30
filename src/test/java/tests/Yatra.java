package tests;

import base.BaseClass;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.yatra.*;

import java.time.Duration;

public class Yatra extends BaseClass {

    @BeforeTest
    public void report() {
        BaseClass.startReport();
    }

    @BeforeTest
    public void setupDriverServer() {
        try {
            BaseClass.setup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void preset(AndroidDriver driver) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
            //Thread.sleep(1000);
            //driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        } catch (Exception e) {
            System.out.println("presetting is done");
        }
    }

    @Test
    public void loginTestCase() {
        test = extent.createTest("LoginTest");
        Login login = new Login();
        preset(driver);
        login.login(driver, "afourtechnology@gmail.com", "G00gle@123");
        test.log(Status.INFO, "Login test successfully");
    }

    public String selectBookingOptionText() {
        return "train";
    }

    @Test(priority = 1)
    public void BookingTestCase() throws InterruptedException {
        String text = selectBookingOptionText();
        if (text == "flight") {
            test = extent.createTest("FlightBooking Test");
            FlightBooking flight = new FlightBooking();

            flight.clickOnFlights(driver);
            flight.clickOnFromCity(driver);
            flight.enterfromCityName(driver, "Mumbai");
            flight.enterDestinationcityName(driver, "Mumbai", "Nagpur");
            flight.selectDate();
            flight.selectTraveller(driver, 0, 0, 0);
            flight.clickonClass(driver);
            flight.clickOnSearchFlight(driver);
            flight.clickonFlight(driver);
            flight.proceedButton(driver);
            flight.enterDetails(driver, "Dinesh", "Parate");
            test.log(Status.INFO, "flightBooking test successfully");
        } else if (text == "Bus") {
            test = extent.createTest("Busbooking Test");
            BusBooking bus = new BusBooking();
            bus.clickOnBusIcon(driver);
            bus.clickOnLeavingFrom(driver);
            bus.selectFromCity(driver, "Mumbai");
            bus.destinationSelection(driver, "Delhi");
            //bus.dateSelection(driver);
            bus.clickOnFindBuses(driver);
            bus.selectBus(driver);
            bus.selectSeat(driver);
            bus.clickproceedButton(driver);
            bus.clickOnBoarding(driver);
            test.log(Status.INFO, "BusBooking test successfully run");
        } else if (text == "Hotel") {
            test = extent.createTest("Hotel Test");
            HotelsBooking hotel = new HotelsBooking();
            hotel.clickOnHotelsIcon(driver, "Manali");
            hotel.enterDetails(driver,"Dinesh","Parate");
            test.log(Status.INFO, "HotelsBooking test successfully run");
        }
        else if(text=="train")
        {
            driver.findElement(By.id("com.yatra.base:id/iv_right_arrow")).click();
            test = extent.createTest("Train Test");
            TrainsBooking train=new TrainsBooking();
            train.trainBooking(driver,"Nagpur","Mumbai");
            test.log(Status.INFO, "Train Booking test case successfully run");
        }

    }

    /*@Test(priority = 2)
    public void logoutTestCase()
    {
        Logout logout=new Logout();
        logout.logout(driver);
    }*/


    @AfterMethod
    public void tearDown(ITestResult result) {
        BaseClass.close(result);
    }

    @AfterTest
    public void closeReport() {
        BaseClass.endReport();
    }

    @AfterTest
    public void tearDow() {
        BaseClass.tearDown();
    }
}
