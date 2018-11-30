package mrichards;

public class PrescriptionItem {
	private String pharmaceuticalName;
	private int prescribedDailyDose;
	private int duration;
	private int containerSize;
	private int counterAvailability;
	private String comments;
	private int numberOfContainers;
	
	public PrescriptionItem(String pharmaceuticalName, int duration, int prescribedDailyDose, int containerSize,
							int counterAvailability, String comments) {
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
		this.pharmaceuticalName = pharmaceuticalName;
	}


	public int getPrescribedDailyDose() {
		return prescribedDailyDose;
	}


	public void setDailyDosage(int prescribedDailyDose) {
		this.prescribedDailyDose = prescribedDailyDose;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public int getContainerSize() {
		return containerSize;
	}


	public void setContainerSize(int containerSize) {
		this.containerSize = containerSize;
	}


	public int isCounterAvailability() {
		return counterAvailability;
	}


	public void setCounterAvailability(int counterAvailability) {
		this.counterAvailability = counterAvailability;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public int getNumberOfContainers() {
		return ( this.duration * this.getPrescribedDailyDose() ) / this.getContainerSize(); 
	}

}
