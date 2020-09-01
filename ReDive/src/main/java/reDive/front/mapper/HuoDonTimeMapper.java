package reDive.front.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import reDive.front.bean.PcrHuoDonTimeInfo;

public interface HuoDonTimeMapper {

	/**
	 * 获取本月活动
	 * @return
	 */
	List<PcrHuoDonTimeInfo> selectnowyhuodon();
	
	/**
	 * 添加活动
	 * @return
	 */
	Integer inserthuodon(@Param("huodon")PcrHuoDonTimeInfo huodon);
}
