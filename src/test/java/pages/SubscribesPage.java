package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.annotations.Element;
import pages.annotations.Page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

@Page(title = "Подписки")
public class SubscribesPage extends AbstractPage {

    @Element("Отписаться")
    public static void unsubscribeTopicFromList() throws InterruptedException {
        for (String hrefAttribute : MainPage.elementList) {
            String relativeHref = hrefAttribute.replace("https://dev.n7lanit.ru", "");

            WebElement element = $(By.xpath("//a[@href='" + relativeHref + "']" +
                    "/ancestor::div[4]" +
                    "//div[@class='col-sm-2 col-md-2 hidden-xs']" +
                    "//span[@class='btn-text' and text()='Активна']"));
            element.click();

            Thread.sleep(1000);

            WebElement unsubscribeButton = $(By.xpath("//div[@class='btn-group open']" +
                    "//button[@class='btn-link' and text()='Отписаться ']"))
                    .shouldBe(visible);
            unsubscribeButton.click();
        }

        MainPage.elementList.clear();
    }
}
