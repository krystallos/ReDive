package reDive.front.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import reDive.front.bean.JsonMessage;
import reDive.front.bean.PcrMenuInfo;
import reDive.front.bean.PcrUserInfo;
import reDive.front.service.LeftMainServiceImpl;

@RestController
public class LeftMainController {

	@Resource
	private LeftMainServiceImpl leftMainServiceImpl;
	
	@PostMapping("Menu.act")
	public void Menu(HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg=new JsonMessage();
		PcrUserInfo userinfo = (PcrUserInfo) session.getAttribute("userFront");
			String roleId = userinfo.getUserRole();
			//查询结果
			List<PcrMenuInfo> list = leftMainServiceImpl.selectMenu(roleId);
			//存储结果
			List<PcrMenuInfo> father = new ArrayList<PcrMenuInfo>();
			//遍历PcrMenuInfo lists : list
			for(int b = 0;b<list.size();b++){
				//获取父级
				if(list.get(b).getpMenuId()==0){
					//子集结果
					List<PcrMenuInfo> chidList = new ArrayList<PcrMenuInfo>();
					for(int a = 0;a<list.size();a++){
						if(list.get(b).getMenuId() == list.get(a).getpMenuId()){
							chidList.add(list.get(a));
						}
					}
					list.get(b).setMenuList(chidList);
					father.add(list.get(b));
				}
			}
			msg.getDatas().put("menus", father);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
}
