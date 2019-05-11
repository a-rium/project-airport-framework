package airport.gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.MutableComboBoxModel;

import airport.Airport;

public class AirportDataModel 
{
	private DefaultListModel<Airport> listModel;
	private MutableComboBoxModel<Airport> fromModel;
	private MutableComboBoxModel<Airport> toModel;
	
	public AirportDataModel() {
		this.listModel = new DefaultListModel<>();
		this.fromModel = new DefaultComboBoxModel<>();
		this.toModel = new DefaultComboBoxModel<>();
	}
	
	public DefaultListModel<Airport> getListModel() {
		return listModel;
	}
	
	public MutableComboBoxModel<Airport> getFromModel() {
		return fromModel;
	}
	
	public MutableComboBoxModel<Airport> getToModel() {
		return toModel;
	}
	
	public void add(Airport airport) {
		listModel.addElement(airport);
		fromModel.addElement(airport);
		toModel.addElement(airport);
	}
	
	public void remove(Airport airport) {
		listModel.removeElement(airport);
		fromModel.removeElement(airport);
		toModel.removeElement(airport);
	}
}
