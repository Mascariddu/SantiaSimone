package it.polito.tdp.timetable.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.timetable.db.TimetableDAO;

public class Model {

	private TimetableDAO dao;
	private School school;
	private int hoursWeekSchool;
	private int hoursDaySchool;
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
				c.setMapSubject(dao.getAllSubjectByCourse(school.getSchoolID(),c.getCourseID()));
			
		return courses;
	}
	
	public Course addNewCourse(String name, int grade, Map<String, Integer> items) {
		this.dao = new TimetableDAO();
		int num = this.courses.size() + 1;
		
		Course c = new Course("CRS00"+num, grade, name, items);
		dao.addNewCourse(c,school.getSchoolID());
		dao.addSubjectsToCourse(school.getSchoolID(),c.getCourseID(),c.getMapSubject());
		courses.add(c);
		return c;

	}
	
	public Subject addNewSubject(String name) {
		this.dao = new TimetableDAO();
		int num = this.subjects.size() + 1;
		
		Subject s = new Subject("SJB00"+num, name);
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
		this.hoursDaySchool = (school.getEndLessons() - school.getStartLessons());
		this.hoursWeekSchool = hoursDaySchool*school.getWorkDays();
	}
	
	public int getHoursWeekSchool() {
		return this.hoursWeekSchool;
	}
	
	public int getHoursDaySchool() {
		return this.hoursDaySchool;
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
		dao.addSubjectsToCourse(school.getSchoolID(), c.getCourseID(), c.getMapSubject());
		
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
		if(teachers.isEmpty()) {
			this.dao = new TimetableDAO();
			this.teachers = dao.getAllTeachers(school.getSchoolID());
			
			for(Teacher t : teachers)
				t.setEnablingSub(dao.getAllSubjectByTeacher(school.getSchoolID(),t.getTeacherID()));
		}
		return teachers;
	}

	public List<Class> getAllClasses() {
		if(classes.isEmpty()) {
			this.dao = new TimetableDAO();
			this.classes = dao.getAllClasses(school.getSchoolID());
		
			for(Class c : classes) {
				c.setMapSubjectTeacher(dao.getAllSubjectTeacherByClass(school.getSchoolID(),c.getClassID()));
				for(String s : c.getMapSubjectTeacher().keySet())
					teachers.get(teachers.indexOf(new Teacher(c.getMapSubjectTeacher().get(s)))).setHoursWork(
							-courses.get(courses.indexOf(new Course(c.getCourseID()))).getMapSubject().get(s));
			}
			
		}
		return classes;
	}

	public Teacher addNewTeacher(String name, String surname, Integer hoursWeek, Integer freeDay, List<Subject> items) {
		this.dao = new TimetableDAO();
		int num = this.teachers.size() + 1;
		List<String> subjectIDList = new ArrayList<>();
		
		for(Subject s : items)
			subjectIDList.add(s.getSubjectID());
		
		Teacher t = new Teacher("THC00"+num, name, surname, hoursWeek, freeDay, subjectIDList);
		dao.addNewTeacher(t,school.getSchoolID());
		dao.addSubjectsToTeacher(school.getSchoolID(),t.getTeacherID(),subjectIDList);
		teachers.add(t);
		return t;
	}

	public void updateTeacher(Teacher c, Teacher old) {
		this.dao = new TimetableDAO();
		dao.updateTeacher(c, school.getSchoolID());
		
		dao.removeSubjectsToTeacher(school.getSchoolID(),old.getTeacherID(),old.getEnablingSub());
		dao.addSubjectsToTeacher(school.getSchoolID(), c.getTeacherID(), c.getEnablingSub());
		
		teachers.remove(old);
		teachers.add(c);
		
	}

	public Class addNewClass(Integer grade, String section, String courseID,
			Map<String, String> mapSubjectTeacher) {
		this.dao = new TimetableDAO();
		
		Class c = new Class("CLS"+grade+section, grade, section, courseID, mapSubjectTeacher);
		dao.addNewClass(c,school.getSchoolID());
		dao.addSubjectsAndTeacherToClass(school.getSchoolID(),c.getClassID(),c.getMapSubjectTeacher());
		
		for(Teacher t : teachers)
			if(c.getMapSubjectTeacher().containsValue(t.getTeacherID()))
				for(String subjectID : c.getMapSubjectTeacher().keySet())
					if(c.getMapSubjectTeacher().get(subjectID).equals(t.getTeacherID()))
						t.setHoursWork(t.getHoursWork() + courses.get(courses.indexOf(new Course(courseID))).getMapSubject().get(subjectID));
				
		classes.add(c);
		return c;
	}

	public void updateClass(Class c, Class old) {
		this.dao = new TimetableDAO();
		dao.updateClass(c, school.getSchoolID());
		
		dao.removeSubjectAndTeacherToClass(school.getSchoolID(),old.getClassID(),old.getMapSubjectTeacher());
		dao.addSubjectsAndTeacherToClass(school.getSchoolID(), c.getClassID(), c.getMapSubjectTeacher());
		
		classes.remove(old);
		classes.add(c);
		
	}

}
