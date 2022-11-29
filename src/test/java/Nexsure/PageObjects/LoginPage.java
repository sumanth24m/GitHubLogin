package Nexsure.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By userName = By.xpath("//input[@name=\"login\"]");
    By password = By.xpath("//input[@name=\"password\"]");
    By submit = By.xpath("//input[@name='commit']");

    public void enterUserData(String enterUserData) {
        try {
            driver.findElement(userName).sendKeys(enterUserData);
        } catch (Exception e) {
            System.out.println("Exception Caught"+ e.getMessage());
        }

    }
    public void enterPasswordData(String enterPassData) {
        try {
            driver.findElement(password).sendKeys(enterPassData);
            driver.findElement(submit).click();
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Exception Caught"+ e.getMessage());
        }

    }
}
