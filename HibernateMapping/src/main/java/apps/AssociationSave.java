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

import entities.Order;
import entities.OrderItem;


public class AssociationSave {

	public AssociationSave() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		// Creating The servie
		
		StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure().build();
		
		
		//Reading Info hibernate.cfg.xml file
		
		Metadata metadata=new MetadataSources(registry).getMetadataBuilder().build();
		
		// Acually con to databaase
		SessionFactory sf=metadata.getSessionFactoryBuilder().build();
		
		// create session 
		
		Session session=sf.openSession();
		
		// saving into master entity --> Order
		/*
		Order o=new Order("Sumit");
		Transaction tr=session.beginTransaction();
		session.save(o);
		tr.commit();  */
		
		//Saving Child Entity for existing master
		/*
		Order order=session.get(Order.class, 1);
		OrderItem oi1=new OrderItem(4,5,order);
		Transaction tr=session.beginTransaction();
		session.save(oi1);
		tr.commit();
		System.out.println("Entry Added successfully"); */
		
		// Saving Master and Child Together
		
		OrderItem oi1=new OrderItem(10,2);
		OrderItem oi2=new OrderItem(11,3);
		
		Set<OrderItem> items=new HashSet();
		items.add(oi1);
		items.add(oi2);
		Order order=new Order("Apurva",items);
		Transaction tr=session.beginTransaction();
		session.save(order);
		tr.commit();
		System.out.println("Added Successfully");
		session.clear();
		sf.close();
		
		
		
		
		
		
		
		
	}

}
