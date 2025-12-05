package smartpayment;

abstract public class Payment {
	
//	- base class for other classes that will implement specific types of payments

	protected double amount;
	protected Beneficiary beneficiary;
	
	public Payment(double amount, Beneficiary beneficiary) {
        this.amount = amount;
        this.beneficiary = beneficiary;
    }
	
//	abstraction
	public abstract void processPayment() throws Exception;
	
	protected void validateAmount() throws InvalidAmountException{
		if(amount<=0) {
			throw new InvalidAmountException("Invalid payment amount: " + amount);
		}
	}
}
