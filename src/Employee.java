
public class Employee {
	private int empid;
	private int age;
	private int yearOfJoining;
	private int salary;
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getYearOfJoining() {
		return yearOfJoining;
	}
	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	public int  getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee(int empid, int age, int yearOfJoining, int salary) {
		super();
		this.empid = empid;
		this.age = age;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}
	public Employee(int empid, int salary) {
		super();
		this.empid = empid;
		this.salary = salary;
	}
	public Employee(int empid, int age, int salary) {
		super();
		this.empid = empid;
		this.age = age;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", age=" + age + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary
				+ "]";
	}

	
	
	
}
