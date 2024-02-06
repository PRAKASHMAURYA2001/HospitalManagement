package com.hexaware.main;


import java.util.Scanner;

import com.hexaware.controller.*;
public class HospitalMain {

	public static void main(String[] args) {
		IHospitalService hospitalService = new HospitalService();
		Scanner sc = new Scanner(System.in);
		String ch = null;
 	   
 	   do {
 		   System.out.println("Enter your choice");
			System.out.println("1. Register");
			System.out.println("2. View appointment Details By ID");
			System.out.println("3. List Appointment for patient");
			System.out.println("4. List Appointment for doctors");
			System.out.println("5. Update appointments");
			System.out.println("6. cancel appointments");
			
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				hospitalService.scheduleAppointment();;
				    break;
				
			case 2:
				System.out.print("Enter Appointment ID");
				int appointmentId =sc.nextInt();
				System.out.println("appointment details:" + hospitalService.getAppointmentById(appointmentId));
				
				    break;
				
			case 3:
				System.out.print("Enter patient ID");
				int patientId =sc.nextInt();
				System.out.println("All appointments: " + hospitalService.getAppointmentsForPatient(patientId));
				    break;
				    
			case 4:
				System.out.print("Enter doctor ID");
				int doctorId =sc.nextInt();
				System.out.println("All appointments: " + hospitalService.getAppointmentsForDoctor(doctorId));
				    break;
				    
			case 5:
				hospitalService.updateAppointment();
				    break;
				    
			case 6:
				hospitalService.cancelAppointment();
				    
			default:
				    System.out.println("Choose a proper choice");
				    break;
			}
			System.out.println("Do you want to continue? Y | y");
			ch = sc.next();
 	   } while (ch.equals("Y") || ch.equals("y"));
		
		
	}

}
