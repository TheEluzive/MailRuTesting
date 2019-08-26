package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class EmailPage extends BasePage{

    public EmailPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[@class='compose-button__wrapper']")
    private WebElement buttonWriteMessage;

    @FindBy(xpath = "//a[@id='PH_logoutLink']")
    private WebElement buttonLogout;

}
