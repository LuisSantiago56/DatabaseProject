package PlainObjects;

import java.sql.Date;

public class Request {

	private long reqid;
	private Date reqdate;
	private long cid;
	private long rid;
	private int qty;
	private long locid;
	
	public long getReqid() {
		return reqid;
	}
	public void setReqid(long reqid) {
		this.reqid = reqid;
	}
	public Date getReqdate() {
		return reqdate;
	}
	public void setReqdate(Date reqdate) {
		this.reqdate = reqdate;
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public long getLocid() {
		return locid;
	}
	public void setLocid(long locid) {
		this.locid = locid;
	}
	@Override
	public String toString() {
		return "Request [reqid=" + reqid + ", reqdate=" + reqdate + ", cid=" + cid + ", rid=" + rid + ", qty=" + qty
				+ ", locid=" + locid + "]";
	}
	
	
}
