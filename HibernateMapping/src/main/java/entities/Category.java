package entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="categories")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int cid;
	@Column
	String cname;
	@Column
	String cdesc;
	
	@OneToMany(mappedBy="category")
	@Cascade(value=CascadeType.ALL)
	Set<Product> items;
	
	
	
	
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	


	public Category(String cname,Set<Product>items) {
		super();
		this.cname = cname;
		for(Product oi : items)
			oi.setCategory(this);
		this.items = items;
	}

	public Category(String cname) {
		super();
		this.cname = cname;
	}



	public Category(String cname, String cdesc) {
		super();
		this.cname = cname;
		this.cdesc = cdesc;
	}



	public Set<Product> getItems() {
		return items;
	}




	public void setItems(Set<Product> items) {
		for(Product oi : items)
			oi.setCategory(this);
		this.items = items;
	}




	public int getCid() {
		return cid;
	}



	public void setCid(int cid) {
		this.cid = cid;
	}



	public String getCname() {
		return cname;
	}



	public void setCname(String cname) {
		this.cname = cname;
	}



	public String getCdesc() {
		return cdesc;
	}



	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	
	
	
	

}
