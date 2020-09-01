package reDive.front.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import reDive.front.bean.PcrZhenshiDaoZhenRon;

public interface ExclZhenShiMapper {

	/**
	 * 带阵容的excl导出
	 * @param start
	 * @param gonhuiid
	 * @return
	 */
	List<PcrZhenshiDaoZhenRon> exclzhenshiteam(@Param("start")String start,@Param("gonhuiid")String gonhuiid);
}
