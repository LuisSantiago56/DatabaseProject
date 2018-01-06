package PlainObjects;

public class Resources {

	private long id;
	private String name;
	private int qtyperpk;
	private float price;
	private long catid;
	private long subcatid;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQtyPerPk() {
		return qtyperpk;
	}
	public void setQtyPerPk(int qtyperpk) {
		this.qtyperpk = qtyperpk;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public long getCatId() {
		return catid;
	}
	public void setCatId(long catid) {
		this.catid = catid;
	}
	public long getSubCatId() {
		return subcatid;
	}
	public void setSubCatId(long subcatid) {
		this.subcatid = subcatid;
	}
	@Override
	public String toString() {
		return "Resources [id=" + id + ", name=" + name + ", qtyperpk=" + qtyperpk + ", price=" + price + ", catid="
				+ catid + ", subcatid=" + subcatid + "]";
	}
	
}
