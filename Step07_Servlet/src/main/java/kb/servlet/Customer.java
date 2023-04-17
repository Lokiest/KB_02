package kb.servlet;

public class Customer {
	private String name;
	private int age;
	private String addr;
	private String phone;
	
	public Customer() {}

	public Customer(String name, int age, String addr, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
