package Pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Data
public class MainPage extends BasePage{

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    private String Url;

    @FindBy(xpath = "//*[@id=\"mailbox:login\"]")
    private WebElement textFieldLogin;

    @FindBy(xpath = "//*[@id=\"mailbox:password\"]")
    private WebElement textFieldPassword;

    @FindBy(xpath = "//input[@class='o-control']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//select[@id='mailbox:domain']")
    private WebElement selectorEmailPostfix;

    public void select(WebElement selector, String value){
        Select select = new Select(selector);
        selector.click();
        select.selectByVisibleText(value);
    }
    public void login(String login, String password, String emailPostfix){
        textFieldLogin.sendKeys(login);
        textFieldPassword.sendKeys(password);
        select(selectorEmailPostfix, emailPostfix);
        buttonLogin.click();
    }

}
