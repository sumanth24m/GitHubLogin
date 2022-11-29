package Nexsure.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {

    WebDriver driver;

    public LoginPage2(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name=\"login\"]") WebElement userName1;

    @FindBy(xpath = "//input[@name=\"password\"]") WebElement password;

    @FindBy(xpath = "//input[@name='commit']") WebElement submit;

    public void enterUserData1(String enterUserData) {
        try {
            userName1.sendKeys(enterUserData);
        } catch (Exception e) {
            System.out.println("Exception Caught"+ e.getMessage());
        }

    }
    public void enterPasswordData1(String enterPassData) {
        try {
            password.sendKeys(enterPassData);
            submit.click();
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Exception Caught"+ e.getMessage());
        }

    }

}
