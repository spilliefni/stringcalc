package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class CalculatorTest {

	@Rule
    public ExpectedException expectedException = ExpectedException.none();
 
    @Test
    public void testNegativeNumber(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Negatives not allowed: -1");
        Calculator.add("-1,2");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(5, Calculator.add("5"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(42, Calculator.add("21,21"));
	}

	@Test
	public void testMultipleNumbers() {
		assertEquals(69, Calculator.add("21,22,26"));
	}

	@Test
	public void testNewLineSeperator() {
		assertEquals(69, Calculator.add("21,22\n26"));
	}

	@Test
	public void testNumbersAboveThousand() {
		assertEquals(37, Calculator.add("1001,37,0"));
	}
}
