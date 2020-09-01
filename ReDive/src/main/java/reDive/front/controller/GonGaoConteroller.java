package reDive.front.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import reDive.front.bean.PcrGonGaoInfo;
import reDive.front.bean.PcrHuoDonTimeInfo;
import reDive.front.bean.PcrUserInfo;
import reDive.front.service.GonGaoServiceImpl;
import reDive.front.service.HuoDonTimeServiceImpl;

@RestController
public class GonGaoConteroller {

	@Resource
	private GonGaoServiceImpl gonGaoServiceImpl;
	@Resource
	private HuoDonTimeServiceImpl huoDonTimeServiceImpl;
	
	@PostMapping("glygongao.act")
	public void glygongao(String gongaoid, String gongaogonhui,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Map<String, Object> datas = new HashMap<String, Object>();
		List<PcrGonGaoInfo> list = gonGaoServiceImpl.selectGongao(gongaoid,gongaogonhui);
		datas.put("glygongao", list);
		msg.setDatas(datas);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}

	@PostMapping("zuozhegongaotianxie.act")
	public void zuozhegongaotianxie(String gongaotype,String gongaobiaoti,String gongaotext,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Integer a = gonGaoServiceImpl.insertgongao(gongaotype, gongaobiaoti, gongaotext, "3","");
		if(a>0) {
			msg.setMsg("添加成功"+a+"条");
		}else {
			msg.setMsg("添加失败");
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("huizhanggongaotianxie.act")
	public void huizhanggongaotianxie(String gongaotype,String gongaobiaoti,String gongaotext,String gongaogonhui,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Integer a = gonGaoServiceImpl.insertgongao(gongaotype, gongaobiaoti, gongaotext, "2",gongaogonhui);
		if(a>0) {
			msg.setMsg("添加成功"+a+"条");
		}else {
			msg.setMsg("添加失败");
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("chaxunzuixingongao.act")
	public void chaxunzuixingongao(
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Map<String, Object> datas = new HashMap<String, Object>();
		List<PcrGonGaoInfo> list = new ArrayList<PcrGonGaoInfo>();
		list.add(gonGaoServiceImpl.selectnewGongao("2"));
		list.add(gonGaoServiceImpl.selectnewGongao("3"));
		datas.put("newgongao", list);
		msg.setDatas(datas);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("huodontime.act")
	public void huodontime(
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Map<String, Object> datas = new HashMap<String, Object>();
		List<PcrHuoDonTimeInfo> list = huoDonTimeServiceImpl.selectnowyhuodon();
		datas.put("huodontime", list);
		msg.setDatas(datas);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("addnewhuodon.act")
	public void addnewhuodon(String huodonname,String start,String end ,String beizhu,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrHuoDonTimeInfo huodon = new PcrHuoDonTimeInfo();
		huodon.setHuoDonName(huodonname);
		huodon.setHuoDonStart(start);
		huodon.setHuoDonEnd(end);
		huodon.setHuoDonBeiZhu(beizhu);
		int a = huoDonTimeServiceImpl.inserthuodon(huodon);
		if(a>0) {
			msg.setId(1);
			msg.setMsg("添加成功!");
		}else {
			msg.setId(2);
			msg.setMsg("添加失败");
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
}
