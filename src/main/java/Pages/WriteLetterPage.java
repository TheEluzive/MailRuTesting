package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class WriteLetterPage extends BasePage {

    @FindBy(xpath = "/html/body/div[14]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div/label/div/div/input")
    private WebElement textFieldTo;

    @FindBy(xpath = "/html/body/div[14]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div[2]/div[1]/div/div[2]")
    private WebElement textFieldLetter;

    @FindBy(xpath = "/html/body/div[14]/div[2]/div/div[2]/div[1]/span[1]/span/span")
    private WebElement buttonSend;

    @FindBy(xpath = "/html/body/div[8]/div/div/div[2]/div[2]/div/div/div[2]")
    private WebElement alert;


    public WriteLetterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void sendLetter(WebDriver driver, String to, String letterText) {
        waitWebElement(driver, textFieldTo).sendKeys(to);
        sendKeysByJS(driver, textFieldLetter, letterText);
        buttonSend.click();
    }

    public boolean sendingIsSuccessful(WebDriver driver) {
        return waitWebElement(driver, alert).getText().equals("Письмо отправлено");
    }
}
