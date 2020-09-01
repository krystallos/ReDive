package reDive.front.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import reDive.front.bean.PcrMonInfo;
import reDive.front.mapper.MoniMapper;

@Service
public class MoniServiceImpl implements MoniService{

	@Resource
	private MoniMapper moniMapper;
	
	@Override
	public List<PcrMonInfo> selectmoni(String start,String limit,String uid, String statrtime,
			String overtime, String bossid, String gonhui) {
		// TODO Auto-generated method stub
		PageHelper.offsetPage(Integer.valueOf(start), Integer.valueOf(limit));
		List<PcrMonInfo> moni = moniMapper.selectmoni(uid, statrtime, overtime, bossid, gonhui);
		return moni;
	}

	@Override
	public Integer selectchafen(String uid, String statrtime, String overtime, String bossid, String gonhui) {
		// TODO Auto-generated method stub
		Integer a = moniMapper.selectchafen(uid, statrtime, overtime, bossid, gonhui);
		return a;
	}
	
	@Override
	public Integer selectall(String uid, String statrtime, String overtime, String bossid, String gonhui) {
		// TODO Auto-generated method stub
		Integer a = moniMapper.selectall(uid, statrtime, overtime, bossid, gonhui);
		return a;
	}
	
	@Override
	public Integer selecttonjiall(String uid, String statrtime, String overtime, String bossid, String gonhui) {
		// TODO Auto-generated method stub
		Integer a = moniMapper.selecttonjiall(uid, statrtime, overtime, bossid, gonhui);
		return a;
	}
	
	@Override
	public Integer insertmoni(String gonhui, String bossid, String shanghai, String daotype, String uid) {
		// TODO Auto-generated method stub
		Integer a = moniMapper.insertmoni(gonhui, bossid, shanghai, daotype, uid);
		return a;
	}
	
	@Override
	public List<PcrMonInfo> selecttonjimoni(String start,int litem, String uid, String statrtime, String overtime, String bossid,
			String gonhui) {
		// TODO Auto-generated method stub
		PageHelper.offsetPage(Integer.valueOf(start), litem);
		List<PcrMonInfo> list = moniMapper.selecttonjimoni(uid, statrtime, overtime, bossid, gonhui);
		return list;
	}
	
	@Override
	public List<PcrMonInfo> exclmoni(String start, String gonhuiid) {
		// TODO Auto-generated method stub
		return moniMapper.exclmoni(start, gonhuiid);
	}
	
	@Override
	public Integer delmoni(Integer gonhuiid, Integer userid, String moniid) {
		// TODO Auto-generated method stub
		return moniMapper.delmoni(gonhuiid, userid, moniid);
	}
}
