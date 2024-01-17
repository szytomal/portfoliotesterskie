package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.containsString;


public class testBuySelenide {

    @BeforeEach
    public void setUp() {
        // przygotowanie do przeprowadzenia testu

        Configuration.timeout = 15000;
        open("https://demo.prestashop.com/#/en/front");
        $("#loadingMessage").shouldNotBe(visible);
        SelenideElement shopFrame = $("#framelive").shouldBe(visible);
        switchTo().frame(shopFrame);
    }

    @Test
    public void buySelenide() {
        // warunek wstępny - zalozenie konta i wylogowanie sie z niego

        $("#_desktop_user_info").click();
        $(By.xpath("//*[@id=\"content\"]/div/a")).click();
        $(By.name("firstname")).sendKeys("Imie");
        $(By.name("lastname")).sendKeys("Nazwisko");
        $(By.name("email")).sendKeys("jakismail@mail.com");
        $(By.name("psgdpr")).click();
        $(By.name("customer_privacy")).click();
        $(By.name("password")).sendKeys("Nawetniewiem");
        $(By.className("form-control-submit")).click();
        $(By.className("logout")).click();

        // zalogowanie sie na istniejace konto

        $("#_desktop_user_info").click();
        $(By.name("email")).sendKeys("jakismail@mail.com");
        $(By.name("password")).sendKeys("Nawetniewiem");
        $(By.id("submit-login")).click();

        // dodanie elementu do koszyka

        $x(("//img[@alt='Hummingbird printed t-shirt']")).click();
        $(".add-to-cart").shouldBe(visible).click();
        $("#blockcart-modal div.modal-content .btn-primary").shouldBe(visible).click();
        $("#main  div.card.cart-summary  .btn-primary").click();

        // uzupelnienie formularza z adresem

        $(By.name("address1")).sendKeys("jakisadres");
        $(By.name("postcode")).sendKeys("55555");
        $(By.name("city")).sendKeys("jakiesmiasto");
        $(By.name("confirm-addresses")).click();

        // uzupelnienie dostawy i platnosci

        $(By.name("confirmDeliveryOption")).click();
        $(By.id("payment-option-1")).click();
        $(By.id("conditions_to_approve[terms-and-conditions]")).click();
        $("div.ps-shown-by-js > button").shouldBe(enabled).click();

        // warunek powodzenia testu

        $(By.id("content-hook_order_confirmation")).shouldBe(visible);
        String message = $(By.id("content-hook_order_confirmation")).getText();
        MatcherAssert.assertThat(message, containsString("YOUR ORDER IS CONFIRMED"));
    }

    @AfterEach
    public void tearDown() {
        closeWindow();
    }
}
