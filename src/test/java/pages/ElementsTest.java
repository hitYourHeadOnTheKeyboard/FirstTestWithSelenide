package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

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
}
