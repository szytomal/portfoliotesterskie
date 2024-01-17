package selenide.page;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.CoreMatchers.containsString;

public class Checkout {


    public static void addressFilling(String address, String city, String zipcode) {
        $(By.name("address1")).sendKeys(address);
        $(By.name("postcode")).sendKeys(zipcode);
        $(By.name("city")).sendKeys(city);
        $(By.name("confirm-addresses")).click();
    }

    public static void delivery() {
        $("#js-delivery > button").click();
    }

    public static void payment() {
        $(By.id("payment-option-1")).click();
        $(By.id("conditions_to_approve[terms-and-conditions]")).click();
        $("div.ps-shown-by-js > button").shouldBe(enabled).click();
    }

    public static void checkOrder() {
        $("#content-hook_order_confirmation").shouldBe(visible);
        String message = $(By.id("content-hook_order_confirmation")).getText();
        MatcherAssert.assertThat(message, containsString("YOUR ORDER IS CONFIRMED"));
    }
}
