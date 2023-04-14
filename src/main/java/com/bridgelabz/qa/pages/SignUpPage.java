package com.bridgelabz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.qa.base.TestBase;

public class SignUpPage extends TestBase {
	
	@FindBy(linkText = "Create new account")
    WebElement Createnewaccount;
    
    @FindBy(name = "firstname")
    WebElement firstname;
    
    @FindBy(name = "lastname")
    WebElement lastname;
    
    @FindBy(name = "reg_email__")
    WebElement emailaddress;
    
    @FindBy(name = "reg_email_confirmation__")
    WebElement reenteremailaddress;
    
    @FindBy(name = "reg_passwd__")
    WebElement newpassword;
    
    @FindBy(name = "birthday_day")
    WebElement day;
    
    @FindBy(name = "birthday_month")
    WebElement month;
    
    @FindBy(name = "birthday_year")
    WebElement year;
    
    @FindBy(xpath = "//input[@value = '2']")
    WebElement gender;
    
    @FindBy(name = "websubmit")
    WebElement singupbutton;
    
    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }
    
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }
    
    public WelcomePage signUp(String fn,String ln,String ea,String rea,String np,String d,String m,String y) {
        Createnewaccount.click();
        firstname.sendKeys(fn);
        lastname.sendKeys(ln);
        emailaddress.sendKeys(ea);
        reenteremailaddress.sendKeys(rea);
        newpassword.sendKeys(np);
        day.sendKeys(d);
        month.sendKeys(m);
        year.sendKeys(y);
        gender.click();
        singupbutton.click();
        
        return new WelcomePage();
    }

}
