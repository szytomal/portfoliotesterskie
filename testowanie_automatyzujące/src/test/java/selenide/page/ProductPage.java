package selenide.page;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {


    public static void openProduct(String productName) {
        $x((String.format("//*[contains(@alt, '%s')]", productName))).click();
    }
}
