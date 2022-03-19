package demoView;

import common.Util;
import org.openqa.selenium.WebElement;

public class RegistrationPageView {
    Util util = new Util();

    public WebElement getRegistrationPageLink() {
        return util.getWebElement("xpath", "//a[text()='Register']");
    }

    public WebElement getRegPageIframe() {
        return util.getWebElement("id", "regIframe");
    }

    public WebElement getName() {
        return util.getWebElement("id", "name");
    }

    public WebElement getAge() {
        return util.getWebElement("id", "age");
    }

    public WebElement getAddress() {
        return util.getWebElement("id", "address");
    }

    public WebElement getNationality() {
        return util.getWebElement("id", "nationality");
    }

    public WebElement getRegisterButton() {
        return util.getWebElement("id", "submit");
    }

}
