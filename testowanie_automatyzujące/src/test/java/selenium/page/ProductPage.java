package selenium.page;

import selenium.framework.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {

    static WebDriverWait wait;

    public static void openProduct(String productName) {
        DriverProvider.getDriver().findElement(By.xpath(String.format("//*[contains(@alt, '%s')]", productName))).click();
    }

    public static void addToCart(){
        WebDriverWait wait = new WebDriverWait(DriverProvider.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".add-to-cart"))).click();
    }

    public static void addToWishList() {
        wait = new WebDriverWait(DriverProvider.getDriver(), Duration.ofSeconds(5));
        DriverProvider.getDriver().findElement(By.className("wishlist-button-add")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".wishlist-list-item")));
        DriverProvider.getDriver().findElement(By.cssSelector(".wishlist-list-item")).click();
    }

}
