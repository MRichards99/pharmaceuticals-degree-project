package mrichards.unittests;

import static org.junit.jupiter.api.Assertions.*;
import mrichards.PrescriptionItem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrescriptionItemTest {
	private static String testPharmaceuticalName1 = "First";
	private static int testDuration1 = 5;
	private static int testPrescribedDailyDose1 = 4;
	private static int testContainerSize1 = 10;
	private static boolean testAvailableOverCounter1 = true;
	private static String testComments1 = "Test Comment 1";
	
	private static String testPharmaceuticalName2 = "Second";
	private static int testDuration2 = 10;
	private static int testPrescribedDailyDose2 = 8;
	private static int testContainerSize2 = 20;
	private static boolean testAvailableOverCounter2 = false;
	private static String testComments2 = "Test Comment 2";
	
	private static PrescriptionItem testPrescriptionItem;

	@BeforeEach
	void setUp() throws Exception {
		testPrescriptionItem = new PrescriptionItem(testPharmaceuticalName1, testDuration1, testPrescribedDailyDose1, testContainerSize1, testAvailableOverCounter1, testComments1);
	}
	
	@Test
	void testGetPharmaceuticalName() {
		String pharmaceuticalName = testPrescriptionItem.getPharmaceuticalName();
		assertEquals(testPharmaceuticalName1, pharmaceuticalName);
	}
	
	@Test
	void testGetPrescribedDailyDose() {
		int prescribedDailyDose = testPrescriptionItem.getPrescribedDailyDose();
		assertEquals(testPrescribedDailyDose1, prescribedDailyDose);
	}
	
	@Test
	void testSetPrescribedDailyDose() {
		testPrescriptionItem.setDailyDosage(testPrescribedDailyDose2);
		int prescribedDailyDose = testPrescriptionItem.getPrescribedDailyDose();
		assertEquals(testPrescribedDailyDose2, prescribedDailyDose);
	}
	
	@Test
	void testGetDuration() {
		int duration = testPrescriptionItem.getDuration();
		assertEquals(testDuration1, duration);
	}
	
	@Test
	void testSetDuration() {
		testPrescriptionItem.setDuration(testDuration2);
		int duration = testPrescriptionItem.getDuration();
		assertEquals(testDuration2, duration);
	}
	
	@Test
	void testGetContainerSize() {
		int containerSize = testPrescriptionItem.getContainerSize();
		assertEquals(testContainerSize1, containerSize);
	}

	@Test
	void testIsAvailableOverCounter() {
		boolean availableOverCounter = testPrescriptionItem.isCounterAvailability();
		assertEquals(testAvailableOverCounter1, availableOverCounter);
	}
	
	@Test
	void testGetComments() {
		String comments = testPrescriptionItem.getComments();
		assertEquals(testComments1 + ";\n", comments);
	}
	
	@Test
	void testGetNumberOfContainers() {
		int numContainers = testPrescriptionItem.getNumberOfContainers();
		assertEquals(2, numContainers);
	}
}
