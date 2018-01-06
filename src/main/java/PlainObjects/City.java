package PlainObjects;

public class City {

	private long cityId;
	private String cityName;
	private int region;
	
	public long getCityId() {
		return cityId;
	}
	public void setCityId(long cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", region=" + region + "]";
	}
	
}
