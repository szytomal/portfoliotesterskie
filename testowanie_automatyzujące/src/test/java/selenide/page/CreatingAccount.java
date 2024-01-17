package selenide.page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreatingAccount {


    public static void creatingAccount(String fname, String lname, String passw, String mail) {
        $(By.xpath("//*[@id=\"content\"]/div/a")).click();
        $(By.name("firstname")).sendKeys(fname);
        $(By.name("lastname")).sendKeys(lname);
        $(By.name("email")).sendKeys(mail);
        $(By.name("psgdpr")).click();
        $(By.name("customer_privacy")).click();
        $(By.name("password")).sendKeys(passw);
    }

    public static void submitAccount() {
        $(By.className("form-control-submit")).click();
    }
}
