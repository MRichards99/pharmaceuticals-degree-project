package mrichards;

import java.util.HashSet;
import java.util.Set;

public class SpecialRequirements {
	private int specialRequirementID;
	private int containerSize;
	private String containerType;
	private boolean storeInFridge;
	private boolean availableOverTheCounter;
	private Set<Pharmaceutical> pharmaceuticals = new HashSet<Pharmaceutical>(0);
	
	
	public SpecialRequirements() {
		
	}
	
	public SpecialRequirements(int specialRequirementID, int containerSize, String containerType, boolean storeInFridge,
			boolean availableOverTheCounter, Set<Pharmaceutical> pharmaceuticals) {
		super();
		this.specialRequirementID = specialRequirementID;
		this.containerSize = containerSize;
		this.containerType = containerType;
		this.storeInFridge = storeInFridge;
		this.availableOverTheCounter = availableOverTheCounter;
		this.pharmaceuticals = pharmaceuticals;
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
	public boolean isStoreInFridge() {
		return storeInFridge;
	}
	public void setStoreInFridge(boolean storeInFridge) {
		this.storeInFridge = storeInFridge;
	}
	public boolean isAvailableOverTheCounter() {
		return availableOverTheCounter;
	}
	public void setAvailableOverTheCounter(boolean availableOverTheCounter) {
		this.availableOverTheCounter = availableOverTheCounter;
	}
	public Set<Pharmaceutical> getPharmaceuticals() {
		return pharmaceuticals;
	}
	public void setPharmaceuticals(Set<Pharmaceutical> pharmaceuticals) {
		this.pharmaceuticals = pharmaceuticals;
	}
	
	
	
	
}
