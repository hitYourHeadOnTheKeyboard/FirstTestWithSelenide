package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.annotations.Element;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TopicPage extends AbstractPage {

    @Element("Ответить")
    public static WebElement getAnswerButton() throws InterruptedException {
        Thread.sleep(2000);
        return $(By.xpath("//button[@class='btn btn-primary btn-block btn-outline']"))
                .shouldBe(visible);
    }

    public static void inputPostText(String post) {
        $(By.xpath("//*[@id='editor-textarea']"))
                .shouldBe(visible)
                .val(post);
    }

    public static WebElement getSendAnswerButton() throws InterruptedException {
        Thread.sleep(2000);
        return $(By.xpath("//button[text()='Отправить ответ']"))
                .shouldBe(visible);
    }

    @Element("Вкладка Темы")
    public static WebElement getThemesTab() {
        return $(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(), 'Темы')]")).shouldBe(visible);
    }
}
