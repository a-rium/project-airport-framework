package airport.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;

import airport.Flight;
import airport.FlightPackage;
import airport.Passenger;
import airport.flightpackage.extra.ChampagneDuringFlightPackage;
import airport.wallet.StandardWallet;

public class AirportTestWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	private final Passenger passenger;
	
	private JTextField fromField;
	private JTextField toField;
	private JTextField priceField;
	
	private DefaultListModel<ImplementedFlight> availableFlightsModel;
	private DefaultListModel<NamedExtraPackage> availableExtrasModel;
	private DefaultListModel<NamedExtraPackage> selectedExtrasModel;
	
	private JList<ImplementedFlight> availableFlights;
	private JList<NamedExtraPackage> availableExtras;
	private JList<NamedExtraPackage> selectedExtras;
	
	public AirportTestWindow() {
		super("Airport - Airport Test GUI");
		
		this.passenger = new Passenger("Dante", new StandardWallet(1000));
		
		JPanel flightManagerPanel = new JPanel(new GridLayout(4, 2));
		flightManagerPanel.setBorder(createTitledBorder("Flight Manager"));
		
		fromField = new JTextField();
		toField = new JTextField();
		priceField = new JTextField();
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(this::addFlight);
		
		flightManagerPanel.add(new JLabel("From:"));
		flightManagerPanel.add(fromField);
		
		flightManagerPanel.add(new JLabel("To:"));
		flightManagerPanel.add(toField);
		
		flightManagerPanel.add(new JLabel("Price:"));
		flightManagerPanel.add(priceField);
		
		flightManagerPanel.add(new JLabel());
		flightManagerPanel.add(addButton);
		
		
		JPanel bookFlightPanel = new JPanel();
		
		availableFlightsModel = new DefaultListModel<>();
		availableExtrasModel = new DefaultListModel<>();
		selectedExtrasModel = new DefaultListModel<>();
		
		availableFlights = new JList<>(availableFlightsModel);
		availableExtras = new JList<>(availableExtrasModel);
		selectedExtras = new JList<>(selectedExtrasModel);
		
		availableFlights.setBorder(createTitledBorder("Available Flights"));
		availableExtras.setBorder(createTitledBorder("Available Extras"));
		selectedExtras.setBorder(createTitledBorder("Selected Extras"));
		
		availableFlights.addListSelectionListener(this::updateExtras);
		
		JScrollPane availableFlightsPane = new JScrollPane(availableFlights);
		JScrollPane availableExtrasPane = new JScrollPane(availableExtras);
		JScrollPane selectedExtrasPane = new JScrollPane(selectedExtras);
		
		JButton pickExtraButton = new JButton(" >> ");
		JButton unpickExtraButton = new JButton(" << ");
		
		pickExtraButton.addActionListener(e -> 
			moveElement(availableExtrasModel, selectedExtrasModel, availableExtras.getSelectedIndex())
		);
		unpickExtraButton.addActionListener(e -> 
			moveElement(selectedExtrasModel, availableExtrasModel, selectedExtras.getSelectedIndex())
		);
		
		JPanel extraButtonPanel = new JPanel(new GridLayout(3, 1));
		extraButtonPanel.add(pickExtraButton);
		extraButtonPanel.add(new JLabel());
		extraButtonPanel.add(unpickExtraButton);
		
		bookFlightPanel.add(availableFlightsPane);
		bookFlightPanel.add(availableExtrasPane);
		bookFlightPanel.add(extraButtonPanel);
		bookFlightPanel.add(selectedExtrasPane);
		
		
		JButton bookButton = new JButton("Book Flight");
		bookButton.addActionListener(this::bookSelectedFlight);
		
		JPanel passengerPanel = new JPanel();
		passengerPanel.setLayout(new BoxLayout(passengerPanel, BoxLayout.PAGE_AXIS));
		passengerPanel.setBorder(createTitledBorder("Passenger"));
		passengerPanel.add(bookFlightPanel);
		passengerPanel.add(bookButton);
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.add(flightManagerPanel);
		mainPanel.add(passengerPanel);
		
		this.add(mainPanel);

		this.setMinimumSize(new Dimension(1000, 480));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private Border createTitledBorder(String title) {
		Border etchedBorder = BorderFactory.createEtchedBorder();
		return new TitledBorder(etchedBorder, title);
	}
	
	private <T> void moveElement(DefaultListModel<T> from, DefaultListModel<T> to, int elementIndex) {
		to.addElement(from.get(elementIndex));
		from.remove(elementIndex);
	}
	
	private void addFlight(ActionEvent event) {
		try {
			double price = Double.parseDouble(priceField.getText());
			String from = fromField.getText(); 
			String to = fromField.getText();
			
			ImplementedFlight flight = new ImplementedFlight(from, to, price);
			flight.addExtra("Champagne", ChampagneDuringFlightPackage::new);
			availableFlightsModel.addElement(flight);		
			
		} catch(NumberFormatException nfe) {
			JOptionPane.showConfirmDialog(this, "Confirm dialog");
		}
	}
	
	private void updateExtras(ListSelectionEvent e) {
		availableExtrasModel.removeAllElements();
		selectedExtrasModel.removeAllElements();
		for (NamedExtraPackage extra : availableFlights.getSelectedValue().getExtras()) {
			availableExtrasModel.addElement(extra);
		}
	}
	
	private void bookSelectedFlight(ActionEvent e) {
		Flight flight = availableFlights.getSelectedValue();
		if (flight.bookSeat(passenger)) {
			FlightPackage packet = flight.getPackage();
			Enumeration<NamedExtraPackage> it = selectedExtrasModel.elements();
			while (it.hasMoreElements()) {
				NamedExtraPackage extra = it.nextElement();
				packet = extra.apply(packet);
			}
			
			passenger.bookFlight(packet);
			JOptionPane.showMessageDialog(this, "Flight total price: " + packet.getPrice());
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new AirportTestWindow());
	}
	
}
