package reDive.front.bean;

public class PcrBossGonHuiInfo {

	private Integer bossGonHuiId;
	private Integer bossId;
	private String bossName;
	private Integer bossNowHp;
	private Integer bossAllHp;
	private Integer bossLv;
	private String bossType;
	private String gonHuiId;
	private Integer paiXu;
	public PcrBossGonHuiInfo() {
		super();
	}
	public PcrBossGonHuiInfo(Integer bossGonHuiId, Integer bossId, String bossName, Integer bossNowHp,
			Integer bossAllHp, Integer bossLv, String bossType, String gonHuiId, Integer paiXu) {
		super();
		this.bossGonHuiId = bossGonHuiId;
		this.bossId = bossId;
		this.bossName = bossName;
		this.bossNowHp = bossNowHp;
		this.bossAllHp = bossAllHp;
		this.bossLv = bossLv;
		this.bossType = bossType;
		this.gonHuiId = gonHuiId;
		this.paiXu = paiXu;
	}
	public Integer getBossGonHuiId() {
		return bossGonHuiId;
	}
	public Integer getBossId() {
		return bossId;
	}
	public String getBossName() {
		return bossName;
	}
	public Integer getBossNowHp() {
		return bossNowHp;
	}
	public Integer getBossAllHp() {
		return bossAllHp;
	}
	public Integer getBossLv() {
		return bossLv;
	}
	public String getBossType() {
		return bossType;
	}
	public String getGonHuiId() {
		return gonHuiId;
	}
	public Integer getpaiXu() {
		return paiXu;
	}
	public void setBossGonHuiId(Integer bossGonHuiId) {
		this.bossGonHuiId = bossGonHuiId;
	}
	public void setBossId(Integer bossId) {
		this.bossId = bossId;
	}
	public void setBossName(String bossName) {
		this.bossName = bossName;
	}
	public void setBossNowHp(Integer bossNowHp) {
		this.bossNowHp = bossNowHp;
	}
	public void setBossAllHp(Integer bossAllHp) {
		this.bossAllHp = bossAllHp;
	}
	public void setBossLv(Integer bossLv) {
		this.bossLv = bossLv;
	}
	public void setBossType(String bossType) {
		this.bossType = bossType;
	}
	public void setGonHuiId(String gonHuiId) {
		this.gonHuiId = gonHuiId;
	}
	public void setpaiXu(Integer paiXu) {
		this.paiXu = paiXu;
	}

}
