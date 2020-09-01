package reDive.front.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reDive.front.bean.PcrImgInfo;
import reDive.front.mapper.ImgMapper;

@Service
public class ImgServiceImpl implements ImgService{

	@Resource
	private ImgMapper imgMapper;
	
	@Override
	public List<PcrImgInfo> selectimg() {
		// TODO Auto-generated method stub
		return imgMapper.selectimg();
	}
}
