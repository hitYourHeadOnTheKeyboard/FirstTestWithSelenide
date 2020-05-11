package pages;

import com.codeborne.selenide.ElementsCollection;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ElementsTest {

    public static void checkAuthorization() {
        Assert.assertTrue($(By.xpath("//ul[@class='ul nav navbar-nav nav-user']" +
                "/li[@class='dropdown']" +
                "/a[@class='dropdown-toggle']"))
                .shouldBe(visible).isDisplayed());
    }

    public static void checkUserName() {
        Assert.assertEquals("Krylov", $(By.xpath("//li[@class='post']//a[text()='Krylov']"))
                .shouldBe(visible)
                .getText());
    }

    public static void checkPost() {
        String post = "Съешь же ещё этих мягких французских булок да выпей чаю";
        Assert.assertEquals(post, $(By.xpath("//li[@class='post']" +
                "//article/p[text()='Съешь же ещё этих мягких французских булок да выпей чаю']"))
                .shouldBe(visible)
                .getText());
    }

    public static void checkSubscriptions() throws InterruptedException {
        Thread.sleep(1000);
        ElementsCollection collection = $$(By.xpath("//div[@class='row thread-row']" +
                "//a[@class='item-title thread-title']"))
                .filter(visible);
        List<String> hrefList = new ArrayList<>();
        for (WebElement elements : collection) {
             String s = elements.getAttribute("href");
            hrefList.add(s);
        }
        boolean b = hrefList.containsAll(MainPage.elementList);
        Assert.assertTrue(b);
    }
}
