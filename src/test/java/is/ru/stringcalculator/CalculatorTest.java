package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class CalculatorTest {
	// Tesing for the empty string
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}
	// Tesing "adding" one number
	@Test
	public void testOneNumber() {
		assertEquals(5, Calculator.add("5"));
	}
	// Testing adding two numbers together
	@Test
	public void testTwoNumbers() {
		assertEquals(42, Calculator.add("21,21"));
	}
	// Tesing adding multiple numbers together
	@Test
	public void testMultipleNumbers() {
		assertEquals(69, Calculator.add("21,22,26"));
	}
	// Tesing the new line seperator
	@Test
	public void testNewLineSeperator() {
		assertEquals(69, Calculator.add("21,22\n26"));
	}
	// Testing negative numbers
	@Rule
    public ExpectedException expectedException = ExpectedException.none();
 
    @Test
    public void testNegativeNumber(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Negatives not allowed: -1");
        Calculator.add("-1,2");
    }

    @Test
    public void testNegativeNumbers(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Negatives not allowed: -1");
        Calculator.add("-1,2,-3,-4");
    }

    // Tesing for numbers above 1000, with other numbers and standing alone
	@Test
	public void testNumbersAboveThousand() {
		assertEquals(37, Calculator.add("1001,37,0"));
	}

	@Test
	public void testNumbersAboveThousand2() {
		assertEquals(0, Calculator.add("1010"));
	}

	// Testing defferent delimeters, start with a semicolon, then an ampersand
	@Test
	public void testDifferentDelimeter() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
	@Test
	public void testDifferentDelimeter2() {
		assertEquals(3, Calculator.add("//&\n1&2"));
	}
}
