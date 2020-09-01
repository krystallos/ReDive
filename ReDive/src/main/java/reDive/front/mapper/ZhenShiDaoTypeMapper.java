package reDive.front.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import reDive.front.bean.PcrZhenShiDaoTypeInfo;

public interface ZhenShiDaoTypeMapper {

	/**
	 * 查询指定用户阵容
	 * @param uid
	 * @return
	 */
	List<PcrZhenShiDaoTypeInfo> selectuserpsolook(@Param("uid")String uid);
	
	/**
	 * 查询指定用户阵容(名称)
	 * @param uid
	 * @return
	 */
	List<PcrZhenShiDaoTypeInfo> selectuserpsolookname(@Param("uid")String uid);
	
	/**
	 * 增加用户阵容
	 * @param one
	 * @param two
	 * @param three
	 * @param four
	 * @param five
	 * @param uid
	 * @return
	 */
	Integer insertdaotype(@Param("one")String one,@Param("two")String two,@Param("three")String three,
			@Param("four")String four,@Param("five")String five,@Param("uid")String uid);
	
	/**
	 * 统计有多少队伍
	 * @param uid
	 * @return
	 */
	Integer selectalltonji(@Param("uid")String uid);
	
	/**
	 * 修改队伍
	 * @param names
	 * @param ids
	 * @param uid
	 * @return
	 */
	Integer updateduiwuname(@Param("duiwuname")String names,@Param("duiwuid")String ids,@Param("uid")String uid);
	
	/**
	 * 删除队伍
	 * @param duiwuid
	 * @param uid
	 * @return
	 */
	Integer delduiwu(@Param("duiwuid")String duiwuid,@Param("uid")String uid);
}
