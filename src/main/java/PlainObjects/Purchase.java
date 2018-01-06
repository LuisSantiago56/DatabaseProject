package PlainObjects;

import java.sql.Date;

public class Purchase {

	private long purid;
	private Date purdate;
	private float purprice;
	private long cid;
	private long rid;
	private String credcardnumber;
	
	public long getPurid() {
		return purid;
	}
	public void setPurid(long purid) {
		this.purid = purid;
	}
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
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public long getRid() {
		return rid;
	}
	public void setRid(long rid) {
		this.rid = rid;
	}
	public String getCredcardnumber() {
		return credcardnumber;
	}
	public void setCredcardnumber(String credcardnumber) {
		this.credcardnumber = credcardnumber;
	}
	@Override
	public String toString() {
		return "Purchase [purid=" + purid + ", purdate=" + purdate + ", purprice=" + purprice + ", cid=" + cid
				+ ", rid=" + rid + ", credcardnumber=" + credcardnumber + "]";
	}
}
