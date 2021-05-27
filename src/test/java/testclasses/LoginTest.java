package testclasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.baseclass.BaseTest;
import test.baseclass.CheckPoint;
import utilities.Constants;

public class LoginTest extends BaseTest {

    @BeforeClass
    public void setUp(){

    }

    @Test(enabled = false)
    public void testLogin() {
        navigationPage = loginPage.signInWith(Constants.DEFAULT_USERNAME, Constants.DEFAULT_PASSWORD);
        boolean headerResult = navigationPage.verifyHeader();
        //Assert.assertTrue(headerResult);
        CheckPoint.mark("test-01", headerResult, "header verification");
        boolean result = navigationPage.isUserLoggedIn();
        //Assert.assertTrue(result);
        CheckPoint.markFinal("test-01", result, "login verification");
    }

    @Test(enabled = false)
    public void testInvalidLogin() {
        navigationPage = loginPage.signInWith(Constants.DEFAULT_USERNAME, Constants.DEFAULT_PASSWORD);

        boolean result = navigationPage.isUserLoggedIn();
        Assert.assertFalse(result);
    }

    @AfterMethod
    public void afterMethod(){
        if(navigationPage.isUserLoggedIn()){
            navigationPage.logOut();
            navigationPage.redirectToLogin();
        }
    }
}
