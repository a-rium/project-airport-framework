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
	public void charge(double amount) {
		balance -= amount;
		System.out.printf("Wallet: charged %.2f$, new balance: %.2f\n", amount, balance);
	}

	@Override
	public double getBalance() {
		return balance;
	}
}
