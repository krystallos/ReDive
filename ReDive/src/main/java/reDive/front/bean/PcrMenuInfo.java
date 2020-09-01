package reDive.front.bean;

import java.util.List;

public class PcrMenuInfo {

	private Integer menuId;
	private String menuName;
	private String menuUrl;
	private Integer pMenuId;
	private String menuIcon;
	private List<PcrMenuInfo> menuList;
	public PcrMenuInfo() {
		super();
	}
	public PcrMenuInfo(Integer menuId, String menuName, String menuUrl, Integer pMenuId, String menuIcon, List<PcrMenuInfo> menuList) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.pMenuId = pMenuId;
		this.menuIcon = menuIcon;
		this.menuList = menuList;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public Integer getpMenuId() {
		return pMenuId;
	}
	public String getMenuIcon() {
		return menuIcon;
	}
	public List<PcrMenuInfo> getMenuList() { return menuList; }
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public void setpMenuId(Integer pMenuId) {
		this.pMenuId = pMenuId;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	public void setMenuList(List<PcrMenuInfo> menuList){ this.menuList = menuList; }
}
