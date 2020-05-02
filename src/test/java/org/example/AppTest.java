package org.example;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

/**
 * Тест проверяет возможность: зарегистрироваться на сайте
 * https://dev.n7lanit.ru/, далее выбрать тему и
 * написать в ней пост
 */

public class AppTest {
    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "G:/Sniper/Driver/chromedriver.exe");
        Configuration.timeout = 5000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-save-password-bubble");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(driver);
    }

    @After
    public void after() {
        System.out.println("Test completed.");
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void mainTest() throws InterruptedException {
        open("https://dev.n7lanit.ru/");
        registrationTest();
        for (int i = 0; i < 2; i++) {
            secondTest();
            $(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(), 'Темы')]")).shouldBe(visible).click();
        }

        Thread.sleep(10000);
    }

    public void registrationTest(){
        $(By.xpath("//*[@id='user-menu-mount']/div/button[contains(text(), 'Войти')]")).should(visible).click();
        $(By.xpath("//*[@id='id_username']")).val("Krylov");
        $(By.xpath("//*[@id='id_password']")).val("amigo1986");
        $(By.xpath("//button[@class='btn btn-primary btn-block']")).should(visible).click();
        Assert.assertTrue($(By.xpath("//ul[@class='ul nav navbar-nav nav-user']/li[@class='dropdown']/a[@class='dropdown-toggle']")).shouldBe(visible).isDisplayed());
    }

    public void secondTest() throws InterruptedException {
        String post  = "Съешь же ещё этих мягких французских булок да выпей чаю";
        ElementsCollection collection = $$(By.xpath("//li[@class='list-group-item thread-new']//a[@class='item-title thread-title']")).filter(visible);
        //TODO Реализовать исключение опросов из коллекции

        int a = (int) (collection.size()*Math.random());
        collection.get(a).click();

        Thread.sleep(2000);
        $(By.xpath("//button[@class='btn btn-primary btn-block btn-outline']")).shouldBe(visible).click();
        $(By.xpath("//*[@id='editor-textarea']")).shouldBe(visible).val(post);
        Thread.sleep(2000);
        $(By.xpath("//button[text()='Отправить ответ']")).shouldBe(visible).click();
        Assert.assertEquals("Krylov", $(By.xpath("//li[@class='post']//a[text()='Krylov']")).shouldBe(visible).getText());
        Assert.assertEquals(post, $(By.xpath("//li[@class='post']//article/p[text()='Съешь же ещё этих мягких французских булок да выпей чаю']")).shouldBe(visible).getText());
    }
}
