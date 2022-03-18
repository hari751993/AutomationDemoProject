package common;

import common.Start;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Util {

    public void clickElement(WebElement element) {
        element.click();
    }

    public WebElement getWebElement(String identifier, String value) {
        WebElement element = null;
        switch (identifier) {
            case "id":
                element = Start.driver.findElement(By.id(value));
                break;
            case "className":
                element = Start.driver.findElement(By.className(value));
                break;
            case "xpath":
                element = Start.driver.findElement(By.xpath(value));
                break;
            case "cssSelector":
                element = Start.driver.findElement(By.cssSelector(value));
                break;
            case "linkText":
                element = Start.driver.findElement(By.linkText(value));
                break;
        }
        return  element;
    }

    public void selectValueFromDropdown(WebElement element, String selectvalue ) {
        Select select = new Select(element);
        select.selectByValue(selectvalue);
    }

    public String getText(WebElement element ) {
        return element.getText();
    }
}
