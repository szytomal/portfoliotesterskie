package selenium.page;

import selenium.framework.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wishlist {

    static WebDriverWait wait;

    public static void oppenWishlist() {
        DriverProvider.getDriver().findElement(By.cssSelector("#wishlist-link > span")).click();
    }

    public static void selectWishlist() {
        wait = new WebDriverWait(DriverProvider.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wishlist-list-item-default")));
        DriverProvider.getDriver().findElement(By.className("wishlist-list-item-title")).click();
    }

    public static String checkWishlist() {
        wait = new WebDriverWait(DriverProvider.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wishlist-products-list")));
        WebElement wishlist = DriverProvider.getDriver().findElement(By.className("wishlist-product-title"));
        return wishlist.getText();
    }

}
