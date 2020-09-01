package reDive.front.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import reDive.front.bean.PcrGonHuiInfo;

public interface GonHuiMapper {

	/**
	 * 查询工会
	 * @param gonhuiName
	 * @return
	 */
	List<PcrGonHuiInfo> selectGonhui(@Param("gonhuiName")String gonhuiName);
	
	/**
	 * 添加工会
	 * @param gonhui
	 * @return
	 */
	Integer insertGonhui(@Param("gonhui")PcrGonHuiInfo pcrGonHuiInfo);
	
	/**
	 * 删除工会
	 * @param gonhuiid
	 * @return
	 */
	Integer delGonhui(@Param("gonhuiid")String gonhuiid);

	/**
	 * 查询工会有多少会长权限人员
	 * @param gonhuiid
	 * @return
	 */
	Integer selectCountAdmin(@Param("gonhuiid") String gonhuiid);

	/**
	 * 把会长给我端咯
	 * @param uid
	 * @param gonhuiid
	 * @return
	 */
	Integer updateAdminUser(@Param("uid") String uid,@Param("gonhuiid") String gonhuiid,@Param("type")String type);
}
