package com.comviva.ocs.bean;

public class LeaveBean {
	private String leaveID;
	private String doctorID;
	private String leaveFrom;
	private String leaveTo;
	private String reason;
	private int status;
	
	public String getLeaveID() {
		return leaveID;
	}
	public void setLeaveID(String leaveID) {
		this.leaveID = leaveID;
	}
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public String getLeaveFrom() {
		return leaveFrom;
	}
	public void setLeaveFrom(String leaveFrom) {
		this.leaveFrom = leaveFrom;
	}
	public String getLeaveTo() {
		return leaveTo;
	}
	public void setLeaveTo(String leaveTo) {
		this.leaveTo = leaveTo;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LeaveBean [leaveID=" + leaveID + ", doctorID=" + doctorID + ", leaveFrom=" + leaveFrom + ", leaveTo="
				+ leaveTo + ", reason=" + reason + ", status=" + status + "]";
	}
	
	
}
