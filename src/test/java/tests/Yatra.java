package tests;

import base.AndroidBaseClass;
import base.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.yatra.BusBooking;
import pages.yatra.FlightBooking;
import pages.yatra.Login;
import pages.yatra.Logout;

import java.time.Duration;

import static base.BaseClass.driver;

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

    @Test
    public void loginTestCase() {
        test = extent.createTest("LoginTest");
        Login login = new Login();
        login.login(driver, "afourtechnology@gmail.com", "G00gle@123");
        test.log(Status.INFO, "Login test successfully");
    }

    @Test(priority = 1)
    public void flightBookingTestCase() throws InterruptedException {
        /*test = extent.createTest("FlightBooking Test");
        FlightBooking flight = new FlightBooking();
        flight.preset(driver);
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
        test.log(Status.INFO, "flightBooking test successfully");*/
        test = extent.createTest("Busbooking Test");
        BusBooking bus=new BusBooking();
        bus.clickOnBusIcon(driver);
        bus.clickOnLeavingFrom(driver);
        bus.selectFromCity(driver,"Mumbai");
        bus.destinationSelection(driver,"Delhi");
        //bus.dateSelection(driver);
        bus.clickOnFindBuses(driver);
        bus.selectBus(driver);
        bus.selectSeat(driver);

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
