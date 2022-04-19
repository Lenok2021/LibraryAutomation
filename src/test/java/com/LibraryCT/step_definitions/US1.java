package com.LibraryCT.step_definitions;

import com.LibraryCT.utilitsDB.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US1 {

    int expectedResult;
    int actualResult;
    List<String> expectedColumnName;

    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        actualResult = 142 ;
        DB_Util.runQuery("select count(id) from users");
        expectedResult = Integer.parseInt((DB_Util.getFirstRowFirstColumn()));

        System.out.println(expectedResult);
    }

    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {
        Assert.assertEquals(expectedResult, actualResult);

    }

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {

        DB_Util.runQuery("select * from users") ;
        expectedColumnName  = DB_Util.getAllColumnNamesAsList();
    }

    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String>actualColumnName) {

        Assert.assertEquals(expectedColumnName, actualColumnName);

    }


}
