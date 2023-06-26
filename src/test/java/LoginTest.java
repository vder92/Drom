import Pages.FavoriteAdsPage;
import Pages.LoginPage;
import Pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {
    public MainPage mainPage;
    public LoginPage loginPage;
    public FavoriteAdsPage favoriteAdsPage;
    String login = "20714342";
    String password = "333zzz";
    SoftAssertions softAssert = new SoftAssertions();

    @Test
    public void loginTest() throws InterruptedException {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        favoriteAdsPage = new FavoriteAdsPage(driver);
        mainPage.getLoginPage();
        loginPage.loginEnter(login);
        loginPage.passwordEnter(password);
        loginPage.submitAuth();
        mainPage.myAccountButtonClick();
        Thread.sleep(800);
        //проверка наличия логина в топ-меню (успешность авторизации)
        assertEquals(mainPage.getLoginInTopMenu(), login);
        mainPage.favoriteButtonClick();
        String favAdTitleFromMainPage = mainPage.getFavoriteTitleText();
        mainPage.getFavoriteAdsPage();
        String favAdTitleFromFavPage = favoriteAdsPage.getAdTitleFromFavoritePage();
        //проверка добавления объявления в избранное
        assertEquals(favAdTitleFromFavPage, favAdTitleFromMainPage);
    }
}

