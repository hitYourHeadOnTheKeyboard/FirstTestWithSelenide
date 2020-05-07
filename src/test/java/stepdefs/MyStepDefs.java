package stepdefs;

import cucumber.api.java.ru.*;

import static com.codeborne.selenide.Selenide.*;
import static pages.AbstractPage.getUrlByTitle;
import static pages.LoginPage.*;
import static pages.ElementsTest.*;
import static pages.MainPage.*;
import static pages.TopicPage.*;

public class MyStepDefs {
    String post = "Съешь же ещё этих мягких французских булок да выпей чаю";

    @Если("Пользователь открывает страницу {string}")
    public void пользовательОткрываетСтраницу(String site) throws ClassNotFoundException {
        open(getUrlByTitle(site));
    }

    @И("Вводит логин и пароль")
    public void вводитЛогинИПароль() {
        getLoginForm().click();
        inputValues();
        getSubmitButton().click();
    }

    @Тогда("^Проверить что авторизация выполнена успешно$")
    public void проверитьЧтоАвторизацияВыполненаУспешно() {
        checkAuthorization();
    }

    @И("^Пользователь кликает по заголовку случайной темы, исключая опросы$")
    public void пользовательКликаетПоЗаголовкуСлучайнойТемыКромеОпроса() {
        getRandomTopic().click();
    }

    @И("В открытой теме пользователь нажимает кнопку {string}")
    public void вОткрытойТемеПользовательНажимаетКнопку(String button) throws InterruptedException {
        getAnswerButton().click();
    }

    @И("В появившейся форме пользователь вводит текст сообщения")
    public void вПоявившейсяФормеПользовательВводитТекстСообщения() {
        inputPostText(post);
    }

    @И("Пользователь нажимает кнопку {string}")
    public void пользовательНажимаетКнопку(String button) throws InterruptedException {
        getSendAnswerButton().click();
    }

    @И("Проверить, что имя пользователя совпадает с автором поста")
    public void проверитьЧтоИмяПользователяСовпадаетСАвторомПоста() {
        checkUserName();
    }

    @И("Текст в посте соответствует отправленному и отображается в теме")
    public void текстВПостеСоответствуетОтправленномуИОтображаетсяВТеме() {
        checkPost(post);
    }

    @И("Перейти на вкладку темы")
    public void перейтиНаВкладкуТемы() throws InterruptedException {
        getThemesTab().click();
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
