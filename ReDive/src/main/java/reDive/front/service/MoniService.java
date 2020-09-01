package reDive.front.service;

import java.util.List;

import reDive.front.bean.PcrMonInfo;

public interface MoniService {

	List<PcrMonInfo> selectmoni(String start,String limit,String uid,
			String statrtime,String overtime,String bossid,String gonhui);
	List<PcrMonInfo> selecttonjimoni(String start,int litem,String uid,
			String statrtime,String overtime,String bossid,String gonhui);
	Integer selectchafen(String uid,String statrtime,String overtime,String bossid,String gonhui);
	Integer selectall(String uid,String statrtime,String overtime,String bossid, String gonhui);
	Integer selecttonjiall(String uid,String statrtime,String overtime,String bossid, String gonhui);
	Integer insertmoni(String gonhui,String bossid,String shanghai,String daotype,String uid);
	List<PcrMonInfo> exclmoni(String start,String gonhuiid);
	Integer delmoni(Integer gonhuiid,Integer userid,String moniid);
}
