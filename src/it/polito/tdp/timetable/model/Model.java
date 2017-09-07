package it.polito.tdp.timetable.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.timetable.db.TimetableDAO;
import javafx.collections.ObservableList;

public class Model {

	private TimetableDAO dao;
	private School school;
	private int hoursWeekSchool;
	private List<Subject> subjects;
	private List<Course> courses;
	private List<Lab> labs;
	private List<Teacher> teachers;
	private List<Class> classes;
	
	
	public Model() {
		this.subjects = new ArrayList<>();
		this.courses = new ArrayList<>();
		this.labs = new ArrayList<>();
		this.teachers = new ArrayList<>();
		this.classes = new ArrayList<>();
	}
	
	public List<Subject> getAllSubjects() {
		if(subjects.isEmpty()) {
			this.dao = new TimetableDAO();
			this.subjects = dao.getAllSubjects(school.getSchoolID());
		}
		return subjects;
	}
	
	public List<Course> getAllCourses() {
			this.dao = new TimetableDAO();
			this.courses = dao.getAllCourses(school.getSchoolID());
			for(Course c : courses)
				c.setListSubject(dao.getAllSubjectByCourse(school.getSchoolID(),c.getCourseID(),subjects));
			
		return courses;
	}
	
	public Course addNewCourse(String name, int hoursWeek, List<Subject> items) {
		this.dao = new TimetableDAO();
		int num = this.courses.size() + 1;
		
		Course c = new Course("CRS00"+num, name, hoursWeek, items);
		dao.addNewCourse(c,school.getSchoolID());
		dao.addSubjectsToCourse(school.getSchoolID(),c.getCourseID(),c.getListSubject());
		courses.add(c);
		return c;
		
	}
	
	public Subject addNewSubject(String name, int hoursWeek, int hoursLab, String typeLab) {
		this.dao = new TimetableDAO();
		int num = this.subjects.size() + 1;
		
		Subject s = new Subject("SJB00"+num, name, hoursWeek, hoursLab, typeLab);
		dao.addSubject(s,school.getSchoolID());
		subjects.add(s);
		return s;
	}
	
	public void updateSubject(Subject s) {
		this.dao = new TimetableDAO();
		dao.updateSubject(s, school.getSchoolID());
		
		subjects.remove(s);
		subjects.add(s);
	}
	
	public void setSchool(School school) {
		this.school = school;
		this.hoursWeekSchool = (school.getEndLessons() - school.getStartLessons())*school.getWorkDays();
	}
	
	public int getHoursWeekSchool() {
		return this.hoursWeekSchool;
	}
	public School getSchool() {
		return this.school;
	}
	
	public List<School> getAllSchools() {
		this.dao = new TimetableDAO();
		return dao.getAllSchools();
	}
	
	public void addSchool(String name, String address, int startLessons, int endLessons, int workDays) {
		this.dao = new TimetableDAO();
		int num = dao.getAllSchools().size() + 1;
		School s = new School("SCH00"+num, name, address, startLessons, endLessons, workDays);
		dao.addSchool(s);
	}

	public List<Lab> getAllLab() {
		if(labs.isEmpty()) {
			this.dao = new TimetableDAO();
			this.labs = dao.getAllLab(school.getSchoolID());
		}
		return labs;
	}

	public Lab addNewLab(String name, String type) {
		this.dao = new TimetableDAO();
		int num = this.labs.size() + 1;
		
		Lab l = new Lab("LAB00"+num, name, type);
		dao.addNewLab(l,school.getSchoolID());
		labs.add(l);
		return l;
	}

	public List<String> getAllTypeLaib() {
		List<String> list = new ArrayList<>();
		
		for(Lab l : labs)
			if(!list.contains(l.getType()))
				list.add(l.getType());
		
		return list;
	}

	public void updateCourse(Course c, Course old) {
		this.dao = new TimetableDAO();
		dao.updateCourse(c, school.getSchoolID());
		dao.removeSubjectsToCourse(school.getSchoolID(),old.getCourseID(),old.getListSubject());
		dao.addSubjectsToCourse(school.getSchoolID(), c.getCourseID(), c.getListSubject());
		courses.remove(old);
		courses.add(c);
		
	}

	public void updateLab(Lab l) {
		this.dao = new TimetableDAO();
		dao.updateLab(l, school.getSchoolID());
		
		labs.remove(l);
		labs.add(l);
		
	}

	public List<Teacher> getAllTeachers() {
		this.dao = new TimetableDAO();
		this.teachers = dao.getAllTeachers(school.getSchoolID());
		
		for(Teacher t : teachers)
			t.setEnablingSub(dao.getAllSubjectByTeacher(school.getSchoolID(),t.getTeacherID(),subjects));
		
		return teachers;
	}

	public List<Class> getAllClasses() {
		this.dao = new TimetableDAO();
		// this.classes = dao.getAllClasses(school.getSchoolID());
		return classes;
	}

	public Teacher addNewTeacher(String name, String surname, Integer hoursWeek, Integer freeDay, List<Subject> items) {
		this.dao = new TimetableDAO();
		int num = this.teachers.size() + 1;
		
		Teacher t = new Teacher("THC00"+num, name, surname, hoursWeek, 0, items);
		dao.addNewTeacher(t,school.getSchoolID());
		dao.addSubjectsToTeacher(school.getSchoolID(),t.getTeacherID(),t.getEnablingSub());
		teachers.add(t);
		return t;
	}

}
