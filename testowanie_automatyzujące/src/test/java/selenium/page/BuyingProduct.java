package selenium.page;

import selenium.framework.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BuyingProduct {

    public static void proceedToCart(){
        WebDriverWait wait = new WebDriverWait(DriverProvider.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-content")));
        DriverProvider.getDriver().findElement(By.partialLinkText("PROCEED")).click();
    }

    public static void proceedToCheckout(){
        DriverProvider.getDriver().findElement(By.partialLinkText("PROCEED TO CHECKOUT")).click();
    }

}

