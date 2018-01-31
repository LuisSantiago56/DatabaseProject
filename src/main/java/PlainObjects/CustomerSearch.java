package PlainObjects;

public class CustomerSearch {
	private int cid;
	private String cname;
	private String clastname;
	private String cphone;
	private String street;
	private String city;
	private String state;
	private String zcode;
	
	public int getCid() {
		return cid;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getClastname() {
		return clastname;
	}
	public void setClastname(String clastname) {
		this.clastname = clastname;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
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
		return "CustomerSearch [cname=" + cname + ", clastname=" + clastname + ", cphone=" + cphone + ", street="
				+ street + ", city=" + city + ", state=" + state + ", zcode=" + zcode + "]";
	}
	
}
