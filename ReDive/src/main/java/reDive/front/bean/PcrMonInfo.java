package reDive.front.bean;

public class PcrMonInfo {

	private Integer moniId;
	private String moniType;
	private String moniDao;
	private String moniShangHai;
	private String moniBossId;
	private String MoniCtime;
	private String moniUserId;
	private String MoniOtime;
	private String gonHuiId;
	public PcrMonInfo() {
		super();
	}
	public PcrMonInfo(Integer moniId, String moniType, String moniDao, String moniShangHai, String moniBossId,
			String moniCtime, String moniUserId, String MoniOtime,String gonHuiId) {
		super();
		this.moniId = moniId;
		this.moniType = moniType;
		this.moniDao = moniDao;
		this.moniShangHai = moniShangHai;
		this.moniBossId = moniBossId;
		this.MoniCtime = moniCtime;
		this.moniUserId = moniUserId;
		this.MoniOtime = MoniOtime;
		this.gonHuiId = gonHuiId;
	}
	
	public String getGonHuiId() {
		return gonHuiId;
	}
	public void setGonHuiId(String gonHuiId) {
		this.gonHuiId = gonHuiId;
	}
	public String getMoniOtime() {
		return MoniOtime;
	}
	public void setMoniOtime(String moniOtime) {
		MoniOtime = moniOtime;
	}
	public Integer getMoniId() {
		return moniId;
	}
	public String getMoniType() {
		return moniType;
	}
	public String getMoniDao() {
		return moniDao;
	}
	public String getMoniShangHai() {
		return moniShangHai;
	}
	public String getMoniBossId() {
		return moniBossId;
	}
	public String getMoniCtime() {
		return MoniCtime;
	}
	public String getMoniUserId() {
		return moniUserId;
	}
	public void setMoniId(Integer moniId) {
		this.moniId = moniId;
	}
	public void setMoniType(String moniType) {
		this.moniType = moniType;
	}
	public void setMoniDao(String moniDao) {
		this.moniDao = moniDao;
	}
	public void setMoniShangHai(String moniShangHai) {
		this.moniShangHai = moniShangHai;
	}
	public void setMoniBossId(String moniBossId) {
		this.moniBossId = moniBossId;
	}
	public void setMoniCtime(String moniCtime) {
		MoniCtime = moniCtime;
	}
	public void setMoniUserId(String moniUserId) {
		this.moniUserId = moniUserId;
	}
	
}
