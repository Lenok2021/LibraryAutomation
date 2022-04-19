package com.LibraryCT.pages;

import com.LibraryCT.utilitis.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

    public DashBoardPage() {

        PageFactory.initElements(Driver.getDriver(), this);


    }

    @FindBy(xpath = "//h2[@id='borrowed_books']")
    public WebElement borrow_book_number;



}
