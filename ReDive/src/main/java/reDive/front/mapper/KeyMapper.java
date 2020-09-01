package reDive.front.mapper;

import org.apache.ibatis.annotations.Param;

import reDive.front.bean.PcrMd5Info;

public interface KeyMapper {

	/**
	 * 增加找回密码的主键
	 * @param md5key
	 * @return
	 */
	Integer insertKeyPass(@Param("md5key") PcrMd5Info pcrMd5Info);
}
