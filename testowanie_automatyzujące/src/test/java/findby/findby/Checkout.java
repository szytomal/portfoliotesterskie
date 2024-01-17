package findby.findby;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static findby.framework.DriverProvider.getDriver;

public class Checkout {


    @FindBy(name = "address1")
    private WebElement address;

    @FindBy(name = "postcode")
    private WebElement zip;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(name = "confirm-addresses")
    private WebElement addressMoveForward;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement deliveryProceed;

    @FindBy(id = "payment-option-1")
    private WebElement paybycash;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement agreeToTerms;

    @FindBy(css = "div.ps-shown-by-js > button")
    private WebElement confirmOrder;

    @FindBy(id = "content-hook_order_confirmation")
    private static WebElement buyCondition;

    public Checkout() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    public void addressFilling(String addr, String postal, String cityName) {
        address.click();
        address.sendKeys(addr);
        zip.click();
        zip.sendKeys(postal);
        city.click();
        city.sendKeys(cityName);
        addressMoveForward.click();
    }

    public void chooseDelivery() {
        deliveryProceed.click();
    }

    public void payment() {
        paybycash.click();
        agreeToTerms.click();
        confirmOrder.click();
    }

    public static String testBuyCondition() {
        WebElement message = buyCondition;
        return message.getText();
    }
}
