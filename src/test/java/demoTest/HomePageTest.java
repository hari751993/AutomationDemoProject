package demoTest;

import common.*;
import demoView.HomePageView;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest {
    Start  start = new Start();
    Util util = new Util();
    HomePageView homePageView = new HomePageView();

    @BeforeSuite
    private void webdriverInitialization() {
        start.initialization();
    }

    @Test(testName = "Validate dropdown selection", priority = 1)
    @Parameters({"select_value"})
    private void validateDropdown(String select_value) {
        Start.driver.get("file:///" + System.getProperty("user.dir") + "/src/main/HomePage.html");
        util.selectValueFromDropdown(homePageView.getVehicleDropdown(), select_value);
        util.clickElement(homePageView.getTryButton());
        util.assertEquals(util.getText(homePageView.getPrintLabel()), "test", "Selected value is not printed in UI!");
    }

    @AfterSuite
    private void terminateTest() {
        start.termination();
    }
}
