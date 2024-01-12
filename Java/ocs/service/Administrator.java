package com.comviva.ocs.service;


import com.comviva.ocs.bean.DoctorBean;
import com.comviva.ocs.bean.ScheduleBean;
import com.comviva.ocs.dao.DoctorDao;

public class Administrator {
	public static int AddDoc(DoctorBean db) {
		return DoctorDao.AddDoc(db);
		}
	public static int UpdateDoc(DoctorBean db) {
		return DoctorDao.UpdateDoc(db);
	}
	public static int DeleteDoc(DoctorBean db) {
		return DoctorDao.DeleteDoc(db);
	}

}

