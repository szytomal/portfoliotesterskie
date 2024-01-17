package selenide.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ContactUs {


    public static void fillForm(String mail, String message) {
        $("#email").sendKeys(mail);
        $("#contactform-message").sendKeys(message);
        $(By.name("submitMessage")).click();
    }

    public static void checkContactUs() {
        String message = $(By.className("alert-success")).getText();
        Assertions.assertEquals("Your message has been successfully sent to our team.", message);
    }
}
