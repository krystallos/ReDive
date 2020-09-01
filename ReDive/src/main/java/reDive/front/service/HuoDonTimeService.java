package reDive.front.service;

import java.util.List;

import reDive.front.bean.PcrHuoDonTimeInfo;

public interface HuoDonTimeService {

	List<PcrHuoDonTimeInfo> selectnowyhuodon();
	Integer inserthuodon(PcrHuoDonTimeInfo huodon);
}
