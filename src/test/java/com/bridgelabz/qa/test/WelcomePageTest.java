package com.bridgelabz.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.qa.base.TestBase;
import com.bridgelabz.qa.pages.FriendsPage;
import com.bridgelabz.qa.pages.GroupsPage;
import com.bridgelabz.qa.pages.LoginPage;
import com.bridgelabz.qa.pages.WelcomePage;

public class WelcomePageTest extends TestBase {
	
	LoginPage loginPage;
    WelcomePage welcomePage;
    FriendsPage friendsPage;
    GroupsPage groupsPage;
    public WelcomePageTest() {
        super();
    }
    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        welcomePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
    @Test(priority = 1)
    public void verifyHomePageTitle() {
        String welcomePageTitle = welcomePage.verifyHomePageTitle();
        Assert.assertEquals(welcomePageTitle, "Facebook");
    }
    
    @Test(priority = 2)
    public void clickOnFriendsButton() throws InterruptedException {
        Thread.sleep(5000);
        friendsPage = welcomePage.friendsButton();
        Thread.sleep(5000);
    }
    
    @Test(priority = 3)
    public void clickOnGroupsButton() throws InterruptedException {
        Thread.sleep(5000);
        groupsPage = welcomePage.groupsButton();
        Thread.sleep(5000);
    }
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

}
