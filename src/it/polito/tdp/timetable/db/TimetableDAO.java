package it.polito.tdp.timetable.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.timetable.model.School;
import it.polito.tdp.timetable.model.Subject;

public class TimetableDAO {
	
public List<School> getAllSchools() {
		
		String sql = "SELECT schoolID, name, address, startLessons, endLessons, workDays FROM school" ;
		
		try {
			Connection conn = DBConnect.getConnection() ;

			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet rs = st.executeQuery() ;
			
			List<School> list = new ArrayList<>() ;
			while(rs.next()) {
				list.add(new School(rs.getString("schoolID"), rs.getString("name"), rs.getString("address"), rs.getInt("startLessons"),
						rs.getInt("endLessons"), rs.getInt("workDays"))) ;
			}
			
			conn.close();
			return list ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}

public void addSchool(School s) {
	Connection conn = DBConnect.getConnection();

	String sql = "INSERT INTO school (schoolID, name, address, startLessons, endLessons, workDays) VALUES (?, ?, ?, ?, ?, ?);";

	PreparedStatement st;
	try {
		st = conn.prepareStatement(sql);

		st.setString(1, s.getSchoolID());
		st.setString(2, s.getName());
		st.setString(3, s.getAdress());
		st.setInt(4, s.getStartLessons());
		st.setInt(5, s.getEndLessons());
		st.setInt(6, s.getWorkDays());

		st.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
}

public List<Subject> getAllSubjects(String schoolID) {
	
	String sql = "SELECT subjectID, name, hoursWeek, hoursLab, typeLab FROM subject WHERE schoolID = '" + schoolID + "'" ;
	
	try {
		Connection conn = DBConnect.getConnection() ;

		PreparedStatement st = conn.prepareStatement(sql) ;
		
		ResultSet rs = st.executeQuery() ;
		
		List<Subject> list = new ArrayList<>() ;
		while(rs.next()) {
			list.add(new Subject(rs.getString("subjectID"), rs.getString("name"), rs.getInt("hoursWeek"), rs.getInt("hoursLab"),
					rs.getString("typeLab"))) ;
		}
		
		conn.close();
		return list ;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null ;
	}
}

public void addSubject(Subject s, String schoolID) {
	Connection conn = DBConnect.getConnection();

	String sql = "INSERT INTO subject (schoolID ,subjectID, name, hoursWeek, hoursLab, typeLab) VALUES (?, ?, ?, ?, ?, ?);";

	PreparedStatement st;
	try {
		st = conn.prepareStatement(sql);

		st.setString(1, schoolID);
		st.setString(2, s.getSubjectID());
		st.setString(3, s.getName());
		st.setInt(4, s.getHoursWeek());
		st.setInt(5, s.getHoursLab());
		st.setString(6, s.getTypeLab());


		st.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
}

}
