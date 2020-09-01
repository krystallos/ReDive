package reDive.front.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reDive.front.bean.PcrBossInfo;
import reDive.front.mapper.BossInfoMapper;

@Service
public class BossInfoServiceImpl implements BossInfoService{

	@Resource
	private BossInfoMapper bossInfoMapper;
	
	@Override
	public List<PcrBossInfo> selectallboss() {
		// TODO Auto-generated method stub
		return bossInfoMapper.selectallboss();
	}
}
