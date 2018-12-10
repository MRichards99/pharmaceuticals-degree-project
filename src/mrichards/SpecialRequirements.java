package mrichards;

public class SpecialRequirements {
	private int specialRequirementID;
	private int containerSize;
	private String containerType;
	private int storeInFridge;
	private boolean availableOverTheCounter;
	
	public SpecialRequirements() {
		
	}
	
	public SpecialRequirements(int specialRequirementID, int containerSize, String containerType, Integer storeInFridge, boolean availableOverTheCounter) {
		super();
		setSpecialRequirementID(specialRequirementID);
		setContainerSize(containerSize);
		setContainerType(containerType);
		setStoreInFridge(storeInFridge);
		setAvailableOverTheCounter(availableOverTheCounter);
	}
	
	public int getSpecialRequirementID() {
		return specialRequirementID;
	}
	
	private void setSpecialRequirementID(int specialRequirementID) {
		this.specialRequirementID = specialRequirementID;
	}
	
	public int getContainerSize() {
		return containerSize;
	}
	
	private void setContainerSize(int containerSize) {
		this.containerSize = containerSize;
	}
	
	public String getContainerType() {
		return containerType;
	}
	
	private void setContainerType(String containerType) {
		this.containerType = containerType;
	}
	
	public int isStoreInFridge() {
		return storeInFridge;
	}
	
	private void setStoreInFridge(Integer storeInFridge) {
		if (storeInFridge != null) {
			this.storeInFridge = storeInFridge;
		} else {
			this.storeInFridge = -1;
		}
	}
	
	public boolean isAvailableOverTheCounter() {
		return availableOverTheCounter;
	}
	
	private void setAvailableOverTheCounter(boolean availableOverTheCounter) {
		this.availableOverTheCounter = availableOverTheCounter;
	}
}
