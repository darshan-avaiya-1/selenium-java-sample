package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

    public static void initDriver() {

        WebDriver driver = null;
        String browser = ConfigReader.getBrowser().toLowerCase();

        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Please enter correct browser name");
        }
        threadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        if (threadLocal.get() == null) {
            initDriver();
        }
        return threadLocal.get();
    }

    public static void quitDriver() {
        if (threadLocal.get() != null) {
            threadLocal.get().quit();
        }
        threadLocal.remove();
    }

}
