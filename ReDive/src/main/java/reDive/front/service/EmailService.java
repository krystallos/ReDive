package reDive.front.service;

import java.util.List;
import java.util.Map;
import reDive.front.bean.PcrMailInfo;
import reDive.front.bean.PcrZhenShiInfo;

public interface EmailService {

	PcrMailInfo selectMail(String mail);
	Integer insertMail(String mail,String uid);
	Integer selectMailHas(String email);
}
