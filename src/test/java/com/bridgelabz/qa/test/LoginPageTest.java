package com.bridgelabz.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.qa.base.TestBase;
import com.bridgelabz.qa.pages.LoginPage;
import com.bridgelabz.qa.pages.WelcomePage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
    WelcomePage welcomePage;
    
    public LoginPageTest() {
        super();
    }
    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }
    @Test(priority = 1)
    public void loginPageTitleTest() {
        String loiginPageTitle = loginPage.validateLoginPageTitle();
        Assert.assertEquals(loiginPageTitle, "Facebook – log in or sign up");
    }
    
    @Test(priority = 2)
    public void loginTest() {
     welcomePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
       // welcomePage = loginPage.login(user,pass);
    }
    
    
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

}
