package airport.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	
	private DefaultListModel<FlightExtra> availableExtrasModel;
	private DefaultListModel<FlightExtra> selectedExtrasModel;
	
	private JList<CommercialFlight> availableFlights;
	private JList<FlightExtra> availableExtras;
	private JList<FlightExtra> selectedExtras;
	
	public PassengerPanel(FlightManager manager, Passenger passenger, DefaultListModel<CommercialFlight> availableFlightsModel) {
		super();
		
		this.manager = manager;
		this.passenger = passenger;
		
		JPanel bookFlightPanel = new JPanel();
		
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
		
		JPanel passengerPanel = new JPanel();
		passengerPanel.setLayout(new BoxLayout(passengerPanel, BoxLayout.PAGE_AXIS));
		passengerPanel.setBorder(GuiUtils.createTitledBorder("Passenger"));
		passengerPanel.add(bookFlightPanel);
		passengerPanel.add(bookButton);
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
		
		manager.finalizeOrder(passenger, reservation);
	}
}
