package stepdefs;

import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MyStepdefs {
    String post = "Съешь же ещё этих мягких французских булок да выпей чаю";

    @Если("Пользователь открывает страницу {string}")
    public void пользовательОткрываетСтраницу(String site) {
        site = "https://dev.n7lanit.ru/";
        open(site);
    }

    @И("Вводит логин и пароль")
    public void вводитЛогинИПароль() {
        $(By.xpath("//*[@id='user-menu-mount']/div/button[contains(text(), 'Войти')]")).should(visible).click();
        $(By.xpath("//*[@id='id_username']")).val("Krylov");
        $(By.xpath("//*[@id='id_password']")).val("amigo1986");
        $(By.xpath("//button[@class='btn btn-primary btn-block']")).should(visible).click();
    }

    @Тогда("^Проверить что авторизация выполнена успешно$")
    public void проверитьЧтоАвторизацияВыполненаУспешно() {
        Assert.assertTrue($(By.xpath("//ul[@class='ul nav navbar-nav nav-user']" +
                "/li[@class='dropdown']" +
                "/a[@class='dropdown-toggle']"))
                .shouldBe(visible).isDisplayed());
    }

    @И("^Пользователь кликает по заголовку случайной темы, исключая опросы$")
    public void пользовательКликаетПоЗаголовкуСлучайнойТемыКромеОпроса() {
        ElementsCollection collection = $$(By.xpath("//div[@class='row thread-row']"))
                .filter(visible)
                .exclude(have(text("Опрос")));
        int a = (int) (collection.size()*Math.random());
        collection.get(a).$(By.xpath(".//a[@class='item-title thread-title']")).click();
    }

    @И("В открытой теме пользователь нажимает кнопку {string}")
    public void вОткрытойТемеПользовательНажимаетКнопку(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        $(By.xpath("//button[@class='btn btn-primary btn-block btn-outline']"))
                .shouldBe(visible)
                .click();
    }

    @И("В появившейся форме пользователь вводит текст сообщения")
    public void вПоявившейсяФормеПользовательВводитТекстСообщения() {
        $(By.xpath("//*[@id='editor-textarea']"))
                .shouldBe(visible)
                .val(post);
    }

    @И("Пользователь нажимает кнопку {string}")
    public void пользовательНажимаетКнопку(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        $(By.xpath("//button[text()='Отправить ответ']"))
                .shouldBe(visible)
                .click();
    }

    @И("Проверить, что имя пользователя совпадает с автором поста")
    public void проверитьЧтоИмяПользователяСовпадаетСАвторомПоста() {
        Assert.assertEquals("Krylov", $(By.xpath("//li[@class='post']//a[text()='Krylov']"))
                .shouldBe(visible)
                .getText());
    }

    @И("Текст в посте соответствует отправленному и отображается в теме")
    public void текстВПостеСоответствуетОтправленномуИОтображаетсяВТеме() {
        Assert.assertEquals(post, $(By.xpath("//li[@class='post']" +
                "//article/p[text()='Съешь же ещё этих мягких французских булок да выпей чаю']"))
                .shouldBe(visible)
                .getText());
    }

    @И("Перейти на вкладку темы")
    public void перейтиНаВкладкуТемы() throws InterruptedException {
        $(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(), 'Темы')]")).shouldBe(visible).click();
        Thread.sleep(2000);
    }

    @И("Повторить пост в случайной теме")
    public void повторитьПостВСлучайнойТеме() throws InterruptedException {
        пользовательКликаетПоЗаголовкуСлучайнойТемыКромеОпроса();
        вОткрытойТемеПользовательНажимаетКнопку("Ответить");
        вПоявившейсяФормеПользовательВводитТекстСообщения();
        пользовательНажимаетКнопку("Отправить ответ");
        проверитьЧтоИмяПользователяСовпадаетСАвторомПоста();
        текстВПостеСоответствуетОтправленномуИОтображаетсяВТеме();
    }
}
