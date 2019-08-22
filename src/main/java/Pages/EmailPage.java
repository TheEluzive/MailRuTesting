package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailPage extends BasePage{

    public EmailPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/div/span/span/span")
    private WebElement buttonWriteMessage;

    public void pressButtonWriteMessage(WebDriver driver, int waiting){
        buttonWriteMessage = (new WebDriverWait(driver, waiting))
                .until(ExpectedConditions.elementToBeClickable(buttonWriteMessage));

        buttonWriteMessage.click();
    }
}
