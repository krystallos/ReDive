package reDive.front.bean;

public class PcrGonHuiInfo {

	private Integer gId;
	private String gName;
	private String gBoss;
	private String gRenShu;
	public PcrGonHuiInfo() {
		super();
	}
	public PcrGonHuiInfo(Integer gId, String gName, String gBoss, String gRenShu) {
		super();
		this.gId = gId;
		this.gName = gName;
		this.gBoss = gBoss;
		this.gRenShu = gRenShu;
	}
	public Integer getgId() {
		return gId;
	}
	public String getgName() {
		return gName;
	}
	public String getgBoss() {
		return gBoss;
	}
	public String getgRenShu() {
		return gRenShu;
	}
	public void setgId(Integer gId) {
		this.gId = gId;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public void setgBoss(String gBoss) {
		this.gBoss = gBoss;
	}
	public void setgRenShu(String gRenShu) {
		this.gRenShu = gRenShu;
	}
	
}
