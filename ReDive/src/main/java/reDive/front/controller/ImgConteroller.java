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
import reDive.front.bean.PcrImgInfo;
import reDive.front.service.ImgServiceImpl;

@RestController
public class ImgConteroller {

	@Resource
	private ImgServiceImpl imgServiceImpl;
	
	@PostMapping("img.act")
	public void img(
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Map<String, Object> datas = new HashMap<String, Object>();
		List<PcrImgInfo> list = imgServiceImpl.selectimg();
		datas.put("img", list);
		msg.setDatas(datas);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
}
