package testProject.pages.Tasks;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TaskOnePage {

    private final SelenideElement
            btnAddTask = $x("//button[text()='Добавить вопрос']"),
            btnTypeTask = $x("//div[text()='Тест (один из списка)']"),
            typeOne = $x("//span[text()='Тест (один из списка)']"),
            nameTask = $x("(//div[text()='Обязательное поле'])[1]"),
            responseOne =$x("//div[text()='Обязательное поле'])[2]"),
            responseTwo =$x("//div[text()='Обязательное поле'])[3]"),
            responseThree =$x("//div[text()='Обязательное поле'])[4]"),
            checkboxCorrect = $x("(//input[@type='checkbox'])[2]"),
            baseLevel = $x("(//input[@placeholder='Ввод текста'])[1]");

    public void addTask(){
        btnAddTask.click();
        btnTypeTask.click();
        typeOne.click();
        nameTask.sendKeys("Тест 1");
        responseOne.sendKeys("Верно");
        responseTwo.sendKeys("Ложь");
        responseThree.sendKeys("Ложь");

    }
}
