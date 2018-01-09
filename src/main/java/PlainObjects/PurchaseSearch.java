package PlainObjects;

import java.sql.Date;

public class PurchaseSearch {

	private Date purdate;
	private float purprice;
	private String rname;
	private float rprice;
	private String credcardnumber;
	private String cname;
	private String cphone;
	private String sname;
	private String sphone;
	
	
	public Date getPurdate() {
		return purdate;
	}
	public void setPurdate(Date purdate) {
		this.purdate = purdate;
	}
	public float getPurprice() {
		return purprice;
	}
	public void setPurprice(float purprice) {
		this.purprice = purprice;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public float getRprice() {
		return rprice;
	}
	public void setRprice(float rprice) {
		this.rprice = rprice;
	}
	public String getCredcardnumber() {
		return credcardnumber;
	}
	public void setCredcardnumber(String credcardnumber) {
		this.credcardnumber = credcardnumber;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	@Override
	public String toString() {
		return "PurchaseSearch [purdate=" + purdate + ", purprice=" + purprice + ", rname=" + rname + ", rprice="
				+ rprice + ", credcardnumber=" + credcardnumber + ", cname=" + cname + ", cphone=" + cphone + ", sname="
				+ sname + ", sphone=" + sphone + "]";
	}
	
}
