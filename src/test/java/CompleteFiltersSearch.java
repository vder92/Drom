import Pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CompleteFiltersSearch extends BaseTest {
    public MainPage mainPage;

    @BeforeEach
    public void completeFilters() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.scrollDown();
        mainPage.AdvancedSearchClick();
        mainPage.clickFirm();
        Thread.sleep(500);
        String brandName = "Toyota";
        mainPage.inputFirmName(brandName);
        Thread.sleep(500);
        mainPage.submitSelectedFirm();
        Thread.sleep(500);
        mainPage.clickModel();
        Thread.sleep(500);
        String modelName = "Harrier";
        Thread.sleep(500);
        mainPage.inputModelName(modelName);
        Thread.sleep(500);
        mainPage.submitSelectedModel();
        mainPage.openGasList();
        int gasTypeNumber = 5;
        Thread.sleep(500);
        mainPage.selectGasType(gasTypeNumber);
        mainPage.unsoldClick();
        mainPage.mileAgeClick();
        Thread.sleep(500);
        int mileAgeTest = 1;
        mainPage.inputMileAge(mileAgeTest);
        mainPage.clickFreePlace();
        Thread.sleep(500);
        mainPage.yearMadeClick();
        Thread.sleep(500);
        int yearMadeFrom = 2007;
        mainPage.selectYearMade(yearMadeFrom);
        Thread.sleep(500);
        mainPage.submitButtonClick();
    }
}