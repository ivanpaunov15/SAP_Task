package Exceptions;

public class WrongPathException extends Exception{
	
	@Override
	public String getMessage() {
		return "Invalid path!";
	}
	
}
