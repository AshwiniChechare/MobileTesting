package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties prop;
    public ReadConfig(){

        //	FileInputStream fis = new FileInputStream("C:\\Users\\pradi\\eclipse-workspace\\FlipcartAppV3\\FlipcartApp3\\src\\main\\resources\\com\\flipcart\\properties\\global.properties");

        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\properties\\global.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getLangauge()
    {
        String lang = (String) prop.get("lang");
        return lang;
    }

    public String getUsername()
    {
        String uname = (String) prop.get("gmail");
        return uname;
    }

    public String getPassword()
    {
        String pwd = (String) prop.get("password");
        return pwd;
    }

    public String getSearchProductName()
    {
        String pname = (String) prop.get("productsearchname");
        return pname;
    }

    public String getAppName()
    {
        String appname = (String) prop.get("FlipcartApp");
        return appname;
    }

    public String getDeviceName()
    {
        String devicename = (String) prop.get("device");
        return devicename;
    }

    public String getFirstName()
    {
        String fname = (String) prop.get("fname");
        return fname;
    }

    public String getLastName()
    {
        String lname = (String) prop.get("lname");
        return lname;
    }

    public String getOrderName()
    {
        String ordername = (String) prop.get("ordername");
        return ordername;
    }

    public String getFilterName()
    {
        String filtername = (String) prop.get("filtername");
        return filtername;
    }

    public String geturl()
    {
        String url = (String) prop.get("Url");
        return url;
    }

    public String getPincode()
    {
        String pincode = (String) prop.get("pincode");
        return pincode;
    }
    public String getVersion()
    {
        String version=(String)prop.get("androidversion");
        return version;
    }
}
