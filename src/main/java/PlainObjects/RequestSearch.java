package PlainObjects;

import java.sql.Date;

public class RequestSearch {
	private Date reqdate;
	private String cname;
	private String rname;
	private String sname;
	private int qty;
	private String latitude;
	private String longitude;
	
	
	public Date getReqdate() {
		return reqdate;
	}
	public void setReqdate(Date reqdate) {
		this.reqdate = reqdate;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
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
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "RequestSearch [reqdate=" + reqdate + ", cname=" + cname + ", rname=" + rname + ", sname=" + sname
				+ ", qty=" + qty + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
}
