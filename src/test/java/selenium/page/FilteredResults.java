package selenium.page;

import selenium.framework.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FilteredResults {

    static WebDriverWait wait;

    public static void sorting(String whichWay) {
        wait = new WebDriverWait(DriverProvider.getDriver(), Duration.ofSeconds(5));
        DriverProvider.getDriver().findElement(By.className("select-title")).click();
        DriverProvider.getDriver().findElement(By.xpath(String.format("//*[contains(text(), '%s')]", whichWay))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".faceted-overlay")));
    }

    public static String checkSortBy() {
        WebElement sortorder = DriverProvider.getDriver().findElement(By.className("select-title"));
        return sortorder.getText();
    }

    public static String checkPageName() {
        WebElement pagename = DriverProvider.getDriver().findElement(By.className("h2"));
        return pagename.getText();
    }

}