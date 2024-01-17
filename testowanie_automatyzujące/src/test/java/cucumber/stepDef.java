package cucumber;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenide.page.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class stepDef {

    @Given("Open prestashop and Switch to frame")
    public void openPrestaShop() {
        Configuration.timeout = 15000;
        open("https://demo.prestashop.com/#/en/front");
        $("#loadingMessage").shouldNotBe(visible);
        SelenideElement shopFrame = $("#framelive").shouldBe(visible);
        switchTo().frame(shopFrame);
    }

    @When("Open Contact Us")
    public void openContactUs() {
        NavBar.openContactUs();
    }

    @And("Fill form as {string} {string}")
    public void fillingForm(String email, String message) {
        ContactUs.fillForm(email, message);
    }

    @Then("Check if form sent successfully")
    public void checkCU() {
        ContactUs.checkContactUs();
    }

    @When("Create new account as {string} {string} {string} {string}")
    public void creatingAccount(String fname, String lname, String pass, String mail) {
        NavBar.openSignIn();
        CreatingAccount.creatingAccount(fname, lname, pass, mail);
        CreatingAccount.submitAccount();
    }

    @And("Sign out")
    public static void signOut() {
        NavBar.signnout();
    }

    @And("Sign in as {string} {string}")
    public void signIn(String mail, String password) {
        NavBar.openSignIn();
        NavBar.signin(mail, password);
    }

    @And("Add product to cart by {string}")
    public void addToCart(String productName) {
        ProductPage.openProduct(productName);
        BuyingProduct.addToCart();
    }

    @And("Go to cart")
    public void gotocart() {
        BuyingProductModal.goToCart();
    }

    @And("Buy")
    public void proceedToChekout() {
        CartView.proceedToCheckout();
    }

    @And("Fill address as {string} {string} {string}")
    public void fillAddress(String address, String city, String zipcode) {
        Checkout.addressFilling(address, city, zipcode);
    }

    @And("Fill delivery")
    public void fillDelivery() {
        Checkout.delivery();
    }

    @And("Fill payment")
    public void fillPayment() {
        Checkout.payment();
    }

    @Then("Check if order is completed")
    public void checkOrder() {
        Checkout.checkOrder();
    }
}
