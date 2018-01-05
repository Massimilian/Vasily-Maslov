package ru.job4j.loop;

import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $IId$
 * @since 06/01/2018
 */
public class PaintTest {
    @Test
    public void whenPyramidFourThenRight() {
    Paint paint = new Paint();
    String rst = paint.rightTrl(4);
    assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator()).add("^   ").add("^^  ").add("^^^ ").add("^^^^").toString()));
    }
	
	@Test
	public void whenPyramidThenFourLeft() {
    Paint paint = new Paint();
    String rst = paint.leftTrl(4);
    assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator()).add("   ^").add("  ^^").add(" ^^^").add("^^^^").toString()));
	}
	
	@Test
    public void whenPyramidFourThenRightAgain() {
    Paint paint = new Paint();
    String rst = paint.rightTriangle(4);
    assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator()).add("^   ").add("^^  ").add("^^^ ").add("^^^^").toString()));
    }
	
	@Test
	public void whenPyramidThenFourLeftAgain() {
    Paint paint = new Paint();
    String rst = paint.leftTriangle(4);
    assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator()).add("   ^").add("  ^^").add(" ^^^").add("^^^^").toString()));
	}
	
}