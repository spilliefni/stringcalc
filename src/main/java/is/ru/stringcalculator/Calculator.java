package is.ru.stringcalculator; 

public class Calculator {
	public static int add(String s) {
		if (s.equals("")) {
			return 0;
		}
		else if(s.contains(",") || s.contains("\n")) {
			return sum(splitString(s));
		}
		else {
			return toInt(s);
		}
	}
	private static int toInt(String num) {
		return Integer.parseInt(num);
	}
	private static String[] splitString(String nums) {
		return nums.split(",|\n");
	}
	private static int sum(String[] nums) throws IllegalArgumentException {
		int total_sum = 0;
		for (String num : nums) {
			if (toInt(num) < 0) {
				throw new IllegalArgumentException("Negatives not allowed: -1");
			}
			total_sum += toInt(num);
		}
		return total_sum;
	}
	

}
