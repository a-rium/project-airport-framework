package airport.wallet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StandardWalletTest {	
	private StandardWallet wallet;
	private final static double defaultBalance = 1000;
	
	@BeforeEach
	public void dataSetInitialization() {
		this.wallet = new StandardWallet(defaultBalance);
	}
	
	@Test
	public void moneyCanBeAddedTo() {
		final double moneyToAdd = 100;
		wallet.add(moneyToAdd);
		
		Assertions.assertEquals(wallet.getBalance(), defaultBalance + moneyToAdd);
	}
	
	@Test
	public void canBeSuccessfullyCharged() {
		final double moneyToCharge = 100;
		Assertions.assertTrue(wallet.charge(moneyToCharge));
	}
	
	@Test
	public void cannotChargeMoreThanTheCurrentBalance() {
		final double moneyToCharge = defaultBalance + 1;
		Assertions.assertFalse(wallet.charge(moneyToCharge));
	}
	
	@Test
	public void moneyIsWithdrawnWhenChargedSuccessfully() {
		final double moneyToCharge = 100;
		wallet.charge(moneyToCharge);
		
		Assertions.assertEquals(wallet.getBalance(), defaultBalance - moneyToCharge);
	}	
	
	@Test
	public void moneyIsNotWithdrawnWhenTheChargedAmountIsGreaterThanBalance() {
		final double moneyToCharge = defaultBalance + 100;
		wallet.charge(moneyToCharge);
		
		Assertions.assertEquals(wallet.getBalance(), defaultBalance);
	}
}
