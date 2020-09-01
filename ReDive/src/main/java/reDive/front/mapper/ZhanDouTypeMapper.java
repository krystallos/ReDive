package reDive.front.mapper;

import java.util.List;

import reDive.front.bean.PcrZhandouInfo;

public interface ZhanDouTypeMapper {

	/**
	 * 查找全部刀类型
	 * @return
	 */
	List<PcrZhandouInfo> selectall();
}
