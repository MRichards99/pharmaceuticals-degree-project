package mrichards;

import java.util.ArrayList;

public class Prescription {
	private ArrayList<PrescriptionItem> prescriptionItems;
	private int numberOfPharmaceuticals;
	private int numberOfContainers;
	
	

	public Prescription() {
		prescriptionItems = new ArrayList<>();
	}

	public void addPrescriptionItem(String pharmaceuticalName, int prescribedDailyDose, int duration, int containerSize, int overTheCounter, String comments) {
		// If there's already an existing item in the list, append the incoming one to existing one, not overwrite
		
		PrescriptionItem newItem = new PrescriptionItem(pharmaceuticalName, duration, prescribedDailyDose, containerSize, overTheCounter, comments);
		prescriptionItems.add(newItem);
	}
	
	public void removePrescriptionItem(String pharmaceuticalName) {
		// Remove the PrescriptionItem from the prescription
		for (int i = 0; i < prescriptionItems.size(); i++) {
			if(prescriptionItems.get(i).getPharmaceuticalName().equals(pharmaceuticalName)) {
				prescriptionItems.remove(i);
			}
		}
	}
	
	public void clearPrescription() {
		// Using clear() instead of removeAll() due to decreased time complexity
		// clear() is O(n) whereas removeAll() is O(n^2)
		prescriptionItems.clear();
	}

	/*
	 * Getters and setters
	 * Is each getter and setter needed? Consider this at the end
	 * Any set clauses to be set private?
	 */
	
	public ArrayList<PrescriptionItem> getPrescriptionItems() {
		return prescriptionItems;
	}

	public void setPrescriptionItems(ArrayList<PrescriptionItem> prescriptionItems) {
		this.prescriptionItems = prescriptionItems;
	}

	public int getNumberOfPharmaceuticals() {
		return numberOfPharmaceuticals;
	}

	public void setNumberOfPharmaceuticals(int numberOfPharmaceuticals) {
		this.numberOfPharmaceuticals = numberOfPharmaceuticals;
	}

	public int getNumberOfContainers() {
		return numberOfContainers;
	}

	public void setNumberOfContainers(int numberOfContainers) {
		this.numberOfContainers = numberOfContainers;
	}
}
