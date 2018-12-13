package mrichards;

public class PrescriptionItem {
	private String pharmaceuticalName;
	private int prescribedDailyDose;
	private int duration;
	private int containerSize;
	private boolean counterAvailability;
	private String comments;
	
	public PrescriptionItem(String pharmaceuticalName, int duration, int prescribedDailyDose, 
							int containerSize, boolean counterAvailability, String comments) {
		setPharmaceuticalName(pharmaceuticalName);
		setPrescribedDailyDose(prescribedDailyDose);
		setDuration(duration);
		setContainerSize(containerSize);
		setCounterAvailability(counterAvailability);
		setComments(comments);
	}

	/*
	 * Getters and setters
	 */
	
	public String getPharmaceuticalName() {
		return pharmaceuticalName;
	}

	private void setPharmaceuticalName(String pharmaceuticalName) {
		if (pharmaceuticalName.matches("[a-zA-Z0-9]+")) {
			this.pharmaceuticalName = pharmaceuticalName;
		}
	}

	public int getPrescribedDailyDose() {
		return prescribedDailyDose;
	}
	
	private void setPrescribedDailyDose(int prescribedDailyDose) {
		this.prescribedDailyDose = prescribedDailyDose;
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
		// Ensures duration matches a value realistic to the real world
		if (duration > 0) {
			this.duration = duration;
		}
	}

	public int getContainerSize() {
		return containerSize;
	}

	private void setContainerSize(int containerSize) {
		this.containerSize = containerSize;
	}
	
	public boolean isCounterAvailability() {
		return counterAvailability;
	}
	
	private void setCounterAvailability(boolean counterAvailability) {
		this.counterAvailability = counterAvailability;
	}

	public String getComments() {
		return comments;
	}

	// Comments set in Prescription class, therefore a public method
	public void setComments(String comments) {
		int textAreaLength = comments.length();
		String finalSection = comments.substring(textAreaLength - 3, textAreaLength);
		if (! finalSection.equals(";\n")) {
			comments += ";\n";
		}
		this.comments = comments;
	}
	
	public int getNumberOfContainers() {
		// Math.ceil always round up, will always need at least 1 container
		return (int) Math.ceil(( this.duration * this.getPrescribedDailyDose() ) / (double) this.getContainerSize());
	}
}
