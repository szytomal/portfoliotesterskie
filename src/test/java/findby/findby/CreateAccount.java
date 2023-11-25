package findby.findby;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static findby.framework.DriverProvider.getDriver;

public class CreateAccount {


    @FindBy(css = "#content > div")
    private WebElement openCreatingAccount;

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(name = "email")
    private WebElement mail;

    @FindBy(name = "password")
    private WebElement pass;

    @FindBy(name = "psgdpr")
    private WebElement agreeToTerms;

    @FindBy(name = "customer_privacy")
    private WebElement customerDataPrivacy;

    @FindBy(className = "form-control-submit")
    private WebElement accountSubmit;


    public CreateAccount() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    public void createNewAccount(String fname, String lname, String email, String passw) {
        openCreatingAccount.click();
        firstName.click();
        firstName.sendKeys(fname);
        lastName.click();
        lastName.sendKeys(lname);
        mail.click();
        mail.sendKeys(email);
        agreeToTerms.click();
        customerDataPrivacy.click();
        pass.click();
        pass.sendKeys(passw);
    }

    public void submitNewAccount() {
        accountSubmit.click();
    }
}
