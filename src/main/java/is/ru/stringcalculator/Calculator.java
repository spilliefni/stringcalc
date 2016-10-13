package is.ru.stringcalculator; 

public class Calculator {
	public static int add(String s) {
		if (s.equals("")) {
			return 0;
		}
		else if(s.contains(",")) {
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
		return nums.split(",");
	}
	private static int sum(String[] nums) {
		int total_sum = 0;
		for (String num : nums) {
			total_sum += toInt(num);
		}
		return total_sum;
	}
}
