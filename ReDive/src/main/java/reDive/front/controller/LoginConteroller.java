package reDive.front.controller;

/*import java.awt.image.BufferedImage;*/
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
//import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.imageio.ImageIO;
//import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import reDive.front.bean.JsonMessage;
import reDive.front.bean.PcrMailInfo;
import reDive.front.bean.PcrMd5Info;
import reDive.front.bean.PcrMonInfo;
import reDive.front.bean.PcrUserInfo;
import reDive.front.service.EmailServiceImpl;
import reDive.front.service.KeyServiceImpl;
import reDive.front.service.LoginServiceImpl;
import reDive.front.service.MailService;
import reDive.front.util.ExportExcel;

@RestController
public class LoginConteroller {

//	private String codese;
	
	@Resource
	private LoginServiceImpl impl;
	@Resource
	private KeyServiceImpl keyServiceImpl;
	@Resource
	private EmailServiceImpl emailSerivceImpl;
	@Autowired
    private MailService mailService;
	
	
//	//验证码
//		@GetMapping("image.act")
//		public void yanzm(HttpServletRequest request, HttpServletResponse response,
//				HttpSession session) throws IOException {
//			Map<String, BufferedImage> imagemap = ImageUtil.createImage();
//			String code = imagemap.keySet().iterator().next();
//			session.setAttribute("code", code);
//			codese = code;
//			BufferedImage image = imagemap.get(code);
//			ServletOutputStream out = response.getOutputStream();
//			ImageIO.write(image, "jpg", out);
//		}
		
		//登入判断
		@PostMapping("login.act")
		public void Login(String uname,String pass,String codes,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			JsonMessage msg = new JsonMessage();
			PcrUserInfo userFront = impl.selectuser(uname, pass);
//			if(codes.equalsIgnoreCase(codese)==false) {
//			   	msg.setId(2);
//			   	msg.setMsg("验证码错误");
//			}
//			else {
				if(userFront!=null) {
					if(userFront.getUserState().equals("禁用")) {
						msg.setId(2);
					   	msg.setMsg("该账户已被停用");
					}else if(userFront.getUserGonhui()==null && !userFront.getUserRole().equals("2")) {
						msg.setId(3);
					}else if(userFront.getUserName()!=null) {						
							msg.setId(1);
							msg.setMsg("登入成功,欢迎您"+userFront.getUserName());
							Map<String, Object> datas = new HashMap<String, Object>();
							datas.put("userFront", userFront);
							msg.setDatas(datas);
							msg.setLocation("admin");
							request.getSession().setAttribute("userFront",userFront);
					}
				}else {
					msg.setId(2);
					msg.setMsg("账号或密码错误");
				}
//			}
			String json = JSONObject.toJSONString(msg);
		   	response.getWriter().println(json);
		}
		
		//邮箱账户验证
		@PostMapping("youxiangzhanhu.act")
		public void youxiangzhanhu(String tel,String mails,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			JsonMessage msg = new JsonMessage();
			PcrMailInfo maile = emailSerivceImpl.selectMail(mails);
			if(maile==null) {
				msg.setMsg("账户与您绑定的邮箱不匹配");
				msg.setId(1);
			}else if(!maile.getMailUserId().equals(tel)){
				msg.setMsg("账户与您绑定的邮箱不匹配");
				msg.setId(1);
			}else {
				msg.setId(2);
			}
			String json = JSONObject.toJSONString(msg);
			response.getWriter().println(json);
		}
		
		//修改密码
		@PostMapping("backpass.act")
		public void backpass(String tel, String pass, String mails,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			JsonMessage msg = new JsonMessage();
				int a = impl.updatepass(tel, pass);
				if(a>0) {
					msg.setMsg("修改成功");
					msg.setLocation("login");
					msg.setId(2);
				}else {
					msg.setMsg("修改失败");
					msg.setId(1);
				}
			String json = JSONObject.toJSONString(msg);
			response.getWriter().println(json);
		}

