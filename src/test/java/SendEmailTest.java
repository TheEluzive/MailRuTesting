import model.Email;
import org.testng.annotations.Listeners;
import pages.EmailPage;
import pages.MainPage;
import pages.WriteLetterPage;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Listeners(Listener.class)
public class SendEmailTest extends BaseTest {


    @DataProvider
    public Object[][] getData() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/Email.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<Email> testData = new Gson().fromJson(dataSet, new TypeToken<List<Email>>() {
        }.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }


    @Test(dataProvider = "getData")
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
