package reDive.front.mapper;

import org.apache.ibatis.annotations.Param;

import reDive.front.bean.PcrMailInfo;

public interface EmailMapper {

	/**
	 * 查询邮箱
	 * @param mail
	 * @return
	 */
	PcrMailInfo selectMail(@Param("mails")String mail);
	
	/**
	 * 添加邮箱
	 * @param mail
	 * @param uid
	 * @return
	 */
	Integer insertMail(@Param("mails")String mail,@Param("uid")String uid);
	
	/**
	 * 邮箱查重
	 * @param email
	 * @return
	 */
	Integer selectMailHas(@Param("mails")String email);
}
