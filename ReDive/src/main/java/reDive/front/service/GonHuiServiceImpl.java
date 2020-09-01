package reDive.front.service;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import reDive.front.bean.PcrGonHuiInfo;
import reDive.front.bean.PcrUserInfo;
import reDive.front.mapper.GonHuiMapper;
import reDive.front.mapper.LoginMapper;

@Service
public class GonHuiServiceImpl implements GonHuiService{

	@Resource
	private GonHuiMapper gonHuiMapper;
	@Resource
	private LoginMapper loginMapper;

	@Override
	public List<PcrGonHuiInfo> selectGonhui(String gonhuiName) {
		// TODO Auto-generated method stub
		return gonHuiMapper.selectGonhui(gonhuiName);
	}

	@Override
	public List<PcrUserInfo> selectListAdmin(String start,int litem) {
		// TODO Auto-generated method stub
		PageHelper.offsetPage(Integer.valueOf(start), litem);
		List<PcrUserInfo> list = loginMapper.selectListAdmin();
		return list;
	}

	@Override
	public Integer selectListAdminPage() {
		return loginMapper.selectListAdminPage();
	}

	@Override
	public Integer insertGonhui(PcrGonHuiInfo pcrGonHuiInfo) {
		// TODO Auto-generated method stub
		return gonHuiMapper.insertGonhui(pcrGonHuiInfo);
	}
	
	@Override
	public Integer delGonhui(String gonhuiid) {
		// TODO Auto-generated method stub
		return gonHuiMapper.delGonhui(gonhuiid);
	}

	public Integer selectCountAdmin(String gonhuiid){
		// TODO Auto-generated method stub
		return gonHuiMapper.selectCountAdmin(gonhuiid);
	}

	@Override
	public Integer updateAdminUser(String uid, String gonhuiid, String type) {
		// TODO Auto-generated method stub
		return gonHuiMapper.updateAdminUser(uid,gonhuiid,type);
	}

}
