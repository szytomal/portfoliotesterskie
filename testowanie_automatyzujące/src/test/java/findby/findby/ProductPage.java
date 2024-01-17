package findby.findby;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static findby.framework.DriverProvider.getDriver;

public class ProductPage {


    @FindBy(xpath = "//img[@alt='Hummingbird printed t-shirt']")
    private WebElement openProduct;

    public ProductPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    public void openProduct() {
        openProduct.click();
    }
}
