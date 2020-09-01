package reDive.front.mapper;

import java.util.List;

import reDive.front.bean.PcrBossInfo;

public interface BossInfoMapper {

	/**
	 * 查询全部boss
	 * @return
	 */
	List<PcrBossInfo> selectallboss();
}
