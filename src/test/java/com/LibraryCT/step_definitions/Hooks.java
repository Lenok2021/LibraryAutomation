package com.LibraryCT.step_definitions;

import com.LibraryCT.utilitis.BrowserUtils;
import com.LibraryCT.utilitis.Driver;
import com.LibraryCT.utilitsDB.DB_Util;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.hc.core5.net.Host;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @Before
    public void setup() {
        /*Host IP: 34.230.35.214 (SAME FOR ALL)
         Username: library2_client
        Password: 6s2LQQTjBcGFfDhY
        Database name: library2
        Port: 3306
        JDBC url : jdbc:mysql://34.230.35.214:3306/library2/
*/
        String url = "jdbc:mysql://34.230.35.214:3306/library2";
        String username_db = "library2_client";
        String password_db = "6s2LQQTjBcGFfDhY";
        DB_Util.createConnection(url, username_db, password_db);

        // Connection con = DriverManager.getConnection(url,username_db,password_db);

    }


    @After
    public void tearDown(Scenario scenario) {



        if (scenario.isFailed()) {
            byte[] screenshort = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshort, "image/png", scenario.getName());
        }

        DB_Util.destroy();
        Driver.closeDriver();

    }


}
