package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WriteLetterPage extends BasePage {

    @FindBy(xpath = "/html/body/div[14]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div/label/div/div/input")
    private WebElement textFieldTo;

    @FindBy(xpath = "/html/body/div[14]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div[2]/div[1]/div/div[2]")
    private WebElement textFieldLetter;

    @FindBy(xpath = "/html/body/div[14]/div[2]/div/div[2]/div[1]/span[1]/span/span")
    private WebElement buttonSend;

    @FindBy(xpath = "/html/body/div[8]/div/div/div[2]/div[2]/div/div/div[2]")
    private WebElement alert;


    public void jsInputTextFieldLetter(WebDriver driver, String text) {
        String JS = " const elem = document.evaluate('/html/body/div[14]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div[2]/div[1]/div/div[2]', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ).singleNodeValue; elem.innerText = '" + text + "' ";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(JS, textFieldLetter);
    }


    public WriteLetterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void sendLetter(WebDriver driver, String to, String letterText) {
        textFieldTo = (new WebDriverWait(driver, WAITING_WEB_ELEMENTS_IN_SECONDS))
                .until(ExpectedConditions.visibilityOf(textFieldTo));
        textFieldTo.sendKeys(to);

        jsInputTextFieldLetter(driver, letterText);
        buttonSend.click();
    }

    public boolean sendingIsSuccessful(WebDriver driver) {
        alert = (new WebDriverWait(driver, WAITING_WEB_ELEMENTS_IN_SECONDS))
                .until(ExpectedConditions.visibilityOf(alert));
        return (alert.getText().equals("Письмо отправлено"));
    }
}
