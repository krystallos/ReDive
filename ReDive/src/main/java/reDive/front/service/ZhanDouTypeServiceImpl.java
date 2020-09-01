package reDive.front.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reDive.front.bean.PcrZhandouInfo;
import reDive.front.mapper.ZhanDouTypeMapper;

@Service
public class ZhanDouTypeServiceImpl implements ZhanDouTypeService{

	@Resource
	private ZhanDouTypeMapper zhandouTypeMapper;
	
	@Override
	public List<PcrZhandouInfo> selectdaotype() {
		// TODO Auto-generated method stub
		List<PcrZhandouInfo> list = zhandouTypeMapper.selectall();
		return list;
	}
}
