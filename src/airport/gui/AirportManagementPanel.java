package airport.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import airport.Airport;

public class AirportManagementPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField nameField;
	private AirportDataModel airportModel;

	private JList<Airport> airportList;
	
	public AirportManagementPanel(AirportDataModel airportModel) {
		super();
		this.airportModel = airportModel;
		
		JPanel airportListPanel = new JPanel();
		airportListPanel.setLayout(new BoxLayout(airportListPanel, BoxLayout.PAGE_AXIS));
		
		airportList = new JList<>(airportModel.getListModel());
		
		JScrollPane airportScrollPane = new JScrollPane(airportList);
		airportScrollPane.setBorder(GuiUtils.createTitledBorder("Airport"));
		
		
		JButton removeButton = new JButton("Remove selected");
		removeButton.addActionListener(this::removeAirport);
		
		airportListPanel.add(airportScrollPane);
		airportListPanel.add(removeButton);
		
//		airportScroolBar.setMinimumSize(new Dimension(300, 200));
		
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		
		nameField = new JTextField();
		JButton addButton = new JButton("Add");
		addButton.addActionListener(this::addAirport);
		
		JPanel airportDetailsPanel = new JPanel(new GridLayout(1, 2));
		
		airportDetailsPanel.add(new JLabel("Airport name: "));
		airportDetailsPanel.add(nameField);
		
		JPanel managementPanel = new JPanel(new GridLayout(3, 1));
		
		managementPanel.setBorder(GuiUtils.createTitledBorder("Airport creation"));
		
		managementPanel.add(airportDetailsPanel);
		managementPanel.add(new JLabel());
		managementPanel.add(addButton);
		
		this.add(airportListPanel);
		this.add(managementPanel);
	}
	
	private void addAirport(ActionEvent e) {
		String name = nameField.getText();
		airportModel.add(new VisibleAirport(name));
		
		nameField.setText("");
		JOptionPane.showMessageDialog(this, "Airport successfully added!", "Airport Message", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void removeAirport(ActionEvent e) {
		Airport selection = airportList.getSelectedValue();
		airportModel.remove(selection);
		
		JOptionPane.showMessageDialog(this, "Airport successfully removed!", "Airport Message", JOptionPane.INFORMATION_MESSAGE);
	}
}
