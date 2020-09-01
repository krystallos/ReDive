package reDive.front.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reDive.front.bean.PcrMailInfo;
import reDive.front.mapper.EmailMapper;

@Service
public class EmailServiceImpl implements EmailService{

	@Resource
	private EmailMapper emailMapper;
	
	@Override
	public PcrMailInfo selectMail(String mail) {
		// TODO Auto-generated method stub
		return emailMapper.selectMail(mail);
	}
	
	@Override
	public Integer insertMail(String mail, String uid) {
		// TODO Auto-generated method stub
		return emailMapper.insertMail(mail, uid);
	}
	
	@Override
	public Integer selectMailHas(String email) {
		// TODO Auto-generated method stub
		return emailMapper.selectMailHas(email);
	}
}
