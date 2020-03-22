package domain;

public class Video {
	private String id;
	private String name;
	private String vright;
	private String descp;
	private int watchVolume;
	private String date;
	private String url;
//	String test="";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRight() {
		return vright;
	}
	public void setRight(String vright) {
		this.vright = vright;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	public int getWatchVolume() {
		return watchVolume;
	}
	public void setWatchVolume(int watchVolume) {
		this.watchVolume = watchVolume;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
