package tests;

import base.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.yatra.Login;
import pages.yatra.Logout;

import static base.BaseClass.driver;

public class Yatra {

    @BeforeTest
    public void setupDriverServer() {
        try {
            BaseClass.setup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginTestCase()
    {
        Login login=new Login();
        login.login(driver,"afourtechnology@gmail.com","G00gle@123");
    }
    @Test(priority = 1)
    public void logoutTestCase()
    {
        Logout logout=new Logout();
        logout.logout(driver);
    }
}
