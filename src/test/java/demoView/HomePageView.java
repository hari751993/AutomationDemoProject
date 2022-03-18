package demoView;

import common.Util;
import org.openqa.selenium.WebElement;

public class HomePageView {
    Util util = new Util();

    public WebElement getVehicleDropdown(){
        return util.getWebElement("id","vehicles_dropdown");
    }

    public WebElement getTryButton(){
        return util.getWebElement("id","tryItButton");
    }

    public WebElement getPrintLabel(){
        return  util.getWebElement("id", "demo");
    }
}
