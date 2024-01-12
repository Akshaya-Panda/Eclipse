package com.comviva.ocs.service;


import com.comviva.ocs.bean.AppointmentBean;
import com.comviva.ocs.bean.CredentialsBean;
import com.comviva.ocs.bean.PatientBean;
import com.comviva.ocs.bean.ScheduleBean;
import com.comviva.ocs.bean.UserBean;
import com.comviva.ocs.dao.PatientDao;
import com.comviva.ocs.dao.UserDao;



public class User{
	public static int AddUser(UserBean db) {
		return UserDao.AddUser(db);
		}
	public static int UpdateUser(UserBean sb) {
		return UserDao.UpdateUser(sb);
		}
	public static int DeleteUser(UserBean pb) {
		return UserDao.DeleteUser(pb);
		}
	public static UserBean ReadUser(String pb) {
		return UserDao.ShowUser(pb);
		}
	public static int loginUser(CredentialsBean lu) {
		return UserDao.loginUser(lu);
	}
	public static int RegisterUser(CredentialsBean ru) {
		return UserDao.registerUser(ru);
	}
	public static String appointmentDoc(AppointmentBean ab) {
		// TODO Auto-generated method stub
		return UserDao.appointmentDoc(ab);
	}

	
}
