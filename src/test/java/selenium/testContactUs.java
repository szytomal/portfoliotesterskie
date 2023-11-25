package selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class testContactUs {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setUp() {

        // przygotowanie do przeprowadzenia testu (tj. zaladowanie strony, drivera itd.)
        System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--allowed-ips=*");
        options.addArguments("--whitelisted-ips==*");
        driver.get("https://demo.prestashop.com/#/en/front");
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#loadingMessage")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("#framelive")));
    }

    @Test
    public void contactUs() {

        //przejscie na zakladke contact us
        driver.findElement(By.cssSelector("#contact-link > a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-md-6")));

        //wypelnienie pol tekstowych na zakladce contact us i wyslanie
        WebElement emailBox = driver.findElement(By.cssSelector("#email"));
        emailBox.click();
        emailBox.sendKeys("ABC@jakismail.com");
        WebElement messageBox = driver.findElement(By.cssSelector("#contactform-message"));
        messageBox.click();
        messageBox.sendKeys("ABC");
        driver.findElement(By.name("submitMessage")).click();

        //warunek powodzenia testu
        WebElement message = driver.findElement(By.className("alert-success"));
        Assertions.assertEquals("Your message has been successfully sent to our team.", message.getText());

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
