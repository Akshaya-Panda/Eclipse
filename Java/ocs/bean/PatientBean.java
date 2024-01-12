package com.comviva.ocs.bean;

public class PatientBean {
	private String patientID;
	private String userID;
	private String appointmentDate;
	private String ailementType;
	private String ailementDetails;
	private String diagnosisHistory;
	
	@Override
	public String toString() {
		return "\npatientID=" + patientID + ",\nuserID=" + userID + ",\nappointmentDate=" + appointmentDate
				+ "\nailementType=" + ailementType + ",\nailementDetails=" + ailementDetails + "\ndiagnosisHistory="
				+ diagnosisHistory;
	}
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAilementType() {
		return ailementType;
	}
	public void setAilementType(String ailementType) {
		this.ailementType = ailementType;
	}
	public String getAilementDetails() {
		return ailementDetails;
	}
	public void setAilementDetails(String ailementDetails) {
		this.ailementDetails = ailementDetails;
	}
	public String getDiagnosisHistory() {
		return diagnosisHistory;
	}
	public void setDiagnosisHistory(String diagnosisHistory) {
		this.diagnosisHistory = diagnosisHistory;
	}
	
}
