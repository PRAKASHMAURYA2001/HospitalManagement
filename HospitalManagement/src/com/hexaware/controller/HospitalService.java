package com.hexaware.controller;



import java.util.List;

import java.util.Scanner;

import com.hexaware.dao.HospitalDAO;

import com.hexaware.model.Appointment;



public class HospitalService implements IHospitalService {

    
    Scanner sc = new Scanner(System.in);
	HospitalDAO hospitalDAO = new HospitalDAO();
	 Appointment appointment = new Appointment() ;
	
	 
	    public void scheduleAppointment() {
	        appointment = new Appointment();
	    	System.out.println("--Please enter Appointment details--\n");

			System.out.print("Enter your Patient ID: ");
			int patientId = sc.nextInt();
			appointment.setPatientId(patientId);

			System.out.print("Enter Doctor ID: ");
			int doctorId = sc.nextInt();
			appointment.setDoctorId(doctorId);
			
			System.out.print("Enter Appointment Date");
			String appointmentDate =sc.next();
			appointment.setAppointmentDate(appointmentDate);
			
		    System.out.print("Enter the Description");
		    String description = sc.next();
		    appointment.setDescription(description);

			System.out.println("reservation details were added succesfully!");
			hospitalDAO.scheduleAppointment(appointment);
	    }

    @Override
    public Appointment getAppointmentById(int appointmentId) {
    	
    	Appointment appointmentById = hospitalDAO.getAppointmentById(appointmentId);
		return appointmentById;
        
    }

    @Override
    public List<Appointment> getAppointmentsForPatient(int patientId) {
    	List<Appointment> allAppointments = hospitalDAO.getAppointmentsForPatient(patientId);
		return allAppointments;
       
    }

    @Override
    public List<Appointment> getAppointmentsForDoctor(int doctorId) {
    	List<Appointment> allAppointments = hospitalDAO.getAppointmentsForDoctor(doctorId);
		return allAppointments;
        
    }

   

    @Override
    public void updateAppointment() {
    	System.out.print("Enter Appointment ID to update: ");
        int updateAppointmentId = sc.nextInt();
        sc.nextLine(); // Consume newline
        Appointment updatedAppointment = hospitalDAO.getAppointmentById(updateAppointmentId);
        if (updatedAppointment != null) {
            System.out.print("Enter new Doctor ID: ");
            updatedAppointment.setDoctorId(sc.nextInt());
            
            System.out.print("Enter new Appointment Date");
    		String appointmentDate =sc.next();
    		updatedAppointment.setAppointmentDate(appointmentDate);
    		
    	    System.out.print("Enter the new Description");
    	    String description = sc.next();
    	    updatedAppointment.setDescription(description);
           
           
            hospitalDAO.updateAppointment(updatedAppointment);
            System.out.println("Reservation updated successfully");
        } else {
            System.out.println("Reservation not found");
        }
	
    }

    @Override
    public void cancelAppointment() {
    	System.out.print("Enter Reservation ID to remove: ");
        int removeReservationId = sc.nextInt();
        hospitalDAO.cancelAppointment(removeReservationId);
        System.out.println("  appointment cancelled successfully");
    }
}
