package reDive.front.bean;

import java.sql.Date;

public class PcrGonGaoInfo {

	private Integer gonGaoId;
	private String gonGaoName;
	private String gonGaoText;
	private String gonGaoRole;
	private Date gonGaoCtime;
	private String gonGaoDengJi;
	private String gonGaoGonHui;
	public PcrGonGaoInfo() {
		super();
	}
	public PcrGonGaoInfo(Integer gonGaoId, String gonGaoName, String gonGaoText, String gonGaoRole, Date gonGaoCtime, String gonGaoGonHui,
			String gonGaoDengJi) {
		super();
		this.gonGaoId = gonGaoId;
		this.gonGaoName = gonGaoName;
		this.gonGaoText = gonGaoText;
		this.gonGaoRole = gonGaoRole;
		this.gonGaoCtime = gonGaoCtime;
		this.gonGaoDengJi = gonGaoDengJi;
		this.gonGaoGonHui = gonGaoGonHui;
	}
	public Integer getGonGaoId() {
		return gonGaoId;
	}
	public String getGonGaoName() {
		return gonGaoName;
	}
	public String getGonGaoText() {
		return gonGaoText;
	}
	public String getGonGaoRole() {
		return gonGaoRole;
	}
	public Date getGonGaoCtime() {
		return gonGaoCtime;
	}
	public String getGonGaoDengJi() {
		return gonGaoDengJi;
	}
	public String getGonGaoGonHui() { return gonGaoGonHui; }
	public void setGonGaoId(Integer gonGaoId) {
		this.gonGaoId = gonGaoId;
	}
	public void setGonGaoName(String gonGaoName) {
		this.gonGaoName = gonGaoName;
	}
	public void setGonGaoText(String gonGaoText) {
		this.gonGaoText = gonGaoText;
	}
	public void setGonGaoRole(String gonGaoRole) {
		this.gonGaoRole = gonGaoRole;
	}
	public void setGonGaoCtime(Date gonGaoCtime) {
		this.gonGaoCtime = gonGaoCtime;
	}
	public void setGonGaoDengJi(String gonGaoDengJi) {
		this.gonGaoDengJi = gonGaoDengJi;
	}
	public void setGonGaoGonHui(String gonGaoGonHui) { this.gonGaoGonHui = gonGaoGonHui; }
	
}
