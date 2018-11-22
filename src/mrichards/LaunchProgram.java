package mrichards;

public class LaunchProgram {

	public static void main(String[] args) {
		PharmaceuticalForm pharmaceuticalForm = new PharmaceuticalForm();
		//pharmaceuticalForm.openPharmaceuticalForm();
		
		HibernateDB hibernateLogic = new HibernateDB();
		hibernateLogic.createSessionFactory();
		hibernateLogic.listPharmaceuticals();
		hibernateLogic.listSpecialRequirements();
	}

}
