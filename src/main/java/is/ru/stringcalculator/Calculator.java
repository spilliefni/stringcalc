package is.ru.stringcalculator; 

public class Calculator {
	public static int add(String s) {
		if (s.equals("")) {
			return 0;
		}
		else if (s.contains("//")) {
			String[] split = splitString(s,"\n");
			String delim = split[0].substring(2);
			return sum(splitString(split[1], delim));
		}
		else if(s.contains(",") || s.contains("\n")) {
			return sum(splitString(s, ",|\n"));
		}
		else {
			return toInt(s);
		}
	}
	private static int toInt(String num) {
		return Integer.parseInt(num);
	}
	private static String[] splitString(String nums, String delim) {
		return nums.split(delim);
	}
	private static int sum(String[] nums) throws IllegalArgumentException {
		int total_sum = 0;
		for (String num : nums) {
			if (toInt(num) < 0) {
				throw new IllegalArgumentException("Negatives not allowed: -1");
			}
			if (toInt(num) < 1000) {
				total_sum += toInt(num);
			}
		}
		return total_sum;
	}
}
