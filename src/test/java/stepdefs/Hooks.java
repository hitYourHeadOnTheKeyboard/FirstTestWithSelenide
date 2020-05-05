package stepdefs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "G:/Sniper/Driver/chromedriver.exe");
        Configuration.timeout = 5000;
        Configuration.startMaximized = true;
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
}
