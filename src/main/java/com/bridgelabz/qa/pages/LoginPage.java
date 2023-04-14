package com.bridgelabz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id = "email")
	WebElement username;

	@FindBy(name = "pass")
	WebElement password;

	@FindBy(name = "login")
	WebElement loginbutton;

//    @FindBy(id = "alertButton")
//    WebElement allowbutton;

	@FindBy(linkText = "Create new account")
	WebElement Createnewaccount;

	// Initializing the page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Action
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public WelcomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
//        allowbutton.click();

		return new WelcomePage();
	}

}
