package util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

public class Hooks {

    DriverFactory driverFactory = new DriverFactory();
    public static String browser;

    @Before
    public void setUp() {
        browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        driverFactory.setDriver(browser);

    }

    @After
    public void quitBrowser() {
        DriverFactory.getDriver().quit();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed_login.png");
        }
    }



}
