package mrichards.unittests;

import static org.junit.jupiter.api.Assertions.*;
import mrichards.SpecialRequirements;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpecialRequirementsTest {
	private static int testSpecialRequirementID = 4;
	private static int testContainerSize = 10;
	private static String testContainerType = "Bottle";
	private static int testStoreInFridge = 1;
	private static boolean testAvailableOverCounter = false; 
	
	private static SpecialRequirements testSpecialRequirements;
	
	
	@BeforeEach
	void setUp() throws Exception {
		testSpecialRequirements = new SpecialRequirements(testSpecialRequirementID, testContainerSize, testContainerType, testStoreInFridge, testAvailableOverCounter);
	}

	@Test
	void testGetSpecialRequirementID() {
		int specialRequirementsID = testSpecialRequirements.getSpecialRequirementID();
		assertEquals(testSpecialRequirementID, specialRequirementsID);
	}
	
	@Test
	void testGetContainerSize() {
		int containerSize = testSpecialRequirements.getContainerSize();
		assertEquals(testContainerSize, containerSize);
	}
	
	@Test
	void testContainerType() {
		String containerType = testSpecialRequirements.getContainerType();
		assertEquals(testContainerType, containerType);
	}
	
	@Test
	void testFridgeStorage() {
		int fridgeStore = testSpecialRequirements.isStoreInFridge();
		assertEquals(testStoreInFridge, fridgeStore);
	}
	
	@Test
	void testAvailableOverCounter() {
		boolean counterAvailable = testSpecialRequirements.isAvailableOverTheCounter();
		assertEquals(testAvailableOverCounter, counterAvailable);
	}

}
