package airport.gui;

import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import airport.FlightManager;
import airport.Passenger;
import airport.flight.CommercialFlight;
import airport.wallet.StandardWallet;

public class AirportTestWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	private final Passenger passenger;
	private final FlightManager manager;
	
	private AirportDataModel airportModel;
	
	private DefaultListModel<CommercialFlight> flightsModel;
	
	public AirportTestWindow() {
		super("Airport - Airport Test GUI");
		
		this.passenger = new Passenger("Dante", new StandardWallet(1000));
		this.manager = new FlightManager();
		
		airportModel = new AirportDataModel();
		flightsModel = new DefaultListModel<>();
		
		JTabbedPane mainPanel = new JTabbedPane();
		
		JPanel airportPanel = new AirportManagementPanel(airportModel);
		JPanel managerPanel = new FlightManagementPanel(manager, flightsModel, airportModel);
		JPanel passengerPanel = new PassengerPanel(manager, passenger, flightsModel);
		
		mainPanel.addTab("Airport", airportPanel);
		mainPanel.addTab("Manager", managerPanel);
		mainPanel.addTab("Passenger", passengerPanel);
		
		this.add(mainPanel);

		this.setMinimumSize(new Dimension(1000, 480));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new AirportTestWindow());
	}
	
}
