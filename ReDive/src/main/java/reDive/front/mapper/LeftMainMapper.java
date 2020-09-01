package reDive.front.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import reDive.front.bean.PcrMenuInfo;

public interface LeftMainMapper {

	/**
	 * 查询菜单
	 * @param roleid
	 * @return
	 */
	List<PcrMenuInfo> selectMenu(@Param("roleid")String roleid);
}
