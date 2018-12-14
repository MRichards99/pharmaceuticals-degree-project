package mrichards.unittests;

import static org.junit.jupiter.api.Assertions.*;
import mrichards.Pharmaceutical;
import mrichards.SpecialRequirements;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PharmaceuticalTest {
	private static int testSpecialRequirementID = 4;
	private static int testContainerSize = 10;
	private static String testContainerType = "Bottle";
	private static int testStoreInFridge = 0;
	private static boolean testAvailableOverCounter = false; 
	
	private static int testPharmaceuticalID;
	private static SpecialRequirements testSpecialRequirementsObject = new SpecialRequirements(testSpecialRequirementID, testContainerSize, testContainerType, testStoreInFridge, testAvailableOverCounter);;
	private static String testPharmaceuticalName = "Name";
	private static String testDescription = "Description";
	private static char testMedicationType = 'T'; 
	private static int testRecommendedDailyDose = 10;
	private static String testDisplayComments = "Description; Comes in a 10ml bottle; ";
	
	private static Pharmaceutical testPharmaceutical;

	@BeforeEach
	void setUp() throws Exception {
		testPharmaceutical = new Pharmaceutical(testPharmaceuticalID, testSpecialRequirementsObject, testPharmaceuticalName, testDescription, testMedicationType, testRecommendedDailyDose);
	}

	@Test
	void testGetDisplayComments() {
		String displayComments = testPharmaceutical.getDisplayComments();
		assertEquals(testDisplayComments, displayComments);
	}
	
	@Test
	void testGetSpecialRequirements() {
		SpecialRequirements specialRequirements = testPharmaceutical.getSpecialRequirementID();
		assertEquals(testSpecialRequirementsObject, specialRequirements);
	}
	
	@Test
	void testGetPharmaceuticalName() {
		String pharmaceuticalName = testPharmaceutical.getPharmaceuticalName();
		assertEquals(testPharmaceuticalName, pharmaceuticalName);
	}
	
	@Test
	void testGetDescription() {
		String description = testPharmaceutical.getDescription();
		assertEquals(testDescription, description);
	}
	
	@Test
	void testGetMedicationType() {
		char medicationType = testPharmaceutical.getMedicationType();
		assertEquals(testMedicationType, medicationType);
	}
	
	@Test
	void testGetRecommendedDose() {
		int recommendedDose = testPharmaceutical.getRecommendedDailyDose();
		assertEquals(testRecommendedDailyDose, recommendedDose);
	}

}
