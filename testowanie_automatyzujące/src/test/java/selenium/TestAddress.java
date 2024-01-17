package selenium;

import selenium.framework.DriverProvider;
import selenium.framework.SetUp;
import selenium.page.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAddress {

    @BeforeEach
    public void setUp() {
        SetUp.prepareDriverForTest();
    }

    @Test
    public void addressTest() {
        NavBar.goToSignIn();
        CreateAccount.createNewAccount();
        CreateAccount.fillAllFields("Imie", "Nazwisko", "jakismail@aa.pl", "napewnosilnehaslo");
        CreateAccount.submitAccount();
        ProductPage.openProduct("Hummingbird");
        ProductPage.addToCart();
        BuyingProduct.proceedToCart();
        BuyingProduct.proceedToCheckout();
        Address.addressFilling("Aaaa", "55555", "aaaaa");
        Assertions.assertEquals("Click and collect", Address.checkAddress());
    }

    @AfterEach
    public void tearDown() {
        DriverProvider.getDriver().quit();
    }

}
