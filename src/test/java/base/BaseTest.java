package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;
import utils.DriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    protected void setup() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getImplicitWait()));
        driver.get(ConfigReader.getUrl());
    }

    @AfterMethod
    protected void tearDown() {
        DriverManager.quitDriver();
    }

}
