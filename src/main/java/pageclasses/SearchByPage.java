package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchByPage {
    public WebDriver driver;

    public SearchByPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='search']")
    WebElement SEARCH_COURSE_FIELD;

    @FindBy(xpath = "//form[@id='search']//button")
    WebElement SEARCH_COURSE_BUTTON;

    public ResultsPage searchCourse(String courseName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(SEARCH_COURSE_FIELD));
        SEARCH_COURSE_FIELD.clear();
        SEARCH_COURSE_FIELD.sendKeys(courseName);
        Thread.sleep(3000);
        SEARCH_COURSE_BUTTON.click();
        Thread.sleep(3000);

        return new ResultsPage(driver);
    }
}
