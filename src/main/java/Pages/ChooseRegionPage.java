package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChooseRegionPage {
    private final WebDriver driver;

    //private final WebDriverWait wait;
    public ChooseRegionPage(WebDriver driver) {
        //     wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@placeholder='поиск города, региона']")
    private WebElement inputRegionField;

    public void inputRegionClick() {
        inputRegionField.click();
    }

    public void inputRegion() {
        inputRegionField.sendKeys("Приморский", Keys.ENTER);
    }
}
