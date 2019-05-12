package airport;

import java.util.List;

import airport.flight.commercial.ClasslessFlight;
import airport.flight.commercial.CommercialFlightData;

public class Main {
	public static void main(String[] args) {
		FlightManager manager = new FlightManager();
		// Operazioni eseguite dal FlightManager
		// - Crea e mette a disposizione i voli
		// - Crea i velivoli
		// - Imposta i vari pacchetti extra
		Aircraft boeing = new Aircraft(0, 1);
		
		Airport pisa = new Airport("Pisa");
		Airport viareggio = new Airport("Viareggio");
		Airport florence = new Airport("Florence");
		
		Flight pisaFlorence = new ClasslessFlight(new CommercialFlightData(pisa, florence, "09:00", "10:00"), boeing, 0);
		Flight pisaViareggio = new ClasslessFlight(new CommercialFlightData(pisa, viareggio, "11:00", "12:00"), boeing, 0);
		manager.add(pisaViareggio);
		manager.add(pisaFlorence);

//		Passenger passenger = new Passenger("Marco", new StandardWallet(10000));
		// Operazioni eseguite dal Passeggero
		// -- Prenotazione voli
		// - Ricerca un volo dato un FlightManager
		// - Seleziona gli eventuali extra a dispozione
		// -- Gestione prenotazioni
		// - Riceve una notifica alla variazione di un dettaglio di una prenotazione(volo posticipato, volo cancellato...)
		// - Cancella una prenotazione
		// -- Gestione finanze
		// - Ricarica il proprio credito
		// - Modifica il metodo di pagamento
		List<Flight> pisaFlights = manager.list(it -> "Pisa".equals(it.getOrigin()));

		for (Flight flight : pisaFlights) {
//			FlightPackage pack = new ChampagneDuringFlightPackage(flight.getPackage());
//			passenger.bookFlight(pack);
			flight.getAircraft().bookSeat();
		}
	}
}
