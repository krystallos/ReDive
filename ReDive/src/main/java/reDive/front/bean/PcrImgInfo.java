package reDive.front.bean;

public class PcrImgInfo {

	private Integer imgId;
	private String imgName;
	private String imgUrl;
	public PcrImgInfo() {
		super();
	}
	public PcrImgInfo(Integer imgId, String imgName, String imgUrl) {
		super();
		this.imgId = imgId;
		this.imgName = imgName;
		this.imgUrl = imgUrl;
	}
	public Integer getImgId() {
		return imgId;
	}
	public String getImgName() {
		return imgName;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
