package it.polito.tdp.timetable.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.timetable.model.School;

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

}
