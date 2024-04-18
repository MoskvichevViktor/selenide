package testProject.pages.Competency;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class BlockCompetencyPage {

    public final SelenideElement
    /* Сайдбар виды блоков компетенций */
    publishedBlockCompetSidebar = $x("//p[text()='Опубликованные']")
      .as("Сайдбар виды блоков компетенций"),
    draftBlockCompetSidebar = $x("//p[text()='Черновик']"),
    archiveBlockCompetSidebar = $x("//p[text()='Архив']"),
    /* Создание блока компетенций */
    btnCreateCompet = $x("//div[@class='CompetenciesIntroPage-section']/child::button[text()='Создать блок компетенций']"),
    /* Публикация блока компетенций */
    publishBlockCompet = $x("//button[@type='button']/child::span[text()='Опубликовать']"),
    /* Подтверждение при публикации блока компетенций */
    publishBlockCompetConfirm = $x("//button[text()='Опубликовать блок']"),
    /* Закрытие блока компетенций */
    closeBlockCompet = $x("//button[@type='button']/child::span[text()='Закрыть']"),
    /* Архивирование блока компетенций */
    btnArchivePublished = $x("//button[@type='button']/child::span[text()='Архив']"),
    /* Утверждение архивации блока компетенций */
    btnArchiveBlockCompetConfirm = $x("//button[text()='Архивировать блок']"),
    /* Удаление блока компетенций */
    btnDelete = $x("//button[@type='button']/child::span[text()='Удалить']"),
    /* Подтверждение при удалении блока компетенций */
    btnYes = $x("//div[@class='ModalFooter-root']/child::button[text()='Да']").as("кнопка Да"),
    /* Дублирование блока компетенции */
    btnDuplicate = $x("//button[@type='button']/child::span[text()='Дублировать']"),
    /* Редактирование блока компетенции.Поля блока компетенции */
    nameBlockCompet = $x("//textarea[@placeholder='Введите название блока компетенций']"),
    nameSphere = $x("//textarea[@placeholder='Введите название сферы компетенций']"),
    nameCompet = $x("//textarea[@placeholder='Введите название компетенции']"),
    minLevel = $x("(//textarea[@placeholder='Ввод текста'])[1]"),
    baseLevel = $x("(//textarea[@placeholder='Ввод текста'])[2]"),
    proLevel = $x("(//textarea[@placeholder='Ввод текста'])[3]"),
    expertLevel = $x("(//textarea[@placeholder='Ввод текста'])[4]"),
    /* Добавление сферы в блоке компетенции */
    btnAddSphere = $x("//button[text()=' Добавить сферу']"),
    btnYesAddSphere = $x("//button[text()='Да']"),
    nameNewSphere = $x("(//textarea[@placeholder='Введите название сферы компетенций'])[1]"),
    nameNewCompet = $x("(//textarea[@placeholder='Введите название компетенции'])[1]"),
    nameNewMinLevel = $x("(//textarea[@placeholder='Ввод текста'])[1]"),
    nameNewBaseLevel = $x("(//textarea[@placeholder='Ввод текста'])[2]"),
    nameNewProLevel = $x("(//textarea[@placeholder='Ввод текста'])[3]"),
    nameNewExpertLevel = $x("(//textarea[@placeholder='Ввод текста'])[4]"),
    publishNewSphere = $x("(//button[text()='Добавить'])[1]");


    public final SelenideElement
    /* Раздел Ассессмент */
    assessmentPage = $x("(//span[text()='Ассесмент'])[1]"),
    /* Результат создания блока компетенции */
    sResult = $x("//div[@class='Paper-root CompetencyBlock-paper CompetencyBlock-primaryGradient']");


    @Step("Создание блока компетенций")
    public void createBlockCompetence(String nameBlockText, String nameSphereText, String nameCompetText, String nameMinLevelText,
                                      String nameBaseLevelText, String nameProLevelText, String nameExpertLevelText) {
        btnCreateCompet.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        nameBlockCompet.sendKeys(nameBlockText);
        nameSphere.sendKeys(nameSphereText);
        nameCompet.sendKeys(nameCompetText);
        minLevel.sendKeys(nameMinLevelText);
        baseLevel.sendKeys(nameBaseLevelText);
        proLevel.sendKeys(nameProLevelText);
        expertLevel.sendKeys(nameExpertLevelText);
        publishBlockCompet.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        publishBlockCompetConfirm.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
    }

    public void delete() {
        btnDelete.click();
        btnYes.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
    }

    public void close() {
        closeBlockCompet.click();
    }

    public void renameBlockCompetence(String name) {
        btnCreateCompet.click();

        publishBlockCompet.click();
        publishBlockCompetConfirm.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
    }

    @Step("Дублирование такого же блока компетенций")
    public void duplicate() {
        btnDuplicate.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        publishBlockCompet.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        publishBlockCompetConfirm.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
    }

    @Step("Отправление в архив блока компетенций")
    public void archive() {
        btnArchivePublished.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        btnArchiveBlockCompetConfirm.click();
    }

    @Step("Добавление еще одной сферы к блоку компетенций")
    public void addSphere() {
        btnAddSphere.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        btnYesAddSphere.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        nameNewSphere.sendKeys("Сфера тест01");
        nameNewCompet.sendKeys("Компетенция тест01");
        nameNewMinLevel.sendKeys("Минимальный исходный уровень01");
        nameNewBaseLevel.sendKeys("Базовый уровень01");
        nameNewProLevel.sendKeys("Продвинутый уровень01");
        nameNewExpertLevel.sendKeys("Экспертный уровень01");
        publishNewSphere.click();
    }

}
