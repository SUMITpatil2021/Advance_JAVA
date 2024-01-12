package apps;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Emp;

public class HqlDemo {

	

	public static void main(String[] args) {
		//create the service
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
										
				//read the info hibernate.cfg.xml file
				Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
										
				//actually conn to database
				SessionFactory sf = metadata.getSessionFactoryBuilder().build();
										
				//create session
				Session session = sf.openSession();	
				
				//SQL- select *from employee;
				
				/* Query q=session.createQuery("from Emp");
				
				List<Emp>emps=q.getResultList();
				System.out.println("\n Eno \t Ename \t Salary \t");
				for(Emp e:emps)
				{
					System.out.println(e.getEno()+"\t"+e.getEname()+"\t"+e.getSal());
				}*/
				
				//SQL ==> select empno,ename,sal from emp where deptno=?;
				
				//Query<Object[]> q=session.createQuery("select "); 
				
				//Display the employee whose salary is max 
				Query q=session.createNativeQuery("  select *from employee order by sal desc limit 1");
				List<Emp>emps=q.getResultList();

				System.out.println("\n Eno \t Ename \t Salary \t");
				for(Emp e:emps)
				{
					System.out.println(e.getEno()+"\t"+e.getEname()+"\t"+e.getSal());
				} 
				/* Count of Employees in table 
				Query q=session.createNativeQuery("select count(*) from employee  ");
				Object emps=q.uniqueResult();
				
					System.out.println(emps); */
				
				
					
			
				
				
				
				
				
				

	}

}
