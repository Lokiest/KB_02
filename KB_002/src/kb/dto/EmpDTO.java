package kb.dto;

public class EmpDTO {
	private int empNo;
	private String ename;
	private String job;
	private int sal;
	private String hiredate;
	
	public EmpDTO() {}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public EmpDTO(int empNo, String ename, String job, int sal, String hiredate) {
		super();
		this.empNo = empNo;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmpDTO [empNo=");
		builder.append(empNo);
		builder.append(", ename=");
		builder.append(ename);
		builder.append(", job=");
		builder.append(job);
		builder.append(", sal=");
		builder.append(sal);
		builder.append(", hiredate=");
		builder.append(hiredate);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
