package PlainObjects;

public class Location {

	private long locid;
	private String latitude;
	private String longitude;
	
	public long getLocid() {
		return locid;
	}
	public void setLocid(long locid) {
		this.locid = locid;
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
		return "Location [locid=" + locid + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
