package mrichards;

public class PrescriptionItem {
	private String pharmaceuticalName;
	private int prescribedDailyDose;
	private int duration;
	private int containerSize;
	private boolean counterAvailability;
	private String comments;
	private int numberOfContainers;
	
	public PrescriptionItem(String pharmaceuticalName, int duration, int prescribedDailyDose, 
							int containerSize, boolean counterAvailability, String comments) {
		this.pharmaceuticalName = pharmaceuticalName;
		this.prescribedDailyDose = prescribedDailyDose;
		this.duration = duration;
		this.containerSize = containerSize;
		this.counterAvailability = counterAvailability;
		this.comments = comments;
	}

	/*
	 * Getters and setters
	 */
	public String getPharmaceuticalName() {
		return pharmaceuticalName;
	}

	public void setPharmaceuticalName(String pharmaceuticalName) {
		if (pharmaceuticalName.matches("[a-zA-Z0-9]+")) {
			this.pharmaceuticalName = pharmaceuticalName;
		}
	}

	public int getPrescribedDailyDose() {
		return prescribedDailyDose;
	}

	public void setDailyDosage(int prescribedDailyDose) {
		// Dosage locked down on GUI controls so only a basic check to check data validity is needed
		if (prescribedDailyDose > 0) {
			this.prescribedDailyDose = prescribedDailyDose;
		}
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		if (duration > 0) {
			this.duration = duration;
		}
	}

	// No setter as container size is never set - setting the value in the program would disturb data integrity
	public int getContainerSize() {
		return containerSize;
	}

	public boolean isCounterAvailability() {
		return counterAvailability;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		// Lock this down to alphanumerics?
		this.comments = comments;
	}
	
	public int getNumberOfContainers() {
		// Math.ceil always round up, will always need at least 1 container
		return (int) Math.ceil(( this.duration * this.getPrescribedDailyDose() ) / (double) this.getContainerSize());
	}
}
