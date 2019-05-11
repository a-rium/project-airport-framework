package airport.wallet;

import airport.Wallet;

public class StandardWallet implements Wallet {
	private double balance;

	public StandardWallet(double balance) {
		this.balance = balance;
	}

	@Override
	public void add(double amount) {
		balance += amount;
	}

	@Override
	public boolean charge(double amount) {
		boolean enoughBalance = balance >= amount; 
		if (enoughBalance) {
			balance -= amount;
			System.out.printf("Wallet: charged %.2f$, new balance: %.2f\n", amount, balance);
		}
		return enoughBalance;
	}

	@Override
	public double getBalance() {
		return balance;
	}
}
