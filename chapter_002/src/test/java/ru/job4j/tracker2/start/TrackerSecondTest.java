package ru.job4j.tracker2.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSecondTest {
	TrackerSecond tracker = new TrackerSecond();
	InputSecond input = new ConsoleInputSecond();
	
	@Before
    public void setStub() {
        System.out.println("StubInput has been set");
		input = new StubInputSecond(new String[]{"1", "Task", "Desc", "1", "Task", "Desc", "0"});
//		input = new StubInputSecond(new String[]{"1", "Task", "Desc", "1", "Task", "Desc", "7", "y"}); // StubInputSecond, вызывающий необъяснимую ошибку.
    }

    @After
    public void setIn() {
		input = new ConsoleInputSecond();
        System.out.println("Input has been returned");
	}
	
	@Test
	public void whenAddItemThenPutItIntoArray() { 
// данный тест почему-то воспринимал метод exit как ошибочный.
// Ошибка возникала в тот момент, когда я делал System.exit(0) (то есть "грубый" выход из системы).
// Компилятор сообщает, что "The forked VM terminated without saying properly goodbye. VM crash or System.exit called ?"
// Специально для данного теста создан альтернативный метод "мягкого" выхода anotherExit, который занимает больше объёма, но нормально отрабатывает в тесте.
// Правильно ли я понимаю, что System.exit(0) тестовая система воспринимает, как нечто недопустимое? И если да - почему так? Спасибо!
		new StartUISecond(input, tracker).init();
		assertThat(tracker.getItem(1).getDescription(), is("Desc"));
	}
}