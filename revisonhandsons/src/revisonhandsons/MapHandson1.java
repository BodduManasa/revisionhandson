package revisonhandsons;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapHandson1 {
	
	static Comparator<Project> projComparator=new Comparator<Project>() {

		@Override
		public int compare(Project o1, Project o2) {
			
			String dom1=o1.getDomain();
			String dom2=o2.getDomain();
			return dom1.compareTo(dom2);
			}
		
	};
	
	public static void main(String args[])
	{
		
		Employee e1=new Employee(101,"boddu",20000.00,"boddu@gmail.com");
		Employee e2=new Employee(102,"manasa",24000.00,"manasa@gmail.com");
		Employee e3=new Employee(103,"vasu",30000.00,"vasu@gmail.com");
		Employee e4=new Employee(104,"pranav",12000.00,"pranav@gmail.com");
		Employee e5=new Employee(105,"ramana",50000.00,"ramana@gmail.com");
		Employee e6=new Employee(106,"lavanya",47000.00,"lavanya@gmail.com");
		Employee e7=new Employee(107,"sasya",28000.00,"sasya@gmail.com");
		Employee e8=new Employee(108,"sreekesh",52000.00,"sreekesh@gmail.com");
		Employee e9=new Employee(109,"yash",37000.00,"yash@gmail.com");
		Employee e10=new Employee(110,"shashank",35000.00,"shashank@gmail.com");
		
		SimpleDateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
		Date d1=new Date("22/10/2018");
		Date d2=new Date("18/12/2018");
		Date d3=new Date("25/03/2019");
		
		
		Project p1=new Project(201,"corejava",d1,d2);
		Project p2=new Project(202,"Advancejava",d1,d2);
		Project p3=new Project(203,"Full stack",d1,d2);
		Project p4=new Project(204,"web",d1,d2);
		Project p5=new Project(205,"Sql",d1,d2);
		Project p6=new Project(206,"datawarehouse",d1,d2);
		Project p7=new Project(207,"c language",d1,d2);
		Project p8=new Project(208,"spring",d1,d2);
		Project p9=new Project(209,"Angular js",d1,d2);
		Project p10=new Project(210,"c++",d1,d2);
		
		Map<Project, Employee> map=new HashMap<Project, Employee>();
		map.put(p1,e1);
		map.put(p2,e2);
		map.put(p3,e3);
		map.put(p4,e4);
		map.put(p5,e5);
		map.put(p6,e6);
		map.put(p7,e7);
		map.put(p8,e8);
		map.put(p9,e9);
		map.put(p10,e10);
		
		displayByProjectID(map);
		System.out.println("**************************");
		displayByProjectDomain(map);
		
	}
	public static void displayByProjectID(Map<Project, Employee> map)
	{
		TreeMap<Project, Employee> empMap1=new TreeMap<Project, Employee>(map);
		empMap1.entrySet().stream().forEach(t->System.out.println(t));	
	
	
	}
	public static void displayByProjectDomain(Map<Project, Employee> map)
	{
		
	map.entrySet().stream().sorted(Map.Entry.comparingByKey(projComparator)).forEach(t->System.out.println(t));	
	
	}
	}


