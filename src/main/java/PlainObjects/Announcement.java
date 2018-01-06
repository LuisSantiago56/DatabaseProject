package PlainObjects;

import java.sql.Date;

public class Announcement {

	private long annid;
	private Date anndate;
	private long rid;
	private int qty;
	private float price;
	
	public long getAnnid() {
		return annid;
	}
	public void setAnnid(long annid) {
		this.annid = annid;
	}
	public Date getAnndate() {
		return anndate;
	}
	public void setAnndate(Date anndate) {
		this.anndate = anndate;
	}
	public long getRid() {
		return rid;
	}
	public void setRid(long rid) {
		this.rid = rid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Announcement [annid=" + annid + ", anndate=" + anndate + ", rid=" + rid + ", qty=" + qty + ", price="
				+ price + "]";
	}
}
