package airport.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import airport.Airport;
import airport.FlightManager;
import airport.flight.CommercialFlight;
import airport.flight.FlightExtra;
import airport.flight.commercial.CommercialFlightData;

public class FlightManagementPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JTextField priceField;
	private JTextField departingAtField;
	private JTextField arrivingAtField;
	
	private JTextField extraNameField;
	private JTextField extraPriceField;
	
	private JComboBox<Airport> fromComboBox;
	private JComboBox<Airport> toComboBox;
	
	private DefaultListModel<FlightExtra> flightExtrasModel;
	private FlightManager manager;
	private DefaultListModel<CommercialFlight> flightsModel;
	
	public FlightManagementPanel(FlightManager manager, DefaultListModel<CommercialFlight> flightsModel, AirportDataModel airportModel) {
		super();
		
		this.manager = manager;
		this.flightsModel = flightsModel;
		
		this.setLayout(new GridLayout(1, 2));
		
		JPanel flightDetailsPanel = new JPanel(new GridLayout(6, 2));
		flightDetailsPanel.setBorder(GuiUtils.createTitledBorder("Flight Manager"));
		
		priceField = new JTextField();
		arrivingAtField = new JTextField();
		departingAtField = new JTextField();
		
		fromComboBox = new JComboBox<>(airportModel.getFromModel());
		toComboBox = new JComboBox<>(airportModel.getToModel());
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(this::addFlight);
		
		flightDetailsPanel.add(new JLabel("From:"));
		flightDetailsPanel.add(fromComboBox);
				
		flightDetailsPanel.add(new JLabel("Departing at:"));
		flightDetailsPanel.add(departingAtField);
		
		flightDetailsPanel.add(new JLabel("To:"));
		flightDetailsPanel.add(toComboBox);		
		
		flightDetailsPanel.add(new JLabel("Arriving at:"));
		flightDetailsPanel.add(arrivingAtField);
		
		flightDetailsPanel.add(new JLabel("Price:"));
		flightDetailsPanel.add(priceField);
				
		flightDetailsPanel.add(new JLabel());
		flightDetailsPanel.add(addButton);
		
		
		JPanel flightExtrasPanel = new JPanel();
		flightExtrasPanel.setLayout(new BoxLayout(flightExtrasPanel, BoxLayout.PAGE_AXIS));
		
		flightExtrasModel = new DefaultListModel<>();
		JList<FlightExtra> flightExtrasList = new JList<>(flightExtrasModel);
		flightExtrasList.setBorder(GuiUtils.createTitledBorder("Extras"));
		
		JScrollPane flightExtrasScrollPane = new JScrollPane(flightExtrasList);
		
		JButton removeSelectedExtraButton = new JButton("Remove selected");
		removeSelectedExtraButton.addActionListener(e -> {
			int selectedIndex = flightExtrasList.getSelectedIndex();
			flightExtrasModel.remove(selectedIndex);
		});
		
		JPanel flightExtraDetailPanel = new JPanel(new GridLayout(3, 2));
		
		extraNameField = new JTextField("Champagne");
		extraPriceField = new JTextField("10");
		
		JButton addExtraButton = new JButton("Add");
		addExtraButton.addActionListener(this::addFlightExtra);
		
		flightExtraDetailPanel.add(new JLabel("Name: "));
		flightExtraDetailPanel.add(extraNameField);
		flightExtraDetailPanel.add(new JLabel("Price: "));
		flightExtraDetailPanel.add(extraPriceField);
		flightExtraDetailPanel.add(new JLabel());		
		flightExtraDetailPanel.add(addExtraButton);
		
		flightExtrasPanel.add(flightExtrasScrollPane);
		flightExtrasPanel.add(removeSelectedExtraButton);
		flightExtrasPanel.add(flightExtraDetailPanel);
		
		this.add(flightDetailsPanel);
		this.add(flightExtrasPanel);
	}
	
	private void addFlight(ActionEvent event) {
		try {
			double price = Double.parseDouble(priceField.getText());
			Airport from = fromComboBox.getItemAt(fromComboBox.getSelectedIndex()); 
			Airport to = toComboBox.getItemAt(toComboBox.getSelectedIndex());
			String departingAt = departingAtField.getText();
			String arrivingAt = arrivingAtField.getText();
			
			CommercialFlightData flightData = new CommercialFlightData(from, to, arrivingAt, departingAt);
			ImplementedFlight flight = new ImplementedFlight(flightData, price);
			for (int i = 0; i < flightExtrasModel.getSize(); i++) {
				FlightExtra extra = flightExtrasModel.getElementAt(i);
				flight.addExtra(extra);
			}
			
			manager.add(flight);
			
			flightsModel.addElement(flight);
			
			JOptionPane.showMessageDialog(this, "Added flight!", "Airport Message", JOptionPane.INFORMATION_MESSAGE);
			
		} catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "Field 'Price' has to be a number", "Airport Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void addFlightExtra(ActionEvent event) {
		try {
			double price = Double.parseDouble(extraPriceField.getText());
			String name = extraNameField.getText();
			
			flightExtrasModel.addElement(new VisibleFlightExtra(name, price));
			
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "Field 'Price' has to be a number", "Airport Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
