package reDive.front.service;
import java.util.List;

import reDive.front.bean.PcrUserInfo;

public interface LoginService {

	PcrUserInfo selectuser(String uname,String pass);
	Integer selectchonfu(String uuid);
	Integer insertuser(PcrUserInfo userFront);
	Integer updateusergonhui(String gonhuiid,String names);
	Integer selectgonhuirenshu(String gonhuiid);
	List<PcrUserInfo> selectuseracctent(String acctent,String type);
	List<PcrUserInfo> selectusergonhuiall(String gonhuiid,String now,String litem,String acctent);
	Integer updatejiesangonhui(String gonhuisid,String gonhuiid);
	Integer updatenames(String usernames,String useruid);
	List<PcrUserInfo> selectusername(String username,String gonhuiid);
	List<PcrUserInfo> selectalluser(String gonhuiid,String useruid);
	Integer updatepass(String tel,String pass);
	Integer updatepasss(String pass,String uid);
	PcrUserInfo gonhuiuser(String usergonhui);
	Integer updateusergonhuiid(String gonhuiid, String names);
}
