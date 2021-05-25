package pageclasses;

import basepage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryFilterPage extends BasePage {
    WebDriver driver;

    public CategoryFilterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "categories")
    WebElement dropDownElement;

    public ResultsPage selectCategory(String categoryName){

//        Select select = new Select(dropDownElement);
//        select.selectByVisibleText(categoryName);
        elementSelect(dropDownElement, "Select By Visible Text", categoryName);

        return new ResultsPage(driver);
    }
}
