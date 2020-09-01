package reDive.front.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import reDive.front.bean.PcrBossGonHuiInfo;
import reDive.front.bean.PcrBossInfo;


public interface BossMapper {
	
	/**
	 * 查找BOSS
	 * @return
	 */
	List<PcrBossGonHuiInfo> selectBoss(@Param("gonhui")String gonhui);
	
	/**
	 * 查询boss状态
	 * @param gonhuiid
	 * @return
	 */
	Integer selectbosstype(@Param("gonhuiid")String gonhuiid,@Param("types")String types);
	
	/**
	 * 查询当前最小boss值
	 * @param gonhuiid
	 * @return
	 */
	Integer selectbossid(@Param("gonhuiid")String gonhuiid);
	
	/**
	 * 查询当前最大boss值
	 * @param gonhuiid
	 * @return
	 */
	Integer selectbossidsm(@Param("gonhuiid")String gonhuiid);
	
	/**
	 * 复原bosshp
	 * @param gonhuiid
	 * @return
	 */
	Integer updatebosshp(@Param("gonhuiid")String gonhuiid);
	
	/**
	 * 删除工会的所有boss
	 * @param gonhuiid
	 * @return
	 */
	Integer delbossxinxi(@Param("gonhuiid")String gonhuiid);
	
	/**
	 * 增加新的工会boss
	 * @param jd1
	 * @param jd2
	 * @param jd3
	 * @param jd4
	 * @param jd5
	 * @param gonhuiid
	 * @return
	 */
	Integer insertbossinxi(@Param("jd1")String jd1,@Param("jd2")String jd2,@Param("jd3")String jd3,@Param("jd4")String jd4,@Param("jd5")String jd5,@Param("gonhuiid")String gonhuiid);

	/**
	 * 查询下一个排序
	 * @param gonhuiid
	 * @param bossid
	 * @return
	 */
	Integer selectnextpaixu(@Param("gonhuiid")String gonhuiid,@Param("bossid")String bossid);
}
