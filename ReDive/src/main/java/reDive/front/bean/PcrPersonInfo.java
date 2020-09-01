package reDive.front.bean;

public class PcrPersonInfo {

	private Integer perSonId;
	private String PerSonName;
	private String perSonIco;
	private Integer perSonRank;
	private String perSonTps;
	private Integer perSonGoRank;
	public PcrPersonInfo() {
		super();
	}
	public PcrPersonInfo(Integer perSonId, String perSonName, String perSonIco, Integer perSonRank, String perSonTps,
			Integer perSonGoRank) {
		super();
		this.perSonId = perSonId;
		PerSonName = perSonName;
		this.perSonIco = perSonIco;
		this.perSonRank = perSonRank;
		this.perSonTps = perSonTps;
		this.perSonGoRank = perSonGoRank;
	}
	public Integer getPerSonId() {
		return perSonId;
	}
	public String getPerSonName() {
		return PerSonName;
	}
	public String getPerSonIco() {
		return perSonIco;
	}
	public Integer getPerSonRank() {
		return perSonRank;
	}
	public String getPerSonTps() {
		return perSonTps;
	}
	public Integer getPerSonGoRank() {
		return perSonGoRank;
	}
	public void setPerSonId(Integer perSonId) {
		this.perSonId = perSonId;
	}
	public void setPerSonName(String perSonName) {
		PerSonName = perSonName;
	}
	public void setPerSonIco(String perSonIco) {
		this.perSonIco = perSonIco;
	}
	public void setPerSonRank(Integer perSonRank) {
		this.perSonRank = perSonRank;
	}
	public void setPerSonTps(String perSonTps) {
		this.perSonTps = perSonTps;
	}
	public void setPerSonGoRank(Integer perSonGoRank) {
		this.perSonGoRank = perSonGoRank;
	}
	
	
}
