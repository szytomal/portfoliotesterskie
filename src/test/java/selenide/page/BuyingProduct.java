package selenide.page;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BuyingProduct {


    public static void addToCart() {
        $(".add-to-cart").shouldBe(visible).click();
    }
}
