package mrichards;

public class Prescription {
	private String prescriptionItems;	// Type may be changed
	private int numberOfPharmaceuticals;
	private int numberOfContainers;
	
	public void addPrescriptionItem(String pharmaceuticalName, int prescribedDailyDose, int duration, boolean counterAvailability, String comments) {
		
	}
	
	public void removePrescriptionItem(String pharmaceuticalName) {
		// Remove the PrescriptionItem from the prescription
	}
	
	public void clearPrescription() {
		// Remove all items from the prescription
	}

	/*
	 * Getters and setters
	 * Is each getter and setter needed? Consider this at the end
	 * Any set clauses to be set private?
	 */
	
	public String getPrescriptionItems() {
		return prescriptionItems;
	}

	public void setPrescriptionItems(String prescriptionItems) {
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
