package selenium.page;

import selenium.framework.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NavBar {

    public static void goToSignIn() {
        DriverProvider.getDriver().findElement(By.cssSelector("#_desktop_user_info")).click();
    }

    public static void searching(String productName) {
        WebElement searching = DriverProvider.getDriver().findElement(By.className("ui-autocomplete-input"));
        searching.click();
        searching.sendKeys(productName);
        searching.submit();
    }

    public static void oppenAccount(String name, String lname) {
        DriverProvider.getDriver().findElement(By.linkText(name + " " + lname)).click();
    }

    public static void goToArt() {
        DriverProvider.getDriver().findElement(By.cssSelector("#category-9 > a")).click();
    }

    public static String checkIfSignIn() {
        WebElement login = DriverProvider.getDriver().findElement(By.className("logout"));
        return login.getText();
    }

}


