package mrichards;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateDB {
	
	private static SessionFactory factory;
	
	public HibernateDB() {
		// Creates session factory
		try {
			// Below single line of code has issues with exceptions
			//factory = new Configuration().configure().buildSessionFactory();
			
			Configuration configuration = new Configuration().addClass(mrichards.Pharmaceutical.class).addClass(mrichards.SpecialRequirements.class);
			configuration.configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			factory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable e) {
			System.out.println("Failed to create sessionFactory object:" + e);
			//throw new ExceptionInInitializerError(e);
			e.printStackTrace();
		}
	}
	
	public static void closeSessionFactory() {
		factory.close();
	}
	
	public void getPharmaceuticalsData() {
		Session session = factory.openSession();
		try {
			List<Pharmaceutical> pharmaceutials = session.createQuery("FROM Pharmaceutical").list();
			for (Iterator<Pharmaceutical> iterator = pharmaceutials.iterator(); iterator.hasNext();) {
				Pharmaceutical pharmaceutical = (Pharmaceutical) iterator.next();
				System.out.println(pharmaceutical.getDescription());
				System.out.println(pharmaceutical.getMedicationType());
				System.out.println(" ");
				System.out.println(pharmaceutical.getSpecialRequirementID());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public Vector<String> getPharmaceuticalNames() {
		Session session = factory.openSession();
		Vector<String> pharmaceuticalNames = new Vector<String>();
		try {
			List<String> pharmaceutialNameList = session.createQuery("SELECT pharmaceuticalName FROM Pharmaceutical").list();
			for (Iterator<String> iterator = pharmaceutialNameList.iterator(); iterator.hasNext();) {
				String pharmaceuticalName = iterator.next();
				pharmaceuticalNames.add(pharmaceuticalName);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return pharmaceuticalNames;
	}
	
	public Pharmaceutical getPharmaceutical(String selectedPharmaceuticalName) {
		Session session = factory.openSession();
		Pharmaceutical selectedPharmaceutical = null;
		try {
			Query query = session.createQuery("FROM Pharmaceutical WHERE pharmaceuticalName = '" + selectedPharmaceuticalName + "'");
			query.setFirstResult(0);
			query.setMaxResults(1);
			List<Pharmaceutical> pharmaceutcials = ((org.hibernate.query.Query) query).list();
			//for (Iterator<Pharmaceutical> iterator = pharmaceutials.iterator(); iterator.hasNext();) {
				//selectedPharmaceutical = (Pharmaceutical) iterator.next();
			//}
			//System.out.println(pharmaceutcials.size());
			System.out.println(pharmaceutcials.get(0));
			selectedPharmaceutical = pharmaceutcials.get(0);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return selectedPharmaceutical;
		
	}
	
	public void getSpecialRequirementsData() {
		Session session = factory.openSession();
		try {
			List<SpecialRequirements> specialRequirements = session.createQuery("FROM SpecialRequirements").list();
			for (Iterator<SpecialRequirements> iterator = specialRequirements.iterator(); iterator.hasNext();) {
				SpecialRequirements specialRequirement = (SpecialRequirements) iterator.next();
				System.out.println(specialRequirement.getSpecialRequirementID());
				System.out.println(specialRequirement.isStoreInFridge());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	protected void finalize() {
		factory.close();
		System.out.println("Final method called");
	}

}
