 package ru.job4j.homeworks.coffeemachine;

 import org.junit.Test;
 import static org.hamcrest.Matchers.is;
 import static org.junit.Assert.*;

public class CoffeeMachineTest {

	 @Test
	 public void whenEnterANumberThenReturnTheResult() {
	 CoffeeMachine cof = new CoffeeMachine();
	 assertThat(cof.changes(100, 82), is(new int[]{10, 5, 2, 1}));
	 }
}
