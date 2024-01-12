package com.comviva.ocs.service;


import com.comviva.ocs.bean.PatientBean;
//import com.comviva.ocs.bean.UserBean;
//import com.comviva.ocs.dao.DoctorDao;
import com.comviva.ocs.dao.PatientDao;




public class Patient {
	public static int AddPatient(PatientBean db) {
		return PatientDao.AddPatient(db);
		}
	public static int UpdatePatient(PatientBean db) {
		return PatientDao.UpdatePatient(db);
		}
	public static int DeletePatient(PatientBean pb) {
		return PatientDao.DeletePatient(pb);
		}
	public static PatientBean ReadPatient(String pb) {
		return PatientDao.ShowPatient(pb);
		}
//	public static String showSlotUser(PatientBean sb1) {
//		return PatientDao.selectAllslot(sb1);
//	}

}

