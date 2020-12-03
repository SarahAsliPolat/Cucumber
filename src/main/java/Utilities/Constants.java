package Utilities;

public class Constants {

    public static  String URL;
    public static  String BROWSER_NAME;

    static  {


        if(BROWSER_NAME==null){
            if(System.getProperty("browser")!=null){BROWSER_NAME = System.getProperty("browser");}

            else {BROWSER_NAME = ConfigFileReader.getPropertyValue("browser");}
        }

        URL = ConfigFileReader.getPropertyValue("url");

    }
}
