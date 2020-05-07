package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage extends AbstractPage {


    public static WebElement getLoginForm() {
        return $(By.xpath("//*[@id='user-menu-mount']/div/button[contains(text(), 'Войти')]")).should(visible);
    }

    public static void inputValues() {
        final String login = "Krylov";
        final String password = "amigo1986";
        $(By.xpath("//*[@id='id_username']")).val(login);
        $(By.xpath("//*[@id='id_password']")).val(password);
    }

    public static WebElement getSubmitButton() {
        return $(By.xpath("//button[@class='btn btn-primary btn-block']")).should(visible);
    }
}
