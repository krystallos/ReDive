package reDive.front.service;

import java.util.List;
import reDive.front.bean.PcrZhenShiDaoTypeInfo;

public interface ZhenShiDaoTypeService {

	List<PcrZhenShiDaoTypeInfo> selectuserpsolook(String uid);
	List<PcrZhenShiDaoTypeInfo> selectuserpsolookname(String uid);
	Integer insertdaotype(String one,String two,String three,String four,String five,String uid);
	Integer selectalltonji(String uid);
	Integer updateduiwuname(String names,String ids,String uid);
	Integer delduiwu(String duiwuid,String uid);
}
