package com.bridgelabz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.qa.base.TestBase;

public class WelcomePage extends TestBase {
	
	@FindBy(xpath = "//span[contains(text(),'Welcome to Facebook, Rohit')]")
    WebElement nameLabel;
    @FindBy(xpath = "//span[contains(text(),'Find friends')]")
    WebElement friends;
    
    @FindBy(xpath = "//span[contains(text(),'Groups')]")
    WebElement groups;
    
    
    // Initializing the page object
    public WelcomePage() {
        PageFactory.initElements(driver, this);
    }
    public String verifyHomePageTitle() {
        return driver.getTitle();
    }
    public boolean verifyCorrectName() {
        return nameLabel.isDisplayed();
    }
    
    
    public FriendsPage friendsButton() {
        friends.click();
        return new FriendsPage();
    }
    
    public GroupsPage groupsButton() {
        groups.click();
        return new GroupsPage();
    }

}