	//修改密码(账户内)
	@PostMapping("updatepass.act")
	public void updatepass(String doubles, String uid,
						   HttpSession session,HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		int a = impl.updatepasss(doubles,uid);
		if(a>0) {
			msg.setMsg("修改成功，新密码是:<b><font color=\"red\">'+news+\"<b></font>，即将跳转至登入页!");
			msg.setLocation("login");
			msg.setId(2);
			session = request.getSession();
			session.invalidate();
		}else {
			msg.setMsg("修改失败，原始密码错误");
			msg.setId(1);
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}

		//主页面退出
		@PostMapping("tuichu.act")
		public void bye(HttpSession session,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			session = request.getSession();
	    	session.invalidate(); 
			JsonMessage msg = new JsonMessage();
			msg.setMsg("注销成功....");
			String json = JSONObject.toJSONString(msg);
			response.getWriter().println(json);
		}
		
		//确定账户是否重复
		@PostMapping("quedinregist.act")
		public void quedinregist(HttpSession session,String uuid,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			JsonMessage msg = new JsonMessage();
			int a = impl.selectchonfu(uuid);
			if(a>0) {
				msg.setId(1);
				msg.setMsg("已被使用");
			}else {
				msg.setId(2);
				msg.setMsg("未被使用");
			}
			String json = JSONObject.toJSONString(msg);
			response.getWriter().println(json);
		}
		
		//确定邮箱是否重复
		@PostMapping("quedinemailregist.act")
		public void quedinemailregist(HttpSession session,String email,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			JsonMessage msg = new JsonMessage();
			int a = emailSerivceImpl.selectMailHas(email);
			if(a>0) {
				msg.setId(1);
				msg.setMsg("已被使用");
			}else {
				msg.setId(2);
				msg.setMsg("未被使用");
			}
			String json = JSONObject.toJSONString(msg);
			response.getWriter().println(json);
		}
		
		//确定账户是否重复
		@PostMapping("quanbuuser.act")
		public void quanbuuser(HttpSession session,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			JsonMessage msg = new JsonMessage();
			PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
			Map<String, Object> datas = new HashMap<String, Object>();
			List<PcrUserInfo> list = impl.selectalluser(user.getUserGonhui()+"", user.getUserUid()+"");
			datas.put("usertype", list);
			msg.setDatas(datas);
			String json = JSONObject.toJSONString(msg);
			response.getWriter().println(json);
		}
		
		private String keyall;
		
		//注册
		@PostMapping("regist.act")
		public void regist(HttpSession session,String uid,String names,String pass,String mail,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			JsonMessage msg = new JsonMessage();
//			PcrMd5Info keyname = new PcrMd5Info();
			PcrUserInfo userFront = new PcrUserInfo();
			userFront.setUserPass(pass);
			userFront.setUserName(names);
			userFront.setUserAcctent(uid);
			int a = impl.insertuser(userFront);
			int b = emailSerivceImpl.insertMail(mail, userFront.getUserUid()+"");
			if(a>0 && b>0) {
//				String keys = DigestUtils.md5DigestAsHex(uid.getBytes());
//				keyall = keys;
//				keyname.setKeyName(keys);
//				keyname.setKeyUser(uid);
//				Integer s = keyServiceImpl.insertKeyPass(keyname);
//				if(s>0) {
					msg.setId(1);
					msg.setMsg("注册成功,欢迎使用");//,个人权限密钥开始下载,请妥善保存
					msg.setLocation("login");
//				}
			}else {
				msg.setId(2);
				msg.setMsg("注册失败!");
			}
			String json = JSONObject.toJSONString(msg);
			response.getWriter().println(json);
		}
		
		@RequestMapping(value = "excl.act", method = RequestMethod.GET)
		public void exclmoni(HttpSession session,
				HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			//----------------------------------------------------------------------------------
			 //把要导出到excel的数据的LinkedHashMap装载到这个List里面,这是导出工具类要求封装格式.
	        List<Map<String, Object>> exportData = new ArrayList<>();
	        //装载数据,就是要导出到excel的数据
	        	LinkedHashMap<String,Object> reportData = new LinkedHashMap<>();
	        	//使用LinkedHashMap,因为这个是有序的map
	        	reportData.put("test1",keyall);
	            exportData.add(reportData);
	        //表格列名用ArrayList装载
	        List<String> columns = new ArrayList<>();
	        //设置excel表格中的列名
	        columns.add("密钥");
	 
	        //点击导出按钮的时候,页面上显示的标题,同时也是sheet的名称
	        String filename = "我的密钥";
	        try {
	            //处理一下中文乱码问题
	            response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes("gb2312"), "ISO8859-1")+".xls");
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	        //以上均为数据准备,下面开始调用导出excel工具类
	        ExportExcel.exportToExcel(response, exportData, filename, columns);
	        //------------------------------------------------------------------------------------
		}
		
		@RequestMapping("getCheckCode")
	    @ResponseBody
	    public String getCheckCode(String email){
	        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
	        String message = "您的注册验证码为："+checkCode;
	        try {
	            mailService.sendSimpleMail(email, "注册验证码", message);
	        }catch (Exception e){
	            return "";
	        }
	        return checkCode;
	    }

	    //查询用户工会
		@PostMapping("gonhuilook.act")
		public void gonhuilook(String uuid,
							   HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			JsonMessage msg = new JsonMessage();
			PcrUserInfo pcrUserInfo = impl.gonhuiuser(uuid);
			if(pcrUserInfo!=null && pcrUserInfo.getUserGonhui()!=null){
				msg.setMsg(pcrUserInfo.getUserGonhui());
				msg.setId(1);
			}else{
				msg.setId(2);
			}
			String json = JSONObject.toJSONString(msg);
			response.getWriter().println(json);
		}
}
