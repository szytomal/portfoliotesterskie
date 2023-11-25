package findby.findby;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static findby.framework.DriverProvider.getDriver;

public class NavBar {


    @FindBy(css = "#contact-link > a")
    private WebElement contactUs;

    @FindBy(css = "#_desktop_user_info")
    private WebElement openSignUp;

    public NavBar() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    public void openSignUp() {
        openSignUp.click();
    }

    public void openContactUs() {
        contactUs.click();
    }
}
