package reDive.front.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import reDive.front.bean.JsonMessage;
import reDive.front.bean.PcrPersonInfo;
import reDive.front.bean.PcrUserInfo;
import reDive.front.bean.PcrZhenShiDaoTypeInfo;
import reDive.front.service.PerSonServiceImpl;
import reDive.front.service.ZhenShiDaoTypeServiceImpl;

@RestController
public class PerSonConteroller {

	@Resource
	private PerSonServiceImpl perSonSerivceImpl;
	@Resource
	private ZhenShiDaoTypeServiceImpl zhenShiDaoTypeServiceImpl;
	
	@PostMapping("renwuchaxun.act")
	public void baocunshanghai(String newnames,HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		List<PcrPersonInfo> list = perSonSerivceImpl.selectlinklook("前卫");
		List<PcrPersonInfo> lists = perSonSerivceImpl.selectlinklook("中卫");
		List<PcrPersonInfo> listss = perSonSerivceImpl.selectlinklook("后卫");
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("qian", list);
		datas.put("zhon", lists);
		datas.put("hou", listss);
		msg.setDatas(datas);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("baocunpco.act")
	public void baocunpco(String daoone,String daotwo,String daothree,String daofour,String daofive,
			HttpSession session,HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrUserInfo userinfo = (PcrUserInfo) session.getAttribute("userFront");
		System.out.println(daoone+"/"+daotwo+"/"+daothree+"/"+daofour+"/"+daofive+"/"+userinfo.getUserUid()+"");
		Integer b = zhenShiDaoTypeServiceImpl.selectalltonji(userinfo.getUserUid()+"");
		if(b<5) {
			Integer a = zhenShiDaoTypeServiceImpl.insertdaotype(daoone, daotwo, daothree, daofour, daofive, userinfo.getUserUid()+"");
			if(a>0) {
				msg.setId(1);
				msg.setMsg("添加阵容成功!");
			}else {
				msg.setId(2);
				msg.setMsg("添加阵容失败....");
			}
		}else {
			msg.setId(2);
			msg.setMsg("阵容数量已达上限!");
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("chuzhanduiwuchakan.act")
	public void chuzhanduiwuchakan(String newnames,HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrUserInfo userinfo = (PcrUserInfo) session.getAttribute("userFront");
		//查路径
		List<PcrZhenShiDaoTypeInfo> list = zhenShiDaoTypeServiceImpl.selectuserpsolook(userinfo.getUserUid()+"");
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("duiwu", list);
		msg.setDatas(datas);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("xiugaisiduiwu.act")
	public void xiugaisiduiwu(String duiwuid,String duiwuname,HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrUserInfo userinfo = (PcrUserInfo) session.getAttribute("userFront");
		//改名称
		Integer a = zhenShiDaoTypeServiceImpl.updateduiwuname(duiwuname, duiwuid, userinfo.getUserUid()+"");
		if(a>0) {
			msg.setId(1);
			msg.setMsg("修改成功");
		}else {
			msg.setId(2);
			msg.setMsg("修改失败");
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("delsduiwu.act")
	public void delsduiwu(String ids,HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrUserInfo userinfo = (PcrUserInfo) session.getAttribute("userFront");
		//删队伍
		Integer a = zhenShiDaoTypeServiceImpl.delduiwu(ids, userinfo.getUserUid()+"");
		if(a>0) {
			msg.setId(1);
			msg.setMsg("删除成功");
		}else {
			msg.setId(2);
			msg.setMsg("删除失败");
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
}
