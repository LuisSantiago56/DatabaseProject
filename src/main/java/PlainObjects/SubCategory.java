package PlainObjects;

public class SubCategory {

	private long subcatid;
	private String subcatname;
	
	public long getSubCategoryId() {
		return subcatid;
	}
	public void setSubCategoryId(long subcatid) {
		this.subcatid = subcatid;
	}
	public String getSubCategoryName() {
		return subcatname;
	}
	public void setSubCategoryName(String subcatname) {
		this.subcatname = subcatname;
	}
	@Override
	public String toString() {
		return "SubCategory [subcatid=" + subcatid + ", subcatname=" + subcatname + "]";
	}
}
