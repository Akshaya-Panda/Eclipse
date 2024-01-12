package com.comviva.ocs.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import com.comviva.ocs.bean.AppointmentBean;
import com.comviva.ocs.bean.CredentialsBean;
import com.comviva.ocs.bean.DoctorBean;
import com.comviva.ocs.bean.LeaveBean;
import com.comviva.ocs.bean.PatientBean;
import com.comviva.ocs.bean.UserBean;
import com.comviva.ocs.dao.DoctorDao;
import com.comviva.ocs.exception.doctorActionDeniedException;
import com.comviva.ocs.service.Administrator;
import com.comviva.ocs.service.Patient;
import com.comviva.ocs.service.Reporter;
import com.comviva.ocs.service.User;


public class MainUI {

//Register User(USER)
protected static void registerUser() {

		JTextField userType = new JTextField();
		JTextField password = new JPasswordField();
		Object[] userMessage = { "User Type:", userType, "Password:", password };

		int optionDoc = JOptionPane.showConfirmDialog(null, userMessage, "Register",
				JOptionPane.OK_CANCEL_OPTION);
		if (optionDoc == JOptionPane.OK_OPTION) {

			System.out.println("New User Register Sucessfully");
			RegisterOperation();
			}else {
				JOptionPane.showMessageDialog(null," Registration Cancelled");
			}
		}
	
private static CredentialsBean RegisterOperation() {

		JTextField userId = new JTextField();
		JTextField password = new JPasswordField();
		JTextField usertype = new JTextField();
		
			Object[] registerUser = { "User Id:", userId, "Password:", password,
					"User Type",usertype
					};
		
			CredentialsBean cb=new CredentialsBean();
			int optionDoc = JOptionPane.showConfirmDialog(null, registerUser, "Register",
					JOptionPane.OK_CANCEL_OPTION);
			if (optionDoc == JOptionPane.OK_OPTION) {
				JOptionPane.showMessageDialog(null,"User Register  Sucessfully");
			}
			cb.setUserid(userId.getText());
			cb.setPassword(password.getText());	
			cb.setUsertype(usertype.getText());
			return cb;
		
	}

//LOGIN
protected static void ClientCred() {

		// TODO Auto-generated method stub
		String usertype = JOptionPane.showInputDialog("Enter User Type");
		
		if (usertype.equals("Admin")) {
			JTextField userId = new JTextField();
			JTextField password = new JPasswordField();
			Object[] message = { "User Id:", userId, "Password:", password };

			int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) {
				if (userId.getText().equals("Admin") && password.getText().equals("Admin")) {
					// System.out.println("Administration Login successful");
					DoctorOperation();
				} 
			}
		}
		
		else if(usertype.equals("Reporter")) {
			CredentialsBean lr=MainUI.loginReporter();
			int loginStatus=Reporter.loginReporter(lr);
			
			if(loginStatus==1) {
				JOptionPane.showMessageDialog(null," Reporter Login Sucessfull");
				ReporterOperation();
			}else {
				JOptionPane.showMessageDialog(null," Reporter Login Failed");
			}
		}
		
		else if(usertype.equals("User")) {
			CredentialsBean lu=MainUI.loginUser();
			int loginStatus=User.loginUser(lu);
			
			if(loginStatus==1) {
				JOptionPane.showMessageDialog(null," User Login Sucessfull");
				PatientOperation();
				
			}else {
				JOptionPane.showMessageDialog(null," User Login Failed");
			}
		}else if(usertype.equals("EX-001")){
			JOptionPane.showMessageDialog(null," User Logout");
			System.exit(0);
		}else {
		}
			System.out.println("Enter valid user type");
		}
		
	
	
protected static CredentialsBean loginUser() {

			JTextField userid = new JTextField();
			JTextField password = new JPasswordField();
			String ut="User";

			Object[] messageUser = { "User Id:", userid, "Password:", password,
					"User Type",ut
					};
			CredentialsBean cb=new CredentialsBean();
			int optionDoc = JOptionPane.showConfirmDialog(null, messageUser, "Login",
					JOptionPane.OK_CANCEL_OPTION);
			if (optionDoc == JOptionPane.OK_OPTION) {
				System.out.println("User login  Sucessfully");

			}
			cb.setUserid(userid.getText());
			cb.setPassword(password.getText());	
			cb.setUsertype(ut);
			return cb;

		}


