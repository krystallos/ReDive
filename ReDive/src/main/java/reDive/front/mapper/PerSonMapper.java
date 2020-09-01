package reDive.front.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import reDive.front.bean.PcrPersonInfo;

public interface PerSonMapper {

	/**
	 * 查询指定站位展示
	 * @param persontps
	 * @return
	 */
	List<PcrPersonInfo> selectlinklook(@Param("persontps")String persontps);
}
