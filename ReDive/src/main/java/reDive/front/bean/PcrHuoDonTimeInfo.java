package reDive.front.bean;

public class PcrHuoDonTimeInfo {

	private Integer huoDonId;
	private String huoDonName;
	private String huoDonStart;
	private String huoDonEnd;
	private String huoDonBeiZhu;
	public PcrHuoDonTimeInfo() {
		super();
	}
	public PcrHuoDonTimeInfo(Integer huoDonId, String huoDonName, String huoDonStart, String huoDonEnd,
			String huoDonBeiZhu) {
		super();
		this.huoDonId = huoDonId;
		this.huoDonName = huoDonName;
		this.huoDonStart = huoDonStart;
		this.huoDonEnd = huoDonEnd;
		this.huoDonBeiZhu = huoDonBeiZhu;
	}
	public Integer getHuoDonId() {
		return huoDonId;
	}
	public String getHuoDonName() {
		return huoDonName;
	}
	public String getHuoDonStart() {
		return huoDonStart;
	}
	public String getHuoDonEnd() {
		return huoDonEnd;
	}
	public String getHuoDonBeiZhu() {
		return huoDonBeiZhu;
	}
	public void setHuoDonId(Integer huoDonId) {
		this.huoDonId = huoDonId;
	}
	public void setHuoDonName(String huoDonName) {
		this.huoDonName = huoDonName;
	}
	public void setHuoDonStart(String huoDonStart) {
		this.huoDonStart = huoDonStart;
	}
	public void setHuoDonEnd(String huoDonEnd) {
		this.huoDonEnd = huoDonEnd;
	}
	public void setHuoDonBeiZhu(String huoDonBeiZhu) {
		this.huoDonBeiZhu = huoDonBeiZhu;
	}
	
	
}
