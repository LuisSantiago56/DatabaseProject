package PlainObjects;

public class Supplies {

	private long supid;
	private long sid;
	private long rid;
	private float supprice;
	private int stock;
	private String rname;
	private int qtyperpk;
	private String catname;
	private String subcatname;
	
	
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getQtyperpk() {
		return qtyperpk;
	}
	public void setQtyperpk(int qtyperpk) {
		this.qtyperpk = qtyperpk;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public String getSubcatname() {
		return subcatname;
	}
	public void setSubcatname(String subcatname) {
		this.subcatname = subcatname;
	}
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
	@Override
	public String toString() {
		return "Supplies [supid=" + supid + ", sid=" + sid + ", rid=" + rid + ", supprice=" + supprice + ", stock="
				+ stock + ", rname=" + rname + ", qtyperpk=" + qtyperpk + ", catname=" + catname + ", subcatname="
				+ subcatname + "]";
	}
	
}
