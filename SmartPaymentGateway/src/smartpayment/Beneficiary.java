package smartpayment;

public class Beneficiary {
//	instance var - Each object of Beneficiary will have its own copy of name and accountNo.
	private String name;
	private String accountNo;
	
//	constructor
	public Beneficiary(String name, String accountNo) {
		this.name = name;
		this.accountNo = accountNo;
	}
	
//	accessor methods - part of encapsulation
//	- allow other classes to read the private fields 
//	bundling data and methods that operate on that data into a single unit — a class — and restricting direct access to some of the object's components.

	public String getName() {
		return name;
	}
	public String getAccountNo() {
		return accountNo;
	}
}
