package reDive.front.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reDive.front.bean.PcrMenuInfo;
import reDive.front.mapper.LeftMainMapper;

@Service
public class LeftMainServiceImpl implements LeftMainService{

	@Resource
	private LeftMainMapper leftMainMapper;
	
	@Override
	public List<PcrMenuInfo> selectMenu(String roleid) {
		// TODO Auto-generated method stub
		List<PcrMenuInfo> list = leftMainMapper.selectMenu(roleid);
		return list;
	}
}
