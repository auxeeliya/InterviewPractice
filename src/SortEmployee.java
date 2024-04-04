import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEmployee {

	public static void main(String[] args) {
		
		List<Employee> emplist = new ArrayList<>();
		emplist.add(new Employee(1, 20, 2014, 500));
		emplist.add(new Employee(2, 20, 2016, 1000));
		emplist.add(new Employee(3, 20, 2013, 1500));
		emplist.add(new Employee(4, 20, 2018, 2000));
		emplist.add(new Employee(5, 20, 2012, 2500));
		emplist.add(new Employee(6, 20, 2019, 3000));
		emplist.add(new Employee(7, 20, 2020, 3500));
		
		//emplist.stream()
		//.sorted((o1,o2)-> o2.getSalary() - o1.getSalary())
		//.collect(Collectors.toList())  // salary based sort in desc
		//.limit(3) // top 3 salaried emp
		//.skip(3) // sal less than 3rd highest
		//.forEach(System.out::println);

		//highest paid employee
		emplist.stream().sorted((o1,o2)-> o2.getSalary() - o1.getSalary())
		.limit(1)
		.forEach(System.out::println);
		
		System.out.println("**************");
		//highest paid employee other way
		System.out.println(emplist.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get().getEmpid());
		
		System.out.println(emplist.stream().collect(Collectors.averagingInt(Employee::getSalary)));
		System.out.println("**************");
		//emp joined after 2014
		emplist.stream().filter(x -> x.getYearOfJoining()>2014)
		.forEach(System.out::println);
		
		
	}

}
