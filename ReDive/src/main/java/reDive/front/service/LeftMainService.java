package reDive.front.service;

import java.util.List;

import reDive.front.bean.PcrMenuInfo;

public interface LeftMainService {

	List<PcrMenuInfo> selectMenu(String roleid);
}
