package ObjetRelationMapping;

import java.util.Objects;

public class Emp {


		int empno;
		String ename;
		Float sal;

	public Emp()
	{
		super();
	}

	public Emp(int empno, String ename, Float sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Float getSal() {
		return sal;
	}

	public void setSal(Float sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return " [empno=" + empno + ", ename=" + ename + ", sal=" + sal + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(empno, ename, sal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		return empno == other.empno && Objects.equals(ename, other.ename) && Objects.equals(sal, other.sal);
	}
	
	
	
	
	}


