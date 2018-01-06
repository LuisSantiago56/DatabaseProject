package PlainObjects;

public class CustomerAddress {

	private long aid;
	private String street;
	private String city;
	private String state;
	private String zcode;
	private long cid;
	
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
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Customer Address [aid=" + aid + ", street=" + street + ", city=" + city + ", state=" + state + ", zcode="
				+ zcode + ", cid=" + cid + "]";
	}
}
