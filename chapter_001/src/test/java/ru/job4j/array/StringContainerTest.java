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
}