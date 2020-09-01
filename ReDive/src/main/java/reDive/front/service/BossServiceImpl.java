package reDive.front.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reDive.front.bean.PcrBossGonHuiInfo;
import reDive.front.bean.PcrBossInfo;
import reDive.front.mapper.BossMapper;

@Service
public class BossServiceImpl implements BossService{

	@Resource
	private BossMapper bossMapper;
	
	@Override
	public List<PcrBossGonHuiInfo> selectBoss(String gonhui) {
		// TODO Auto-generated method stub
		List<PcrBossGonHuiInfo> list = bossMapper.selectBoss(gonhui);
		return list;
	}
	
	@Override
	public Integer selectbosstype(String gonhuiid,String types) {
		// TODO Auto-generated method stub
		return bossMapper.selectbosstype(gonhuiid,types);
	}
	
	@Override
	public Integer selectbossid(String gonhuiid) {
		// TODO Auto-generated method stub
		return bossMapper.selectbossid(gonhuiid);
	}
	
	@Override
	public Integer selectbossidsm(String gonhuiid) {
		// TODO Auto-generated method stub
		return bossMapper.selectbossidsm(gonhuiid);
	}
	
	@Override
	public Integer updatebosshp(String gonhuiid) {
		// TODO Auto-generated method stub
		return bossMapper.updatebosshp(gonhuiid);
	}
	
	@Override
	public Integer delbossinxi(String gonhuiid) {
		// TODO Auto-generated method stub
		return bossMapper.delbossxinxi(gonhuiid);
	}
	
	@Override
	public Integer insertbossinxi(String jd1, String jd2, String jd3, String jd4, String jd5, String gonhuiid) {
		// TODO Auto-generated method stub
		return bossMapper.insertbossinxi(jd1,jd2,jd3,jd4,jd5,gonhuiid);
	}
	
	@Override
	public Integer selectnextpaixu(String gonhuiid, String bossid) {
		// TODO Auto-generated method stub
		return bossMapper.selectnextpaixu(gonhuiid, bossid);
	}
}
