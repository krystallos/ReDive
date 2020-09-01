package reDive.front.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import reDive.front.bean.JsonMessage;
import reDive.front.bean.PcrGonHuiInfo;
import reDive.front.bean.PcrUserInfo;
import reDive.front.service.GonHuiServiceImpl;
import reDive.front.service.LoginServiceImpl;

@RestController
public class GonHuiConteroller {

	@Resource
	private GonHuiServiceImpl gonHuiServiceImpl;
	@Resource
	private LoginServiceImpl loginServiceImpl;
	
	@PostMapping("chaxungonhui.act")
	public void chaxungonhui(String gonhuiid,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Map<String, Object> datas = new HashMap<String, Object>();
		List<PcrGonHuiInfo> list = gonHuiServiceImpl.selectGonhui(gonhuiid);
		datas.put("gonhui", list);
		msg.setDatas(datas);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("baochungonhui.act")
	public void baochungonhui(
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		Integer b = 0;
		if(user.getUserGonhui()!=null) {
			b = loginServiceImpl.selectgonhuirenshu(user.getUserGonhui()+"");
		}
//		if(b>=30) {
//			msg.setId(2);
//			msg.setMsg("加入失败,人数已满");
//		}else {
//			Integer a = loginServiceImpl.updateusergonhui(gonhuiid, names);
//			if(a>0) {
//				msg.setId(1);
//				msg.setMsg("加入成功");
//			}else {
//				msg.setId(2);
//				msg.setMsg("加入失败");
//			}
//		}
		msg.setId(b);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("chaxunyonhumingchens.act")
	public void chaxunyonhumingchens(String useracctent,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Map<String, Object> datas = new HashMap<String, Object>();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		List<PcrUserInfo> list = loginServiceImpl.selectusername(useracctent, user.getUserGonhui()+"");
		datas.put("user", list);
		msg.setDatas(datas);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("chaxunyonhumingchen.act")
	public void chaxunyonhumingchen(String useracctent,String type,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Map<String, Object> datas = new HashMap<String, Object>();
		List<PcrUserInfo> list = loginServiceImpl.selectuseracctent(useracctent,type);
		datas.put("user", list);
		msg.setDatas(datas);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("tianjiayonhugonhui.act")
	public void tianjiayonhugonhui(String uid,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		Integer a = loginServiceImpl.updateusergonhui(user.getUserGonhui()+"", uid);
		if(a>0) {
			msg.setMsg("添加成功");
		}else {
			msg.setMsg("添加失败");
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("chaxunquanbuyonhu.act")
	public void chaxunquanbuyonhu(String now,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Map<String, Object> datas = new HashMap<String, Object>();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		if(user.getUserGonhui()==null) {
			msg.setMsg("1");
		}else {
			Integer a = loginServiceImpl.selectgonhuirenshu(user.getUserGonhui()+"");
			int litem = 6;
			now = Integer.valueOf(now)*litem - litem+"";
			if(a % litem !=0) {
				a = a/litem + 1;
			}else {
				a = a/litem;
			}
			List<PcrUserInfo> list = loginServiceImpl.selectusergonhuiall(user.getUserGonhui()+"",now,litem+"",user.getUserAcctent());
			datas.put("gonhuichengyuan", list);
			datas.put("allpage", a);
			msg.setDatas(datas);
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("delyonhugonhui.act")
	public void delyonhugonhui(String uid,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Integer a = loginServiceImpl.updateusergonhui("", uid);
		if(a>0) {			
			msg.setMsg("移出成功");
		}else {
			msg.setMsg("移出失败");
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}

	@PostMapping("delyonhugonhuiid.act")
	public void delyonhugonhuiid(String uid,
							   HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Integer a = loginServiceImpl.updateusergonhuiid("", uid);
		if(a>0) {
			msg.setMsg("退出成功，您将在1秒后退回至登入界面");
		}else {
			msg.setMsg("退出失败");
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}

	private Integer gonhuiid = null;
	
	@PostMapping("jiesangonhui.act")
	public void jiesangonhui(
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		Integer a = loginServiceImpl.updatejiesangonhui("", user.getUserGonhui()+"");
		Integer b = gonHuiServiceImpl.delGonhui(user.getUserGonhui()+"");
		user = loginServiceImpl.selectuser(user.getUserAcctent(), user.getUserPass());
		if(a>0 & b>0) {
			msg.setMsg("解散完成");
			gonhuiid = Integer.valueOf(user.getUserGonhui());
		}else {
			msg.setMsg("失败");
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("baocungonhuiadd.act")
	public void baocungonhuiadd(String gonhuiname,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrGonHuiInfo pcrGonHuiInfo = new PcrGonHuiInfo();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		pcrGonHuiInfo.setgName(gonhuiname);
		pcrGonHuiInfo.setgBoss(user.getUserUid()+"");
		if(gonhuiid==null) {
			Integer a = gonHuiServiceImpl.insertGonhui(pcrGonHuiInfo);
			Integer b = loginServiceImpl.updateusergonhui(pcrGonHuiInfo.getgId()+"", user.getUserAcctent()+"");
			if(a>0 && b>0) {
				msg.setMsg("建立完成");
				user = loginServiceImpl.selectuser(user.getUserAcctent(), user.getUserPass());
				request.getSession().setAttribute("userFront",user);
			}else {
				msg.setMsg("失败");
			}
		}else {
				msg.setMsg("您已经拥有一个工会，如需建立需要解散目前工会");
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}

	@PostMapping("adminuserlook.act")
	public void adminuserlook(String now,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		JsonMessage msg = new JsonMessage();
		Map<String, Object> datas = new HashMap<String, Object>();
		int b = gonHuiServiceImpl.selectListAdminPage();
		int litem = 6;
		request.setCharacterEncoding("UTF-8");
		now = Integer.valueOf(now)*litem - litem+"";
		if(b % litem !=0) {
			b = b/litem + 1;
		}else {
			b = b/litem;
		}
		List<PcrUserInfo> list = gonHuiServiceImpl.selectListAdmin(now,litem);
		datas.put("list",list);
		datas.put("allpage",b);
		msg.setDatas(datas);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}

	@PostMapping("adminuserdel.act")
	public void adminuserdel(String gonhui,String uid,HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		JsonMessage msg = new JsonMessage();
		int a = gonHuiServiceImpl.selectCountAdmin(gonhui);
		if(a==1 || a<1){
			 msg.setMsg("不可移除，该工会会长权限仅有一位，请先解散后移除");
		}else{
			int b = gonHuiServiceImpl.updateAdminUser(uid,gonhui,"1");
			if(b>0){
				msg.setMsg("移除成功");
			}else{
				msg.setMsg("移除失败");
			}
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}

	@PostMapping("adminUser.act")
	public void adminUser(String gonhui,String uid,HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		JsonMessage msg = new JsonMessage();
			int b = gonHuiServiceImpl.updateAdminUser(uid,gonhui,"2");
			if(b>0){
				msg.setMsg("添加成功");
			}else{
				msg.setMsg("添加失败");
			}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}

}
