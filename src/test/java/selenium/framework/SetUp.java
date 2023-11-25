package selenium.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static selenium.framework.DriverProvider.getDriver;

public class SetUp {

    public static WebDriver prepareDriverForTest() {
        WebDriver driver = getDriver();
        loadPageAndSwitchFrame(driver);
        return driver;
    }

    public static void loadPageAndSwitchFrame(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.get("https://demo.prestashop.com/#/en/front");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#loadingMessage")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("#framelive")));
    }

}
