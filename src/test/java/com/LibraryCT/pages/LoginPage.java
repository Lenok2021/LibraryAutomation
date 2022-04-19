package com.LibraryCT.pages;

import com.LibraryCT.utilitis.ConfigurationReader;
import com.LibraryCT.utilitis.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);


    }

    @FindBy(id = "inputEmail")
    public WebElement userName;

    @FindBy(id = "inputPassword")
    public WebElement userPassword ;

    @FindBy(xpath =  "//button[. = 'Sign in']")
    public WebElement loginButton ;

    public void loginByLibrarian(){
        userName.sendKeys(ConfigurationReader.getProperty("username_L"));
        userPassword.sendKeys(ConfigurationReader.getProperty("password_L"));
        loginButton.click();
    }




}
