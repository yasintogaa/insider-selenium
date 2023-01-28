package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public abstract class DriverManager {

    public WebDriver driver;
    public static String baseUrl = "https://useinsider.com/";


    public void setDriver(String testBrowser){
        switch (testBrowser){
            case "chrome":{
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                //driver.manage().window().fullscreen();
                System.out.println("Tests are running via Chrome Browser");
                break;
            }
            case "firefox":{
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                //firefoxOptions.addArguments("--start-maximized");
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().fullscreen();
                System.out.println("Tests are running via Firefox Browser");
                break;
            }
            default:{
                System.out.println("ERROR: Unsupported Browser!");
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void addViewedCookiePolicy(){
        driver.manage().addCookie(new Cookie("viewed_cookie_policy","yes"));
    }
}
