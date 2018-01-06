package PlainObjects;

import java.sql.Date;

public class CreditCard {

	private String credcardnumber;
	private Date expdate;
	private int cvcnumber;
	private int holdername;
	private long cid;
	
	public String getCredcardnumber() {
		return credcardnumber;
	}
	public void setCredcardnumber(String credcardnumber) {
		this.credcardnumber = credcardnumber;
	}
	public Date getExpdate() {
		return expdate;
	}
	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}
	public int getCvcnumber() {
		return cvcnumber;
	}
	public void setCvcnumber(int cvcnumber) {
		this.cvcnumber = cvcnumber;
	}
	public int getHoldername() {
		return holdername;
	}
	public void setHoldername(int holdername) {
		this.holdername = holdername;
	}
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "CreditCard [credcardnumber=" + credcardnumber + ", expdate=" + expdate + ", cvcnumber=" + cvcnumber
				+ ", holdername=" + holdername + ", cid=" + cid + "]";
	}
}
