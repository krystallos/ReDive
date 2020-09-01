package reDive.front.service;

import java.util.List;

import reDive.front.bean.PcrGonHuiInfo;
import reDive.front.bean.PcrUserInfo;

public interface GonHuiService {

	List<PcrGonHuiInfo> selectGonhui(String gonhuiName);
	List<PcrUserInfo> selectListAdmin(String start,int litem);
	Integer selectListAdminPage();
	Integer insertGonhui(PcrGonHuiInfo pcrGonHuiInfo);
	Integer delGonhui(String gonhuiid);
	Integer selectCountAdmin(String gonhuiid);
	Integer updateAdminUser(String uid,String gonhuiid,String type);
}
