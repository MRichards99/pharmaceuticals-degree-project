package mrichards;

public class SpecialRequirements {
	private int specialRequirementID;
	private int containerSize;
	private String containerType;
	private Boolean storeInFridge;
	private Boolean availableOverTheCounter;
	
	public SpecialRequirements() {
		
	}
	
	public SpecialRequirements(int specialRequirementID, int containerSize, String containerType, Boolean storeInFridge, Boolean availableOverTheCounter) {
		super();
		this.specialRequirementID = specialRequirementID;
		this.containerSize = containerSize;
		this.containerType = containerType;
		this.storeInFridge = storeInFridge;
		this.availableOverTheCounter = availableOverTheCounter;
	}
	
	public int getSpecialRequirementID() {
		return specialRequirementID;
	}
	public void setSpecialRequirementID(int specialRequirementID) {
		this.specialRequirementID = specialRequirementID;
	}
	public int getContainerSize() {
		return containerSize;
	}
	public void setContainerSize(int containerSize) {
		this.containerSize = containerSize;
	}
	public String getContainerType() {
		return containerType;
	}
	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}
	public Boolean isStoreInFridge() {
		return storeInFridge;
	}
	public void setStoreInFridge(Boolean storeInFridge) {
		this.storeInFridge = storeInFridge;
	}
	public Boolean isAvailableOverTheCounter() {
		return availableOverTheCounter;
	}
	public void setAvailableOverTheCounter(Boolean availableOverTheCounter) {
		this.availableOverTheCounter = availableOverTheCounter;
	}
	
	
	
	
}
