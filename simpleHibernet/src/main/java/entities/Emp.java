package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")

public class Emp {
	@Id
	private int eno;
	@Column
	private String ename;
	@Column
	private float sal;
	public Emp() {
		
	}
	public Emp(int eno, String ename, float sal) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.sal = sal; 
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	

}
