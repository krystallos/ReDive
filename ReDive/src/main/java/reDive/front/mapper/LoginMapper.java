package reDive.front.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import reDive.front.bean.PcrUserInfo;

public interface LoginMapper {

	/**
	 * 登入 
	 * @param uname
	 * @param upass
	 * @return
	 */
	PcrUserInfo selectuser(@Param("uname")String uname,@Param("upass")String upass);
	
	/**
	 * 确认账号重复
	 * @param uuid
	 * @return
	 */
	Integer selectchonfu(@Param("uuid")String uuid);
	
	/**
	 * 注册
	 * @param userfront
	 * @return
	 */
	Integer insertuser(@Param("userfront")PcrUserInfo userFront);

	/**
	 * 添加工会
	 * @param gonhuiid
	 * @param names
	 * @return
	 */
	Integer updateusergonhui(@Param("gonhuiid")String gonhuiid,@Param("names")String names);

	/**
	 * T出工会工会(UID)
	 * @param gonhuiid
	 * @param names
	 * @return
	 */
	Integer updateusergonhuiid(@Param("gonhuiid")String gonhuiid,@Param("names")String names);
	
	/**
	 * 查询工会是否满员
	 * @param gonhuiid
	 * @return
	 */
	Integer selectgonhuirenshu(@Param("gonhuiid")String gonhuiid);
	
	/**
	 * 会长查询成员(根据状态)
	 * @param acctent
	 * @return
	 */
	List<PcrUserInfo> selectuseracctent(@Param("acctent")String acctent,@Param("type")String type);
	
	/**
	 * 查询工会全部成员
	 * @param gonhuiid
	 * @return
	 */
	List<PcrUserInfo> selectusergonhuiall(@Param("gonhuiid")String gonhuiid,@Param("acctent")String acctent);
	
	/**
	 * 查询工会内用户
	 * @param username
	 * @param gonhuiid
	 * @return
	 */
	List<PcrUserInfo> selectusername(@Param("username")String username,@Param("gonhuiid")String gonhuiid);
	/**
	 * 
	 * @param gonhuisid
	 * @param gonhuisid
	 * @return
	 */
	Integer updatejiesangonhui(@Param("gonhuisid")String gonhuisid,@Param("gonhuiid")String gonhuiid);
	
	/**
	 * 改名字
	 * @param usernames
	 * @param useruid
	 * @return
	 */
	Integer updatenames(@Param("usernames")String usernames,@Param("useruid")String useruid);
	
	/**
	 * 查询工会会全部成员
	 * @param gonhuiid
	 * @param useruid
	 * @return
	 */
	List<PcrUserInfo> selectalluser(@Param("gonhuiid")String gonhuiid,@Param("useruid")String useruid);
	
	/**
	 * 修改密码
	 * @param uid
	 * @param pass
	 * @return
	 */
	Integer updatepass(@Param("pass")String pass,@Param("uid")String uid);

	/**
	 * 修改密码(账户内)
	 * @param pass
	 * @param uid
	 * @return
	 */
	Integer updatepasss(@Param("pass")String pass,@Param("uid")String uid);

	/**
	 * 查询工会会长
	 * @return
	 */
	List<PcrUserInfo> selectListAdmin();

	/**
	 * 查询会长总人数
	 * @return
	 */
	int selectListAdminPage();

	/**
	 * 查询用户的公户
	 * @param usergonhui
	 * @return
	 */
	PcrUserInfo gonhuiuser(@Param("usergonhui")String usergonhui);
}
