package airport;

public interface Wallet
{
	public void add(double amount);
	public void charge(double amount);
	public double getBalance();
}
