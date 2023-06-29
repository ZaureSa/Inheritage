package ru.netology.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void shouldFindMatchingTasksSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        simpleTask.matches("родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("родителям");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchingTasksEpicInOneSubtask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);

        epic.matches("Хлеб");

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldNotFindAnotherTaskEpicInOneSubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);

        epic.matches("Сыр");

        boolean expected = false;
        boolean actual = epic.matches("Сыр");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchingTaskEpicInTwoSubtasks() {
        String[] subtasks = {"Сыр свежий", "Яйца", "Хлеб свежий"};
        Epic epic = new Epic(2, subtasks);

        epic.matches("свежий");

        boolean expected = true;
        boolean actual = epic.matches("свежий");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchingTasksMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        meeting.matches("версии");

        boolean expected = true;
        boolean actual = meeting.matches("версии");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAnotherTasksMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        meeting.matches("В среду");

        boolean expected = false;
        boolean actual = meeting.matches("В среду");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchingTasksMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        meeting.matches("НетоБанка");

        boolean expected = true;
        boolean actual = meeting.matches("НетоБанка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAnotherTasksMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        meeting.matches("сайт");

        boolean expected = false;
        boolean actual = meeting.matches("сайт");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindId() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        simpleTask.matches(5);
        epic.matches(5);
        meeting.matches(5);

        boolean expected = false;
        boolean actual = simpleTask.matches(5);
        epic.matches(5);
        meeting.matches(5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindIdSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(7, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        simpleTask.getId();

        int expected = 7;
        int actual = simpleTask.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindIdEpic () {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(3, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        epic.getId();

        int expected = 3;
        int actual = epic.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindIdMeeting () {
        SimpleTask simpleTask = new SimpleTask(5,"Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic =new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                5,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        meeting.getId();

        int expected = 5;
        int actual = meeting.getId();

        Assertions.assertEquals(expected, actual);
    }
}