protected static CredentialsBean loginReporter() {

	JTextField userid = new JTextField();
	JTextField password = new JPasswordField();
	String ut="Reporter";

	
	Object[] messageRep = { "User Id:", userid, "Password:", password,"User Type",ut
			};
	CredentialsBean cb=new CredentialsBean();
	int optionDoc = JOptionPane.showConfirmDialog(null, messageRep, "Reporter Login",
			JOptionPane.OK_CANCEL_OPTION);
	if (optionDoc == JOptionPane.OK_OPTION) {
		System.out.println("Reporter Logined Sucessfully");

	}
	cb.setUserid(userid.getText());
	cb.setPassword(password.getText());	
	cb.setUsertype(ut);
	return cb;

}		

	

	


		//This is for (USER-->PATIENT) PS-001,PS-002,PS-003,US-002,PS-004,US-002,CS-001
private static void PatientOperation() {

			String PatientOperation = JOptionPane.showInputDialog(null,
					"Enter Code to Perform Operation on Patient Data");
			//Add USERS or register patient
			
			if (PatientOperation.equals("PS-001")) {
				//Add
					PatientBean sb1=MainUI.AddPatient();
					JOptionPane.showMessageDialog(null,Patient.AddPatient(sb1)+" record inserted successfully...");
			} 
			//Read patient
			else if (PatientOperation.equals("PS-002")) {
				PatientBean sb1=MainUI.ReadPatient();
			JOptionPane.showMessageDialog(null,sb1);
			}
//			Add User
			else if (PatientOperation.equals("US-001")) {
				UserBean sb1=MainUI.AddUser();
				JOptionPane.showMessageDialog(null,User.AddUser(sb1)+" record inserted successfully...");
				
			} 
			
			//Read User indication
			else if(PatientOperation.equals("US-002")) {
				UserBean sb1=MainUI.ReadUser();
				JOptionPane.showMessageDialog(null,sb1);
				}
			
			//Update
			else if (PatientOperation.equals("PS-003")) {
				PatientBean sb1=MainUI.UpdatePatient();
				JOptionPane.showMessageDialog(null,Patient.UpdatePatient(sb1)+" record updated successfully...");
			}
			else if(PatientOperation.equals("US-003")) {
				UserBean sb1=MainUI.UpdateUser();
				JOptionPane.showMessageDialog(null,User.UpdateUser(sb1)+" record updated successfully...");
				if(sb1.getUserID()==null) {
					JOptionPane.showMessageDialog(null,"User Id does not exist");
				}
				else {
				JOptionPane.showMessageDialog(null,sb1);
				}
			}
			//Delete
			else if (PatientOperation.equals("PS-004")) {
				PatientBean sb1=MainUI.DeletePatient();
				JOptionPane.showMessageDialog(null,Patient.DeletePatient(sb1)+" record Deleted successfully...");
			}
			//Delete User
			else if (PatientOperation.equals("US-004")) {
				UserBean sb1=MainUI.DeleteUser();
				JOptionPane.showMessageDialog(null,User.DeleteUser(sb1)+" record Deleted successfully...");
			}
			//This is used to choose slot
			else if (PatientOperation.equals("CS-001")) {
				//ReadDoc();
				String userId=JOptionPane.showInputDialog("Enter the Patient ID");
				
				ArrayList<DoctorBean> a=DoctorDao.selectAllslot(userId);
				
				AppointmentBean ab=MainUI.appointmentDoc();
				JOptionPane.showMessageDialog(null,User.appointmentDoc(ab)+" is your Appointment ID");
				String str="";
				for(DoctorBean s:a)
				{
				   str+=s.getDoctorID()+" "+s.getDoctorName()+" "+s.getGender();
				}
				JOptionPane.showMessageDialog(null, str);
			}
			else {
				JOptionPane.showMessageDialog(null,"Invalid code");
			}
		}
		



