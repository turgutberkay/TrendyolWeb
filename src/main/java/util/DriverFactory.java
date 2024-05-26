package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {

    static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public WebDriver setDriver(String browser) {
        switch (browser) {
            case "Chrome":
                WebDriverManager.chromedriver().clearDriverCache();
                WebDriverManager.chromedriver().clearResolutionCache();
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-popup-blocking");
                driverThreadLocal.set(new ChromeDriver(chromeOptions));
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().clearDriverCache();
                WebDriverManager.firefoxdriver().clearResolutionCache();
                WebDriverManager.firefoxdriver().setup();
                driverThreadLocal.set(new FirefoxDriver());
                break;
            case "Edge":
                WebDriverManager.edgedriver().clearDriverCache();
                WebDriverManager.edgedriver().clearResolutionCache();
                WebDriverManager.edgedriver().setup();
                driverThreadLocal.set(new EdgeDriver());
                break;
            case "Safari":
                // SafariDriver setup can be different based on your OS
                driverThreadLocal.set(new SafariDriver());
                break;
        }

        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }
}
