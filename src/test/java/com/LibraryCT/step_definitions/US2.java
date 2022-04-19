package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.DashBoardPage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.utilitis.ConfigurationReader;
import com.LibraryCT.utilitis.Driver;
import com.LibraryCT.utilitsDB.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US2 {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    String actualResult;
    String expectedResult;

    @Given("I am in the homepage of the library app")
    public void i_am_in_the_homepage_of_the_library_app() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginPage.loginByLibrarian();

    }

    @When("I take borrowed books number")
    public void i_take_borrowed_books_number() {
        actualResult = dashBoardPage.borrow_book_number.getText();
        System.out.println(actualResult);

    }

    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        DB_Util.runQuery("select count(*) from book_borrow where is_returned=0");
        expectedResult = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedResult, actualResult);


    }
}
