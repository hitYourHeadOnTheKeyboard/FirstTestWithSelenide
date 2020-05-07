package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.annotations.Page;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

@Page(title = "Главная страница", url = "https://dev.n7lanit.ru")
public class MainPage extends AbstractPage{

    public static WebElement getRandomTopic() {
        ElementsCollection collection = $$(By.xpath("//div[@class='row thread-row']"))
                .filter(visible)
                .exclude(have(text("Опрос")));
        int a = (int) (collection.size()*Math.random());
        return collection.get(a).$(By.xpath(".//a[@class='item-title thread-title']"));
    }
}
