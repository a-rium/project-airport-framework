package airport.gui;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public final class GuiUtils {
	private GuiUtils() {}
	
	public static Border createTitledBorder(String title) {
		Border etchedBorder = BorderFactory.createEtchedBorder();
		return new TitledBorder(etchedBorder, title);
	}
}
