package findby.findby;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static findby.framework.DriverProvider.getDriver;

public class CartView {


    @FindBy(css = "#main  div.card.cart-summary  .btn-primary")
    private WebElement proceedToCheckout;

    public CartView() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    public void proceedToCheckout() {
        proceedToCheckout.click();
    }
}
