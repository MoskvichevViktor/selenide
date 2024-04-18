package testProject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class LoginPage {

    private final SelenideElement
            byPassword = $x("//*[@id='rc-tabs-0-tab-2']"),
            emailInput = $x("(//input[@name='phone'])[2]"),
            passwordInput = $x("//*[@id='password']"),
            btnLogIn = $x("//button[./span[text()='Войти']]");
    public final SelenideElement
            userContent = $x("//div[@class='NavProfile_userName__4mGdD']").as("отображение имени пользователя");


    public void userAuthorisation(String username, String password) {
        //Authorization
        byPassword.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        btnLogIn.click();
        //header.shouldBe(Condition.visible, Duration.ofSeconds(10));
        switchTo().window(0);
        // assessmentPage.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }
}
