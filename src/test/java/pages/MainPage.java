package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public static final String URL = "https://otus.ru";
    private By auth = By.xpath("//button[@data-modal-id='new-log-reg']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() {
        driver.get(URL);
        logger.info("Main page OTUS is open");
        return this;
    }

    public AuthPage auth() {
        driver.findElement(auth).click();
        logger.info("Auth page OTUS is open");
        return new AuthPage(driver);
    }
}
