package carloan;

public class CalculateLoan {

	double principal;
    double annualRate;
    int years;

    // Constructor for loan details
    public CalculateLoan(double principal, double annualRate, int years) {
        this.principal = principal;
        this.annualRate = annualRate;
        this.years = years;
    }

    // calculate simple interest (P * T * R) / 100
    public double simpleInterest() {
        return (principal * years * annualRate) / 100.0;
    }
    
//    A = P(1+r/n)^(n*t)
    public double compoundInterest(int n) {
        double rateInDecimal = annualRate / 100;
        double amount = principal * Math.pow(1 + (rateInDecimal / n), n * years);
        
        return amount - principal;
    }


    public double totalAmount() {

        return this.principal + simpleInterest();
    }


    public double emi() {
        double totalAmount = totalAmount();
        int numberOfMonths = this.years * 12;
        // EMI = Total Amount / Number of Months
        return totalAmount / numberOfMonths;
    }

}
