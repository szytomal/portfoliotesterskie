package findby.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverProvider {
    private static WebDriver driverInstance;

    public static WebDriver getDriver() {
        if (driverInstance == null) {
            System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--allowed-ips=*");
            options.addArguments("--whitelisted-ips==*");
            driverInstance = new ChromeDriver(options);
        }
        return driverInstance;
    }

    public static void quitDriver() {
        if (driverInstance != null) {
            getDriver().quit();
            driverInstance = null;
        }
    }
}
