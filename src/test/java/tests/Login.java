package tests;

import base.AndroidBaseClass;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login{

    public AndroidDriver driver;

    @BeforeMethod
    public void setupDriverServer()
    {
        try {
            AndroidBaseClass.setup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test()
    public void login()
    {
        AndroidBaseClass base=new AndroidBaseClass();
        base.preset();
    }
}
