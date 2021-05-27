package testclasses;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageclasses.CategoryFilterPage;
import pageclasses.SearchByPage;
import test.baseclass.BaseTest;
import test.baseclass.CheckPoint;
import utilities.Constants;
import utilities.ExcelUtility;

public class AllCoursesTest extends BaseTest {

    @DataProvider(name = "verifySearchCourseData")
    public Object[][] getVerifySearchCourseData(){
        Object[][] testData = ExcelUtility.getTestData("verify_search_course");
        return testData;
    }

    @BeforeClass
    public void setUp() {
        navigationPage = loginPage.signInWith(Constants.DEFAULT_USERNAME, Constants.DEFAULT_PASSWORD);
        ExcelUtility.setExcelFile(Constants.EXCEL_FILE, "AllCoursesTests");
    }

    @Test(dataProvider = "verifySearchCourseData")
    public void searchByInput(String courseName) throws InterruptedException {
        navigationPage.scrollPage();
        searchByPage = new SearchByPage(driver);
        resultsPage = searchByPage.searchCourse(courseName);

        boolean searchResult = resultsPage.verifySearchResult();
        //Assert.assertTrue(searchResult);
        CheckPoint.markFinal("searchByInput", searchResult, "Input Search Verification");
    }

    @Test(enabled = false)
    public void searchByCategory(){
        navigationPage.scrollPage();
        categoryFilterPage = new CategoryFilterPage(driver);
        resultsPage = categoryFilterPage.selectCategory("Sofware Testing");
        boolean categoryResults = resultsPage.verifySearchResult();
        Assert.assertTrue(categoryResults);

    }
}
