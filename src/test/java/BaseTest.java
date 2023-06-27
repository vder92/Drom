import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--remote-allow-origins=*");
        //driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();
        driver.get("http://auto.drom.ru/");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
