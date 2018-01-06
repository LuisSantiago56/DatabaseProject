package PlainObjects;

public class Category {
	
	private long catid;
	private String catname;
	
	public long getCategoryId() {
		return catid;
	}
	public void setCategoryId(long catid) {
		this.catid = catid;
	}
	public String getCategoryName() {
		return catname;
	}
	public void setCategoryName(String catname) {
		this.catname = catname;
	}
	@Override
	public String toString() {
		return "Category [catid=" + catid + ", catname=" + catname + "]";
	}
}
