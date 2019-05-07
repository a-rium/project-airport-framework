package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import airport.Wallet;
import airport.wallet.StandardWallet;

public class WalletTest {
	
	Wallet w;
	
	@Before
	public void init() {
		w = new StandardWallet(0);
	}
	
	@Test
	void test() {
		init();
		w.add(1);
		assertEquals(1, w.getBalance());
		w.charge(1.0);
		assertEquals(0, w.getBalance());
	}
}
