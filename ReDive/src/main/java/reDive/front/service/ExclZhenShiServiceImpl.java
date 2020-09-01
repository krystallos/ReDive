package reDive.front.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reDive.front.bean.PcrZhenshiDaoZhenRon;
import reDive.front.mapper.ExclZhenShiMapper;

@Service
public class ExclZhenShiServiceImpl implements ExclZhenShiService{

	@Resource
	private ExclZhenShiMapper exclZhenShiMapper;
	
	@Override
	public List<PcrZhenshiDaoZhenRon> exclzhenshiteam(String start, String gonhuiid) {
		// TODO Auto-generated method stub
		return exclZhenShiMapper.exclzhenshiteam(start, gonhuiid);
	}
}
