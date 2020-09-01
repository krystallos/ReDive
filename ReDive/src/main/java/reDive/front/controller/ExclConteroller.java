package reDive.front.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import reDive.front.bean.JsonMessage;
import reDive.front.bean.PcrMonInfo;
import reDive.front.bean.PcrUserInfo;
import reDive.front.bean.PcrZhenShiDaoTypeInfo;
import reDive.front.bean.PcrZhenShiInfo;
import reDive.front.bean.PcrZhenshiDaoZhenRon;
import reDive.front.service.ExclZhenShiServiceImpl;
import reDive.front.service.MoniServiceImpl;
import reDive.front.service.ZhenShiDaoTypeServiceImpl;
import reDive.front.service.ZhenShiServiceImpl;
import reDive.front.util.ExportExcel;

@RestController
public class ExclConteroller {

	@Resource
	private MoniServiceImpl moniServiceImpl;
	@Resource
	private ZhenShiServiceImpl zhenShiServiceImpl;
	@Resource
	private ZhenShiDaoTypeServiceImpl zhenShiDaoTypeServiceImpl;
	@Resource
	private ExclZhenShiServiceImpl exclZhenShiServiceImpl;
	
	@RequestMapping(value = "exclmoni.act", method = RequestMethod.GET)
	public void exclmoni(String start,HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
        //把要导出到excel的数据的LinkedHashMap装载到这个List里面,这是导出工具类要求封装格式.
        List<Map<String, Object>> exportData = new ArrayList<>();
        //装载数据,就是要导出到excel的数据
        PcrUserInfo userinfo = (PcrUserInfo) session.getAttribute("userFront");
        List<PcrMonInfo> lists = moniServiceImpl.exclmoni(start, userinfo.getUserGonhui()+"");
        for(int a=0;a<lists.size();a++) {
        	LinkedHashMap<String,Object> reportData = new LinkedHashMap<>();
        	//使用LinkedHashMap,因为这个是有序的map
        	reportData.put("test1",lists.get(a).getMoniUserId());
            reportData.put("test2",lists.get(a).getMoniShangHai());
            reportData.put("test3",lists.get(a).getMoniBossId());
            reportData.put("test4",lists.get(a).getMoniCtime());
            reportData.put("test5",lists.get(a).getMoniDao());
            exportData.add(reportData);
        }
        //表格列名用ArrayList装载
        List<String> columns = new ArrayList<>();
        //设置excel表格中的列名
        columns.add("名称");
        columns.add("伤害");
        columns.add("Boss");
        columns.add("时间");
        columns.add("备注");
        //点击导出按钮的时候,页面上显示的标题,同时也是sheet的名称
        String filename = start+"Boss出刀表(模拟)";
        try {
            //处理一下中文乱码问题
            response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes("gb2312"), "ISO8859-1")+".xls");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //以上均为数据准备,下面开始调用导出excel工具类
        ExportExcel.exportToExcel(response, exportData, filename, columns);
	}
	
	@RequestMapping(value = "exclzhenshi.act", method = RequestMethod.GET)
	public void exclzhenshi(String start,HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
        //把要导出到excel的数据的LinkedHashMap装载到这个List里面,这是导出工具类要求封装格式.
        List<Map<String, Object>> exportData = new ArrayList<>();
        //装载数据,就是要导出到excel的数据
        PcrUserInfo userinfo = (PcrUserInfo) session.getAttribute("userFront");
        List<PcrZhenshiDaoZhenRon> lists = exclZhenShiServiceImpl.exclzhenshiteam(start,userinfo.getUserGonhui()+"");
        for(int a=0;a<lists.size();a++) {
        	LinkedHashMap<String,Object> reportData = new LinkedHashMap<>();
        	//使用LinkedHashMap,因为这个是有序的map
        	reportData.put("test1",lists.get(a).getZhenShiUserId());
            reportData.put("test2",lists.get(a).getZhenShiShangHai());
            reportData.put("test3",lists.get(a).getZhenShiBossId());
            reportData.put("test4",lists.get(a).getZhenShiCtime());
            reportData.put("test5",lists.get(a).getZhenShiType());
            reportData.put("test6",lists.get(a).getZhenShiDaoOne()+"/"+lists.get(a).getZhenShiDaoTwo()+"/"+lists.get(a).getZhenShiDaoThree()
            		+"/"+lists.get(a).getZhenShiDaoFour()+"/"+lists.get(a).getZhenShiDaoFive());
            exportData.add(reportData);
        }
        //表格列名用ArrayList装载
        List<String> columns = new ArrayList<>();
        //设置excel表格中的列名
        columns.add("名称");
        columns.add("伤害");
        columns.add("Boss");
        columns.add("时间");
        columns.add("备注");
        columns.add("阵容");
        //点击导出按钮的时候,页面上显示的标题,同时也是sheet的名称
        String filename = start+"Boss出刀表(正式)";
        try {
            //处理一下中文乱码问题
            response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes("gb2312"), "ISO8859-1")+".xls");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //以上均为数据准备,下面开始调用导出excel工具类
        ExportExcel.exportToExcel(response, exportData, filename, columns);
	}
	
}
