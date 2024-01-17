package selenide.page;

import static com.codeborne.selenide.Selenide.$;

public class CartView {


    public static void proceedToCheckout() {
        $("#main  div.card.cart-summary  .btn-primary").click();
    }
}
