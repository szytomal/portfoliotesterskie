package selenium.page;

import selenium.framework.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CreateAccount {

    static WebDriverWait wait;

    public static void createNewAccount(){
        DriverProvider.getDriver().findElement(By.linkText("No account? Create one here")).click();
    }

    public static void fillAllFields(String firstname, String lastname, String email, String passw){
        wait = new WebDriverWait(DriverProvider.getDriver(), Duration.ofSeconds(5));
        WebElement fname = DriverProvider.getDriver().findElement(By.name("firstname"));
        fname.click();
        fname.sendKeys(firstname);
        WebElement lname = DriverProvider.getDriver().findElement(By.name("lastname"));
        lname.click();
        lname.sendKeys(lastname);
        WebElement mail = DriverProvider.getDriver().findElement(By.name("email"));
        mail.click();
        mail.sendKeys(email);
        DriverProvider.getDriver().findElement(By.name("psgdpr")).click();
        DriverProvider.getDriver().findElement(By.name("customer_privacy")).click();
        WebElement pass = DriverProvider.getDriver().findElement(By.name("password"));
        pass.click();
        pass.sendKeys(passw);
    }

    public static void submitAccount(){
        DriverProvider.getDriver().findElement(By.className("form-control-submit")).click();
    }

}
