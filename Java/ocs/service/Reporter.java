package com.comviva.ocs.service;


import com.comviva.ocs.bean.CredentialsBean;
import com.comviva.ocs.bean.LeaveBean;
import com.comviva.ocs.dao.LeaveDao;
import com.comviva.ocs.dao.UserDao;

public class Reporter {
	public static int unavailableDoc(LeaveBean lb) {
		return LeaveDao.unavailableDoc(lb);
		}

	public static int loginReporter(CredentialsBean lr) {
		return UserDao.loginUser(lr);
	}
}
