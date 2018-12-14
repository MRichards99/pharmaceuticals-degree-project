package mrichards.unittests;

import static org.junit.jupiter.api.Assertions.*;
import mrichards.Prescription;
import mrichards.PrescriptionItem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrescriptionTest {
	
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
	
	private static Prescription testPrescription;

	@BeforeEach
	void setUp() throws Exception {
		testPrescription = new Prescription();
		testPrescription.addPrescriptionItem(testPharmaceuticalName1, testPrescribedDailyDose1, testDuration1, testContainerSize1, testAvailableOverCounter1, testComments1);
		testPrescription.addPrescriptionItem(testPharmaceuticalName2, testPrescribedDailyDose2, testDuration2, testContainerSize2, testAvailableOverCounter2, testComments2);
	}

	@Test
	void testAddPrescriptionItem() {
		String pharmaceuticalName = "Name";
		int duration = 30;
		int prescribedDailyDose = 15;
		int containerSize = 5;
		boolean availableOverCounter = false;
		String comments = "This is a test comment";
		
		testPrescription.addPrescriptionItem(pharmaceuticalName, prescribedDailyDose, duration, containerSize, availableOverCounter, comments);
		
		String pharmaceuticalNameOutput = testPrescription.getPrescriptionItems().get(2).getPharmaceuticalName();
		int durationOutput = testPrescription.getPrescriptionItems().get(2).getDuration();
		int prescribedDailyDoseOutput = testPrescription.getPrescriptionItems().get(2).getPrescribedDailyDose();
		int containerSizeOutput = testPrescription.getPrescriptionItems().get(2).getContainerSize();
		boolean availableOverCounterOutput = testPrescription.getPrescriptionItems().get(2).isCounterAvailability();
		
		assertEquals(pharmaceuticalName, pharmaceuticalNameOutput);
		assertEquals(duration, durationOutput);
		assertEquals(prescribedDailyDose, prescribedDailyDoseOutput);
		assertEquals(containerSize, containerSizeOutput);
		assertEquals(availableOverCounter, availableOverCounterOutput);
	}
	
	@Test
	void testRemovePrescriptionItem() {
		testPrescription.removePrescriptionItem(testPharmaceuticalName1);
		int size = testPrescription.getPrescriptionItems().size();
		assertEquals(1, size);
	}
	
	@Test
	void testClearPrescription() {
		testPrescription.clearPrescription();
		int size = testPrescription.getPrescriptionItems().size();
		assertEquals(0, size);
	}
	
	@Test
	void getSelectedPrescriptionItem() {
		PrescriptionItem testItem = testPrescription.getSelectedPrescriptionItem(testPharmaceuticalName2);
		String pharmaceuticalName = testItem.getPharmaceuticalName();
		int containerSize = testItem.getContainerSize();
		
		assertEquals(testPharmaceuticalName2, pharmaceuticalName);
		assertEquals(testContainerSize2, containerSize);
	}
	
	@Test
	void testGetPrescriptionItems() {
		String pharmaceuticalName1 = testPrescription.getPrescriptionItems().get(0).getPharmaceuticalName();
		boolean availableOverCounter = testPrescription.getPrescriptionItems().get(1).isCounterAvailability();
		
		assertEquals(testPharmaceuticalName1, pharmaceuticalName1);
		assertEquals(testAvailableOverCounter2, availableOverCounter);
	}
}
