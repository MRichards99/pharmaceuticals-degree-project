package mrichards;

public class SpecialRequirements {
	private int specialRequirementID;
	private int containerSize;
	private String containerType;
	private Integer storeInFridge;
	private int availableOverTheCounter;
	
	public SpecialRequirements() {
		
	}
	
	public SpecialRequirements(int specialRequirementID, int containerSize, String containerType, Integer storeInFridge, int availableOverTheCounter) {
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
	public int isStoreInFridge() {
		return storeInFridge;
	}
	public int setStoreInFridge(Integer storeInFridge) {
		this.storeInFridge = storeInFridge;
		if (storeInFridge != null)
			return storeInFridge.intValue();
		else
			return -1;
	}
	public int isAvailableOverTheCounter() {
		return availableOverTheCounter;
	}
	public void setAvailableOverTheCounter(Integer availableOverTheCounter) {
		this.availableOverTheCounter = availableOverTheCounter;
	}
	
	
	
	
}
