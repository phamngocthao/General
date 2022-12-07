package fa.training.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {
	
	private static final String CUSTOMER_ID_REGEX = "KH[0-9]{5}";
	
	
	public static boolean checkIsEmptyOrNull(String data) {
		
		if(data.isEmpty() || data == null) {
			
			return true;
		}
		
		return false;
	}
	
	public static boolean isCustomerId(String customerId) {
		return isMatches(CUSTOMER_ID_REGEX, customerId);
	}
	
	
	public static boolean isMatches(String regex, String data) {
		
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(data);
		
		return matcher.matches();
		
	}
	
}
