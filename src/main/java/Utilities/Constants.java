package Utilities;

public class Constants {

    public static  String URL;
    public static  String BROWSER_NAME;
    public static String TEST_TYPE;
    static  {


        {
            if(System.getProperty("browser")!=null){BROWSER_NAME = System.getProperty("browser");}

            else {BROWSER_NAME = ConfigFileReader.getPropertyValue("browser");}
        }

        {
            if(System.getProperty("testType")!=null){TEST_TYPE = System.getProperty("testType");}

            else {TEST_TYPE = ConfigFileReader.getPropertyValue("testType");}
        }

        URL = ConfigFileReader.getPropertyValue("url");

    }
}
