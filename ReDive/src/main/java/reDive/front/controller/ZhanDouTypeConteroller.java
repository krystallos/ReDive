package reDive.front.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import reDive.front.bean.JsonMessage;
import reDive.front.bean.PcrUserInfo;
import reDive.front.bean.PcrZhandouInfo;
import reDive.front.bean.PcrZhenShiDaoTypeInfo;
import reDive.front.service.ZhanDouTypeServiceImpl;
import reDive.front.service.ZhenShiDaoTypeServiceImpl;

@RestController
public class ZhanDouTypeConteroller {

	@Resource
	private ZhanDouTypeServiceImpl zhanDouTypeServiceImpl;
	@Resource
	private ZhenShiDaoTypeServiceImpl zhenShiDaoTypeServiceImpl;
	
	@PostMapping("zhandoutype.act")
	public void zhandoutype(HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg=new JsonMessage();
		PcrUserInfo userinfo = (PcrUserInfo) session.getAttribute("userFront");
			List<PcrZhandouInfo> list = zhanDouTypeServiceImpl.selectdaotype();
			List<PcrZhenShiDaoTypeInfo> lists = zhenShiDaoTypeServiceImpl.selectuserpsolookname(userinfo.getUserUid()+"");
			msg.getDatas().put("daotype", list);
			msg.getDatas().put("duitype", lists);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
}
