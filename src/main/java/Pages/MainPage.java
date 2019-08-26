package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MainPage extends BasePage{

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id=\"mailbox:login\"]")
    private WebElement textFieldLogin;

    @FindBy(xpath = "//*[@id=\"mailbox:password\"]")
    private WebElement textFieldPassword;

    @FindBy(xpath = "//input[@class='o-control']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//select[@id='mailbox:domain']")
    private WebElement selectorEmailPostfix;


    public void login(String login, String password, String emailPostfix){
        textFieldLogin.sendKeys(login);
        textFieldPassword.sendKeys(password);
        select(selectorEmailPostfix, emailPostfix);
        buttonLogin.click();
    }

}
