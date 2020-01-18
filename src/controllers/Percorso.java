package controllers;

/**
 * Handles an itinerary
 * 
 * @author gabrieleromanato
 *
 */

public class Percorso {
	
	private double arrivalKm;
	private double departureKm;
	private int travelKm;

	public Percorso() {
		this(20, 20);
	}

	public Percorso(double arrivalKm, double departureKm) {
		this.arrivalKm = arrivalKm;
		this.departureKm = departureKm;
	}
	
	/**
	 * Sets the total itinerary distance
	 */
	
	public void calculateTravelKm() {
		travelKm = (int) arrivalKm - (int) departureKm;
	}

	public double getArrivalKm() {
		return arrivalKm;
	}

	public void setArrivalKm(double arrivalKm) {
		this.arrivalKm = arrivalKm;
	}

	public double getDepartureKm() {
		return departureKm;
	}

	public void setDepartureKm(double departureKm) {
		this.departureKm = departureKm;
	}

	public int getTravelKm() {
		return travelKm;
	}

	public void setTravelKm(int travelKm) {
		this.travelKm = travelKm;
	}

}
