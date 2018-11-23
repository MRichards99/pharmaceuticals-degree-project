package mrichards;

public class LaunchProgram {

	public static void main(String[] args) {
		try {
			PharmaceuticalForm pharmaceuticalForm = new PharmaceuticalForm();
			pharmaceuticalForm.createForm();
		} finally {
			//HibernateDB.closeSessionFactory();
			//System.out.println("CLOSE");
			//databaseConnection.finalize();
		}
	}
	
	public void cleanUp() {
		System.out.println("Program closing.");
		
		// JFrame to be closed
		// Session factory to be closed
	}
}
