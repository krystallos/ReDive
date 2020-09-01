package reDive.front.service;

import java.util.List;
import java.util.Map;
import reDive.front.bean.PcrZhenShiInfo;

public interface ZhenShiService {

	List<PcrZhenShiInfo> selectxinxi(String start,int litem,String uid,String statrtime,String bossid,String gonhui);
	List<PcrZhenShiInfo> selectxinxis(String uid,String statrtime,String gonhui);
	Integer selectallpage(String uid,String statrtime,String bossid,String gonhui);
	Map<String, Object> selectalltonji(String uid,String statrtime,String bossid);
	Integer insertZhenshi(String zhenshitype,String zhenshishanghai,String zhenshiduiwu,String bossid,
	String uid,String gonhuiid);
	Integer updateShanghai(String zhenshishanghai,String bossid);
	Integer selectHp(String bossid,String gonhuiid);
	Integer updatebosstype(String bosstype,String gonhuiid,String bossid);
	Integer updatebosstypeto(String bosstype,String gonhuiid);
	List<PcrZhenShiInfo> exclzhenshi(String start,String gonhuiid);
	List<PcrZhenShiInfo> selectalltonjidao(String gonhuiid,int now,int limte);
	Integer selectalltonjidaopage(String gonhuiid);
	Integer dels(String zhenshiid,String gonhuiid);
}
