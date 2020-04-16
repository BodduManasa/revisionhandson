package revisonhandsons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import revisonhandsons.Employee;
public class MapHandson2 {
	public static Map<Project, Employee> loadProjects() throws ParseException {

		Employee e1 = new Employee(1, "bhanu", 25000, "bhanu@gmail.com");
		Employee e2 = new Employee(2, "harsha", 25000, "harsha@gmail.com");
		Employee e3 = new Employee(3, "alekhya", 25000, "alekhya@gmail.com");
		Employee e4 = new Employee(4, "mounika", 25000, "mounika@gmail.com");

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date startdate = sdf.parse("12-12-2019");
		Date enddate = sdf.parse("30-04-2020");
		Project p1 = new Project(101, "Java", startdate, enddate);
		Project p2 = new Project(103, "Android", sdf.parse("12-10-2019"), sdf.parse("04-04-2020"));
		Project p3 = new Project(104, "SAP", sdf.parse("01-01-2020"), sdf.parse("04-04-2020"));
		Project p4 = new Project(106, "AWS", sdf.parse("12-10-2019"), sdf.parse("04-05-2020"));
		Project p5 = new Project(105, "Datawarehouse", sdf.parse("10-10-2019"), sdf.parse("28-02-2020"));
		Project p6 = new Project(108, "IOT", sdf.parse("02-01-2020"), sdf.parse("30-04-2020"));
		Project p7 = new Project(109, "React js", sdf.parse("12-10-2019"), sdf.parse("04-05-2020"));
		Project p8 = new Project(107, "Angular js", sdf.parse("12-12-2019"), sdf.parse("30-03-2020"));
		Project p9 = new Project(102, "AI", sdf.parse("12-02-2020"), sdf.parse("31-06-2020"));
		Project p10 = new Project(110, "Machine Learning", sdf.parse("12-10-2019"), sdf.parse("04-07-2020"));

		Map<Project, Employee> map = new TreeMap<Project, Employee>();
		map.put(p1, e1);
		map.put(p2, e2);
		map.put(p3, e3);
		map.put(p4, e4);
		map.put(p5, e1);
		map.put(p6, e2);
		map.put(p7, e3);
		map.put(p8, e4);
		map.put(p9, e1);
		map.put(p10, e3);

		return map;
	}

	public static void displayByProjectId(Map<Project, Employee> map) {
		 SortedMap<Project,Employee>  sortedMap = new TreeMap<Project, Employee>(map);
		
		 sortedMap.entrySet().stream().forEach(t->System.out.println(t));
		
		
		/*
		 * Comparator<Map.Entry<Project,Employee>> Comparator = new
		 * Comparator<Map.Entry<Project,Employee>>() {
		 * 
		 * 
		 * @Override public int compare(Entry<Project, Employee> o1 ,Entry<Project,
		 * Employee> o2) { if(o1.getKey().getId()>o2.getKey().getId()) { return 1; }else
		 * if(o1.getKey().getId()<o2.getKey().getId()) { return -1; } else { return 0; }
		 * // TODO Auto-generated method stub } };
		 * 
		 * ArrayList<Map.Entry<Project,Employee>> sortedlist=new
		 * ArrayList<Map.Entry<Project,Employee>>();
		 * map.entrySet().stream().forEach(t->sortedlist.add(t));
		 * Collections.sort(sortedlist, Comparator); Map<Project,Employee> sortedmap=new
		 * TreeMap<Project,Employee>(); for(Map.Entry<Project,Employee> m:sortedlist) {
		 * sortedmap.put(m.getKey(), m.getValue()); }
		 * sortedmap.entrySet().stream().forEach(t->System.out.println(t));
		 * 
		 * map.entrySet().stream().forEach(t->System.out.println(t));
		 */

	}

	public static void displayByProjectDomain(Map<Project, Employee> map) {
		Comparator<Project> projectDomainComaprator = new Comparator<Project>() {

			@Override
			public int compare(Project o1, Project o2) {
				// TODO Auto-generated method stub
				return o1.getDomain().compareTo(o2.getDomain());
			}
		};
		
		
		
		/*
		 * Comparator<Map.Entry<Project, Employee>> Comparator = new
		 * Comparator<Map.Entry<Project, Employee>>() {
		 * 
		 * @Override public int compare(Entry<Project, Employee> o1, Entry<Project,
		 * Employee> o2) {
		 * 
		 * return o1.getKey().getDomain().compareTo(o2.getKey().getDomain()); } };
		 */
		/*
		 * ArrayList<Map.Entry<Project,Employee>> sortedlist=new
		 * ArrayList<Map.Entry<Project,Employee>>();
		 * map.entrySet().stream().forEach(t->sortedlist.add(t));
		 * Collections.sort(sortedlist, Comparator);
		 */
		map.entrySet().stream().sorted(Map.Entry.comparingByKey(projectDomainComaprator)).forEach(t -> System.out.println(t));
		;
		/*
		 * Map<Project,Employee> sortedmap=new TreeMap<Project,Employee>();
		 * for(Map.Entry<Project,Employee> m:sortedlist) { sortedmap.put(m.getKey(),
		 * m.getValue()); }
		 * sortedmap.entrySet().stream().forEach(t->System.out.println(t));
		 */

	}

	public static void main(String args[]) throws ParseException {
		Map<Project, Employee> map = loadProjects();
		displayByProjectId(map);
		System.out.println("***************");
		displayByProjectDomain(map);
	}

}

