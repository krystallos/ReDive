package reDive.front.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import reDive.front.bean.PcrGonGaoInfo;
import reDive.front.mapper.GonGaoMapper;

@Service
public class GonGaoServiceImpl implements GonGaoService{

	@Resource
	private GonGaoMapper gonGaoMapper;
	
	@Override
	public List<PcrGonGaoInfo> selectGongao(String gongaoid, String gongaogonhui) {
		// TODO Auto-generated method stub
		PageHelper.offsetPage(Integer.valueOf(0), Integer.valueOf(10));
		return gonGaoMapper.selectGongao(gongaoid,gongaogonhui);
	}
	
	@Override
	public PcrGonGaoInfo selectnewGongao(String role) {
		// TODO Auto-generated method stub
		return gonGaoMapper.selectnewGongao(role);
	}
	
	@Override
	public Integer insertgongao(String gongaotype, String gongaobiaoti, String gongaotext, String gongaorole, String gongaogonhui) {
		// TODO Auto-generated method stub
		return gonGaoMapper.insertgongao(gongaotype, gongaobiaoti, gongaotext, gongaorole, gongaogonhui);
	}
}
