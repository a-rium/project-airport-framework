package airport.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;

import airport.FlightManager;
import airport.Passenger;
import airport.flight.CommercialFlight;
import airport.flight.CommercialFlightReservation;
import airport.flight.FlightClass;
import airport.flight.FlightExtra;

public class PassengerPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private final Passenger passenger;
	private final FlightManager manager;
	
	private JLabel currencyLabel;
	private JTextField rechargeAmountField;
	
	private DefaultListModel<FlightExtra> availableExtrasModel;
	private DefaultListModel<FlightExtra> selectedExtrasModel;
	
	private JList<CommercialFlight> availableFlights;
	private JList<FlightExtra> availableExtras;
	private JList<FlightExtra> selectedExtras;
	
	public PassengerPanel(FlightManager manager, Passenger passenger, DefaultListModel<CommercialFlight> availableFlightsModel) {
		super();
		
		this.manager = manager;
		this.passenger = passenger;
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(GuiUtils.createTitledBorder("Passenger"));

		JPanel walletPanel = new JPanel(new GridLayout(3, 2));
		walletPanel.setBorder(GuiUtils.createTitledBorder("Wallet Management"));
		
		currencyLabel = new JLabel("" + passenger.getWallet().getBalance());
		rechargeAmountField = new JTextField();
		JButton rechargeButton = new JButton("Recharge wallet");
		rechargeButton.addActionListener(this::rechargeWallet);
		
		walletPanel.add(new JLabel("Available currency: "));
		walletPanel.add(currencyLabel);
		walletPanel.add(new JLabel("Recharge by: "));
		walletPanel.add(rechargeAmountField);
		walletPanel.add(new JLabel());
		walletPanel.add(rechargeButton);
		
		JPanel bookFlightPanel = new JPanel();
		bookFlightPanel.setBorder(GuiUtils.createTitledBorder("Book Flight"));
		
		availableExtrasModel = new DefaultListModel<>();
		selectedExtrasModel = new DefaultListModel<>();
		
		availableFlights = new JList<>(availableFlightsModel);
		availableExtras = new JList<>(availableExtrasModel);
		selectedExtras = new JList<>(selectedExtrasModel);
		
		availableFlights.setBorder(GuiUtils.createTitledBorder("Available Flights"));
		availableExtras.setBorder(GuiUtils.createTitledBorder("Available Extras"));
		selectedExtras.setBorder(GuiUtils.createTitledBorder("Selected Extras"));
		
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
		
		this.add(walletPanel);
		this.add(bookFlightPanel);
		this.add(bookButton);
	}
	
	private void rechargeWallet(ActionEvent e) {
		try {
			double amount = Double.parseDouble(rechargeAmountField.getText());
			passenger.getWallet().add(amount);
			currencyLabel.setText("" + passenger.getWallet().getBalance());
			JOptionPane.showMessageDialog(this, "Wallet successfully recharged!", "Airport Message", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "Field 'Recharge amount' has to be a number", "Airport Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private <T> void moveElement(DefaultListModel<T> from, DefaultListModel<T> to, int elementIndex) {
		to.addElement(from.get(elementIndex));
		from.remove(elementIndex);
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
		CommercialFlight flight = availableFlights.getSelectedValue();
		FlightClass flightClass = flight.getClasses().next();
	
		CommercialFlightReservation reservation = new CommercialFlightReservation(flight, flightClass);
		for (int i = 0; i < selectedExtrasModel.getSize(); i++) {
			FlightExtra extra = selectedExtrasModel.getElementAt(i);
			reservation.addExtra(extra);
		}
		
		boolean success = manager.finalizeOrder(passenger, reservation);
		if (success) {
			JOptionPane.showMessageDialog(this, "Flight successfully booked!", "Airport Message", JOptionPane.INFORMATION_MESSAGE);
			currencyLabel.setText("" + passenger.getWallet().getBalance());
		} else {
			JOptionPane.showMessageDialog(this, "Insufficient credit!", "Airport Transaction Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
