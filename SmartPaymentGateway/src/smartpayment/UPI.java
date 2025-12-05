package smartpayment;

class UPI extends Payment implements Retryable, Refundable {
	private String upiId;
    private String pin;
    
    public UPI(double amount, Beneficiary beneficiary, String upiId, String pin) {
        super(amount, beneficiary);
        this.upiId = upiId;
        this.pin = pin;
    }
    @Override
    
    public void processPayment() throws Exception{
    	validateAmount();
    	
    	if(beneficiary==null) {
    		throw new BeneficiaryNotFoundException("Beneficiary not found!");
    	}
    	
//    	hardcoded PIN
    	if (!"1002".equals(pin))  
            throw new InvalidCredentialsException("Invalid UPI PIN!");
    	
    	System.out.println("Processing UPI payment of ₹" + amount + " to " + beneficiary.getName());
        System.out.println("UPI payment successful");
    }
    
    @Override
    public void retry() {
        System.out.println("Retrying UPI payment...");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding ₹" + amount + " to UPI ID: " + upiId);
    }
    
}
