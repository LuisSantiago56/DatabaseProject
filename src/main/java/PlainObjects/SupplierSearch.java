package PlainObjects;

public class SupplierSearch {

	private String sname;
	private String slastname;
	private String sphone;
	private String street;
	private String city;
	private String state;
	private String zcode;
	
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSlastname() {
		return slastname;
	}
	public void setSlastname(String slastname) {
		this.slastname = slastname;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZcode() {
		return zcode;
	}
	public void setZcode(String zcode) {
		this.zcode = zcode;
	}
	@Override
	public String toString() {
		return "SupplierSearch [sname=" + sname + ", slastname=" + slastname + ", sphone=" + sphone + ", street="
				+ street + ", city=" + city + ", state=" + state + ", zcode=" + zcode + "]";
	}
	
}
