package reDive.front.bean;

public class PcrMd5Info {

	private Integer keyId;
	private String keyName;
	private String keyRole;
	private String keyUser;
	public PcrMd5Info() {
		super();
	}
	public PcrMd5Info(Integer keyId, String keyName, String keyRole, String keyUser) {
		super();
		this.keyId = keyId;
		this.keyName = keyName;
		this.keyRole = keyRole;
		this.keyUser = keyUser;
	}
	public Integer getKeyId() {
		return keyId;
	}
	public String getKeyName() {
		return keyName;
	}
	public String getKeyRole() {
		return keyRole;
	}
	public String getKeyUser() {
		return keyUser;
	}
	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public void setKeyRole(String keyRole) {
		this.keyRole = keyRole;
	}
	public void setKeyUser(String keyUser) {
		this.keyUser = keyUser;
	}
	
}
