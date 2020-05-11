package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.annotations.Element;
import pages.annotations.Page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Page(title = "Топик")
public class TopicPage extends AbstractPage {

    @Element("Ответить")
    public static WebElement getAnswerButton() throws InterruptedException {
        Thread.sleep(1000);
        return $(By.xpath("//button[@class='btn btn-primary btn-block btn-outline']"))
                .shouldBe(visible);
    }

    @Element("Текст")
    public static void inputPostText() {
        String post = "Съешь же ещё этих мягких французских булок да выпей чаю";
        $(By.xpath("//*[@id='editor-textarea']"))
                .shouldBe(visible)
                .val(post);
    }

    @Element("Отправить ответ")
    public static WebElement getSendAnswerButton() throws InterruptedException {
        Thread.sleep(1000);
        return $(By.xpath("//button[text()='Отправить ответ']"))
                .shouldBe(visible);
    }

    @Element("Темы")
    public static WebElement getThemesTab() {
        return $(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(), 'Темы')]")).shouldBe(visible);
    }
}
