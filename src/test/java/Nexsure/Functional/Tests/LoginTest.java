package Nexsure.Functional.Tests;

import Nexsure.PageObjects.LoginPage;
import Nexsure.PageObjects.LoginPage2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.qz.common.utilities.CommonFunctions;

import java.time.Duration;

public class LoginTest extends CommonFunctions {

//    WebDriver driver;

//    @BeforeTest
//    public void beforetest() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        driver.manage().window().maximize();
//        driver.get("https://github.com/login");
//    }

    @Test
    public void loginGithub() throws InterruptedException {
        LoginPage2 page = new LoginPage2(driver);
        page.enterUserData1("sumanth24m@gmail.com");
        page.enterPasswordData1("Sumanth@789");
        Thread.sleep(5000);
    }

    @AfterTest
    public void aftertest() {
        driver.quit();
    }
}
