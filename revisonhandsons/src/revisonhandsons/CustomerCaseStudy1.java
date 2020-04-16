package revisonhandsons;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import revisonhandsons.Address;
import revisonhandsons.Customer;

public class CustomerCaseStudy1 {
	
	public static Customer createCustomer(String customer) throws Exception
	{
	Customer c = new Customer();
	Address add=new Address();
	String cust[] =customer.split(",");
	c.setCustid(Integer.parseInt(cust[0]));
	c.setCustname(cust[1]);
	c.setEmail(cust[2]);
	c.setMobile(cust[3]);
	SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
	Date d=sd.parse(cust[4]);
	c.setDob(d);	
	c.setAddress(add);
	add.setCity(cust[5]);
	add.setState(cust[6]);
	add.setCountry(cust[7]);
	return c;
	}
	public static List<Customer> getAllCustomers() throws Exception
	{
		FileReader fis = new FileReader(new File("D:\\revisiontextfolders\\customer.txt"));
		BufferedReader b=new BufferedReader(fis);
		String s=b.readLine();
		ArrayList<Customer> a=new ArrayList<Customer>();

		while(s!=null)
		{
		Customer c= createCustomer(s);
		a.add(c);
		s=b.readLine();
		}
		return a;
		}
		
	public static void displayCustomers(String sortkey) throws Exception
	{
		List<Customer> list = getAllCustomers();
		 if(sortkey.equalsIgnoreCase("custid"))
		 {
		Collections.sort(list);
		 }else if(sortkey.equalsIgnoreCase("custname"))
		 {
			 Comparator<Customer> custComparator=(c1,c2)->{ 
				 return c1.getCustname().compareTo(c2.getCustname());
			 };
			 Collections.sort(list,custComparator);
		 }
		 else
		 {
			 
		 }
		for(Customer c: list)
		{
			System.out.println(c);
		}
	}
		
	public static int calculateAge(Date dob)
	{
		int age=(2020-(dob.getYear()+1900));
		return age;
		
	}
	
	public static void displayByAge(int age) throws Exception
	{
		List<Customer> list=getAllCustomers();
		List<Customer> l1=new ArrayList();
		for(Customer cust:list)
		{
			int age1=calculateAge(cust.getDob());
			if(age1<age)
			{
				l1.add(cust);
			}
		}
		
	for(Customer c:l1)
	{
		System.out.println(c);
	}
	
	}
	
	public static void displayByCity(String cityname) throws Exception
	{
		List<Customer> list = getAllCustomers();
		for(Customer cust:list)
		{
			if(cust.getAddress().getCity().equalsIgnoreCase(cityname))
			{
				System.out.println(cust);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
		System.out.println("Select \n 1.Display All Customers \n 2. Display customers by Age \n3 Display customers by city \n 4. Exit");
		
		int option= sc.nextInt();
		
		if(option==1)	
		{
			System.out.println("Enter Sort Key");
			String sk = sc.next();
			
			displayCustomers(sk);
			
		}
		else if(option==2)
		{
			
			System.out.println("Enter age");
			int age=sc.nextInt();	
			displayByAge(age);
		}
		else if(option==3)
		{
			System.out.println("Enter city name");
			String cn=sc.next();
			displayByCity(cn);
		}
		else
		{
			System.out.println("Bye");
			System.exit(0);
		}
	}
	}
}

	
