package reDive.front.bean;

public class PcrMailInfo {

	private Integer mailId;
	private String mailName;
	private String mailUserId;
	private String mailType;
	public PcrMailInfo() {
		super();
	}
	public PcrMailInfo(Integer mailId, String mailName, String mailUserId, String mailType) {
		super();
		this.mailId = mailId;
		this.mailName = mailName;
		this.mailUserId = mailUserId;
		this.mailType = mailType;
	}
	public Integer getMailId() {
		return mailId;
	}
	public String getMailName() {
		return mailName;
	}
	public String getMailUserId() {
		return mailUserId;
	}
	public String getMailType() {
		return mailType;
	}
	public void setMailId(Integer mailId) {
		this.mailId = mailId;
	}
	public void setMailName(String mailName) {
		this.mailName = mailName;
	}
	public void setMailUserId(String mailUserId) {
		this.mailUserId = mailUserId;
	}
	public void setMailType(String mailType) {
		this.mailType = mailType;
	}
	
	
}
