package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static WebDriver driver;


    private DriverManager(){}

    public static WebDriver getDriver(){
        if (null == driver){
            switch (System.getProperty("browser")){
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                default: {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
            }
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
