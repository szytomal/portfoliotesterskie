package selenium.page;

import selenium.framework.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Address {

    public static void addressFilling(String address, String zipcode, String city) {
        WebElement address2 = DriverProvider.getDriver().findElement(By.name("address1"));
        address2.click();
        address2.sendKeys(address);
        WebElement zipc = DriverProvider.getDriver().findElement(By.name("postcode"));
        zipc.click();
        zipc.sendKeys(zipcode);
        WebElement cityname = DriverProvider.getDriver().findElement(By.name("city"));
        cityname.click();
        cityname.sendKeys(city);
        DriverProvider.getDriver().findElement(By.name("confirm-addresses")).click();
    }

    public static String checkAddress() {
        WebElement address = DriverProvider.getDriver().findElement(By.className("carriere-name-container"));
        return address.getText();
    }

}