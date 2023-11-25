package findby.findby;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static findby.framework.DriverProvider.getDriver;


public class BuyingProduct {


    @FindBy(css = ".add-to-cart")
    private WebElement addtoCart;

    public BuyingProduct() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    public void addCart() {
        addtoCart.click();
    }


}
