package testProject.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

  public static void setUp() {
    Configuration.browser = "Chrome";
    //Configuration.browserSize = "1920x1080";
    Configuration.headless = false;
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
  }

  @BeforeAll
  static void init() {
    setUp();
  }

  @AfterAll
  static void tearDown() {
    //closeWebDriver();
  }
}
