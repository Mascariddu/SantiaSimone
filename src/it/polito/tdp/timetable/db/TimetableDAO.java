package it.polito.tdp.timetable.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.timetable.model.Class;
import it.polito.tdp.timetable.model.Course;
import it.polito.tdp.timetable.model.Lab;
import it.polito.tdp.timetable.model.School;
import it.polito.tdp.timetable.model.Subject;
import it.polito.tdp.timetable.model.Teacher;

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
	
	String sql = "SELECT subjectID, name FROM subject WHERE schoolID = '" + schoolID + "'" ;
	
	try {
		Connection conn = DBConnect.getConnection() ;

		PreparedStatement st = conn.prepareStatement(sql) ;
		
		ResultSet rs = st.executeQuery() ;
		
		List<Subject> list = new ArrayList<>() ;
		while(rs.next()) {
			list.add(new Subject(rs.getString("subjectID"), rs.getString("name")));
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

	String sql = "INSERT INTO subject (schoolID ,subjectID, name) VALUES (?, ?, ?);";

	PreparedStatement st;
	try {
		st = conn.prepareStatement(sql);

		st.setString(1, schoolID);
		st.setString(2, s.getSubjectID());
		st.setString(3, s.getName());

		st.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
}

public void addNewCourse(Course c, String schoolID) {
	Connection conn = DBConnect.getConnection();

	String sql = "INSERT INTO course (schoolID ,courseID, grade, name) VALUES (?, ?, ?, ?);";

	PreparedStatement st;
	try {
		st = conn.prepareStatement(sql);

		st.setString(1, schoolID);
		st.setString(2, c.getCourseID());
		st.setInt(3, c.getGrade());
		st.setString(4, c.getName());

		st.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public List<Course> getAllCourses(String schoolID) {
	
	String sql = "SELECT courseID, name, grade FROM course WHERE schoolID = '" + schoolID + "'" ;
	
	try {
		Connection conn = DBConnect.getConnection() ;

		PreparedStatement st = conn.prepareStatement(sql) ;
		
		ResultSet rs = st.executeQuery() ;
		
		List<Course> list = new ArrayList<>() ;
		while(rs.next()) {
			list.add(new Course(rs.getString("courseID"), rs.getInt("grade"),rs.getString("name"))) ;
		}
		
		conn.close();
		return list ;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null ;
	}
}

public Map<String, Integer> getAllSubjectByCourse(String schoolID, String courseID) {
	String sql = "SELECT subjectID, hoursweek FROM study_plan WHERE schoolID = '" + schoolID + "' AND courseID = '" + courseID + "'" ;
	
	try {
		Connection conn = DBConnect.getConnection() ;

		PreparedStatement st = conn.prepareStatement(sql) ;
		
		ResultSet rs = st.executeQuery() ;
		
		Map<String, Integer> map = new HashMap<>() ;
		while(rs.next()) {
			map.put(rs.getString("subjectID"), rs.getInt("hoursweek"));
		}
		
		conn.close();
		return map ;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null ;
	}
	
	
}

public void updateSubject(Subject s, String schoolID) {
	Connection conn = DBConnect.getConnection();

	String sql = "UPDATE `timetable`.`subject` SET `name`= ? WHERE  `subjectID`= ? AND `schoolID`= ?";

	PreparedStatement st;
	try {
		st = conn.prepareStatement(sql);

		st.setString(1, s.getName());
		st.setString(2, s.getSubjectID());
		st.setString(3, schoolID);


		st.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void addSubjectsToCourse(String schoolID, String courseID, Map<String, Integer> listSubject) {
	Connection conn = DBConnect.getConnection(); 

	for( String subjectID : listSubject.keySet() ) {
		String sql = "INSERT INTO study_plan (subjectID, courseID, schoolID, hoursweek ) VALUES (?, ?, ?, ?);";
	
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
	
			st.setString(1, subjectID);
			st.setString(2, courseID);
			st.setString(3, schoolID);
			st.setInt(4, listSubject.get(subjectID));
	
			st.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public List<Lab> getAllLab(String schoolID) {
	String sql =  "SELECT labID, name, type FROM lab WHERE schoolID = '" + schoolID + "'" ;
	
	try {
		Connection conn = DBConnect.getConnection() ;

		PreparedStatement st = conn.prepareStatement(sql) ;
		
		ResultSet rs = st.executeQuery() ;
		
		List<Lab> list = new ArrayList<>() ;
		while(rs.next()) {
			list.add(new Lab(rs.getString("labID"), rs.getString("name"), rs.getString("type"))) ;
		}
		
		conn.close();
		return list ;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null ;
	}
}

public void addNewLab(Lab l, String schoolID) {
	Connection conn = DBConnect.getConnection();

	String sql = "INSERT INTO lab (schoolID ,labID, name, type) VALUES (?, ?, ?, ?);";

	PreparedStatement st;
	try {
		st = conn.prepareStatement(sql);

		st.setString(1, schoolID);
		st.setString(2, l.getLabID());
		st.setString(3, l.getName());
		st.setString(4, l.getType());


		st.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void updateCourse(Course c, String schoolID) {
	Connection conn = DBConnect.getConnection();

	String sql = "UPDATE `timetable`.`course` SET `name`= ?, `grade`= ? WHERE  `courseID`= ? AND `schoolID`= ?";

	PreparedStatement st;
	try {
		st = conn.prepareStatement(sql);

		st.setString(1, c.getName());
		st.setInt(2, c.getGrade());
		st.setString(3, c.getCourseID());
		st.setString(4, schoolID);


		st.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void removeSubjectsToCourse(String schoolID, String courseID, List<String> listSubject) {
	Connection conn = DBConnect.getConnection();

	for(String subjectID :listSubject) {
		String sql = "DELETE FROM `timetable`.`study_plan` "
				+ "WHERE `subjectID`= ? AND `courseID`= ? AND `schoolID`= ?;";
	
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
	
			st.setString(1, subjectID);
			st.setString(2, courseID);
			st.setString(3, schoolID);
	
			st.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public void updateLab(Lab l, String schoolID) {
	Connection conn = DBConnect.getConnection();

	String sql = "UPDATE `timetable`.`lab` SET `name`= ?, `type`= ? WHERE  `labID`= ? AND `schoolID`= ?";

	PreparedStatement st;
	try {
		st = conn.prepareStatement(sql);

		st.setString(1, l.getName());
		st.setString(2, l.getType());
		st.setString(3, l.getLabID());
		st.setString(4, schoolID);


		st.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public List<Teacher> getAllTeachers(String schoolID) {
	String sql = "SELECT teacherID, name, surname, hoursWeek, freeDay FROM teacher WHERE schoolID = '" + schoolID + "'" ;
	
	try {
		Connection conn = DBConnect.getConnection() ;

		PreparedStatement st = conn.prepareStatement(sql) ;
		
		ResultSet rs = st.executeQuery() ;
		
		List<Teacher> list = new ArrayList<>() ;
		while(rs.next()) {
			list.add(new Teacher(rs.getString("teacherID"), 
					rs.getString("name"), 
					rs.getString("surname"),
					rs.getInt("hoursWeek"), 
					rs.getInt("freeday"))) ;
		}
		
		conn.close();
		return list ;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null ;
	}
}

public void addNewTeacher(Teacher t, String schoolID) {
	Connection conn = DBConnect.getConnection();

	String sql = "INSERT INTO teacher (schoolID ,teacherID, name, surname, hoursWeek, freeDay) VALUES (?, ?, ?, ?, ?, ?);";

	PreparedStatement st;
	try {
		st = conn.prepareStatement(sql);

		st.setString(1, schoolID);
		st.setString(2, t.getTeacherID());
		st.setString(3, t.getName());
		st.setString(4, t.getSurname());
		st.setInt(5, t.getHoursWeek());
		st.setInt(6, t.getFreeDay());

		st.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

public void addSubjectsToTeacher(String schoolID, String teacherID, List<String> enablingSub) {
	Connection conn = DBConnect.getConnection();

	for(String subjectID : enablingSub) {
		String sql = "INSERT INTO enabling (schoolID, subjectID, teacherID ) VALUES (?, ?, ?);";
	
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
	
			st.setString(1, schoolID);
			st.setString(2, subjectID);
			st.setString(3, teacherID);
	
			st.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public List<String> getAllSubjectByTeacher(String schoolID, String teacherID) {
	String sql = "SELECT subjectID FROM enabling WHERE schoolID = '" + schoolID + "' AND teacherID = '" + teacherID + "'" ;
	
	try {
		Connection conn = DBConnect.getConnection() ;

		PreparedStatement st = conn.prepareStatement(sql) ;
		
		ResultSet rs = st.executeQuery() ;
		
		List<String> list = new ArrayList<>() ;
		while(rs.next()) {
			list.add(rs.getString("subjectID"));
		}
		
		conn.close();
		return list ;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null ;
	}
}

public void removeSubjectsToTeacher(String schoolID, String teacherID, List<String> enablingSub) {
	Connection conn = DBConnect.getConnection();

	for(String subjectID : enablingSub) {
		String sql = "DELETE FROM `timetable`.`enabling` "
				+ "WHERE `subjectID`= ? AND `teacherID`= ? AND `schoolID`= ?;";
	
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
	
			st.setString(1, subjectID);
			st.setString(2, teacherID);
			st.setString(3, schoolID);
	
			st.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public void updateTeacher(Teacher c, String schoolID) {
	Connection conn = DBConnect.getConnection();

	String sql = "UPDATE `timetable`.`teacher` SET `name`= ?, `surname`= ? , `hoursWeek`= ?, `freeDay`= ?"
			+ " WHERE  `teacherID`= ? AND `schoolID`= ?";

	PreparedStatement st;
	try {
		st = conn.prepareStatement(sql);

		st.setString(1, c.getName());
		st.setString(2, c.getSurname());
		st.setInt(3, c.getHoursWeek());
		st.setInt(4, c.getFreeDay());
		st.setString(5, c.getTeacherID());
		st.setString(6, schoolID);


		st.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public List<Class> getAllClasses(String schoolID) {
	String sql = "SELECT classID, grade, section, courseID FROM class WHERE schoolID = '" + schoolID + "'" ;
	
	try {
		Connection conn = DBConnect.getConnection() ;

		PreparedStatement st = conn.prepareStatement(sql) ;
		
		ResultSet rs = st.executeQuery() ;
		
		List<Class> list = new ArrayList<>() ;
		while(rs.next()) {
			list.add(new Class(rs.getString("classID"), 
					rs.getInt("grade"),
					rs.getString("section"), 
					rs.getString("courseID")));
		}
		
		conn.close();
		return list ;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null ;
	}
}

}
