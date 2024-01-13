package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
    @Column
	int pid;
    @Column
	int qty;
    
    @ManyToOne
    @JoinColumn(name="oid")
	Order order;
	
	public OrderItem() {
		super();
	}
	
	

	public OrderItem(int pid, int qty, Order order) {
		super();
		this.pid = pid;
		this.qty = qty;
		this.order = order;
	}
	
	

	public OrderItem(int pid, int qty) {
		super();
		this.pid = pid;
		this.qty = qty;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}



	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", pid=" + pid + ", qty=" + qty + ", order=" + order + "]";
	}
	
	
	
	

}
