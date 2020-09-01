package reDive.front.service;

import java.util.List;

import reDive.front.bean.PcrGonGaoInfo;

public interface GonGaoService {

	List<PcrGonGaoInfo> selectGongao(String gongaoid, String gongaogonhui);
	PcrGonGaoInfo selectnewGongao(String role);
	Integer insertgongao(String gongaotype,String gongaobiaoti,String gongaotext,String gongaorole,String gongaogonhui);
}
