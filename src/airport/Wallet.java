package airport;

public interface Wallet {
	public void add(double amount);

	public boolean charge(double amount);

	public double getBalance();
}
