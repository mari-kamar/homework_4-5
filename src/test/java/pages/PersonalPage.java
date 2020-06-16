package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PersonalPage extends BasePage {
    private WebElement username = driver.findElement(By.xpath("//div[@class='header2-menu']//div[contains(@class,'username')]"));
    private WebElement personalLink = driver.findElement(By.xpath("//a[contains(@href,'personal')]"));
    private By fname = By.xpath("//input[@name = 'fname']");
    private By lname = By.xpath("//input[@name = 'lname']");
    private By fnameLatin = By.xpath("//input[@name = 'fname_latin']");
    private By lnameLatin = By.xpath("//input[@name = 'lname_latin']");
    private By blogName = By.xpath("//input[@name = 'blog_name']");
    private By birthdate = By.xpath("//input[@name = 'date_of_birth']");
    private By addButton = By.xpath("//div[@data-prefix='contact']/button[contains(@text, '')]");
    private By typeContact1 = By.xpath("//div[@data-num='0']//span[@class='placeholder']");
    private By typeContact2 = By.xpath("//div[@data-num='1']//span[@class='placeholder']");
    private By typeContactFacebook = By.xpath("//button[@data-value='facebook']");
    private By fieldContactFacebook = By.xpath("//input[@name='contact-0-value']");
    private By typeContactSkype = By.xpath("//div[@data-num=\"1\"]//button[@data-value='skype']");
    private By fieldContactSkype = By.xpath("//input[@name='contact-1-value']");
    private By saveButton = By.xpath("//button[@name='continue']");

    Actions actions = new Actions(this.driver);

    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    public PersonalPage openPP() {
        actions.moveToElement(username).perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        personalLink.click();
        logger.info("Personal page OTUS is open");
        return this;
    }

    public PersonalPage names(String myFirstName, String myLastName, String myFirstNameLatin, String myLastNameLatin, String myBlogName) {
        driver.findElement(fname).clear();
        driver.findElement(fname).sendKeys(myFirstName);
        driver.findElement(lname).clear();
        driver.findElement(lname).sendKeys(myLastName);
        driver.findElement(fnameLatin).clear();
        driver.findElement(fnameLatin).sendKeys(myFirstNameLatin);
        driver.findElement(lnameLatin).clear();
        driver.findElement(lnameLatin).sendKeys(myLastNameLatin);
        driver.findElement(blogName).clear();
        driver.findElement(blogName).sendKeys(myBlogName);
        logger.info("Insert personal information");

        return new PersonalPage(driver);
    }

    public PersonalPage birthdate(String myBirthday) {
        driver.findElement(birthdate).clear();
        driver.findElement(birthdate).sendKeys(myBirthday);
        logger.info("Birthdate was added");

        return new PersonalPage(driver);
    }


    public PersonalPage addContacts(String myFacebook, String mySkype) {
        driver.findElement(fieldContactFacebook).clear();
        driver.findElement(fieldContactFacebook).sendKeys(myFacebook);
        driver.findElement(fieldContactSkype).clear();
        driver.findElement(fieldContactSkype).sendKeys(mySkype);
        logger.info("2 contacts was added");

        return new PersonalPage(driver);
    }

    public PersonalPage save() {
        driver.findElement(saveButton).click();
        logger.info("Information was saved");

        return new PersonalPage(driver);
    }

    public List<String> getPersonalInfo() {
        List<String> personalInfo = new ArrayList<>();
        personalInfo.add(driver.findElement(fname).getAttribute("value"));
        personalInfo.add(driver.findElement(lname).getAttribute("value"));
        personalInfo.add(driver.findElement(fnameLatin).getAttribute("value"));
        personalInfo.add(driver.findElement(lnameLatin).getAttribute("value"));
        personalInfo.add(driver.findElement(blogName).getAttribute("value"));
        personalInfo.add(driver.findElement(birthdate).getAttribute("value"));
        personalInfo.add(driver.findElement(fieldContactFacebook).getAttribute("value"));
        personalInfo.add(driver.findElement(fieldContactSkype).getAttribute("value"));

        return personalInfo;
    }

}
