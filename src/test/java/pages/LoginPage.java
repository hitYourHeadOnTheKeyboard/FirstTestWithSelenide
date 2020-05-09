package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.annotations.Element;
import pages.annotations.Page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Page(title = "Авторизация")
public class LoginPage extends AbstractPage {

    @Element("Логин")
    public static void inputLogin() {
        final String LOGIN = "Krylov";
        $(By.xpath("//*[@id='id_username']")).val(LOGIN);
    }

    @Element("Пароль")
    public static void inputPassword() {
        final String PASSWORD = "amigo1986";
        $(By.xpath("//*[@id='id_password']")).val(PASSWORD);
    }

    @Element("Submit (Войти)")
    public static WebElement getSubmitButton() {
        return $(By.xpath("//button[@class='btn btn-primary btn-block']")).should(visible);
    }
}
