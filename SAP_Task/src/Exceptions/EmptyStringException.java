package Exceptions;

public class EmptyStringException extends Exception{
	
	@Override
	public String getMessage() {
		return "Empty string!";
	}
}
