package ex0206.list;

public class Emp implements Comparable<Emp> {
	private int empno;
	private String ename;
	private int age;
	private String addr;

	public Emp() {

	}

	public Emp(int empno, String ename, int age, String addr) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.age = age;
		this.addr = addr;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() { // object의 toString을 오버라이딩.
		StringBuilder builder = new StringBuilder();
		builder.append("Emp [empno=");
		builder.append(empno);
		builder.append(", ename=");
		builder.append(ename);
		builder.append(", age=");
		builder.append(age);
		builder.append(", addr=");
		builder.append(addr);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * 음수 0 양수 5-2=3(왼쪽 크다) 5-5=0(양쪽 같다) 5-7=-2(오른쪽 크다)
	 * 
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Emp o) {
		System.out.println("compareTo call...");
		return empno - o.empno;
	}

}
