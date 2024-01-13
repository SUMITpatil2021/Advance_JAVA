package apps;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Category;
import entities.Product;

public class AssoCategorySave {

	public static void main(String[] args) {
		//create the service
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
										
				//read the info hibernate.cfg.xml file
				Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
										
				//actually conn to database
				SessionFactory sf = metadata.getSessionFactoryBuilder().build();
										
				//create session
				Session session = sf.openSession();	
				
				// Saving Master Entity --> Category 
				/* Category cat=new Category("Electroncis");
				Transaction tr=session.beginTransaction();
				session.save(cat); 
				tr.commit();
				System.out.println("Category Added "); */
				
				// Saving Child Entity for existing master  --> products 
				
				/* Category category=session.get(Category.class,1);
				Product product=new Product("OnePlus Nord 2T 5G",30000.00f,category);
				//Product product2=new Product("Washing Machine",50000.00f,category);
				Transaction tr=session.beginTransaction();
				session.save(product);
				tr.commit();
				System.out.println("Product Added ");  */
				
				// saving Master and child together 
				Product p1=new Product("Detol Antiseptic Liquid",500);
				Product p2=new Product("Odonil Room Freshner",250);
				Set<Product> items=new HashSet();
				items.add(p1);
				items.add(p2);
				Category c=new Category("HouseHold",items);
				Transaction tr=session.beginTransaction();
				session.save(c);
				tr.commit();
				System.out.println("Products Added");
				
				
				
				
				session.clear();
				sf.close();
				
				
				
	}

}
