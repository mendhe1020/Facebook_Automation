package com.bridgelabz.qa.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.qa.base.TestBase;
import com.bridgelabz.qa.pages.FriendRequestListpage;
import com.bridgelabz.qa.pages.FriendsPage;
import com.bridgelabz.qa.pages.LoginPage;
import com.bridgelabz.qa.pages.WelcomePage;

public class FriendsPageTest extends TestBase {
	
	LoginPage loginPage;
    WelcomePage welcomePage;
    FriendsPage friendsPage;
    FriendRequestListpage friendsRequestPage;
    public FriendsPageTest() {
        super();
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        welcomePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(2000);
        friendsPage = welcomePage.friendsButton();
    }
    
    @Test
    public void clickOnFriendsRequestButton() throws InterruptedException {
        Thread.sleep(5000);
         friendsRequestPage = friendsPage.friendRequestListButton();
        Thread.sleep(5000);
    }

}
