package selenide.page;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NavBar {


    public static void openSignIn() {
        $("#_desktop_user_info").shouldBe(Condition.visible).click();
    }

    public static void signnout() {
        $(By.className("logout")).click();
    }

    public static void signin(String mail, String password) {
        $(By.name("email")).sendKeys(mail);
        $(By.name("password")).sendKeys(password);
        $(By.id("submit-login")).click();
    }

    public static void openContactUs() {
        $("#contact-link > a").click();
    }
}
