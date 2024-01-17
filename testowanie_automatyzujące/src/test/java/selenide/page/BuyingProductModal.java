package selenide.page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BuyingProductModal {


    public static void goToCart() {
        $("#blockcart-modal div.modal-content .btn-primary").shouldBe(visible).click();
    }
}
