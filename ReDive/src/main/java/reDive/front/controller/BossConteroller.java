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
import reDive.front.bean.PcrBossGonHuiInfo;
import reDive.front.bean.PcrBossInfo;
import reDive.front.bean.PcrMonInfo;
import reDive.front.bean.PcrUserInfo;
import reDive.front.bean.PcrZhenShiInfo;
import reDive.front.service.BossInfoServiceImpl;
import reDive.front.service.BossServiceImpl;
import reDive.front.service.MoniServiceImpl;
import reDive.front.service.ZhenShiServiceImpl;

@RestController
public class BossConteroller {

	@Resource
	private BossServiceImpl bossServiceImpl;
	@Resource
	private MoniServiceImpl moniServiceImpl;
	@Resource
	private ZhenShiServiceImpl zhenShiServiceImpl;
	@Resource
	private BossInfoServiceImpl bossInfoServiceImpl;
	
	@PostMapping("bossname.act")
	public void bossname(
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Map<String, Object> datas = new HashMap<String, Object>();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		List<PcrBossGonHuiInfo> list = bossServiceImpl.selectBoss(user.getUserGonhui()+"");
		datas.put("boss", list);
		msg.setDatas(datas);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("monicishu.act")
	public void monicishu(String statrtime,String overtime,String bossid,String now,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Map<String, Object> datas = new HashMap<String, Object>();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		int a = moniServiceImpl.selectall(user.getUserUid()+"", statrtime, overtime, bossid, user.getUserGonhui()+"");
		int litem = 3;
		now = Integer.valueOf(now)*litem - 3+"";
		if(a % litem !=0) {
			a = a/litem + 1;
		}else {
			a = a/litem;
		}
		List<PcrMonInfo> list = moniServiceImpl.selectmoni(now,litem+"",user.getUserUid()+"", statrtime, overtime, bossid,user.getUserGonhui()+"");
		Integer chafen = moniServiceImpl.selectchafen(user.getUserUid()+"", statrtime, overtime, bossid, user.getUserGonhui()+"");
		datas.put("bossname", list);
		datas.put("chafen", chafen);
		datas.put("allpage", a);
		msg.setDatas(datas);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("monitonji.act")
	public void monitonji(String statrtime,String overtime,String bossid,String username,String now,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Map<String, Object> datas = new HashMap<String, Object>();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		int a = moniServiceImpl.selecttonjiall(username, statrtime, overtime, bossid, user.getUserGonhui()+"");
		int litem = 6;
		now = Integer.valueOf(now)*litem - litem+"";
		if(a % litem !=0) {
			a = a/litem + 1;
		}else {
			a = a/litem;
		}
		List<PcrMonInfo> list = moniServiceImpl.selecttonjimoni(now,litem,username, statrtime, overtime, bossid, user.getUserGonhui()+"");
		datas.put("bossname", list);
		datas.put("allpage", a);
		msg.setDatas(datas);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("zhenshitonji.act")
	public void zhenshitonji(String statrtime,String overtime,String bossid,String username,String now,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Map<String, Object> datas = new HashMap<String, Object>();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		if(username.equals("本地数据")) {
			username = user.getUserName();
		}
		int b = zhenShiServiceImpl.selectallpage(username, statrtime, bossid, user.getUserGonhui()+"");
		int litem = 6;
		now = Integer.valueOf(now)*litem - litem+"";
		if(b % litem !=0) {
			b = b/litem + 1;
		}else {
			b = b/litem;
		}
		List<PcrZhenShiInfo> lists = zhenShiServiceImpl.selectxinxi(now, litem, username, statrtime, bossid, user.getUserGonhui()+"");
		datas.put("zhenshi", lists);
		datas.put("allpages", b);
		msg.setDatas(datas);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("zhenshitonjis.act")
	public void zhenshitonjis(String statrtime,String overtime,String username,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Map<String, Object> datas = new HashMap<String, Object>();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		List<PcrZhenShiInfo> lists = zhenShiServiceImpl.selectxinxis(username, statrtime, user.getUserGonhui()+"");
		datas.put("zhenshi", lists);
		msg.setDatas(datas);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("baocunshanghai.act")
	public void baocunshanghai(String bossid,String shanghai,String daotype,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		Integer a = moniServiceImpl.insertmoni(user.getUserGonhui()+"", bossid, shanghai, daotype, user.getUserUid()+"");
		if(a>0) {
			msg.setMsg("添加成功");
		}else {
			msg.setMsg("添加失败");
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("deldaoid.act")
	public void deldaoid(String daoids,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		Integer a = zhenShiServiceImpl.dels(daoids, user.getUserGonhui()+"");
		if(a>0) {
			msg.setMsg("移出成功");
		}else {
			msg.setMsg("移出失败");
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("tonjijishu.act")
	public void tonjijishu(String statrtime,String bossid,String username,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		if(username.equals("本地数据")) {
			username = user.getUserUid()+"";
		}
		Map<String, Object> maps = zhenShiServiceImpl.selectalltonji(username, statrtime, bossid);
		msg.setDatas(maps);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("zhenshitianjia.act")
	public void zhenshitianjia(String daotype,String bosshanghai,int bossids,String zhenshiduiwu,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		Integer a = zhenShiServiceImpl.insertZhenshi(daotype, bosshanghai, zhenshiduiwu,bossids+"", user.getUserUid()+"", user.getUserGonhui()+"");
		Integer b = zhenShiServiceImpl.updateShanghai(bosshanghai, bossids+"");
		Integer c = zhenShiServiceImpl.selectHp(bossids+"",user.getUserGonhui()+"");
		//血量低于0
		if(c<=0) {
			//查询paixu
			Integer nowboss = bossServiceImpl.selectnextpaixu(user.getUserGonhui()+"", bossids+"");
			Integer nowhp = zhenShiServiceImpl.updateShanghai(c+"", bossids+"");
			//改变状态
			Integer d = zhenShiServiceImpl.updatebosstype("2", user.getUserGonhui()+"", (nowboss-1)+"");
			//查询最大bossid
			d = bossServiceImpl.selectbossidsm(user.getUserGonhui()+"");
			if(nowboss>d) {
				//查询最小的bossid
				Integer s = bossServiceImpl.selectbossid(user.getUserGonhui()+"");
				//全部改成状态未开始
				Integer e = zhenShiServiceImpl.updatebosstypeto("0", user.getUserGonhui()+"");
				//将最小的bossid改成1
				e = zhenShiServiceImpl.updatebosstype("1", user.getUserGonhui()+"", s+"");
				//恢复HP
				e = bossServiceImpl.updatebosshp(user.getUserGonhui()+"");
			}else {
				//修改下一个排序序列的状态
				d = zhenShiServiceImpl.updatebosstype("1", user.getUserGonhui()+"", nowboss+"");
			}
			//查询最大值的boss是否攻略完成
		}
		if(a>0 && b>0) {
			msg.setMsg("写入"+a+"条成功");
		}else {
			msg.setMsg("失败");
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("dailizhenshitianjia.act")
	public void dailizhenshitianjia(String daotype,String bosshanghai,int bossids,String useruids,String dailiduiwu,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		Integer a = zhenShiServiceImpl.insertZhenshi(daotype, bosshanghai, dailiduiwu,bossids+"", useruids, user.getUserGonhui()+"");
		Integer b = zhenShiServiceImpl.updateShanghai(bosshanghai, bossids+"");
		Integer c = zhenShiServiceImpl.selectHp(bossids+"",user.getUserGonhui()+"");
		//血量低于0
		if(c<=0) {
			//查询paixu
			Integer nowboss = bossServiceImpl.selectnextpaixu(user.getUserGonhui()+"", bossids+"");
			Integer nowhp = zhenShiServiceImpl.updateShanghai(c+"", bossids+"");
			//改变状态
			Integer d = zhenShiServiceImpl.updatebosstype("2", user.getUserGonhui()+"", (nowboss-1)+"");
			//查询最大bossid
			d = bossServiceImpl.selectbossidsm(user.getUserGonhui()+"");
			if(nowboss>d) {
				//查询最小的bossid
				Integer s = bossServiceImpl.selectbossid(user.getUserGonhui()+"");
				//全部改成状态未开始
				Integer e = zhenShiServiceImpl.updatebosstypeto("0", user.getUserGonhui()+"");
				//将最小的bossid改成1
				e = zhenShiServiceImpl.updatebosstype("1", user.getUserGonhui()+"", s+"");
				//恢复HP
				e = bossServiceImpl.updatebosshp(user.getUserGonhui()+"");
			}else {
				//修改下一个排序序列的状态
				d = zhenShiServiceImpl.updatebosstype("1", user.getUserGonhui()+"", nowboss+"");
			}
			//查询最大值的boss是否攻略完成
		}
		if(a>0 && b>0) {
			msg.setMsg("写入"+a+"条成功");
		}else {
			msg.setMsg("失败");
		}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("chaxunzonboss.act")
	public void chaxunzonboss(
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Map<String, Object> datas = new HashMap<String, Object>();
		List<PcrBossInfo> list = bossInfoServiceImpl.selectallboss();
		datas.put("allboss", list);
		msg.setDatas(datas);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("addbossgonhui.act")
	public void addbossgonhui(String jd1,String jd2,String jd3,String jd4,String jd5,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
			Integer b = bossServiceImpl.delbossinxi(user.getUserGonhui()+"");
			Integer a = bossServiceImpl.insertbossinxi(jd1, jd2, jd3, jd4, jd5, user.getUserGonhui()+"");
			if(a>0) {
				msg.setMsg("写入成功");
			}else {
				msg.setMsg("增加库写入失败");
			}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("delallbossxinxi.act")
	public void delallbossxinxi(String moniid,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
			Integer b = bossServiceImpl.delbossinxi(user.getUserGonhui()+"");
			if(b>0) {
				msg.setMsg("删除成功");
			}else {
				msg.setMsg("删除库失败,内部为空");
			}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("delmonijieguo.act")
	public void delmonijieguo(String moniid,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		Integer b = moniServiceImpl.delmoni(Integer.valueOf(user.getUserGonhui()), user.getUserUid(), moniid);
			if(b>0) {
				msg.setMsg("删除成功");
			}else {
				msg.setMsg("删除库失败,内部为空");
			}
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
	@PostMapping("tonjialluserchudao.act")
	public void tonjialluserchudao(String moniid,int now,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		JsonMessage msg = new JsonMessage();
		Map<String, Object> datas = new HashMap<String, Object>();
		PcrUserInfo user = (PcrUserInfo) request.getSession().getAttribute("userFront");
		int b = zhenShiServiceImpl.selectalltonjidaopage(user.getUserGonhui()+"");
		int litem = 10;
		now = Integer.valueOf(now)*litem - litem;
		if(b % litem !=0) {
			b = b/litem + 1;
		}else {
			b = b/litem;
		}
		List<PcrZhenShiInfo> list = zhenShiServiceImpl.selectalltonjidao(user.getUserGonhui()+"",now,litem);
		datas.put("alltonji", list);
		datas.put("allpages", b);
		msg.setDatas(datas);
		String json = JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}
	
}
