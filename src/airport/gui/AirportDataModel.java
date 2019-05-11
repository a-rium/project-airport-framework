package airport.gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.MutableComboBoxModel;

import airport.Airport;

public class AirportDataModel 
{
	private MutableComboBoxModel<Airport> fromModel;
	private MutableComboBoxModel<Airport> toModel;
	
	public AirportDataModel() {
		fromModel = new DefaultComboBoxModel<Airport>();
		toModel = new DefaultComboBoxModel<Airport>();
	}
	
	public MutableComboBoxModel<Airport> getFromModel() {
		return fromModel;
	}
	
	public MutableComboBoxModel<Airport> getToModel() {
		return toModel;
	}
	
	public void add(Airport airport) {
		fromModel.addElement(airport);
		toModel.addElement(airport);
	}
}
