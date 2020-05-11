package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.annotations.Element;
import pages.annotations.Page;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Page(title = "Главная страница")
public class MainPage extends AbstractPage{
    public static List<String> elementList = new ArrayList<>();

    @Element("Войти")
    public static WebElement getLoginForm() {
        return $(By.xpath("//*[@id='user-menu-mount']/div/button[contains(text(), 'Войти')]")).should(visible);
    }

    @Element("Случайной темы")
    public static WebElement getRandomTopic() throws InterruptedException {
        Thread.sleep(1000);
        ElementsCollection collection = $$(By.xpath("//div[@class='row thread-row']"))
                .filter(visible)
                .exclude(have(text("Опрос")));
        int a = (int) (collection.size()*Math.random());
        return collection.get(a).$(By.xpath(".//a[@class='item-title thread-title']"));
    }

    @Element("Неактивна")
    public static WebElement getRandomNotSubscribed() throws InterruptedException {
        Thread.sleep(1000);
        ElementsCollection collection = $$(By.xpath("//div[@class='col-sm-2 col-md-2 hidden-xs']" +
                "//span[@class='btn-text' and text()='Неактивна']"));
        int a = (int) (collection.size()*Math.random());
        WebElement element = collection.get(a);
        WebElement elementForList = element.findElement(By.xpath("./ancestor::div[6]//div[@class='media-body']" +
                "/a[@class='item-title thread-title']"));
        elementList.add(elementForList.getAttribute("href"));
        return element;
    }

    @Element("Подписаться")
    public static WebElement subscribe() throws InterruptedException {
        Thread.sleep(1000);
        return $(By.xpath("//div[@class='col-sm-2 col-md-2 hidden-xs']" +
                "//div[@class='btn-group open']" +
                "//button[@class='btn-link' and text()='Подписаться']"))
                .shouldBe(visible);
    }

    @Element("Вкладка Подписки")
    public static WebElement getSubscriptionsTab() throws InterruptedException {
        Thread.sleep(1000);
        return $(By.xpath("//a[text()='Подписки']"));
    }
}
