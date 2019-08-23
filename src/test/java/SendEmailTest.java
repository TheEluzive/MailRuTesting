import Pages.EmailPage;
import Pages.MainPage;
import Pages.WriteLetterPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendEmailTest extends BaseTest {

    @Test
    public void sendEmailTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.login(EMAIL_FOR_LOGIN, PASSWORD, EMAIL_POSTFIX);

        EmailPage emailPage = new EmailPage(driver);
        emailPage.pressButtonWriteMessage(driver, WAITING_WEB_ELEMENTS);

        WriteLetterPage writeLetterPage = new WriteLetterPage(driver);
        writeLetterPage.sendLetter(LETTER_ADDRESSEE, LETTER_THEME, LETTER_TEXT, driver, WAITING_WEB_ELEMENTS);
        Assert.assertTrue(writeLetterPage.isSuccessful());
        Thread.sleep(20000);
    }

}
