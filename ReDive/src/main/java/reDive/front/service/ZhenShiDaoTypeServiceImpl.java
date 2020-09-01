package reDive.front.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reDive.front.bean.PcrZhenShiDaoTypeInfo;
import reDive.front.mapper.ZhenShiDaoTypeMapper;

@Service
public class ZhenShiDaoTypeServiceImpl implements ZhenShiDaoTypeService{

	@Resource
	private ZhenShiDaoTypeMapper zhenShiDaoTypeMapper;
	
	@Override
	public List<PcrZhenShiDaoTypeInfo> selectuserpsolook(String uid) {
		// TODO Auto-generated method stub
		return zhenShiDaoTypeMapper.selectuserpsolook(uid);
	}
	
	@Override
	public List<PcrZhenShiDaoTypeInfo> selectuserpsolookname(String uid) {
		// TODO Auto-generated method stub
		return zhenShiDaoTypeMapper.selectuserpsolookname(uid);
	}
	
	@Override
	public Integer insertdaotype(String one, String two, String three, String four, String five, String uid) {
		// TODO Auto-generated method stub
		return zhenShiDaoTypeMapper.insertdaotype(one, two, three, four, five, uid);
	}
	
	@Override
	public Integer selectalltonji(String uid) {
		// TODO Auto-generated method stub
		return zhenShiDaoTypeMapper.selectalltonji(uid);
	}
	
	@Override
	public Integer updateduiwuname(String names, String ids, String uid) {
		// TODO Auto-generated method stub
		return zhenShiDaoTypeMapper.updateduiwuname(names, ids, uid);
	}
	
	@Override
	public Integer delduiwu(String duiwuid, String uid) {
		// TODO Auto-generated method stub
		return zhenShiDaoTypeMapper.delduiwu(duiwuid, uid);
	}
	
}
