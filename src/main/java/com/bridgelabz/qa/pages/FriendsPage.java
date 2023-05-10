package com.bridgelabz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.qa.base.TestBase;

public class FriendsPage extends TestBase {
	
	@FindBy(xpath = "//span[contains(text(),'Friend Requests')]")
    WebElement friendRequestList;
    
    public FriendsPage() {
        PageFactory.initElements(driver,  this);
    }
    
    public FriendRequestListpage friendRequestListButton() {
        friendRequestList.click();
        return new FriendRequestListpage();
    }

}
