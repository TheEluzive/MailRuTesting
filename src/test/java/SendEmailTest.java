import Model.DataPool;
import Model.Email;
import Model.User;
import Pages.EmailPage;
import Pages.MainPage;
import Pages.WriteLetterPage;
import org.testng.Assert;
import org.testng.ITestContext;

import org.testng.annotations.BeforeSuite;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SendEmailTest extends BaseTest {


    @Test
    public void sendEmailTest() {

        MainPage mainPage = new MainPage(driver);
        LOGGER.debug("Call: login.");
        mainPage.login(EMAIL_FOR_LOGIN, PASSWORD, EMAIL_POSTFIX);

        LOGGER.debug("Call: pressButtonWriteMessage.");
        EmailPage emailPage = new EmailPage(driver);
        emailPage.pressButtonWriteMessage(driver);

        LOGGER.debug("Call: sendLetter.");
        WriteLetterPage writeLetterPage = new WriteLetterPage(driver);
        writeLetterPage.sendLetter(driver, LETTER_ADDRESSEE,  LETTER_TEXT);

        LOGGER.debug("Call: assert.");
        Assert.assertTrue(writeLetterPage.sendingIsSuccessful(driver));

    }

}
