package reDive.front.mapper;

import java.util.List;

import reDive.front.bean.PcrImgInfo;

public interface ImgMapper {

	/**
	 * 查询广告图
	 * @return
	 */
	List<PcrImgInfo> selectimg();
}
