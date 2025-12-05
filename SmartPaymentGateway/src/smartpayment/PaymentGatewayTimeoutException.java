package smartpayment;

public class PaymentGatewayTimeoutException extends Exception{
	public PaymentGatewayTimeoutException(String msg) {
		super(msg);
	}
}
