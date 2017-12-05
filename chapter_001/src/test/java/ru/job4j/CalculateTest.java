package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Vasily Maslov (vasalekmas@gmail.com)
* @version $~$
* @since 06/12/2017
*/
public class CalculateTest {
/**
* Test echo.
*/ 
@Test
public void whenTakeMyNameThenTreeEchoPlusName() {
    String input = "Vasily Maslov";
    String expect = "Echo, echo, echo : Vasily Maslov"; 
    Calculate calc = new Calculate();
    String result = calc.echo(input);
    assertThat(result, is(expect));
	}
}