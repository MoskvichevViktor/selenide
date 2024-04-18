package testProject.pages.Tasks;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TaskPage {
    public final SelenideElement
            tasksPage = $x("//div[@class='topBar-navbar-0-2-26']/child::a[text()='Задания']"),
            btnAddTask = $x("//button[@iconleft='[object Object]'/child::button[text()='Добавить вопрос']");

}
