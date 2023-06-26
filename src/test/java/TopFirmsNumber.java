import Pages.ChooseRegionPage;
import Pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.and;

public class TopFirmsNumber extends BaseTest {
    public MainPage mainPage;
    public ChooseRegionPage chooseRegionPage;

    @Test
    @DisplayName("Top 20 firms with the highest number of ads")
    public void twentyTopFirms() throws InterruptedException {
        //открытие страницы с обяъвлениями в Приморском крае
        mainPage = new MainPage(driver);
        chooseRegionPage = new ChooseRegionPage(driver);
        mainPage.getChooseRegionPage();
        Thread.sleep(1000);
        chooseRegionPage.inputRegionClick();
        chooseRegionPage.inputRegion();
        mainPage.clickFirm();
        //создание массива с марками машин, у которых есть 1 и более объявлений
        ArrayList<String> firms = new ArrayList<>();
        for (int i = 1; i <= 33; i++) {
            if (i < 19) {
                WebElement firmNames0 = driver.findElement(By.xpath("(//*[@aria-label = 'Марка']/div/div/div)" + "[" + i + "]"));
                WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(firmNames0);
                if (firmNames0.getText().contains(" (")) {
                    firms.add(firmNames0.getText());
                }
            } else if (i == 19) {
                WebElement firmNames0 = driver.findElement(By.xpath("(//*[@aria-label = 'Марка']/div/div/div)" + "[" + i + "]"));
                WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(firmNames0);
                new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 230).perform();
                if (firmNames0.getText().contains(" (")) {
                    firms.add(firmNames0.getText());
                }
            } else {
                for (int k = 11; k <= 22; k++) {
                    WebElement firmNames1 = driver.findElement(By.xpath("(//*[@aria-label = 'Марка']/div/div/div)" + "[" + k + "]"));
                    if (firmNames1.getText().equals("УАЗ (146)"))
                        break;
                    if (k == 22) {
                        WheelInput.ScrollOrigin scrollOrigin1 = WheelInput.ScrollOrigin.fromElement(firmNames1);
                        new Actions(driver).scrollFromOrigin(scrollOrigin1, 0, 230).perform();
                    }
                    if (firmNames1.getText().contains(" (")) {
                        firms.add(firmNames1.getText());
                    }
                }
            }
        }
        //удаление дублирующихся марок
        for (int i = 0; i < 5; i++) {
            firms.remove(0);
        }
        // поиск TOП 20 марок по кол-ву объявлений
        boolean marker;
        do {
            marker = false;
            for (int i = 0; i <= firms.size() - 2; i++) {
                String[] splitFirmAndNUmber = firms.get(i).split("\\(");
                String[] splitNumberAndBracket = splitFirmAndNUmber[1].split("\\)");
                int amount1 = Integer.parseInt(splitNumberAndBracket[0]);
                String[] splitFirmAndNUmberNext = firms.get(i + 1).split("\\(");
                String[] splitNumberAndBracketNext = splitFirmAndNUmberNext[1].split("\\)");
                int amount = Integer.parseInt(splitNumberAndBracketNext[0]);
                String temp;
                if (amount > amount1) {
                    temp = firms.get(i + 1);
                    firms.set(i + 1, firms.get(i));
                    firms.set(i, temp);
                    marker = true;
                }
            }
        }
        while (marker);
        //вывод результата
        System.out.println("|Фирма|Количество объявлений|");
        for (int i = 0; i < 20; i++) {
            System.out.print("|" + (firms.get(i).split(" \\(")[0]) + "|");
            String amount = firms.get(i).split("\\(")[1];
            String amountWithoutBrackets = amount.split("\\)")[0];
            System.out.println(amountWithoutBrackets + "|");
        }
    }
}
