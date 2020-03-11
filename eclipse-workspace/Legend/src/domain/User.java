package domain;

public class User {

	private String openid;
	private String userRight;
	private String session_key;
	
	public User(){}
	public User(String openid, String session_key, String userRight){
		this.openid = openid;
		this.session_key = session_key;
		this.userRight = userRight;
	}
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getSession_key() {
		return session_key;
	}
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}
	public String getUserRight() {
		return userRight;
	}
	public void setUserRight(String userRight) {
		this.userRight = userRight;
	}
	
	public String toJson() {
		// TODO Auto-generated method stub
		return "{\"openid\":\"" + openid + "\", \"userRight\":\"" + userRight + "\", \"session_key\":\""+session_key+"\"}";
	}

}
