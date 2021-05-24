package pageclasses;

import basepage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Util;

public class LoginPage extends BasePage {

    /***
     * Variables
     * Locators
     * URL
     */

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h4[text()='Login']")
    WebElement LOGIN_PAGE_HEADER;

    @FindBy(id = "email")
    WebElement EMAIL_FIELD;

    @FindBy(id = "password")
    WebElement PASSWORD_FIELD;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement LOGIN_BUTTON;

    public boolean verifyPage(){
        String actualText = LOGIN_PAGE_HEADER.getText();
        return Util.verifyTextContains(actualText, "Login");
    }

    public NavigationPage signInWith(String email, String password){
        EMAIL_FIELD.clear();
        EMAIL_FIELD.sendKeys(email);
        PASSWORD_FIELD.clear();
        PASSWORD_FIELD.sendKeys(password);
        LOGIN_BUTTON.click();

        return new NavigationPage(driver);
    }
}
