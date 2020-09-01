package reDive.front.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import reDive.front.bean.JsonMessage;
import reDive.front.bean.PcrUserInfo;
import reDive.front.service.LoginServiceImpl;

@RestController
public class MyMineConteroller {

	@Resource
	private LoginServiceImpl loginServiceImpl;
	
	@PostMapping("updatename.act")
	public void baocunshanghai(String newnames,HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrUserInfo userinfo = (PcrUserInfo) session.getAttribute("userFront");
		Integer a = loginServiceImpl.updatenames(newnames, userinfo.getUserUid()+"");
		userinfo.setUserName(newnames);
		Map<String, Object> datas = new HashMap<String, Object>();
		request.getSession().setAttribute("userFront",userinfo);
		datas.put("userFront", userinfo);
		if(a>0) {
			msg.setMsg("修改成功,名字将在下次登入生效");
			msg.setDatas(datas);
		}else {
			msg.setMsg("修改失败");
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
}
