package PlainObjects;

public class ResourceSearch {
	private int rid;
	private String rname;
	private String catname;
	private String subcatname;
	private int qtyperpk;
	private float rprice;
	
	public int getRid() {
		return rid;
	}
	
	public void setId(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
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
	public int getQtyperpk() {
		return qtyperpk;
	}
	public void setQtyperpk(int qtyperpk) {
		this.qtyperpk = qtyperpk;
	}
	public float getRprice() {
		return rprice;
	}
	public void setRprice(float rprice) {
		this.rprice = rprice;
	}
	@Override
	public String toString() {
		return "ResourceSearch [rname=" + rname + ", catname=" + catname + ", subcatname=" + subcatname + ", qtyperpk="
				+ qtyperpk + ", rprice=" + rprice + "]";
	}
	
}
