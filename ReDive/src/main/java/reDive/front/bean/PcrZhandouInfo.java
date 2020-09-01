package reDive.front.bean;

public class PcrZhandouInfo {

	private Integer zhanDouId;
	private String zhanDouType;
	public PcrZhandouInfo() {
		super();
	}
	public PcrZhandouInfo(Integer zhanDouId, String zhanDouType) {
		super();
		this.zhanDouId = zhanDouId;
		this.zhanDouType = zhanDouType;
	}
	public Integer getZhanDouId() {
		return zhanDouId;
	}
	public String getZhanDouType() {
		return zhanDouType;
	}
	public void setZhanDouId(Integer zhanDouId) {
		this.zhanDouId = zhanDouId;
	}
	public void setZhanDouType(String zhanDouType) {
		this.zhanDouType = zhanDouType;
	}
	
}
