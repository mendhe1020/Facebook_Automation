package com.bridgelabz.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.qa.base.TestBase;
import com.bridgelabz.qa.pages.SignUpPage;
import com.bridgelabz.qa.pages.WelcomePage;

public class SingnUpPageTest extends TestBase {
	
	SignUpPage signUpPage;
    WelcomePage welcomePage;
    
    public SingnUpPageTest() {
        super();
    }
    
    @BeforeMethod
    public void setUp() {
        initialization();
        signUpPage= new SignUpPage();
        
    }
    
    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = signUpPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Facebook – log in or sign up");
    }
    
    @Test(priority = 2)
    public void signUpTest() {
        welcomePage = signUpPage.signUp(prop.getProperty("firstname"),prop.getProperty("lastname"),prop.getProperty("emailaddress"),prop.getProperty("reenteremailaddress"),prop.getProperty("newpassword"),prop.getProperty("day"),prop.getProperty("month"),prop.getProperty("year"));
    }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
