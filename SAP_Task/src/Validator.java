import Exceptions.EmptyStringException;
import Exceptions.NegativeNumberException;
import Exceptions.WrongPathException;

public class Validator {

	public static boolean checkPath(String path) throws WrongPathException {
		if(!path.endsWith(".txt") || path.length() <=4) {
			throw new WrongPathException();
		}
		else {
			return true;
		}
		
	}
	public static boolean checkIfNegative(String num) throws NegativeNumberException {
		if(Integer.parseInt(num)<=0) {
			throw new NegativeNumberException();
		}
		else {
			return true;
		}
	}
	public static boolean checkIfStringIsEmpty(String text) throws EmptyStringException {
		if(text.isBlank()) {
			throw new EmptyStringException();
		}
		else {
			return true;
		}
	}
}
