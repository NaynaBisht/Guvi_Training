package smartpayment;

class Wallet extends Payment implements Refundable {
    private double walletBalance;

    public Wallet(double amount, Beneficiary beneficiary, double walletBalance) {
        super(amount, beneficiary);
        this.walletBalance = walletBalance;
    }

    @Override
    public void processPayment() throws Exception {
        validateAmount();
        if (beneficiary == null)
            throw new BeneficiaryNotFoundException("Beneficiary not found!");

        if (walletBalance < amount)
            throw new InsufficientBalanceException("Wallet balance ₹" + walletBalance + " is insufficient.");

        System.out.println("Processing Wallet payment of ₹" + amount + " to " + beneficiary.getName());
        System.out.println("Wallet payment successful");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding ₹" + amount + " to Wallet.");
    }
}