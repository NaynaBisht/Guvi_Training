package smartpayment;

class CreditCard extends Payment implements Retryable {
    private String cardNumber;
    private String cvv;

    public CreditCard(double amount, Beneficiary beneficiary, String cardNumber, String cvv) {
        super(amount, beneficiary);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public void processPayment() throws Exception {
        validateAmount();
        if (beneficiary == null)
            throw new BeneficiaryNotFoundException("Beneficiary not found!");

        if (!cvv.equals("111"))
            throw new InvalidCredentialsException("Invalid CVV entered!");

        System.out.println("Processing Credit Card payment of ₹" + amount + " to " + beneficiary.getName());
        System.out.println("Credit Card payment successful");
    }

    @Override
    public void retry() {
        System.out.println("Retrying Credit Card payment...");
    }
}