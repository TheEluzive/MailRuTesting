import Model.DataPool;
import Model.Email;
import Pages.EmailPage;
import Pages.MainPage;
import Pages.WriteLetterPage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SendEmailTest extends BaseTest {

    @BeforeSuite
    public void dataPool(ITestContext testContext) {
        dataPool = new DataPool<>("data", testContext, Email.class);
    }

    @DataProvider(name = "email")
    public Object[] dataProviderNewUserFromJson() {
        return dataPool.getData();
    }

    @Test(dataProvider = "email")
    public void sendEmailTest(Email email) {

        MainPage mainPage = new MainPage(driver);
        LOGGER.debug("Call: login.");
        //mainPage.login(EMAIL_FOR_LOGIN, PASSWORD, EMAIL_POSTFIX);
        mainPage.login(email.getUser().getLogin(), email.getUser().getPassword(), email.getUser().getEmailPostfix());

        LOGGER.debug("Call: pressButtonWriteMessage.");
        EmailPage emailPage = new EmailPage(driver);
        emailPage.pressButtonWriteMessage(driver);

        LOGGER.debug("Call: sendLetter.");
        WriteLetterPage writeLetterPage = new WriteLetterPage(driver);
        //writeLetterPage.sendLetter(driver, LETTER_ADDRESSEE,  LETTER_TEXT);
        writeLetterPage.sendLetter(driver, email.getAddressee(), email.getEmailText());

        LOGGER.debug("Call: assert.");
        Assert.assertTrue(writeLetterPage.sendingIsSuccessful(driver));

    }

}
