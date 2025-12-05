package smartpayment;

class NetBanking extends Payment implements Retryable {
    private String username;
    private String password;

    public NetBanking(double amount, Beneficiary beneficiary, String username, String password) {
        super(amount, beneficiary);
        this.username = username;
        this.password = password;
    }

    @Override
    public void processPayment() throws Exception {
        validateAmount();
        if (beneficiary == null)
            throw new BeneficiaryNotFoundException("Beneficiary not found!");

        if (!password.equals("bank@123"))
            throw new InvalidCredentialsException("Invalid NetBanking credentials!");

        System.out.println("Processing NetBanking payment of ₹" + amount + " to " + beneficiary.getName());
        System.out.println("NetBanking payment successful ✅");
    }

    @Override
    public void retry() {
        System.out.println("Retrying NetBanking payment...");
    }
}