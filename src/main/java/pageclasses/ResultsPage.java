package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultsPage {
    public WebDriver driver;
//    private final String PARTIAL_SEARCH_URL = "courses.letskodeit.com";
//    private final String PARTIAL_CATEGORY_URL = "courses.letskodeit.com/courses/category/";

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='zen-course-list']")
    List<WebElement> COURSES_LIST;

//    public boolean hasSearchPageURL(){
//        return driver.getCurrentUrl().contains(PARTIAL_SEARCH_URL);
//    }

//    public boolean hasCategoryPageURL(){
//        return driver.getCurrentUrl().contains(PARTIAL_CATEGORY_URL);
//    }

    public int countCourses(){
        return COURSES_LIST.size();
    }

    public boolean verifyInputSearchResult(){
        boolean result = false;
        if(countCourses() > 0){
            result = true;
        }
        //result = hasSearchPageURL() && result;
        return result;
    }

    public boolean verifyCategorySearchResult(){
        boolean result = false;
        if(countCourses() > 0){
            result = true;
        }
        //result = hasCategoryPageURL() && result;
        return result;
    }

}
