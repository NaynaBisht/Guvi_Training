package smartpayment;

public class TransactionFailedException extends Exception{
	public TransactionFailedException(Throwable cause) {
        super(cause);
    }
}
