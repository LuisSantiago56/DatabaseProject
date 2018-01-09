package PlainObjects;

import java.sql.Date;

public class AnnouncementSearch {
	private Date anndate;
	private String sname;
	private int qty;
	private double annprice;
	private String rname;
	private Date expdate;
	
	public Date getAnndate() {
		return anndate;
	}
	public void setAnndate(Date anndate) {
		this.anndate = anndate;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getAnnprice() {
		return annprice;
	}
	public void setAnnprice(double annprice) {
		this.annprice = annprice;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public Date getExpdate() {
		return expdate;
	}
	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}
	@Override
	public String toString() {
		return "AnnouncementSearch [anndate=" + anndate + ", sname=" + sname + ", qty=" + qty + ", annprice=" + annprice
				+ ", rname=" + rname + ", expdate=" + expdate + "]";
	}
	
	
}
