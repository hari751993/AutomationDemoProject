package demoTest;

import common.Util;
import demoAction.AllureListener;
import demoView.RegistrationPageView;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationPageTest {
    Util util = new Util();
    RegistrationPageView regView = new RegistrationPageView();
    AllureListener allureListener = new AllureListener();

    @Test
    private void validateRegistration() {
        util.clickElement(regView.getRegistrationPageLink());
        util.switchToIframe(regView.getRegPageIframe());
        util.sendText(regView.getName(), "Freddy Jain");
        util.sendText(regView.getAge(), "28");
        util.sendText(regView.getAddress(), "123 North street");
        util.sendText(regView.getNationality(), "US");
        util.clickElement(regView.getRegisterButton());
        Assert.assertTrue(util.fetchAlertMessage().contains("Freddy Jain"), "Applicant name is missing in alert message !");
    }

    @AfterMethod
    private void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            allureListener.addScreenshotInAllureReport("Registration failure");
        }
    }
}

