package reDive.front.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import reDive.front.bean.PcrUserInfo;
import reDive.front.mapper.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService{

	@Resource
	private LoginMapper loginMapper;
	
	@Override
	public PcrUserInfo selectuser(String uname, String pass) {
		// TODO Auto-generated method stub
		PcrUserInfo list = loginMapper.selectuser(uname, pass);
		return list;
	}
	
	@Override
	public Integer selectchonfu(String uuid) {
		// TODO Auto-generated method stub
		Integer a = loginMapper.selectchonfu(uuid);
		return a;
	}
	
	@Override
	public Integer insertuser(PcrUserInfo userFront) {
		// TODO Auto-generated method stub
		Integer a = loginMapper.insertuser(userFront);
		return a;
	}
	
	@Override
	public Integer updateusergonhui(String gonhuiid, String names) {
		// TODO Auto-generated method stub
		Integer a = loginMapper.updateusergonhui(gonhuiid, names);
		return a;
	}
	
	@Override
	public Integer selectgonhuirenshu(String gonhuiid) {
		// TODO Auto-generated method stub
		Integer a = loginMapper.selectgonhuirenshu(gonhuiid);
		return a;
	}
	
	@Override
	public List<PcrUserInfo> selectuseracctent(String acctent,String type) {
		// TODO Auto-generated method stub
		return loginMapper.selectuseracctent(acctent,type);
	}
	
	@Override
	public List<PcrUserInfo> selectusergonhuiall(String gonhuiid,String now,String litem,String acctent) {
		// TODO Auto-generated method stub
		PageHelper.offsetPage(Integer.valueOf(now), Integer.valueOf(litem));
		List<PcrUserInfo> list = loginMapper.selectusergonhuiall(gonhuiid,acctent);
		return list;
	}
	
	@Override
	public Integer updatejiesangonhui(String gonhuisid, String gonhuiid) {
		// TODO Auto-generated method stub
		return loginMapper.updatejiesangonhui(gonhuisid, gonhuiid);
	}
	
	@Override
	public Integer updatenames(String usernames, String useruid) {
		// TODO Auto-generated method stub
		return loginMapper.updatenames(usernames, useruid);
	}
	
	@Override
	public List<PcrUserInfo> selectusername(String username, String gonhuiid) {
		// TODO Auto-generated method stub
		return loginMapper.selectusername(username, gonhuiid);
	}
	
	@Override
	public List<PcrUserInfo> selectalluser(String gonhuiid, String useruid) {
		// TODO Auto-generated method stub
		return loginMapper.selectalluser(gonhuiid, useruid);
	}
	
	@Override
	public Integer updatepass(String tel, String pass) {
		// TODO Auto-generated method stub
		return loginMapper.updatepass(tel, pass);
	}

	@Override
	public Integer updatepasss(String pass,String uid){
		// TODO Auto-generated method stub
		return loginMapper.updatepass(pass, uid);
	}

	@Override
	public PcrUserInfo gonhuiuser(String usergonhui) {
		// TODO Auto-generated method stub
		return loginMapper.gonhuiuser(usergonhui);
	}

	@Override
	public Integer updateusergonhuiid(String gonhuiid, String names) {
		// TODO Auto-generated method stub
		return loginMapper.updateusergonhuiid(gonhuiid, names);
	}


}
