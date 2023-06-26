import Pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.assertj.core.api.SoftAssertions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ToyotaHarrierTest extends CompleteFiltersSearch {
    SoftAssertions softAssert = new SoftAssertions();
    int pageAmountToCheck = 2;

    @Test
    @DisplayName("Line through the text is not present")
    public void lineThroughTextCheck() throws InterruptedException {
        mainPage = new MainPage(driver);
        for (int k = 1; k <= pageAmountToCheck; k++) {
            Thread.sleep(800);
            String lineThroughClass = "css-1e5mzqy";
            for (int i = 0; i <= (mainPage.adOnPageCount() - 1); i++) {
                softAssert.assertThat(mainPage.lineThroughClassCheck(lineThroughClass, i)).isFalse();
            }
            if (k < pageAmountToCheck) {
                mainPage.turnNextPage();
            }
        }
        softAssert.assertAll();
    }

    @Test
    @DisplayName("YearMade is not less than 2007")
    public void yearMadeCheck() throws InterruptedException {
        mainPage = new MainPage(driver);
        int yearToCheck = 2007;
        for (int k = 1; k <= pageAmountToCheck; k++) {
            for (int i = 0; i <= (mainPage.adOnPageCount() - 1); i++) {
                String[] titleTextSplit = mainPage.getAdTitle(i).getText().split(", ");
                int year = Integer.parseInt(titleTextSplit[1]);
                softAssert.assertThat(year).isGreaterThanOrEqualTo(yearToCheck);
            }
            if (k < pageAmountToCheck) {
                mainPage.turnNextPage();
            }
        }
        softAssert.assertAll();
    }

    @Test
    @DisplayName("Each ad has a mileage")
    public void mileAgeCheck() throws InterruptedException {
        mainPage = new MainPage(driver);
        for (int k = 1; k <= pageAmountToCheck; k++) {
            softAssert.assertThat(mainPage.MileAgeListSize()).isEqualTo(mainPage.adOnPageCount());
            if (k < pageAmountToCheck) {
                mainPage.turnNextPage();
            }
        }
        softAssert.assertAll();
    }
}

