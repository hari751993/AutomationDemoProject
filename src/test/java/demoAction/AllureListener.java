package demoAction;

import common.Start;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.ByteArrayInputStream;

public class AllureListener {

    public void addScreenshotInAllureReport(String name) {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) Start.driver).getScreenshotAs(OutputType.BYTES)));
    }
}
