import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public static final String EMAIL_FOR_LOGIN = "emailForQAQA";
    public static final String PASSWORD = "QAQAQAQA123qa";
    public static final String EMAIL_POSTFIX = "@inbox.ru";
    public static final String LETTER_ADDRESSEE = "someonesorry@mail.ru";
    public static final String LETTER_THEME = "It is the theme";
    public static final String LETTER_TEXT = "Text";

    public static final int WAITING_WEB_ELEMENTS=100;

    protected WebDriver driver;

    @BeforeTest
    public void onStart(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.ru");
        driver.manage().window().maximize();

    }

    @AfterTest
    public void onFinish(){
        driver.close();
    }
}
