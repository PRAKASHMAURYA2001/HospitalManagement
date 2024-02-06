package com.hexaware.controller;

import java.util.List;

import com.hexaware.model.Appointment;

public interface IHospitalService {
	public void scheduleAppointment();
    
    public Appointment getAppointmentById(int appointmentId);

   public List<Appointment> getAppointmentsForPatient(int patientId);

    public List<Appointment> getAppointmentsForDoctor(int doctorId);

   public void updateAppointment();

   public void cancelAppointment();
}
