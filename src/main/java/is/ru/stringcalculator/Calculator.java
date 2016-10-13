package is.ru.stringcalculator; 

public class Calculator {
	public static int add(String s) {
		if (s.equals("")) {
			return 0;
		}
		else {
			return toInt(s);
		}
	}
	private static int toInt(String num) {
		return Integer.parseInt(num);
	}
}
