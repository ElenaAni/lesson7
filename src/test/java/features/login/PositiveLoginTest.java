package features.login;

import Pages.HomePage;
import Pages.LoginPage;
import base.BaseUITest;
import helpers.ScreenshotMaker;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static common.Configuration.*;

@Feature("Login")
@Severity(SeverityLevel.BLOCKER)
public class PositiveLoginTest extends BaseUITest {

    @Test
    @Description("Логин сущесвующим пользователем")
    public void loginWithBaseUserTest() {
        new LoginPage(driver)
                .enterLogin(STUDENT_LOGIN)
                .enterPassword(STUDENT_PASSWORD)
                .clickLoginButton()
                .checkUrl(BASE_URL);

        ScreenshotMaker.makeScreenshot(driver,"login.jpg");
    }

    @Test
    @Description("Логин с помощью cookie")
    public void loginWithCookieTest() {
        driver.get(BASE_URL);
        driver
                .manage()
                .addCookie(new Cookie("BAPID", "c06ded2dea21a32e33f50811c141fa2d"));

        driver.get(BASE_URL);

        new HomePage(driver)
                .checkUrl(BASE_URL);
    }
}

