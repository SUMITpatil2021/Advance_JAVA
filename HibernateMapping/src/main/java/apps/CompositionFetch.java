package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import entities.Student;

public class CompositionFetch {


	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
								
		//create session
		Session session = sf.openSession();	
        Student s = session.get(Student.class, 1);
		
		System.out.println(s.getName()+" : "+s.getAddress().getCity());
		
		session.close();
		
		sf.close();

	}

}
