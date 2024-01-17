package selenium;

import selenium.framework.DriverProvider;
import selenium.framework.SetUp;
import selenium.page.CreateAccount;
import selenium.page.NavBar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestNewClient {

    @BeforeEach
    public void setUp() {
        SetUp.prepareDriverForTest();
    }

    @Test
    public void testNewClient() {
        NavBar.goToSignIn();
        CreateAccount.createNewAccount();
        CreateAccount.fillAllFields("Imie", "Nazwisko", "jakismail@aa.pl", "pass121314142412");
        CreateAccount.submitAccount();
        Assertions.assertEquals("\uE7FF Sign out", NavBar.checkIfSignIn());
    }

    @AfterEach
    public void tearDown() {
        DriverProvider.getDriver().quit();
    }

}