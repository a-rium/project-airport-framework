package airport.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Iterator;

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

import airport.FlightManager;
import airport.Passenger;
import airport.flight.CommercialFlightReservation;
import airport.flight.FlightClass;
import airport.flight.FlightExtra;
import airport.wallet.StandardWallet;

public class AirportTestWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	private final Passenger passenger;
	private final FlightManager manager;
	
	private JTextField fromField;
	private JTextField toField;
	private JTextField priceField;
	
	private DefaultListModel<FlightExtra> flightExtrasModel;
	
	private DefaultListModel<ImplementedFlight> availableFlightsModel;
	private DefaultListModel<FlightExtra> availableExtrasModel;
	private DefaultListModel<FlightExtra> selectedExtrasModel;
	
	private JList<ImplementedFlight> availableFlights;
	private JList<FlightExtra> availableExtras;
	private JList<FlightExtra> selectedExtras;
	
	public AirportTestWindow() {
		super("Airport - Airport Test GUI");
		
		this.passenger = new Passenger("Dante", new StandardWallet(1000));
		this.manager = new FlightManager();
		
		JPanel managerPanel = new JPanel(new GridLayout(1, 2));
		
		JPanel flightDetailsPanel = new JPanel(new GridLayout(4, 2));
		flightDetailsPanel.setBorder(createTitledBorder("Flight Manager"));
		
		fromField = new JTextField();
		toField = new JTextField();
		priceField = new JTextField();
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(this::addFlight);
		
		flightDetailsPanel.add(new JLabel("From:"));
		flightDetailsPanel.add(fromField);
		
		flightDetailsPanel.add(new JLabel("To:"));
		flightDetailsPanel.add(toField);
		
		flightDetailsPanel.add(new JLabel("Price:"));
		flightDetailsPanel.add(priceField);
		
		flightDetailsPanel.add(new JLabel());
		flightDetailsPanel.add(addButton);
		
		
		JPanel flightExtrasPanel = new JPanel();
		flightExtrasPanel.setLayout(new BoxLayout(flightExtrasPanel, BoxLayout.PAGE_AXIS));
		
		flightExtrasModel = new DefaultListModel<>();
		JList<FlightExtra> flightExtrasList = new JList<>(flightExtrasModel);
		flightExtrasList.setBorder(createTitledBorder("Extras"));
		
		JScrollPane flightExtrasScrollPane = new JScrollPane(flightExtrasList);
		
		JButton removeSelectedExtraButton = new JButton("Remove selected");
		removeSelectedExtraButton.addActionListener(e -> {
			int selectedIndex = flightExtrasList.getSelectedIndex();
			flightExtrasModel.remove(selectedIndex);
		});
		
		JPanel flightExtraDetailPanel = new JPanel(new GridLayout(3, 2));
		
		JTextField extraNameField = new JTextField("Champagne");
		JTextField extraPriceField = new JTextField("10");
		
		JButton addExtraButton = new JButton("Add");
		addExtraButton.addActionListener(e -> {
			try {
				double price = Double.parseDouble(extraPriceField.getText());
				String name = extraNameField.getText();
				
				flightExtrasModel.addElement(new VisibleFlightExtra(name, price));
				
			} catch (NumberFormatException nfe) {
				// error handling
			}
		});
		
		flightExtraDetailPanel.add(new JLabel("Name: "));
		flightExtraDetailPanel.add(extraNameField);
		flightExtraDetailPanel.add(new JLabel("Price: "));
		flightExtraDetailPanel.add(extraPriceField);
		flightExtraDetailPanel.add(new JLabel());		
		flightExtraDetailPanel.add(addExtraButton);
		
		flightExtrasPanel.add(flightExtrasScrollPane);
		flightExtrasPanel.add(removeSelectedExtraButton);
		flightExtrasPanel.add(flightExtraDetailPanel);
		
		managerPanel.add(flightDetailsPanel);
		managerPanel.add(flightExtrasPanel);
		
		
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
		mainPanel.add(managerPanel);
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
			String to = toField.getText();
			
			ImplementedFlight flight = new ImplementedFlight(from, to, price);
			for (int i = 0; i < flightExtrasModel.getSize(); i++) {
				FlightExtra extra = flightExtrasModel.getElementAt(i);
				flight.addExtra(extra);
			}
			
			manager.add(flight);
			
			availableFlightsModel.addElement(flight);
			
		} catch(NumberFormatException nfe) {
			JOptionPane.showConfirmDialog(this, "Confirm dialog");
		}
	}
	
	private void updateExtras(ListSelectionEvent e) {
		availableExtrasModel.removeAllElements();
		selectedExtrasModel.removeAllElements();
		Iterator<FlightExtra> it = availableFlights.getSelectedValue().getExtras(); 
		while (it.hasNext()) {
			FlightExtra extra = it.next();
			availableExtrasModel.addElement(extra);
		}
	}
	
	private void bookSelectedFlight(ActionEvent e) {
		ImplementedFlight flight = availableFlights.getSelectedValue();
		FlightClass flightClass = flight.getClasses().next();
	
//		CommercialFlightReservation reservation = new CommercialFlightReservation(passenger, flight, flightClass);
		CommercialFlightReservation reservation = new CommercialFlightReservation(flight, flightClass);
		for (int i = 0; i < selectedExtrasModel.getSize(); i++) {
			FlightExtra extra = selectedExtrasModel.getElementAt(i);
			reservation.addExtra(extra);
		}
		
		manager.finalizeOrder(passenger, reservation);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new AirportTestWindow());
	}
	
}
