package stepdefs;

import cucumber.api.java.ru.*;
import java.lang.reflect.InvocationTargetException;

import static com.codeborne.selenide.Selenide.*;
import static pages.AbstractPage.getUrlByTitle;
import static pages.AbstractPage.getPageByTitle;
import static pages.ElementsTest.*;

public class MyStepDefs {

    @Если("Пользователь открывает страницу {string}")
    public void пользовательОткрываетСтраницу(String site) throws ClassNotFoundException {
        open(getUrlByTitle(site));
    }

    @И("На странице {string} открывает форму {string}")
    public void наСтраницеОткрываетФорму(String title, String formName) throws IllegalAccessException,
            InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(formName).click();
    }

    @И("На странице {string} вводит {string} и {string}")
    public void вводитЛогинИПароль(String title, String login, String password) throws IllegalAccessException,
            InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(login);
        getPageByTitle(title).getElementByName(password);
    }

    @И("На странице {string} нажимает на кнопку {string}")
    public void наСтраницеНажимаетНаКнопку(String title, String buttonName) throws IllegalAccessException,
            InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(buttonName).click();
    }

    @Тогда("^Проверить что авторизация выполнена успешно$")
    public void проверитьЧтоАвторизацияВыполненаУспешно() {
        checkAuthorization();
    }

    @И("Пользователь на странице {string} кликает по заголовку {string} исключая опросы")
    public void пользовательНаСтраницеКликаетПоЗаголовкуИсключаяОпросы(String title, String randomTopic)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(randomTopic).click();
    }

    @И("В открытой странице {string} пользователь нажимает кнопку {string}")
    public void вОткрытойТемеПользовательНажимаетКнопку(String title, String answerButton) throws IllegalAccessException,
            InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(answerButton).click();
    }

    @И("На странице {string} пользователь вводит {string} сообщения")
    public void наСтраницеПользовательВводитТекстСообщения(String title, String text) throws IllegalAccessException,
            InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(text);
    }

    @И("На странице {string} пользователь нажимает кнопку {string}")
    public void наСтраницеПользовательНажимаетКнопку(String title, String sendButton) throws IllegalAccessException,
            InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(sendButton).click();
    }

    @И("Проверить, что имя пользователя совпадает с автором поста")
    public void проверитьЧтоИмяПользователяСовпадаетСАвторомПоста() {
        checkUserName();
    }

    @И("Текст в посте соответствует отправленному и отображается в теме")
    public void текстВПостеСоответствуетОтправленномуИОтображаетсяВТеме() {
        checkPost();
    }

    @И("Пользователь на странице {string} нижимает вклдаку {string}")
    public void пользовательНаСтраницеНижимаетВклдаку(String title, String themeTab) throws IllegalAccessException,
            InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(themeTab).click();
    }

    @И("Пользователь на странице {string} выбирает случайную тему и нажимает на кнопку {string}")
    public void пользовательНаСтраницеВыбираетСлучайнуюТемуИНажимаетНаКнопку(String title, String buttonForSubs)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(buttonForSubs).click();
    }

    @И("На странице {string} в появившемся выпадающем меню нажимает на кнопку {string}")
    public void наСтраницеВПоявившемсяВыпадающемМенюНажимаетНаКнопкуПодписаться(String title, String subsButton)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(subsButton).click();
    }

    @И("На странице {string} проверить – что среди подписок есть те, на которые он подписался ранее в этом сценарии")
    public void наСтраницеПроверитьЧтоСредиПодписокЕстьТеНаКоторыеОнПодписалсяРанееВЭтомСценарии(String title)
            throws InterruptedException {
        checkSubscriptions();
    }

    @И("На странице {string} нажимает {string} от тех топиков на которые только что подписался")
    public void наСтраницеНажимаетОтТехТопиковНаКоторыеТолькоЧтоПодписался(String title, String button)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(button);
    }
}
