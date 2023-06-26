package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    //private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {

       // wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // локаторы
    @FindBy(id = "sign")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "signbutton")
    private WebElement signButton;


    //методы
    public void loginEnter(String login) {
        loginField.sendKeys(login);
    }

    public void passwordEnter(String password) {
        passwordField.sendKeys(password);
    }

    public void submitAuth() {
        signButton.click();
    }


}