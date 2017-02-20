package com.shavika.foodies.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shavika.foodies.api.dto.Login;
import com.shavika.foodies.api.exception.ShavikaAppException;
import com.shavika.foodies.dao.LoginDao;
import com.shavika.foodies.util.Constants;
import com.shavika.foodies.util.DateTimeUtil;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	private static final Logger LOGGER = Logger.getLogger(LoginServiceImpl.class);

	@Autowired
	private LoginDao loginDao;

	@Override
	public Login getUserLoginByName(String userName) throws ShavikaAppException {
		return this.loginDao.getLoginByName(userName);
	}

	@Override
	public Login getUserLoginByEmail(String userEmail) throws ShavikaAppException {
		return this.loginDao.getLoginByEmail(userEmail);
	}

	@Override
	public Login getUserLoginByNamePwd(String userName, String password) throws ShavikaAppException {
		return this.loginDao.getLoginByNamePwd(userName, password);
	}

	@Override
	public Login getCurrentUser() throws ShavikaAppException {
		Login login = null;
		List<Login> loginList = loginDao.findAll(Login.class);
		if (!loginList.isEmpty())
			login = loginList.get(0);
		return login;
	}

	@Override
	public Login createRupdateUser(Login login) throws ShavikaAppException {
		List<Login> loginList = loginDao.findAll(Login.class);
		if (loginList.isEmpty())
			return loginDao.save(login);
		else {
			loginDao.deleteAll(Login.class);
			return loginDao.save(login);
		}
	}

	@Override
	public String genrateResponse(boolean status, int loginType) throws ShavikaAppException {
		String returnObject = null;
		if (status && loginType == Constants.LOGIN_TYPE)
			returnObject = "{ \"STATUSCODE\":" + Constants.STATUS_CODE_SUCCESS + ", \"STATUSERROR\": \""
					+ Constants.STATUS_MSG_LOGIN_SUCCESS + "\"}";
		else if (!status && loginType == Constants.LOGIN_TYPE)
			returnObject = "{ \"STATUSCODE\":" + Constants.STATUS_CODE_ERROR + ", \"STATUSERROR\": \""
					+ Constants.STATUS_MSG_LOGIN_FAIL + "\"}";
		else if (status && loginType == Constants.REGISTERATION_TYPE)
			returnObject = "{ \"STATUSCODE\":" + Constants.STATUS_CODE_SUCCESS + ", \"STATUSERROR\": \""
					+ Constants.STATUS_MSG_REGISTER_SUCCESS + "\"}";
		else if (!status && loginType == Constants.REGISTERATION_TYPE)
			returnObject = "{ \"STATUSCODE\":" + Constants.STATUS_CODE_ERROR + ", \"STATUSERROR\": \""
					+ Constants.STATUS_MSG_REGISTER_FAIL + "\"}";
		else if (status && loginType == Constants.FORGOTPASSWORD_TYPE)
			returnObject = "{ \"STATUSCODE\":" + Constants.STATUS_CODE_SUCCESS + ", \"STATUSERROR\": \""
					+ Constants.STATUS_MSG_FORGOT_SUCCESS + "\"}";
		else if (!status && loginType == Constants.FORGOTPASSWORD_TYPE)
			returnObject = "{ \"STATUSCODE\":" + Constants.STATUS_CODE_ERROR + ", \"STATUSERROR\": \""
					+ Constants.STATUS_MSG_FORGOT_FAIL + "\"}";
		return returnObject;
	}

	@Override
	public Login getRequestUser(HttpServletRequest request) throws ShavikaAppException {
		Login login = new Login();
		// login.setId(1);
		login.setUser_name(request.getParameter("registerUsername"));
		login.setPassword(request.getParameter("registerpassword"));
		login.setEmail(request.getParameter("registeremail"));
		login.setPhone(request.getParameter("registerphone"));
		login.setSrc_element_id(String.valueOf(login.hashCode()));
		login.setIs_deleted(Constants.ID_DELETED);
		login.setCreated_on(DateTimeUtil.getMillis());
		login.setModified_on(DateTimeUtil.getMillis());
		return login;
	}

}
