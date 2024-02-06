package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.model.Appointment;
import com.hexaware.util.DBConnection;

public class HospitalDAO {
	Connection con=DBConnection.getDBConn();
	  Statement stmt;
	  PreparedStatement ps;
	  ResultSet rs;
	  
	  
	  public void scheduleAppointment(Appointment appointment) {
		  try {
			     // con = DBConnection.getDBConn();
			      ps =
			        con.prepareStatement(
			          "INSERT INTO Appointment" +
			          "(patientId, doctorId, appointmentDate,description)" +
			          "VALUES (?,?,?,?)",
			          Statement.RETURN_GENERATED_KEYS
			        );
			      ps.setInt(1, appointment.getPatientId());
			      ps.setInt(2, appointment.getDoctorId());
			      ps.setString(3, appointment.getAppointmentDate());
			      ps.setString(4, appointment.getDescription());
			     
			      int affectedRows = ps.executeUpdate();
			      //System.out.println(no_of_rows + " inserted Successfully !!!" );

			      if (affectedRows > 0) {
			        // Retrieve auto-generated keys (in this case, appointmentID)
			        ResultSet generatedKeys = ps.getGeneratedKeys();
			        if (generatedKeys.next()) {
			          int generatedAppointmentID = generatedKeys.getInt(1);
			          appointment.setAppointmentId(generatedAppointmentID);
			         
			          System.out.println(
			            "Your new Appointment ID: " +
			            		generatedAppointmentID 
			           
			          );
			        }
			      }
			    } catch (SQLException e) {
			      e.printStackTrace();
			    }
			  }
	  
	//Get an Reservation by ID
	  public Appointment getAppointmentById(int appointmentId) {
	  	
		  Appointment appointment = null;

		try {
			//con = DBConnection.getDBConn();
		    String sqlQuery = "SELECT * FROM Appointment WHERE AppointmentId = ?";

			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, appointmentId);
			rs = ps.executeQuery();

			if (rs.next()) {
				
			    // Create Appointment object from ResultSet
				appointment = new Appointment(
				    rs.getInt("appointmentId"),
				    rs.getInt("patientId"),
				    rs.getInt("doctorId"),
				    rs.getString("appointmentDate"),
				    rs.getString("description"));
				   
				   }
		    
		} catch (SQLException e) {
		    e.printStackTrace();
		    // Handle SQL exception
		} 
			return appointment;
		}
	  
	  public List<Appointment> getAppointmentsForPatient(int patientId){
		  
		  List<Appointment> appointments = new ArrayList<>();

		  Appointment appointment=null;
			try {
				//con = DBConnection.getDBConn();
			    String sqlQuery = "SELECT * FROM Appointment WHERE patientId = ?";

				ps = con.prepareStatement(sqlQuery);
				ps.setInt(1, patientId);
				rs = ps.executeQuery();

				while (rs.next()) {
					
				    // Create Appointment object from ResultSet
					appointment = new Appointment(
							rs.getInt("appointmentId"),
						    rs.getInt("patientId"),
						    rs.getInt("doctorId"),
						    rs.getString("appointmentDate"),
						    rs.getString("description"));
					appointments.add(appointment);
					   }
			    
			} catch (SQLException e) {
			    e.printStackTrace();
			    // Handle SQL exception
			} 
				return appointments;
	  }
	  
	  public List<Appointment> getAppointmentsForDoctor(int doctorId){
		  List<Appointment> appointments = new ArrayList<>();

		  Appointment appointment=null;
			try {
				//con = DBConnection.getDBConn();
			    String sqlQuery = "SELECT * FROM Appointment WHERE doctorId = ?";

				ps = con.prepareStatement(sqlQuery);
				ps.setInt(1, doctorId);
				rs = ps.executeQuery();

			      while (rs.next()) {
					
				    // Create Appointment object from ResultSet
					appointment = new Appointment(
							rs.getInt("appointmentId"),
						    rs.getInt("patientId"),
						    rs.getInt("doctorId"),
						    rs.getString("appointmentDate"),
						    rs.getString("description"));
					appointments.add(appointment);
					   }
			    
			} catch (SQLException e) {
			    e.printStackTrace();
			    // Handle SQL exception
			} 
				return appointments;
		  
	  }
	  
	  
	 
	  
	  
	//Update an Reservation
	  public void updateAppointment(Appointment appointment) {
		try {
		    String query = "UPDATE Appointment SET doctorId = ?, appointmentDate = ?, "
		    		+ "description = ? WHERE AppointmentId = ?";
		    ps = con.prepareStatement(query);
		    ps.setInt(1, appointment.getDoctorId());
		    ps.setString(2, appointment.getAppointmentDate());
		    ps.setString(3, appointment.getDescription());
		      int appointmentId = appointment.getAppointmentId();
		      ps.setInt(4,appointmentId );
			ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
		    e.printStackTrace();
		    // Handle SQL exception
		}
	  }
	  
	  public void cancelAppointment(int appointmentId) {
		  try {
			    String query = "DELETE FROM Appointment WHERE appointmentId = ?";
			    ps = con.prepareStatement(query);
				ps.setInt(1, appointmentId);

				ps.executeUpdate();
			 
			} catch (SQLException e) {
			    e.printStackTrace();
			    // Handle SQL exception
			}
	  }
	  	  
}
