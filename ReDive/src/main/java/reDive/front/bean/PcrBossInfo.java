package reDive.front.bean;

public class PcrBossInfo {

	private Integer bossId;
	private String bossName;
	private String bossOn;
	private Integer bossAllHp;
	private Integer bossNowHp;
	private Integer bossLv;
	private String bossRole;
	private String bossStart;
	private Integer bossShunXu;
	public PcrBossInfo() {
		super();
	}
	public PcrBossInfo(Integer bossId, String bossName, String bossOn, Integer bossAllHp, Integer bossNowHp,
			Integer bossLv, String bossRole, String bossStart, Integer bossShunXu) {
		super();
		this.bossId = bossId;
		this.bossName = bossName;
		this.bossOn = bossOn;
		this.bossAllHp = bossAllHp;
		this.bossNowHp = bossNowHp;
		this.bossLv = bossLv;
		this.bossRole = bossRole;
		this.bossStart = bossStart;
		this.bossShunXu = bossShunXu;
	}
	
	public String getBossStart() {
		return bossStart;
	}
	public Integer getBossShunXu() {
		return bossShunXu;
	}
	public void setBossStart(String bossStart) {
		this.bossStart = bossStart;
	}
	public void setBossShunXu(Integer bossShunXu) {
		this.bossShunXu = bossShunXu;
	}
	public String getBossRole() {
		return bossRole;
	}
	public void setBossRole(String bossRole) {
		this.bossRole = bossRole;
	}
	public Integer getBossId() {
		return bossId;
	}
	public String getBossName() {
		return bossName;
	}
	public String getBossOn() {
		return bossOn;
	}
	public Integer getBossAllHp() {
		return bossAllHp;
	}
	public Integer getBossNowHp() {
		return bossNowHp;
	}
	public Integer getBossLv() {
		return bossLv;
	}
	public void setBossId(Integer bossId) {
		this.bossId = bossId;
	}
	public void setBossName(String bossName) {
		this.bossName = bossName;
	}
	public void setBossOn(String bossOn) {
		this.bossOn = bossOn;
	}
	public void setBossAllHp(Integer bossAllHp) {
		this.bossAllHp = bossAllHp;
	}
	public void setBossNowHp(Integer bossNowHp) {
		this.bossNowHp = bossNowHp;
	}
	public void setBossLv(Integer bossLv) {
		this.bossLv = bossLv;
	}
	
}
