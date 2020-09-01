package reDive.front.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import reDive.front.bean.PcrZhenShiInfo;
import reDive.front.mapper.ZhenShiMapper;

@Service
public class ZhenShiServiceImpl implements ZhenShiService{

	@Resource
	private ZhenShiMapper zhenShiMapper;
	
	@Override
	public List<PcrZhenShiInfo> selectxinxi(String start, int litem, String uid, String statrtime, String bossid,
			String gonhui) {
		// TODO Auto-generated method stub
		PageHelper.offsetPage(Integer.valueOf(start), litem);
		List<PcrZhenShiInfo> list = zhenShiMapper.selectxinxi(uid, statrtime, bossid, gonhui);
		return list;
	}
	
	@Override
	public List<PcrZhenShiInfo> selectxinxis(String uid, String statrtime, String gonhui) {
		// TODO Auto-generated method stub
		List<PcrZhenShiInfo> list = zhenShiMapper.selectxinxis(uid, statrtime, gonhui);
		return list;
	}
	
	@Override
	public Integer selectallpage(String uid, String statrtime, String bossid, String gonhui) {
		// TODO Auto-generated method stub
		Integer a = zhenShiMapper.selectallpage(uid, statrtime, bossid, gonhui);
		return a;
	}
	
	@Override
	public Map<String, Object> selectalltonji(String uid, String statrtime, String bossid) {
		// TODO Auto-generated method stub
		return zhenShiMapper.selectalltonji(uid, statrtime, bossid);
	}
	
	@Override
	public Integer insertZhenshi(String zhenshitype, String zhenshishanghai, String zhenshiduiwu,String bossid, String uid,
			String gonhuiid) {
		// TODO Auto-generated method stub
		Integer a = zhenShiMapper.insertZhenshi(zhenshitype, zhenshishanghai, zhenshiduiwu,bossid, uid, gonhuiid);
		return a;
	}
	
	@Override
	public Integer updateShanghai(String zhenshishanghai, String bossid) {
		// TODO Auto-generated method stub
		return zhenShiMapper.updateShanghai(zhenshishanghai, bossid);
	}
	
	@Override
	public Integer selectHp(String bossid,String gonhuiid) {
		// TODO Auto-generated method stub
		return zhenShiMapper.selectHp(bossid,gonhuiid);
	}
	
	@Override
	public Integer updatebosstype(String bosstype, String gonhuiid, String bossid) {
		// TODO Auto-generated method stub
		return zhenShiMapper.updatebosstype(bosstype, gonhuiid, bossid);
	}
	
	@Override
	public Integer updatebosstypeto(String bosstype, String gonhuiid) {
		// TODO Auto-generated method stub
		return zhenShiMapper.updatebosstypeto(bosstype, gonhuiid);
	}
	
	@Override
	public List<PcrZhenShiInfo> exclzhenshi(String start, String gonhuiid) {
		// TODO Auto-generated method stub
		return zhenShiMapper.exclzhenshi(start, gonhuiid);
	}
	
	@Override
	public List<PcrZhenShiInfo> selectalltonjidao(String gonhuiid,int now,int limte) {
		// TODO Auto-generated method stub
		PageHelper.offsetPage(now, limte);
		return zhenShiMapper.selectalltonjidao(gonhuiid);
	}
	
	@Override
	public Integer selectalltonjidaopage(String gonhuiid) {
		// TODO Auto-generated method stub
		return zhenShiMapper.selectalltonjidaopage(gonhuiid);
	}
	
	@Override
	public Integer dels(String zhenshiid, String gonhuiid) {
		// TODO Auto-generated method stub
		return zhenShiMapper.dels(zhenshiid, gonhuiid);
	}
	
}
