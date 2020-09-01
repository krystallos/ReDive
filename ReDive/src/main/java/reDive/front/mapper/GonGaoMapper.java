package reDive.front.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import reDive.front.bean.PcrGonGaoInfo;

public interface GonGaoMapper {

	/**
	 * 查询公告
	 * @param gongaoid
	 * @return
	 */
	List<PcrGonGaoInfo> selectGongao(@Param("gongaoid")String gongaoid, @Param("gongaogonhui")String gongaogonhui);
	
	/**
	 * 查询最新公告
	 * @param role
	 * @return
	 */
	PcrGonGaoInfo selectnewGongao(@Param("role")String role);
	
	/**
	 * 添加公告
	 * @param gongaotype
	 * @param gongaobiaoti
	 * @param gongaotext
	 * @param gongaorole
	 * @return
	 */
	Integer insertgongao(@Param("gongaotype")String gongaotype,@Param("gongaobiaoti")String gongaobiaoti,@Param("gongaotext")String gongaotext,@Param("gongaorole")String gongaorole,@Param("gongaogonhui")String gongaogonhui);
}
