package common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.time.LocalDateTime;

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
        return element;
    }

    public void selectValueFromDropdown(WebElement element, String selectvalue) {
        Select select = new Select(element);
        select.selectByValue(selectvalue);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void sendText(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void assertEquals(String expectedValue, String actualValue, String failureMessage) {
        Assert.assertEquals(actualValue, expectedValue, failureMessage);
    }

    public void takeSnapShot() {
        try {
            String dateTimeNow = LocalDateTime.now().toString().replace(":", "");
            TakesScreenshot screenshot = ((TakesScreenshot) Start.driver);
            File scrnFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("./src/main/resources/screenshots/" + dateTimeNow + ".png");
            FileUtils.copyFile(scrnFile, destFile);
        } catch (Exception e) {

        }
    }

    public void switchToIframe(WebElement element) {
        Start.driver.switchTo().frame(element);
    }

    public String fetchAlertMessage() {
        String message = Start.driver.switchTo().alert().getText();
        Start.driver.switchTo().alert().accept();
        return message;
    }

}
