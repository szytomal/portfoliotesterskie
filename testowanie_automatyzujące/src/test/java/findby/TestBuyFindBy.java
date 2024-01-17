package findby;

import findby.findby.*;
import findby.framework.DriverProvider;
import findby.framework.SetUp;
import findby.precondition.Precondition;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;


public class TestBuyFindBy {

    BuyingProduct buyingProduct;
    Checkout checkout;
    ProductPage productPage;
    String message;
    Precondition requirements;
    CartView cartView;
    BuyingProductModal buyingProductModal;


    @BeforeEach
    public void setUp() {
        SetUp.prepareDriverForTest();
    }

    @Test
    public void buyingProcess() {
        buyingProduct = new BuyingProduct();
        checkout = new Checkout();
        productPage = new ProductPage();
        requirements = new Precondition();
        cartView = new CartView();
        buyingProductModal = new BuyingProductModal();

        requirements.precondition("Jakies imie", "Jakies nazwisko", "Jakistammail@mail.com", "Trudne haslow");

        productPage.openProduct();
        buyingProduct.addCart();
        buyingProductModal.proceedToCart();
        cartView.proceedToCheckout();

        checkout.addressFilling("Aaaa", "55555", "Bbbbb");
        checkout.chooseDelivery();
        checkout.payment();
        message = checkout.testBuyCondition();
        MatcherAssert.assertThat(message, containsString("YOUR ORDER IS CONFIRMED"));
    }

    @AfterEach
    public void tearDown() {
        DriverProvider.quitDriver();
    }
}
