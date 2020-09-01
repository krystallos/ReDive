package reDive.front.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import reDive.front.bean.PcrZhenShiInfo;

public interface ZhenShiMapper {

	/**
	 * 查询正式刀的信息
	 * @param uid
	 * @param statrtime
	 * @param bossid
	 * @param gonhui
	 * @return
	 */
	List<PcrZhenShiInfo> selectxinxi(@Param("uid")String uid,@Param("statrtime")String statrtime,@Param("bossid")String bossid,@Param("gonhui")String gonhui);
	
	/**
	 * 查询正式刀的信息
	 * @param uid
	 * @param statrtime
	 * @param bossid
	 * @param gonhui
	 * @return
	 */
	List<PcrZhenShiInfo> selectxinxis(@Param("uid")String uid,@Param("statrtime")String statrtime,@Param("gonhui")String gonhui);

	/**
	 * 统计总页数
	 * @param uid
	 * @param statrtime
	 * @param bossid
	 * @param gonhui
	 * @return
	 */
	Integer selectallpage(@Param("uid")String uid,@Param("statrtime")String statrtime,@Param("bossid")String bossid,@Param("gonhui")String gonhui);

	/**
	 * 统计总数
	 * @param uid
	 * @param statrtime
	 * @param bossid
	 * @return
	 */
	Map<String, Object> selectalltonji(@Param("uid")String uid,@Param("statrtime")String statrtime,@Param("bossid")String bossid);

	/**
	 * 添加正式战斗记录
	 * @param zhenshitype
	 * @param zhenshishanghai
	 * @param bossid
	 * @param uid
	 * @param gonhuiid
	 * @return
	 */
	Integer insertZhenshi(@Param("zhenshitype")String zhenshitype,@Param("zhenshishanghai")String zhenshishanghai,@Param("zhenshiduiwu")String zhenshiduiwu,
			@Param("bossid")String bossid,@Param("uid")String uid,@Param("gonhuiid")String gonhuiid);

	/**
	 * 伤害计算
	 * @param zhenshishanghai
	 * @param bossid
	 * @return
	 */
	Integer updateShanghai(@Param("zhenshishanghai")String zhenshishanghai,@Param("bossid")String bossid);

	/**
	 * 查询当前血量
	 * @param bossid
	 * @return
	 */
	Integer selectHp(@Param("bossid")String bossid,@Param("gonhuiid")String gonhuiid);
	
	/**
	 * 修改BOSS状态
	 * @param bosstype
	 * @param gonhuiid
	 * @param bossid
	 * @return
	 */
	Integer updatebosstype(@Param("bosstype")String bosstype,@Param("gonhuiid")String gonhuiid,@Param("bossid")String bossid);
	
	/**
	 * 修改BOSS状态
	 * @param bosstype
	 * @param gonhuiid
	 * @return
	 */
	Integer updatebosstypeto(@Param("bosstype")String bosstype,@Param("gonhuiid")String gonhuiid);
	
	/**
	 * 导出当天excl
	 * @param start
	 * @param gonhuiid
	 * @return
	 */
	List<PcrZhenShiInfo> exclzhenshi(@Param("start")String start,@Param("gonhuiid")String gonhuiid);
	
	/**
	 * 查询出刀数量
	 * @param gonhuiid
	 * @return
	 */
	List<PcrZhenShiInfo> selectalltonjidao(@Param("gonhuiid")String gonhuiid);
	
	/**
	 * 出刀数量分页
	 * @param gonhuiid
	 * @return
	 */
	Integer selectalltonjidaopage(@Param("gonhuiid")String gonhuiid);
	
	/**
	 * 删除出刀
	 * @param zhenshiid
	 * @param gonhuiid
	 * @return
	 */
	Integer dels(@Param("zhenshiid")String zhenshiid,@Param("gonhuiid")String gonhuiid);
}
