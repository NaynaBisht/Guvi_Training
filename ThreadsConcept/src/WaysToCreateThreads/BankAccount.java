package WaysToCreateThreads;

public class BankAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FixBankAccount acc = new FixBankAccount();
		
		Thread user1 = new Thread(() -> acc.withdraw(700), "User1" );
		Thread user2 = new Thread(() -> acc.withdraw(700), "User2" );
		
		user1.start();
		user2.start();
		
	}

}
class FixBankAccount{
	private int balance = 1000;
	
	public synchronized void withdraw(int amount) {
		if(balance >= amount) {
			System.out.println(Thread.currentThread().getName() + " has withdrawn " +amount);
			balance = balance-amount;
			System.out.println(Thread.currentThread().getName() + " new balance: " + balance);
		}else {
			System.out.println("Insufficient balance for " + Thread.currentThread().getName());
		}
	}
	
	public int getBalance(){
		return balance;
	}
}
