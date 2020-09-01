package reDive.front.bean;

public class PcrZhenShiInfo {

	private Integer zhenShiId;
	private String zhenShiType;
	private Integer zhenShiDaoType;
	private Integer zhenShiShangHai;
	private String zhenShiBossId;
	private String zhenShiCtime;
	private String zhenShiUserId;
	private String gonHuiId;
	public PcrZhenShiInfo() {
		super();
	}
	public PcrZhenShiInfo(Integer zhenShiId, String zhenShiType, Integer zhenShiDaoType, Integer zhenShiShangHai,
			String zhenShiBossId, String zhenShiCtime, String zhenShiUserId, String gonHuiId) {
		super();
		this.zhenShiId = zhenShiId;
		this.zhenShiType = zhenShiType;
		this.zhenShiDaoType = zhenShiDaoType;
		this.zhenShiShangHai = zhenShiShangHai;
		this.zhenShiBossId = zhenShiBossId;
		this.zhenShiCtime = zhenShiCtime;
		this.zhenShiUserId = zhenShiUserId;
		this.gonHuiId = gonHuiId;
	}
	public Integer getZhenShiId() {
		return zhenShiId;
	}
	public String getZhenShiType() {
		return zhenShiType;
	}
	public Integer getZhenShiDaoType() {
		return zhenShiDaoType;
	}
	public Integer getZhenShiShangHai() {
		return zhenShiShangHai;
	}
	public String getZhenShiBossId() {
		return zhenShiBossId;
	}
	public String getZhenShiCtime() {
		return zhenShiCtime;
	}
	public String getZhenShiUserId() {
		return zhenShiUserId;
	}
	public String getGonHuiId() {
		return gonHuiId;
	}
	public void setZhenShiId(Integer zhenShiId) {
		this.zhenShiId = zhenShiId;
	}
	public void setZhenShiType(String zhenShiType) {
		this.zhenShiType = zhenShiType;
	}
	public void setZhenShiDaoType(Integer zhenShiDaoType) {
		this.zhenShiDaoType = zhenShiDaoType;
	}
	public void setZhenShiShangHai(Integer zhenShiShangHai) {
		this.zhenShiShangHai = zhenShiShangHai;
	}
	public void setZhenShiBossId(String zhenShiBossId) {
		this.zhenShiBossId = zhenShiBossId;
	}
	public void setZhenShiCtime(String zhenShiCtime) {
		this.zhenShiCtime = zhenShiCtime;
	}
	public void setZhenShiUserId(String zhenShiUserId) {
		this.zhenShiUserId = zhenShiUserId;
	}
	public void setGonHuiId(String gonHuiId) {
		this.gonHuiId = gonHuiId;
	}
	
}
