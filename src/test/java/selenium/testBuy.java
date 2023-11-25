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

public class testBuy {
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
    public void buy() {

        //zalozenie konta i wylogowanie sie z niego
        driver.findElement(By.cssSelector("#_desktop_user_info")).click();
        driver.findElement(By.linkText("No account? Create one here")).click();
        WebElement fname = driver.findElement(By.name("firstname"));
        fname.click();
        fname.sendKeys("Imie");
        WebElement lname = driver.findElement(By.name("lastname"));
        lname.click();
        lname.sendKeys("Nazwisko");
        WebElement mail = driver.findElement(By.name("email"));
        mail.click();
        mail.sendKeys("jakismail@mail.com");
        driver.findElement(By.name("psgdpr")).click();
        driver.findElement(By.name("customer_privacy")).click();
        WebElement pass = driver.findElement(By.name("password"));
        pass.click();
        pass.sendKeys("Nawetniewiem");
        driver.findElement(By.className("form-control-submit")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out"))).click();

        //zalogowanie sie na istniejace konto
        driver.findElement(By.cssSelector("#_desktop_user_info")).click();
        WebElement email = driver.findElement(By.name("email"));
        email.click();
        email.sendKeys("jakismail@mail.com");
        WebElement passw = driver.findElement(By.name("password"));
        passw.click();
        passw.sendKeys("Nawetniewiem");
        driver.findElement(By.id("submit-login")).click();

        //dodanie elementu do koszyka
        driver.findElement(By.linkText("Hummingbird Printed T-Shirt")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".add-to-cart")));
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart-content")));
        driver.findElement(By.partialLinkText("PROCEED")).click();
        driver.findElement(By.partialLinkText("PROCEED TO CHECKOUT")).click();

        //uzupelnienie formularza z adresem
        WebElement adress = driver.findElement(By.name("address1"));
        adress.click();
        adress.sendKeys("jakisadres");
        WebElement zip = driver.findElement(By.name("postcode"));
        zip.click();
        zip.sendKeys("55555");
        WebElement city = driver.findElement(By.name("city"));
        city.click();
        city.sendKeys("jakiesmiasto");

        //uzupelnienie dostawy i platnosci
        driver.findElement(By.name("confirm-addresses")).click();
        driver.findElement(By.name("confirmDeliveryOption")).click();
        driver.findElement(By.id("payment-option-1")).click();
        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ps-shown-by-js > button"))).click();

        //warunek powodzenia testu
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content-hook_order_confirmation")));
        WebElement message = driver.findElement(By.id("content-hook_order_confirmation"));
        Assertions.assertEquals("\uE876YOUR ORDER IS CONFIRMED\nAn email has been sent to the jakismail@mail.com address.", message.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}


