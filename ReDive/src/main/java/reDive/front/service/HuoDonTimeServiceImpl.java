package reDive.front.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reDive.front.bean.PcrHuoDonTimeInfo;
import reDive.front.mapper.HuoDonTimeMapper;

@Service
public class HuoDonTimeServiceImpl implements HuoDonTimeService{

	@Resource
	private HuoDonTimeMapper huoDonTimeMapper;
	
	@Override
	public List<PcrHuoDonTimeInfo> selectnowyhuodon() {
		// TODO Auto-generated method stub
		return huoDonTimeMapper.selectnowyhuodon();
	}
	
	@Override
	public Integer inserthuodon(PcrHuoDonTimeInfo huodon) {
		// TODO Auto-generated method stub
		return huoDonTimeMapper.inserthuodon(huodon);
	}
}
