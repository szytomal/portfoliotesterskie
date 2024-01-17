package findby;

import findby.findby.ContactUs;
import findby.findby.NavBar;
import findby.framework.DriverProvider;
import findby.framework.SetUp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestContactUsFindBy {
    NavBar navBar;
    ContactUs contactUs;

    @BeforeEach
    public void setUp() {
        SetUp.prepareDriverForTest();
    }

    @Test
    public void contactUsFindBy() {
        navBar = new NavBar();
        contactUs = new ContactUs();
        navBar.openContactUs();
        contactUs.whatEmail("jakissobie@mail.com");
        contactUs.whatMessage("ABC");
        contactUs.sendMessage();
        Assertions.assertEquals("Your message has been successfully sent to our team.", ContactUs.contactCondition());
    }

    @AfterEach
    public void tearDown() {
        DriverProvider.quitDriver();
    }
}
