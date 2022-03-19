package demoTest;

import common.*;
import demoView.HomePageView;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

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
        util.assertEquals(util.getText(homePageView.getPrintLabel()), select_value, "Selected value is not printed in UI!");
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            util.takeSnapShot();
        }
    }

    //@AfterSuite
    private void terminateTest() {
        start.termination();
    }
}
