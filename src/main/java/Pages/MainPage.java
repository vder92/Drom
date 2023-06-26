package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;


public class MainPage {
    private final WebDriver driver;
    //private final WebDriverWait wait;

    public MainPage(WebDriver driver) {

        //wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@placeholder = 'Марка']")
    private WebElement firm;
    @FindBy(xpath = "//*[@placeholder = 'Модель']")
    private WebElement model;
    @FindBy(xpath = "//button[contains(text(),'Топливо')]")
    private WebElement gas;
    @FindBy(xpath = "//div[@class='css-u25ii9 e154wmfa0']/div")
    private List<WebElement> gasList = new ArrayList<>();
    @FindBy(xpath = "//label[@for='sales__filter_unsold']")
    private WebElement unsold;
    @FindBy(xpath = "//span[contains(text(),'Расширенный поиск')]")
    private WebElement advancedSearch;
    @FindBy(xpath = "//input[@placeholder = 'от, км']")
    private WebElement mileAge;
    @FindBy(xpath = "//button[contains(text(),'Год от')]")
    private WebElement yearMade;
    @FindBy(xpath = "//div[@data-ftid='sales__filter_year-from']//select")
    private WebElement yearMadeList;
    @FindBy(xpath = "//*[@data-ftid='sales__filter_submit-button']")
    private WebElement submitButton;
    @FindBy(xpath = "//button[contains(text(),'Сначала новые объявления')]")
    private WebElement buttonNewAd;
    @FindBy(xpath = "//*[@data-ftid='bulls-list_filter_full']")
    private WebElement formFreePlace;
    @FindBy(xpath = "//*[@data-ftid='component_pagination-item-next']")
    private WebElement nextPageButton;
    @FindBy(xpath = "(//*[@data-ftid='bull_title'])/..")
    private List<WebElement> adTitle = new ArrayList<>();
    @FindBy(xpath = "(//div[@data-ftid='component_inline-bull-description'])/span[5]")
    private List<WebElement> mileAgeAdList = new ArrayList<>();
    @FindBy(css = "[data-ftid='component_header_login']")
    private WebElement loginPageButton;
    @FindBy(xpath = "//a[contains(text(),'Другой город')]")
    private WebElement anotherCityButton;

    //Для задания добавления в избранное
    @FindBy(xpath = "//div[@data-ftid='component_header_user-info-expand-controller']")
    private WebElement myAccountButton;
    @FindBy(xpath = "//a[@data-ftid='component_header_my-account']")
    private WebElement myLoginLink;
    @FindBy(xpath = "(//*[@class='css-pivpd8 e13r0v7w0'])[1]")
    private WebElement favoriteButton;
    @FindBy(xpath = "(//*[@data-ftid='component_header_my-favorite'])[2]")
    private WebElement favoriteButtonTopMenu;
    @FindBy(xpath = "(//*[@data-ftid='bull_title'])[1]")
    private WebElement favoriteAdTitle;

    //для задания 3 задания----------------------------------------------------------------------------
    @FindBy(xpath = "//*[@aria-label = 'Марка']/div/div/div")
    private List<WebElement> firmList = new ArrayList<>();
    //-------------------------------------------------------------------------------------------------

    //методы
    public void AdvancedSearchClick() {
        advancedSearch.click();
    }

    public void clickFirm() {
        firm.click();
    }

    public void clickFreePlace() {
        formFreePlace.click();
    }

    public void inputFirmName(String firmName) {
        firm.sendKeys(firmName);
    }

    public void submitSelectedFirm() {
        firm.sendKeys(Keys.ENTER);
    }

    public void clickModel() {
        model.click();
    }

    public void inputModelName(String modelName) {
        model.sendKeys(modelName);
    }

    public void submitSelectedModel() {
        model.sendKeys(Keys.ENTER);
    }

    public void scrollDown() {
        Actions scrollDown = new Actions(driver);
        scrollDown.moveToElement(buttonNewAd);
        scrollDown.perform();
    }

    public void openGasList() {
        gas.click();
    }

    public void selectGasType(int gasTypeNumber) {
        gasList.get(gasTypeNumber).click();
    }

    public void unsoldClick() {
        unsold.click();
    }

    public void mileAgeClick() {
        mileAge.click();
    }

    public void inputMileAge(int mileAgeTest) {
        mileAge.sendKeys("" + mileAgeTest);
    }

    public void yearMadeClick() {
        yearMade.click();
    }

    public void selectYearMade(int yearMadeFrom) {
        Select yearMade = new Select(yearMadeList);
        yearMade.selectByValue("" + yearMadeFrom);
    }

    public void submitButtonClick() {
        submitButton.click();
    }

    public void turnNextPage() {
        nextPageButton.click();
    }

    public int adOnPageCount() {
        return adTitle.size();
    }

    public boolean lineThroughClassCheck(String lineThroughClass, int i) {
        return adTitle.get(i).getAttribute("class").contains(lineThroughClass);
    }

    public WebElement getAdTitle(int i) {
        return adTitle.get(i);
    }

    public int MileAgeListSize() {
        return mileAgeAdList.size();
    }

    public void getLoginPage() {
        loginPageButton.click();
    }

    //для добавления в избранное
    public void myAccountButtonClick() {
        Actions action = new Actions(driver);
        action.moveToElement(myAccountButton);
        action.perform();
    }

    public String getLoginInTopMenu() {
        return myLoginLink.getText();
    }

    public void favoriteButtonClick() {
        favoriteButton.click();
    }

    public void getFavoriteAdsPage() {
        favoriteButtonTopMenu.click();
    }

    public String getFavoriteTitleText() {
        return favoriteAdTitle.getText();
    }

    //Для задания 3------------------------------------------------------------------------
    public void getChooseRegionPage() {
        anotherCityButton.click();
    }

    int sizeList;

    public int sizeFirmList() {
        int sizeList = firmList.size();
        return sizeList;
    }

    public String getFirmFromList1(int i) {
        return firmList.get(i).getText();
    }

    public void scrollFirmList1(int i) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", firmList.get(i));
    }
}