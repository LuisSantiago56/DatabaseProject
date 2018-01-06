package PlainObjects;

public class Location {

	private long locid;
	private String latitude;
	private String longitud;
	
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
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	@Override
	public String toString() {
		return "Location [locid=" + locid + ", latitude=" + latitude + ", longitud=" + longitud + "]";
	}

}
