package smartpayment;

public class InvalidAmountException extends Exception{
//	- This constructor takes a message (msg) and passes it to the superclass (Exception) 
//	so it can be retrieved later using getMessage().

	public InvalidAmountException (String msg) {
		super(msg);
	}
}
