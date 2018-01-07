package PlainObjects;

public class Supplies {

	private long supid;
	private long sid;
	private long rid;
	private float supprice;
	private int stock;
	private long cityid;
	
	public long getSupid() {
		return supid;
	}
	public void setSupid(long supid) {
		this.supid = supid;
	}
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public long getRid() {
		return rid;
	}
	public void setRid(long rid) {
		this.rid = rid;
	}
	public float getSupprice() {
		return supprice;
	}
	public void setSupprice(float supprice) {
		this.supprice = supprice;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public long getCityid() {
		return cityid;
	}
	public void setCityid(long cityid) {
		this.cityid = cityid;
	}
	@Override
	public String toString() {
		return "Supplies [supid=" + supid + ", sid=" + sid + ", rid=" + rid + ", supprice=" + supprice + ", stock="
				+ stock + ", cityid=" + cityid + "]";
	}
	
}
