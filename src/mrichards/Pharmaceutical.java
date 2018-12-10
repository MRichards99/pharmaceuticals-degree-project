package mrichards;

public class Pharmaceutical {

	private int pharmaceuticalID;
	private SpecialRequirements specialRequirementID;
	private String pharmaceuticalName;
	private String description;
	private char medicationType;
	private int recommendedDailyDose;
	
	
	public Pharmaceutical() {
		
	}
	
	public Pharmaceutical(int pharmaceuticalID, SpecialRequirements specialRequirementID, String pharmaceuticalName,
			String description, char medicationType, int recommendedDailyDose) {
		super();
		setPharmaceuticalID(pharmaceuticalID);
		setSpecialRequirementID(specialRequirementID);
		setPharmaceuticalName(pharmaceuticalName);
		setDescription(description);
		setMedicationType(medicationType);
		setRecommendedDailyDose(recommendedDailyDose);
	}
	
	public String getDisplayComments() {
		// Description
		String displayComments = "";
		displayComments = this.getDescription() + "; ";
		
		// Pharmaceutical available over the counter
		if (this.getSpecialRequirementID().isAvailableOverTheCounter()) {
			displayComments += "Available over the counter and maybe cheaper; ";
		}
		
		// Amount and type of pharmaceutical
		switch (this.getSpecialRequirementID().getContainerType()) {
			case "Bottle":
				displayComments += "Comes in a " + this.getSpecialRequirementID().getContainerSize() + "ml bottle; ";
				break;
			case "Box":
				displayComments += "Comes in a box of " + this.getSpecialRequirementID().getContainerSize() + " tablets; ";
				break;
			case "Tube":
				displayComments += "Comes in a " + this.getSpecialRequirementID().getContainerSize() + "ml cream; ";
				break;
			case "Phial":
				displayComments += "Comes in a " + this.getSpecialRequirementID().getContainerSize() + "ml phial; ";
				break;
		}
		
		// Whether pharmaceutical requires fridge storage
		if (this.getSpecialRequirementID().isStoreInFridge() == 1) {
			displayComments += "MUST BE STORED IN FRIDGE; ";
		}
		
		return displayComments;
	}
	
	/*
	 * Getters and setters
	 */
	
	private void setPharmaceuticalID(int pharmaceuticalID) {
		this.pharmaceuticalID = pharmaceuticalID;
	}
	
	public SpecialRequirements getSpecialRequirementID() {
		return specialRequirementID;
	}
	
	private void setSpecialRequirementID(SpecialRequirements specialRequirementID) {
		this.specialRequirementID = specialRequirementID;
	}
	
	public String getPharmaceuticalName() {
		return pharmaceuticalName;
	}
	
	private void setPharmaceuticalName(String pharmaceuticalName) {
		this.pharmaceuticalName = pharmaceuticalName;
	}
	
	public String getDescription() {
		return description;
	}
	
	private void setDescription(String description) {
		this.description = description;
	}
	
	public char getMedicationType() {
		return medicationType;
	}
	
	private void setMedicationType(char medicationType) {
		this.medicationType = medicationType;
	}
	
	public int getRecommendedDailyDose() {
		return recommendedDailyDose;
	}
	
	private void setRecommendedDailyDose(int recommendedDailyDose) {
		this.recommendedDailyDose = recommendedDailyDose;
	}
}
