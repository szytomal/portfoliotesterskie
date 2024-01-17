package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class testContactUsSelenide {

    @BeforeEach
    public void setUp() {
        Configuration.timeout = 15000;
        open("https://demo.prestashop.com/#/en/front");
        $("#loadingMessage").shouldNotBe(visible);
        SelenideElement shopFrame = $("#framelive").shouldBe(visible);
        switchTo().frame(shopFrame);
    }

    @Test
    public void contactUsSelenide() {

        $("#contact-link > a").click();
        $("#email").sendKeys("ABC@jakismail.com");
        $("#contactform-message").sendKeys("ABC");
        $(By.name("submitMessage")).click();
        String message = $(By.className("alert-success")).getText();
        Assertions.assertEquals("Your message has been successfully sent to our team.", message);
    }

    @AfterEach
    public void tearDown() {
        closeWindow();
    }
}
