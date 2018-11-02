package mrichards;

public class PrescriptionItem {
	private String pharmaceuticalName;
	private int prescribedDailyDose;
	private int duration;
	private int containerSize;
	private boolean counterAvailability;
	private String comments;
	
	
	public PrescriptionItem(String pharmaceuticalName, int prescribedDailyDose, int duration, int containerSize, boolean counterAvailability, String comments) {
		
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


	public boolean isCounterAvailability() {
		return counterAvailability;
	}


	public void setCounterAvailability(boolean counterAvailability) {
		this.counterAvailability = counterAvailability;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}

}
