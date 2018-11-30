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
		// New duration should be added to the existing entry's duration and dose should be prescriptionItem's presribed dose or user defined one, whichever
		// is greater
		
		boolean appendPrescription = false;
		int appendPrescriptionIndex = 0;
		
		for(int i = 0; i < prescriptionItems.size(); i++) {
			String search = prescriptionItems.get(i).getPharmaceuticalName();
			if (pharmaceuticalName.equals(search)) {
				appendPrescription = true;
				
				// Adding new duration onto existing one
				int existingDuration = prescriptionItems.get(i).getDuration();
				int newDuration = existingDuration + duration;
				
				prescriptionItems.get(i).setDuration(newDuration);
				//prescriptionItems.get(i).set
				if (prescribedDailyDose > prescriptionItems.get(i).getPrescribedDailyDose()) {
					prescriptionItems.get(i).setDailyDosage(prescribedDailyDose);
				}
				
				// Do append here
				// Set newPrescriptionItemNeeded to false
				// So that's not done below
				// Keep break in
				break;
			}
		}
		
		if (appendPrescription == true) {
			// Append
			
		} else {
			PrescriptionItem newItem = new PrescriptionItem(pharmaceuticalName, duration, prescribedDailyDose, containerSize, overTheCounter, comments);
			prescriptionItems.add(newItem);
			
			// Set number of containers variable
		}
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
	
	public int getNumberOfPrescriptionItems() {
		return prescriptionItems.size();
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
