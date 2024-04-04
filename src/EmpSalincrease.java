import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmpSalincrease {

	public static void main(String[] args) {
		List<Employee> emplist = new ArrayList<>();
		emplist.add(new Employee(1, 1000, 20));
		emplist.add(new Employee(2, 1000, 30));
		emplist.add(new Employee(3, 1000, 25));
		emplist.add(new Employee(4, 1000, 50));
		
	//	emplist.stream().filter(x -> x.getAge() >25)
		//.map(x -> x.setSalary(x.getSalary()* 1.10))
		//.collect(Collectors.toList());
		
		List<Employee> resultList = emplist.stream().map(e->
		{
			if(e.getAge()>25) {
				e.setSalary((int) (e.getSalary()* 1.10));
			}
			return e;
		})
		.collect(Collectors.toList());
		
		System.out.println(resultList);
	}

}
