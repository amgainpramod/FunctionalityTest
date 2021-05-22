package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CategoryFilterPage {
    WebDriver driver;

    public CategoryFilterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "categories")
    WebElement dropDownElement;

    public ResultsPage selectCategory(String categoryName){

        Select select = new Select(dropDownElement);
        select.selectByVisibleText(categoryName);

        return new ResultsPage(driver);
    }
}
