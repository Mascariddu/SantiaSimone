package it.polito.tdp.timetable.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

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

public void addNewCourse(Course c, String schoolID) {
	Connection conn = DBConnect.getConnection();

	String sql = "INSERT INTO course (schoolID ,courseID, name, hoursWeek) VALUES (?, ?, ?, ?);";

	PreparedStatement st;
	try {
		st = conn.prepareStatement(sql);

		st.setString(1, schoolID);
		st.setString(2, c.getCourseID());
		st.setString(3, c.getName());
		st.setInt(4, c.getHoursWeek());

		st.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public List<Course> getAllCourses(String schoolID) {
	
	String sql = "SELECT courseID, name, hoursWeek FROM course WHERE schoolID = '" + schoolID + "'" ;
	
	try {
		Connection conn = DBConnect.getConnection() ;

		PreparedStatement st = conn.prepareStatement(sql) ;
		
		ResultSet rs = st.executeQuery() ;
		
		List<Course> list = new ArrayList<>() ;
		while(rs.next()) {
			list.add(new Course(rs.getString("courseID"), rs.getString("name"), rs.getInt("hoursWeek"))) ;
		}
		
		conn.close();
		return list ;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null ;
	}
}

public List<Subject> getAllSubjectByCourse(String schoolID, String courseID, List<Subject> subjectList) {
	String sql = "SELECT subjectID FROM study_plan WHERE schoolID = '" + schoolID + "' AND courseID = '" + courseID + "'" ;
	
	try {
		Connection conn = DBConnect.getConnection() ;

		PreparedStatement st = conn.prepareStatement(sql) ;
		
		ResultSet rs = st.executeQuery() ;
		
		List<Subject> list = new ArrayList<>() ;
		while(rs.next()) {
			list.add(subjectList.get(subjectList.indexOf(new Subject(rs.getString("subjectID")))));
		}
		
		conn.close();
		return list ;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null ;
	}
	
	
}

public void updateSubject(Subject s, String schoolID) {
	Connection conn = DBConnect.getConnection();

	String sql = "UPDATE `timetable`.`subject` SET `name`= ?, `hoursWeek`= ?, `hoursLab`= ? , `typeLab`= ? WHERE  `subjectID`= ? AND `schoolID`= ?";

	PreparedStatement st;
	try {
		st = conn.prepareStatement(sql);

		st.setString(1, s.getName());
		st.setInt(2, s.getHoursWeek());
		st.setInt(3, s.getHoursLab());
		st.setString(4, s.getTypeLab());
		st.setString(5, s.getSubjectID());
		st.setString(6, schoolID);


		st.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void addSubjectsToCourse(String schoolID, String courseID, List<Subject> listSubject) {
	Connection conn = DBConnect.getConnection();

	for(Subject s :listSubject) {
		String sql = "INSERT INTO study_plan (grade, subjectID, courseID, schoolID ) VALUES (?, ?, ?, ?);";
	
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
	
			st.setInt(1, 0);
			st.setString(2, s.getSubjectID());
			st.setString(3, courseID);
			st.setString(4, schoolID);
	
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

	String sql = "UPDATE `timetable`.`course` SET `name`= ?, `hoursWeek`= ? WHERE  `courseID`= ? AND `schoolID`= ?";

	PreparedStatement st;
	try {
		st = conn.prepareStatement(sql);

		st.setString(1, c.getName());
		st.setInt(2, c.getHoursWeek());
		st.setString(3, c.getCourseID());
		st.setString(4, schoolID);


		st.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void removeSubjectsToCourse(String schoolID, String courseID, List<Subject> listSubject) {
	Connection conn = DBConnect.getConnection();

	for(Subject s :listSubject) {
		String sql = "DELETE FROM `timetable`.`study_plan` "
				+ "WHERE  `grade`= ? AND `subjectID`= ? AND `courseID`= ? AND `schoolID`= ?;";
	
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
	
			st.setInt(1, 0);
			st.setString(2, s.getSubjectID());
			st.setString(3, courseID);
			st.setString(4, schoolID);
	
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

public void addSubjectsToTeacher(String schoolID, String teacherID, List<Subject> enablingSub) {
	Connection conn = DBConnect.getConnection();

	for(Subject s : enablingSub) {
		String sql = "INSERT INTO enabling (schoolID, subjectID, teacherID ) VALUES (?, ?, ?);";
	
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
	
			st.setString(1, schoolID);
			st.setString(2, s.getSubjectID());
			st.setString(3, teacherID);
	
			st.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public List<Subject> getAllSubjectByTeacher(String schoolID, String teacherID, List<Subject> subjectList) {
	String sql = "SELECT subjectID FROM enabling WHERE schoolID = '" + schoolID + "' AND teacherID = '" + teacherID + "'" ;
	
	try {
		Connection conn = DBConnect.getConnection() ;

		PreparedStatement st = conn.prepareStatement(sql) ;
		
		ResultSet rs = st.executeQuery() ;
		
		List<Subject> list = new ArrayList<>() ;
		while(rs.next()) {
			list.add(subjectList.get(subjectList.indexOf(new Subject(rs.getString("subjectID")))));
		}
		
		conn.close();
		return list ;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null ;
	}
}

/*public List<Class> getAllClasses(String schoolID) {
	String sql = "SELECT classID, grade, surname, hoursWeek, freeDay FROM teacher WHERE schoolID = '" + schoolID + "'" ;
	
	try {
		Connection conn = DBConnect.getConnection() ;

		PreparedStatement st = conn.prepareStatement(sql) ;
		
		ResultSet rs = st.executeQuery() ;
		
		List<Class> list = new ArrayList<>() ;
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
}*/

}
