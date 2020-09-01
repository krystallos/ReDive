package reDive.front.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import reDive.front.bean.PcrMonInfo;

public interface MoniMapper {

	/**
	 * 查找
	 * @param statrtime
	 * @param overtime
	 * @param bossid
	 * @param gonhui
	 * @return
	 */
	List<PcrMonInfo> selectmoni(@Param("uid")String uid,@Param("statrtime")String statrtime,@Param("overtime")String overtime,@Param("bossid")String bossid,@Param("gonhui")String gonhui);

	/**
	 * 查找统计模拟刀
	 * @param statrtime
	 * @param overtime
	 * @param bossid
	 * @param gonhui
	 * @param uid
	 * @return
	 */
	List<PcrMonInfo> selecttonjimoni(@Param("uid")String uid,@Param("statrtime")String statrtime,@Param("overtime")String overtime,@Param("bossid")String bossid,@Param("gonhui")String gonhui);
	
	/**
	 * 模拟战差分值
	 * @param uid
	 * @param statrtime
	 * @param overtime
	 * @param bossid
	 * @param gonhui
	 * @return
	 */
	Integer selectchafen(@Param("uid")String uid,@Param("statrtime")String statrtime,@Param("overtime")String overtime,@Param("bossid")String bossid,@Param("gonhui")String gonhui);

	/**
	 * 统计总数据
	 * @param uid
	 * @param statrtime
	 * @param overtime
	 * @param bossid
	 * @param gonhui
	 * @return
	 */
	Integer selectall(@Param("uid")String uid,@Param("statrtime")String statrtime,@Param("overtime")String overtime,@Param("bossid")String bossid,@Param("gonhui")String gonhui);

	/**
	 * 统计带名称的总数据
	 * @param uid
	 * @param statrtime
	 * @param overtime
	 * @param bossid
	 * @param gonhui
	 * @return
	 */
	Integer selecttonjiall(@Param("uid")String uid,@Param("statrtime")String statrtime,@Param("overtime")String overtime,@Param("bossid")String bossid,@Param("gonhui")String gonhui);
	
	/**
	 * 添加模拟刀数据
	 * @param gonhui
	 * @param bossid
	 * @param shanghai
	 * @param daotype
	 * @param uid
	 * @return
	 */
	Integer insertmoni(@Param("gonhui")String gonhui,@Param("bossid")String bossid,@Param("shanghai")String shanghai,@Param("daotype")String daotype,@Param("uid")String uid);

	/**
	 * 导出当天excl
	 * @param start
	 * @param gonhuiid
	 * @return
	 */
	List<PcrMonInfo> exclmoni(@Param("start")String start,@Param("gonhuiid")String gonhuiid);
	
	/**
	 * 删除模拟战信息
	 * @param gonhuiid
	 * @param userid
	 * @param moniid
	 * @return
	 */
	Integer delmoni(@Param("gonhuiid")Integer gonhuiid,@Param("userid")Integer userid,@Param("moniid")String moniid);
}