private static AppointmentBean appointmentDoc() {
	JTextField appointmentID = new JTextField();
	JTextField doctorID = new JTextField();
	JTextField patientID = new JTextField();
	JTextField appointmentDate = new JTextField();
	JTextField appointmentTime = new JTextField();
	
	Object[] messageApp = { "Appointment Id:", appointmentID, "Doctor Id:", doctorID, "Patient Id:", patientID,
			"Appointment Date:", appointmentDate,"Appointment Time: ", appointmentTime
	};
	AppointmentBean ab=new AppointmentBean();
	
	int optionDoc = JOptionPane.showConfirmDialog(null, messageApp, " Appointment Booked",
			JOptionPane.OK_CANCEL_OPTION);
	if (optionDoc == JOptionPane.OK_OPTION) {

		System.out.println("Patient Added Sucessfully");

	}
	ab.setAppointmentID(appointmentID.getText());
	ab.setDoctorID(doctorID.getText());
	ab.setPatientID(patientID.getText());
	ab.setAppointmentDate(appointmentDate.getText());
	ab.setAppointmentTime(appointmentTime.getText());		
	return ab;

	
}

//Register User(USER)
protected static void UserOperation() {

			String UserOperation = JOptionPane.showInputDialog(null,
					"Enter Code to Perform Operation:");
			//Add
			if (UserOperation.equals("US-001")) {
				UserBean sb1=MainUI.AddUser();
				JOptionPane.showMessageDialog(null,User.AddUser(sb1)+" record inserted successfully...");
				loginUser();
			} 
			else {
				JOptionPane.showMessageDialog(null,"Invalid code");
				loginUser();
			}
			
			}
	
private static PatientBean AddPatient() {

			
			JTextField patientId = new JTextField();
			JTextField userId = new JTextField();
			JTextField appoinmentDate = new JTextField();
			JTextField ailmentType = new JTextField();
			JTextField ailmentdetails = new JTextField();
			JTextField diagonisisHistory = new JTextField();
			
			Object[] messageDoc = { "Patient Id:", patientId, "User Id:", userId, "Appointement Date:", appoinmentDate,
					"Ailment Type:", ailmentType,"Ailment Details: ", ailmentdetails, "Diagonisis History: ", diagonisisHistory

			};
			PatientBean db=new PatientBean();
			
			int optionDoc = JOptionPane.showConfirmDialog(null, messageDoc, "patint Added",
					JOptionPane.OK_CANCEL_OPTION);
			if (optionDoc == JOptionPane.OK_OPTION) {

				System.out.println("Patient Added Sucessfully");

			}
			db.setPatientID(patientId.getText());
			db.setUserID(userId.getText());
			db.setAppointmentDate(appoinmentDate.getText());
			db.setAilementType(ailmentType.getText());
			db.setAilementDetails(ailmentdetails.getText());
			db.setDiagnosisHistory(diagonisisHistory.getText());		
			return db;
		}

		
