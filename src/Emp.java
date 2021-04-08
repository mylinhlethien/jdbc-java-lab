import java.util.Date;


public class Emp {

	private int empNo;
	
	private String ename;
	
	private String efirst;
	
	private String job;
	
	private Emp mgr;
	
	private Date hireDate;
	
	private int sal;
	
	private int comm;
	
	private int tel;
	
	private Dept department;
	
	public Emp(int empNo, String ename, String efirst) {
        this.empNo = empNo;				
        this.ename = ename;
        this.efirst = efirst;				
    }
    public Emp(){}

	public Dept getDepartment() {
		return department;
	}

	public void setDepartment(Dept department) {
		this.department = department;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Emp getMgr() {
		return mgr;
	}

	public void setMgr(Emp mgr) {
		this.mgr = mgr;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getEfirst() {
		return efirst;
	}

	public void setEfirst(String efirst) {
		this.efirst = efirst;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	
	public String toString() {
		return "Empno: " + this.getEmpNo() + "\n Name: " + this.getEname() + "\n First name: " +					
		this.getEfirst() ;
	}
	
}
