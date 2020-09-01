package reDive.front.bean;

import java.sql.Date;

public class PcrUserInfo {

	private Integer userUid;
	private String userPass;
	private String userName;
	private String userState;
	private Date userDate;
	private String userGonhui;
	private String userAcctent;
	private String userRole;
	public PcrUserInfo() {
		super();
	}
	public PcrUserInfo(Integer userUid, String userPass, String userName, String userState, Date userDate,
			String userGonhui,String userAcctent,String userRole) {
		super();
		this.userUid = userUid;
		this.userPass = userPass;
		this.userName = userName;
		this.userState = userState;
		this.userDate = userDate;
		this.userGonhui = userGonhui;
		this.userAcctent = userAcctent;
		this.userRole = userRole;
	}
	
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserAcctent() {
		return userAcctent;
	}
	public void setUserAcctent(String userAcctent) {
		this.userAcctent = userAcctent;
	}
	public Integer getUserUid() {
		return userUid;
	}
	public String getUserPass() {
		return userPass;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserState() {
		return userState;
	}
	public Date getUserDate() {
		return userDate;
	}
	public String getUserGonhui() {
		return userGonhui;
	}
	public void setUserUid(Integer userUid) {
		this.userUid = userUid;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}
	public void setUserGonhui(String userGonhui) {
		this.userGonhui = userGonhui;
	}
	
}
