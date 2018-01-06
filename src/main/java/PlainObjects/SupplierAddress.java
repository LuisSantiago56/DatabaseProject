package PlainObjects;

public class SupplierAddress {

	private long aid;
	private String street;
	private String city;
	private String state;
	private String zcode;
	private long sid;
	public long getAid() {
		return aid;
	}
	public void setAid(long aid) {
		this.aid = aid;
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
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "Supplier Address [aid=" + aid + ", street=" + street + ", city=" + city + ", state=" + state + ", zcode="
				+ zcode + ", sid=" + sid + "]";
	}
}