//update Patient
		
	private static PatientBean UpdatePatient() {
			
			JTextField patientId = new JTextField();
			JTextField appoinmentDate = new JTextField();
			JTextField ailmentType = new JTextField();
			JTextField ailmentdetails = new JTextField();
			JTextField diagonisisHistory = new JTextField();
			
			Object[] messageDoc = { "Patient Id:", patientId,"Appointement Date:", appoinmentDate,
					"Ailment Type:", ailmentType,"Ailment Details: ", ailmentdetails, "Diagonisis History: ", diagonisisHistory

			};
			PatientBean db=new PatientBean();
			
			int optionDoc = JOptionPane.showConfirmDialog(null, messageDoc, "patint Added",
					JOptionPane.OK_CANCEL_OPTION);
			if (optionDoc == JOptionPane.OK_OPTION) {

				System.out.println("Patient Added Sucessfully");

			}
			db.setPatientID(patientId.getText());
			db.setAppointmentDate(appoinmentDate.getText());
			db.setAilementType(ailmentType.getText());
			db.setAilementDetails(ailmentdetails.getText());
			db.setDiagnosisHistory(diagonisisHistory.getText());		
			return db;
		}

	//delete patient

	private static PatientBean DeletePatient() {
		
		String patientId=JOptionPane.showInputDialog("Enter the patient ID");
		PatientBean pb=new PatientBean();
		pb.setPatientID(patientId);
		return pb;
	}
	
	//Read Patient
	private static PatientBean ReadPatient() {
		String PatientId=JOptionPane.showInputDialog("Enter the Patient ID");
		PatientBean pb=Patient.ReadPatient(PatientId);
		return pb;
	}
	
	
	
	
	//for Add User 
	
	private static UserBean AddUser() {


			JTextField userId = new JTextField();
			JTextField firstName = new JTextField();
			JTextField lastName = new JTextField();
			JTextField dateOfBirth = new JTextField();
			JTextField gender = new JTextField();
			JTextField street = new JTextField();
			JTextField location = new JTextField();
			JTextField city = new JTextField();
			JTextField state = new JTextField();
			JTextField pincode = new JTextField();
			JTextField mobileno = new JTextField();
			JTextField emailid = new JTextField();
			
			
			Object[] messageDoc = { "User Id:", userId, "First Name:", firstName, "Last Name:", lastName,
					"DOB:", dateOfBirth,"Gender: ", gender, "Street:",street,"Location:",location,"City:",city,"State:",state,"Pincode",pincode,"Mobile No:",mobileno,
					"Email:",emailid};
			UserBean db=new UserBean();
			
			int optionDoc = JOptionPane.showConfirmDialog(null, messageDoc, "user Added",
					JOptionPane.OK_CANCEL_OPTION);
			if (optionDoc == JOptionPane.OK_OPTION) {

				System.out.println("User Added Sucessfully");

			}
			db.setUserID(userId.getText());
			db.setFirstName(firstName.getText());
			db.setLastName(lastName.getText());
			db.setDateOfBirth(dateOfBirth.getText());
			db.setGender(gender.getText());
			db.setStreet(street.getText());
			db.setLocation(location.getText());
			db.setState(state.getText());
			db.setPincode(pincode.getText());
			db.setCity(city.getText());
			db.setMobileNumber(mobileno.getText());
			db.setEmailID(emailid.getText());
					
			return db;
		}

	//update user

	private static UserBean UpdateUser() {
		JTextField userId = new JTextField();
		JTextField firstName = new JTextField();
		JTextField lastName = new JTextField();
		JTextField dateOfBirth = new JTextField();
		JTextField gender = new JTextField();
		JTextField street = new JTextField();
		JTextField location = new JTextField();
		JTextField city = new JTextField();
		JTextField state = new JTextField();
		JTextField pincode = new JTextField();
		JTextField mobileno = new JTextField();
		JTextField emailid = new JTextField();
		
		Object[] messageDoc = { "User Id:", userId, "First Name:", firstName, "Last Name:", lastName,
				"DOB:", dateOfBirth,"Gender: ", gender, "Street:",street,"Location:",location,"City:",city,"State:",state,"Pincode",pincode,"Mobile No:",mobileno,
				"Email:",emailid};
		UserBean sb=new UserBean();
		
		int optionDoc = JOptionPane.showConfirmDialog(null, messageDoc, "user Added",
				JOptionPane.OK_CANCEL_OPTION);
		if (optionDoc == JOptionPane.OK_OPTION) {

			System.out.println("User Updated Sucessfully");

		}
		sb.setUserID(userId.getText());
		sb.setFirstName(firstName.getText());
		sb.setLastName(lastName.getText());
		sb.setDateOfBirth(dateOfBirth.getText());
		sb.setGender(gender.getText());
		sb.setStreet(street.getText());
		sb.setLocation(location.getText());
		sb.setState(state.getText());
		sb.setPincode(pincode.getText());
		sb.setCity(city.getText());
		sb.setMobileNumber(mobileno.getText());
		sb.setEmailID(emailid.getText());	
		return sb;
	}

	//Delete User
	private static UserBean DeleteUser() {
		String UserId=JOptionPane.showInputDialog("Enter the User ID");
		UserBean pb=new UserBean();
		pb.setUserID(UserId);
		return pb;
	}

	//ReadUser
	private static UserBean ReadUser() {
		String UserId=JOptionPane.showInputDialog("Enter the User ID");
		UserBean pb=User.ReadUser(UserId);
		return pb;
	}
	
	

//this is for the (REPORTER)
private static LeaveBean ReporterOperation() {
		
		LeaveBean sb3=MainUI.unavailableDoc();
		JOptionPane.showMessageDialog(null,Reporter.unavailableDoc(sb3)+" record inserted successfully...");
		return sb3;
		
	}
	
