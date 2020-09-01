package reDive.front.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reDive.front.bean.PcrMd5Info;
import reDive.front.mapper.KeyMapper;

@Service
public class KeyServiceImpl implements KeyMapper{

	@Resource
	private KeyMapper keyMapper;
	
	@Override
	public Integer insertKeyPass(PcrMd5Info pcrMd5Info) {
		// TODO Auto-generated method stub
		return keyMapper.insertKeyPass(pcrMd5Info);
	}
}
