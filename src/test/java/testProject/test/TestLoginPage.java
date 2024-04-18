package testProject.test;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import testProject.pages.Competency.BlockCompetencyPage;
import testProject.pages.LoginPage;


import static com.codeborne.selenide.Selenide.open;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // для применения для @Order(1)
public class TestLoginPage extends BaseTest{

    @Order(1) // вместо приорити
    @Test
    @Description("Первый тест")
    public void checkAuth() {
        open("https://www.google.com");
        //open("https://auth.unionetest.ru/login");
        LoginPage loginPage = new LoginPage();
        loginPage.userAuthorisation("9138264544", "9584219lol");
        Selenide.sleep(5000);
        Assertions.assertEquals(loginPage.userContent.getText(), "Скирневская Катерина Михайловна");
    }

    @Order(2)
    @Test
    @Description("Второй тест")
    public void checkCreateCompet() {
        open("https://www.google.com");
        BlockCompetencyPage blockCompetencyPage = new BlockCompetencyPage();
        blockCompetencyPage.renameBlockCompetence("Блок компетенции");

        blockCompetencyPage.assessmentPage.click();
        blockCompetencyPage.createBlockCompetence("Блок компетенции", "Сфера тест",
                "Компет тест", "Мин уровень", "Баз уровень",
                "Про уровень", "Эксперт уровень");
        Assertions.assertTrue(blockCompetencyPage.sResult.isDisplayed());
    }
}
