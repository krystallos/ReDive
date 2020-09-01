package reDive.front.service;

import java.util.List;

import reDive.front.bean.PcrBossGonHuiInfo;


public interface BossService {

	List<PcrBossGonHuiInfo> selectBoss(String gonhui);
	Integer selectbosstype(String gonhuiid,String types);
	Integer selectbossid(String gonhuiid);
	Integer selectbossidsm(String gonhuiid);
	Integer updatebosshp(String gonhuiid);
	Integer delbossinxi(String gonhuiid);
	Integer insertbossinxi(String jd1,String jd2,String jd3,String jd4,String jd5,String gonhuiid);
	Integer selectnextpaixu(String gonhuiid,String bossid);
}
