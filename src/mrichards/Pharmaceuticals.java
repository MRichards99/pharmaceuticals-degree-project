package mrichards;

public class Pharmaceuticals {

	private int pharmaceuticalID;
	private int specialRequirementID;
	private String pharmaceuticalName;
	private String description;
	private char medicationType;
	private int recommendedDailyDose;
	
	
	
	
	public Pharmaceuticals() {
		
	}
	
	public Pharmaceuticals(int pharmaceuticalID, int specialRequirementID, String pharmaceuticalName,
			String description, char medicationType, int recommendedDailyDose) {
		super();
		this.pharmaceuticalID = pharmaceuticalID;
		this.specialRequirementID = specialRequirementID;
		this.pharmaceuticalName = pharmaceuticalName;
		this.description = description;
		this.medicationType = medicationType;
		this.recommendedDailyDose = recommendedDailyDose;
	}
	public int getPharmaceuticalID() {
		return pharmaceuticalID;
	}
	public void setPharmaceuticalID(int pharmaceuticalID) {
		this.pharmaceuticalID = pharmaceuticalID;
	}
	public int getSpecialRequirementID() {
		return specialRequirementID;
	}
	public void setSpecialRequirementID(int specialRequirementID) {
		this.specialRequirementID = specialRequirementID;
	}
	public String getPharmaceuticalName() {
		return pharmaceuticalName;
	}
	public void setPharmaceuticalName(String pharmaceuticalName) {
		this.pharmaceuticalName = pharmaceuticalName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public char getMedicationType() {
		return medicationType;
	}
	public void setMedicationType(char medicationType) {
		this.medicationType = medicationType;
	}
	public int getRecommendedDailyDose() {
		return recommendedDailyDose;
	}
	public void setRecommendedDailyDose(int recommendedDailyDose) {
		this.recommendedDailyDose = recommendedDailyDose;
	}
	
	
}
