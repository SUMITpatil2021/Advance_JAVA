package ObjetRelationMapping;

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
	
	
	}


