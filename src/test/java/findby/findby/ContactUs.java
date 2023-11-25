package findby.findby;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static findby.framework.DriverProvider.getDriver;

public class ContactUs {


    @FindBy(css = "#email")
    private WebElement mail;

    @FindBy(css = "#contactform-message")
    private WebElement message;

    @FindBy(name = "submitMessage")
    private WebElement send;

    @FindBy(className = "alert-success")
    private static WebElement contactUsCondition;

    public ContactUs() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    public void whatEmail(String email) {
        mail.click();
        mail.sendKeys(email);
    }

    public void whatMessage(String text) {
        message.click();
        message.sendKeys(text);
    }

    public void sendMessage() {
        send.click();
    }

    public static String contactCondition() {
        WebElement message = contactUsCondition;
        return message.getText();
    }
}
