package pageclasses;

import basepage.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationPage extends BasePage {
    public WebDriver driver;
    private final JavascriptExecutor JSExecutor;
    private final String Home_URL = "https://courses.letskodeit.com/";

    public NavigationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.JSExecutor = (JavascriptExecutor)driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='https://courses.letskodeit.com/login']")
    WebElement LOGIN_LINK;

    @FindBy(xpath = "//button[@id='dropdownMenu1']/img")
    WebElement ACCOUNT_IMAGE;

    @FindBy(id = "dropdownMenu1")
    WebElement ACCOUNT_DROPDOWN;

    @FindBy(xpath = "//a[contains(text(), 'ALL COURSES')]")
    WebElement ALL_COURSES_LINK;

    @FindBy(xpath = "//div[@id='navbar-inverse-collapse']/ul/li[4]/a")
    WebElement MY_COURSES_LINK;

    @FindBy(xpath = "//a[@href='/logout']")
    WebElement LOGOUT_LINK;

    public LoginPage login(){
        LOGIN_LINK.click();
        return new LoginPage(driver);

    }

    public void scrollPage() {
        JSExecutor.executeScript("window.scrollBy(0,1000)");
    }

    public void goToAllCourses() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(ALL_COURSES_LINK)).click();
    }

    public void goToMyCourses() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(MY_COURSES_LINK)).click();
    }

    public boolean isUserLoggedIn() {
        try {
            return ACCOUNT_IMAGE.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void logOut(){
        ACCOUNT_DROPDOWN.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(LOGOUT_LINK)).click();
    }

    public void redirectToLogin(){
        new LoginPage(driver);
    }
}


