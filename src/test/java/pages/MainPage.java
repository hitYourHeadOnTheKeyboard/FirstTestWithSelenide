package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.annotations.Element;
import pages.annotations.Page;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Page(title = "Главная страница")
public class MainPage extends AbstractPage{

    @Element("Войти")
    public static WebElement getLoginForm() {
        return $(By.xpath("//*[@id='user-menu-mount']/div/button[contains(text(), 'Войти')]")).should(visible);
    }

    @Element("Случайной темы")
    public static WebElement getRandomTopic() throws InterruptedException {
        Thread.sleep(2000);
        ElementsCollection collection = $$(By.xpath("//div[@class='row thread-row']"))
                .filter(visible)
                .exclude(have(text("Опрос")));
        int a = (int) (collection.size()*Math.random());
        return collection.get(a).$(By.xpath(".//a[@class='item-title thread-title']"));
    }
}
