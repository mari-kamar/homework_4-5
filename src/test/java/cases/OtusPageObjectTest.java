package cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

public class OtusPageObjectTest extends OtusBaseTest {
    private static String myBirthday = "15.09.1988";
    private static String myFirstName = "Имя";
    private static String myLastName = "Фамилия";
    private static String myFirstNameLatin = "Name";
    private static String myLastNameLatin = "Surname";
    private static String myBlogName = "test";
    private static String myFacebook = "test.facebook";
    private static String mySkype = "test.skype";

    @Test
    public void otusPageObjectTest() {

        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .auth()
                .login(myLogin, myPass)
                .enter()
                .openPP()
                .names(myFirstName, myLastName, myFirstNameLatin, myLastNameLatin, myBlogName)
                .birthdate(myBirthday)
                .addContacts(myFacebook, mySkype)
                .save();

        driver.manage().deleteAllCookies();
        logger.info("restart browser");

        mainPage = new MainPage(driver);
        List<String> personalInfo;
        personalInfo = mainPage
                .open()
                .auth()
                .login(myLogin, myPass)
                .enter()
                .openPP()
                .getPersonalInfo();

        Assert.assertTrue(personalInfo.contains(myFirstName), "First name field is empty");
        Assert.assertTrue(personalInfo.contains(myLastName), "Last name field is empty");
        Assert.assertTrue(personalInfo.contains(myFirstNameLatin), "Latin first name field is empty");
        Assert.assertTrue(personalInfo.contains(myLastNameLatin), "Latin last name field is empty");
        Assert.assertTrue(personalInfo.contains(myBlogName), "Blog name field is empty");
        Assert.assertTrue(personalInfo.contains(myBirthday), "Birth date field is empty");
        Assert.assertTrue(personalInfo.contains(myFacebook), "First contact field is empty");
        Assert.assertTrue(personalInfo.contains(mySkype), "Second contact field is empty");
    }

}
