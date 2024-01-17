package findby.findby;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static findby.framework.DriverProvider.getDriver;

public class BuyingProductModal {


    @FindBy(css = "#blockcart-modal div.modal-content .btn-primary")
    private WebElement proceedToCart;

    public BuyingProductModal() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    public void proceedToCart() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart-content")));
        proceedToCart.click();
    }
}
