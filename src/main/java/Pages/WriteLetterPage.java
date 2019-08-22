package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WriteLetterPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'compose-head__row-wrapper compose-head__row-wrapper_to js-row')]//textarea[@class='js-input compose__labels__input']")
    private WebElement textFieldTo;

    @FindBy(xpath = "//input[contains(@name,'Subject')]")
    private WebElement textFieldTheme;

    @FindBy(xpath = "//body[@id='tinymce']")
    private WebElement textFieldLetter;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div/div/div[2]/div[1]/div/span")
    private WebElement buttonSend;

    public WriteLetterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void sendLetter(String to, String theme, String letterText, WebDriver driver, int waiting){
        textFieldTo = (new WebDriverWait(driver, waiting))
                .until(ExpectedConditions.visibilityOf(textFieldTo));
        textFieldTo.sendKeys(to);
        textFieldLetter.sendKeys(theme);
        textFieldLetter.sendKeys(letterText);
        buttonSend.click();
    }
}
