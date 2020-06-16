package pages;

import cases.OtusBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;
    public Logger logger = LogManager.getLogger(OtusBaseTest.class);

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

}
