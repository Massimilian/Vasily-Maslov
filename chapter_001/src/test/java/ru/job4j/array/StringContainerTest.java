package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 10/01/2018
 */
 
 public class StringContainerTest {
	 @Test
	 public void whenEnterTwoStringsThenLookEqualPartsAndDoNotFoundThem() {
	 StringContainer str = new StringContainer();
	 boolean test = str.contains("Это правильный тест", "А это неправильный");
	 boolean result = false;
	 assertThat(test, is(result));
	 }
	 
	 @Test
	 public void whenEnterTwoSimilarStringsThenLookEqualAndReturnTrue() {
	 StringContainer str = new StringContainer();
	 boolean test = str.contains("Мир, труд, май!", "Мир, труд, май!");
	 boolean result = true;
	 assertThat(test, is(result));
	 }
	 
	 @Test
	 public void whenEnterTwoStringsThenLookEqualAndReturnTrue() {
	 StringContainer str = new StringContainer();
	 boolean test = str.contains("Мой дядя самых честных правил, когда не в шутку занемог, вдруг уважать себя заставил и лучше выдумать не мог.", "ог, вдр");
	 boolean result = true;
	 assertThat(test, is(result));
	 }
	 
	 @Test
	 public void whenEnterTwoStringsThenLookEqualPartsAndDoNotFoundThemAnotherTry() {
	 StringContainer str = new StringContainer();
	 boolean test = str.containsVersionOne("Это правильный тест", "А это неправильный");
	 boolean result = false;
	 assertThat(test, is(result));
	 }
	 
	 @Test
	 public void whenEnterTwoSimilarStringsThenLookEqualAndReturnTrueAnotherTry() {
	 StringContainer str = new StringContainer();
	 boolean test = str.containsVersionOne("Мир, труд, май!", "Мир, труд, май!");
	 boolean result = true;
	 assertThat(test, is(result));
	 }
	 
	 @Test
	 public void whenEnterTwoStringsThenLookEqualAndReturnTrueAnotherTry() {
	 StringContainer str = new StringContainer();
	 boolean test = str.containsVersionOne("Мой дядя самых честных правил, когда не в шутку занемог, вдруг уважать себя заставил и лучше выдумать не мог.", "ог, вдр");
	 boolean result = true;
	 assertThat(test, is(result));
	 }

	 @Test
	 public void whenEnterTooBigSecondWorldThenReturnFalse() {
	 StringContainer str = new StringContainer();
	 boolean test = str.contains("Это маленькая строчка", "А это ну просто слищком большая строка!!!!!");
	 boolean result = false;
	 assertThat(test, is(result));
	 }
}