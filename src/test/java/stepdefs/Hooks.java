package stepdefs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Hooks {

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "G:/Sniper/Driver/chromedriver.exe");
        Configuration.timeout = 5000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-save-password-bubble");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }

    @After
    public void after() throws InterruptedException {
        System.out.println("Test completed.");
        Thread.sleep(5000);
        WebDriverRunner.closeWebDriver();
    }
}
