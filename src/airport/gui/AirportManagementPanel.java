package airport.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AirportManagementPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField nameField;
	private AirportDataModel airportModel;

	public AirportManagementPanel(AirportDataModel airportModel) {
		super();
		this.airportModel = airportModel;
		
		this.setLayout(new GridLayout(2, 2));
		
		nameField = new JTextField();
		JButton addButton = new JButton("Add");
		addButton.addActionListener(this::addAirport);
		
		this.add(new JLabel("Airport name: "));
		this.add(nameField);
		this.add(new JLabel());
		this.add(addButton);
	}
	
	private void addAirport(ActionEvent e) {
		String name = nameField.getText();
		airportModel.add(new VisibleAirport(name));
	}
}
