package selenium;

import selenium.framework.DriverProvider;
import selenium.framework.SetUp;
import selenium.page.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestWishlist {

    @BeforeEach
    public void setUp() {
        SetUp.prepareDriverForTest();
    }

    @Test
    public void testWl() {
        String product = "Mug The best is yet to come";
        String fname = "imie";
        String lname = "nawisko";
        NavBar.goToSignIn();
        CreateAccount.createNewAccount();
        CreateAccount.fillAllFields(fname, lname, "mail@mail.com", "nawetniewiemjakieshaslo");
        CreateAccount.submitAccount();
        ProductPage.openProduct(product);
        ProductPage.addToWishList();
        NavBar.oppenAccount(fname, lname);
        Wishlist.oppenWishlist();
        Wishlist.selectWishlist();
        Assertions.assertEquals(product, Wishlist.checkWishlist());
    }

    @AfterEach
    public void tearDown() {
        DriverProvider.getDriver().quit();
    }

}