package revisonhandsons;


public class Address {
	
	public String city;
	public String State;
	public String country;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Address(String city, String state, String country) {
		super();
		this.city = city;
		State = state;
		this.country = country;
	}
	public Address() {
		super();
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", State=" + State + ", country=" + country + "]";
	}
	

}
