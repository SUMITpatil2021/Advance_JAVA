package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import entities.Product;

public class AssoCategoryFetch {

	public static void main(String[] args) {
		
		//create the service
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
										
				//read the info hibernate.cfg.xml file
				Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
										
				//actually conn to database
				SessionFactory sf = metadata.getSessionFactoryBuilder().build();
										
				//create session
				Session session = sf.openSession();	
				
	
		
		
		Product product=session.get(Product.class, 2);
		System.out.println(product.getName()+"\t"+product.getPrice()+"\t"+product.getCategory().getCname());
		
		session.close();
		sf.close();
	}

}