//this is reporter	
private static LeaveBean unavailableDoc() {
		JTextField leaveID = new JTextField();
		JTextField doctorID = new JTextField();
		JTextField leaveFrom = new JTextField();
		JTextField leaveTo = new JTextField();
		JTextField reason = new JTextField();
		JTextField status = new JTextField();
		Object[] messageReporter = { "Leave Id:", leaveID, "Doctor Id:", doctorID, "Leave From:", leaveFrom,
				"Leave To:", leaveTo,"Reason: ", reason, "Status: ", status
		};
		LeaveBean db=new LeaveBean();
		
		int optionDoc = JOptionPane.showConfirmDialog(null, messageReporter, "Doctor Leave ",
				JOptionPane.OK_CANCEL_OPTION);
		if (optionDoc == JOptionPane.OK_OPTION) {

			System.out.println("Doctor is on Leave");

		}
		db.setLeaveID(leaveID.getText());
		db.setDoctorID(doctorID.getText());
		db.setLeaveFrom(leaveFrom.getText());
		db.setLeaveTo(leaveTo.getText());
		db.setReason(reason.getText());
		db.setStatus(Integer.parseInt(status.getText()));
		return db;
		
	}





//this is for part to add doctor used by (ADMIN)
private static void DoctorOperation() {


		String adminOperation = JOptionPane.showInputDialog(null,
				"Enter Code to Perform Operation on Doctor's Data");
		//Add
		if (adminOperation.equals("AD-001")) {
			DoctorBean sb1=MainUI.AddDoc();
//			int temp=Administrator.AddDoc(sb1);
//			JOptionPane.showMessageDialog(null,temp+" record inserted successfully...");
//			System.out.println(temp);
			JOptionPane.showMessageDialog(null,Administrator.AddDoc(sb1)+" record inserted successfully...");
			ClientCred();
		} 
		//Read
		else if (adminOperation.equals("AD-002")) {
			//ReadDoc();
			ArrayList<DoctorBean> a=DoctorDao.selectAll();
			String str="";
			for(DoctorBean s:a)
			{
			   str+=s.getDoctorID()+" "+s.getDoctorName()+" "+s.getSpecialization();
			}
			
			ClientCred();

			
		}
		//Update
		else if (adminOperation.equals("AD-003")) {
			DoctorBean sb2=MainUI.UpdateDoc();
			JOptionPane.showMessageDialog(null,Administrator.UpdateDoc(sb2)+" Database Updated");
			ClientCred();
		}
		//Delete
		else if (adminOperation.equals("AD-004")) {
			
			DoctorBean sb3=MainUI.DeleteDoc();
			JOptionPane.showMessageDialog(null,Administrator.DeleteDoc(sb3)+" Database Deleted");
			ClientCred();
		}
		else {
			System.out.println("Invalid Code");
		}
		
	}

private static DoctorBean DeleteDoc() {


	String doctorId=JOptionPane.showInputDialog("Enter the Doctor Id");
	DoctorBean db=new DoctorBean();
	db.setDoctorID(doctorId);
	System.out.println("This is from doctor id "+doctorId);
	return db;
	
}

private static DoctorBean AddDoc() {
		JTextField doctorId = new JTextField();
		JTextField doctorName = new JTextField();
		JTextField DateOfBirth = new JTextField();
		JTextField DateofJoining = new JTextField();
		JTextField gender = new JTextField();
		JTextField qualification = new JTextField();
		JTextField specialization = new JTextField();
		JTextField yearsofexperience = new JTextField();
		JTextField street = new JTextField();
		JTextField Location = new JTextField();
		JTextField city = new JTextField();
		JTextField state = new JTextField();
		JTextField contactno = new JTextField();
		JTextField pincode = new JTextField();
		JTextField emailid = new JTextField();
		Object[] messageDoc = { "Doctor Id:", doctorId, "Doctor Name:", doctorName, "Date of Birth:", DateOfBirth,
				"Date of Joining:", DateofJoining,"Gender: ", gender, "Qualification: ", qualification, "specialization: ",
				specialization, "Years Of Experience: ", yearsofexperience, "Street: ", street,
				"Location: ", Location,"city:",city, "state:", state, "Contact:", contactno,"pincode:", pincode, "Email Id:", emailid

		};
		DoctorBean db=new DoctorBean();
		
		int optionDoc = JOptionPane.showConfirmDialog(null, messageDoc, "Doctor Added",
				JOptionPane.OK_CANCEL_OPTION);
		if (optionDoc == JOptionPane.OK_OPTION) {

			System.out.println("Doctor Added Sucessfully");
			

		}
		else {
			try {
				throw new doctorActionDeniedException();
			}catch(doctorActionDeniedException ie){
				System.out.println(ie);
			}
		}
		db.setDoctorID(doctorId.getText());
		db.setDoctorName(doctorName.getText());
		db.setDateOfBirth(DateOfBirth.getText());
		db.setDateOfJoining(DateofJoining.getText());
		db.setGender(gender.getText());
		db.setQualification(qualification.getText());
		db.setSpecialization(specialization.getText());
		db.setYearOfExperience(yearsofexperience.getText());
		db.setStreet(street.getText());
		db.setLocation(Location.getText());
		db.setCity(city.getText());
		db.setState(state.getText());
		db.setPincode(pincode.getText());
		db.setContactNumber(contactno.getText());
		db.setEmailID(emailid.getText());
		return db;
	}
	
