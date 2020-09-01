package reDive.front.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reDive.front.bean.PcrPersonInfo;
import reDive.front.mapper.PerSonMapper;

@Service
public class PerSonServiceImpl implements PerSonService{

	@Resource
	private PerSonMapper perSonMapper;
	
	@Override
	public List<PcrPersonInfo> selectlinklook(String persontps) {
		// TODO Auto-generated method stub
		return perSonMapper.selectlinklook(persontps);
	}
	
}
