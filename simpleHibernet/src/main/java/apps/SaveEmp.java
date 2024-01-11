package apps;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Emp;

public class SaveEmp {

	public SaveEmp() {
		
	}

	public static void main(String[] args) {
		//create session factory
				//create the service
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
								
				//read the info hibernate.cfg.xml file
				Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
				//actually conn to database
				SessionFactory sf = metadata.getSessionFactoryBuilder().build();
				
				
				//create session
				Session session = sf.openSession();

			
			
				
				Emp emp = new Emp(11,"Supriya",50000);
				
				Transaction tr = session.beginTransaction();
				
				session.persist(emp);  //insert query
				
				tr.commit();
				
				session.close();
				
				sf.close();

	}

}
