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
        Thread.sleep(300);
        String brandName = "Toyota";
        mainPage.inputFirmName(brandName);
        Thread.sleep(300);
        mainPage.submitSelectedFirm();
        mainPage.clickModel();
        Thread.sleep(300);
        String modelName = "Harrier";
        Thread.sleep(500);
        mainPage.inputModelName(modelName);
        Thread.sleep(300);
        mainPage.submitSelectedModel();
        mainPage.openGasList();
        int gasTypeNumber = 5;
        mainPage.selectGasType(gasTypeNumber);
        mainPage.unsoldClick();
        mainPage.mileAgeClick();
        int mileAgeTest = 1;
        mainPage.inputMileAge(mileAgeTest);
        mainPage.clickFreePlace();
        mainPage.yearMadeClick();
        int yearMadeFrom = 2007;
        mainPage.selectYearMade(yearMadeFrom);
        mainPage.submitButtonClick();
    }
}
