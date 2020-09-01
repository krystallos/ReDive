package reDive.front.bean;

import java.util.HashMap;
import java.util.Map;

public class JsonMessage {
	private int id;//编号
	private String msg;//消息
	private String location;//跳转路径
	private Map<String,Object> datas=new HashMap<String,Object>();
	public JsonMessage() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Map<String, Object> getDatas() {
		return datas;
	}
	public void setDatas(Map<String, Object> datas) {
		this.datas = datas;
	}
	public JsonMessage(int id, String msg, String location, Map<String, Object> datas) {
		super();
		this.id = id;
		this.msg = msg;
		this.location = location;
		this.datas = datas;
	}
	
	
}