private static DoctorBean UpdateDoc() {
	String doctorId=JOptionPane.showInputDialog("Enter Doctor Id");
//	JTextField doctorId = new JTextField();
	JTextField doctorName = new JTextField();
	JTextField DateofBirth = new JTextField();
	JTextField gender = new JTextField();
	JTextField qualification = new JTextField();
	JTextField specialization = new JTextField();
	JTextField yearsofexperience = new JTextField();
	JTextField street = new JTextField();
	JTextField Location = new JTextField();
	JTextField state = new JTextField();
	JTextField contactno = new JTextField();
	JTextField emailid = new JTextField();
	// JTextField docName = new JPasswordField();
	Object[] messageDoc = { "Doctor Id:", doctorId, "Doctor Name:", doctorName, "DOB:", DateofBirth,
			"Gender: ", gender, "Qualification: ", qualification, "specialization: ",
			specialization, "Years Of Experience: ", yearsofexperience, "Street: ", street,
			"Location: ", Location, "state:", state, "Contact:", contactno, "Email Id:", emailid

	};
	
	DoctorBean db=new DoctorBean();
	int optionDoc = JOptionPane.showConfirmDialog(null, messageDoc, "Update Doctor",
			JOptionPane.OK_CANCEL_OPTION);
	if (optionDoc == JOptionPane.OK_OPTION) {

		System.out.println("Doctor Updated Sucessfully");

	}
	db.setDoctorID(doctorId);
	db.setDoctorName(doctorName.getText());
	//db.setDateOfBirth(DateOfBirth.getText());
	db.setGender(gender.getText());
	db.setQualification(qualification.getText());
	db.setSpecialization(specialization.getText());
	db.setYearOfExperience(yearsofexperience.getText());
	db.setStreet(street.getText());
	db.setLocation(Location.getText());
	db.setState(state.getText());
	db.setContactNumber(contactno.getText());
	db.setEmailID(emailid.getText());
	
	return db;
	
}




	


public static void main(String[] args) {
		
//	LeaveBean sb3=MainUI.unavailableDoc();
//	JOptionPane.showMessageDialog(null,Reporter.unavailableDoc(sb3)+" record inserted successfully...");
	
//		loginUser();
		 
		JFrame win = new JFrame("Welcome to Comcubs Clinic");
	    JPanel P1, P2;
	    P1 = new JPanel();
	    win.add(P1,BorderLayout.PAGE_START);
	    P2 = new JPanel();
	    P2.setLayout (new GridLayout(1,2));
	    JButton b1, b2 ; 
	    b1 = new JButton(" Login ");
	    P2.add(b1);
	    b2 = new JButton(" Register ");
	    P2.add(b2);
	    win.setVisible(true);
	    b1.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	//loginUser();
	        	win.setVisible(false);
	        	ClientCred();
	        	
	        }
	    });

	    b2.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	win.setVisible(false);
	        	CredentialsBean ru=MainUI.RegisterOperation();
	        	int temp=User.RegisterUser(ru);
				//JOptionPane.showMessageDialog(null,temp+" User Register");
			if(temp==1) {
				System.out.println(temp);
				ClientCred();
				}else {
					JOptionPane.showMessageDialog(null," Registration Failed");
				}
	        }
	    });
	    win.add(P2);
	    win.setSize(500,200);
	    
		win.setLocationRelativeTo(null);

	
	}
}
