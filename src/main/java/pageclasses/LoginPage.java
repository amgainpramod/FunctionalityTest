package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    /***
     * Variables
     * Locators
     * URL
     */

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(id = "email")
    WebElement EMAIL_FIELD;

    @FindBy(id = "password")
    WebElement PASSWORD_FIELD;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement LOGIN_BUTTON;



    /***
     * Methods
     */


    public NavigationPage signInWith(String email, String password){
        EMAIL_FIELD.clear();
        EMAIL_FIELD.sendKeys(email);
        PASSWORD_FIELD.clear();
        PASSWORD_FIELD.sendKeys(password);
        LOGIN_BUTTON.click();

        /***
         * If a new page is the result of an action (method), then the method should return the Page Object of
         * the new Page
         */

        return new NavigationPage(driver);
    }
}
