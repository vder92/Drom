package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FavoriteAdsPage {
    private final WebDriver driver;

    //private final WebDriverWait wait;
    public FavoriteAdsPage(WebDriver driver) {

        //wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "(//*[@class='bulletinLink bull-item__self-link auto-shy'])[1]")
    private WebElement adFromFavoritePage;

    public String getAdTitleFromFavoritePage() {
        return adFromFavoritePage.getText();
    }
}