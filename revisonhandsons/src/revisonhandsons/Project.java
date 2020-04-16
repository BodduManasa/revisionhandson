package revisonhandsons;

import java.io.Serializable;
import java.util.Date;

public class Project implements Comparable<Project>, Serializable,Cloneable{

int id;
String domain;
Date startDate;
Date endDate;




public int getId() {
	return id;
}




public void setId(int id) {
	this.id = id;
}




public String getDomain() {
	return domain;
}




public void setDomain(String domain) {
	this.domain = domain;
}




public Date getStartDate() {
	return startDate;
}




public void setStartDate(Date startDate) {
	this.startDate = startDate;
}




public Date getEndDate() {
	return endDate;
}




public void setEndDate(Date endDate) {
	this.endDate = endDate;
}




public Project(int id, String domain, Date startDate, Date endDate) {
	super();
	this.id = id;
	this.domain = domain;
	this.startDate = startDate;
	this.endDate = endDate;
}




public Project() {
	super();
}




@Override
protected Object clone() throws CloneNotSupportedException {
	// TODO Auto-generated method stub
	return super.clone();
}




@Override
public String toString() {
	return "Project [id=" + id + ", domain=" + domain + ", startDate=" + startDate + ", endDate=" + endDate + "]";
}




@Override
public int compareTo(Project o) {
	
	 if(this.id > o.id)
	 
	 { 
		 
		 return 1;
		 } else if(this.id < o.id) 
		 
		 {
			 return -1;
	} else 
	{ 
		return 0; 
		}
	
	
	
	}






}
