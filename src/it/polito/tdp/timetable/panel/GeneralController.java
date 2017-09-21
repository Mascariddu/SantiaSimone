/**
 * Sample Skeleton for 'PanelGeneral.fxml' Controller Class
 */

package it.polito.tdp.timetable.panel;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.timetable.model.Course;
import it.polito.tdp.timetable.model.Lab;
import it.polito.tdp.timetable.model.Class;
import it.polito.tdp.timetable.model.Model;
import it.polito.tdp.timetable.model.School;
import it.polito.tdp.timetable.model.Teacher;
import it.polito.tdp.timetable.model.TimetableGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;

public class GeneralController {
	
	private Model model;
	private School school;
	private List<Class> classes;
	private List<Teacher> teachers;
	private List<Lab> labs;
	private TimetableGenerator timetable;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtIdSchool"
    private Label txtIdSchool; // Value injected by FXMLLoader

    @FXML // fx:id="txtNameSchool"
    private Label txtNameSchool; // Value injected by FXMLLoader

    @FXML // fx:id="txtAddressSchool"
    private Label txtAddressSchool; // Value injected by FXMLLoader

    @FXML // fx:id="txtStartSchool"
    private Label txtStartSchool; // Value injected by FXMLLoader

    @FXML // fx:id="txtEndSchool"
    private Label txtEndSchool; // Value injected by FXMLLoader

    @FXML // fx:id="txtDaysSchool"
    private Label txtDaysSchool; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumCourses"
    private Label txtNumCourses; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumTeachers"
    private Label txtNumTeachers; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumSubjects"
    private Label txtNumSubjects; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumClasses"
    private Label txtNumClasses; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumLabs"
    private Label txtNumLabs; // Value injected by FXMLLoader

    @FXML // fx:id="txtPercDB"
    private Label txtPercDB; // Value injected by FXMLLoader

    @FXML // fx:id="pgbCompleteDB"
    private ProgressBar pgbCompleteDB; // Value injected by FXMLLoader

    @FXML // fx:id="hbxAllertTimetable"
    private HBox hbxAllertTimetable; // Value injected by FXMLLoader

    @FXML // fx:id="hbTimetable"
    private HBox hbTimetable; // Value injected by FXMLLoader

    @FXML // fx:id="cmbClass"
    private ComboBox<Class> cmbClass; // Value injected by FXMLLoader

    @FXML // fx:id="cmbTeacher"
    private ComboBox<Teacher> cmbTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="cmbLab"
    private ComboBox<Lab> cmbLab; // Value injected by FXMLLoader

    @FXML // fx:id="btnGenera"
    private Button btnGenera; // Value injected by FXMLLoader

    @FXML // fx:id="txtTimeProcess"
    private Label txtTimeProcess; // Value injected by FXMLLoader

    @FXML // fx:id="txtPercSuccess"
    private Label txtPercSuccess; // Value injected by FXMLLoader

    @FXML // fx:id="hbxProgressTime"
    private HBox hbxProgressTime; // Value injected by FXMLLoader

    @FXML // fx:id="prgCreateTime"
    private ProgressBar prgCreateTime; // Value injected by FXMLLoader

    @FXML
    void doGeneraTimetable(ActionEvent event) {
    	this.timetable = new TimetableGenerator(model.getAllClasses(), model.getAllTeachers(), 
				model.getAllCourses(), model.getHoursWeekSchool(), model.getHoursDaySchool(), school.getWorkDays());
    	
		cmbClass.getItems().addAll(classes);
		cmbLab.getItems().addAll(labs);
		cmbTeacher.getItems().addAll(teachers);
		btnGenera.setDisable(true);		
		
		this.timetable.generateTimetable();
		
		txtTimeProcess.setText(String.valueOf(timetable.getTimeProcess())+ " s");
		txtPercSuccess.setText(String.valueOf((this.timetable.getCountNotSatisfied() * 100) / teachers.size()) + "%");
    }

    @FXML
    void openTabClass(ActionEvent event) {
    	Launcher.openTabClass();
    }

    @FXML
    void openTabCourse(ActionEvent event) {
    	Launcher.openTabCourse();
    }

    @FXML
    void openTabLab(ActionEvent event) {
    	Launcher.openTabLab();
    }

    @FXML
    void openTabSubject(ActionEvent event) {
    	Launcher.openTabSubject();
    }

    @FXML
    void openTabTeacher(ActionEvent event) {
    	Launcher.openTabTeacher();
    }
    
    @FXML
    void viewTimeClass(ActionEvent event) {
    	if(cmbClass.getSelectionModel().isEmpty())
    		return;
    	
    	Launcher.openTimetable(this.timetable.getTimetableByClass(cmbClass.getSelectionModel().getSelectedItem().getClassID()));
    }

    @FXML
    void viewTimeLab(ActionEvent event) {
    	if(cmbLab.getSelectionModel().isEmpty())
    		return;
    	
    //	Launcher.openTimetable(this.timetable);
    }

    @FXML
    void viewTimeTeacher(ActionEvent event) {
    	if(cmbTeacher.getSelectionModel().isEmpty())
    		return;
    	
    //	Launcher.openTimetable(cmbTeacher.getSelectionModel().getSelectedItem().getTeacherID(), this.timetable);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtIdSchool != null : "fx:id=\"txtIdSchool\" was not injected: check your FXML file 'General.fxml'.";
        assert txtNameSchool != null : "fx:id=\"txtNameSchool\" was not injected: check your FXML file 'General.fxml'.";
        assert txtAddressSchool != null : "fx:id=\"txtAddressSchool\" was not injected: check your FXML file 'General.fxml'.";
        assert txtStartSchool != null : "fx:id=\"txtStartSchool\" was not injected: check your FXML file 'General.fxml'.";
        assert txtEndSchool != null : "fx:id=\"txtEndSchool\" was not injected: check your FXML file 'General.fxml'.";
        assert txtDaysSchool != null : "fx:id=\"txtDaysSchool\" was not injected: check your FXML file 'General.fxml'.";
        assert txtNumCourses != null : "fx:id=\"txtNumCourses\" was not injected: check your FXML file 'General.fxml'.";
        assert txtNumTeachers != null : "fx:id=\"txtNumTeachers\" was not injected: check your FXML file 'General.fxml'.";
        assert txtNumSubjects != null : "fx:id=\"txtNumSubjects\" was not injected: check your FXML file 'General.fxml'.";
        assert txtNumClasses != null : "fx:id=\"txtNumClasses\" was not injected: check your FXML file 'General.fxml'.";
        assert txtNumLabs != null : "fx:id=\"txtNumLabs\" was not injected: check your FXML file 'General.fxml'.";
        assert txtPercDB != null : "fx:id=\"txtPercDB\" was not injected: check your FXML file 'General.fxml'.";
        assert pgbCompleteDB != null : "fx:id=\"pgbCompleteDB\" was not injected: check your FXML file 'General.fxml'.";
        assert hbxAllertTimetable != null : "fx:id=\"hbxAllertTimetable\" was not injected: check your FXML file 'General.fxml'.";
        assert hbTimetable != null : "fx:id=\"hbTimetable\" was not injected: check your FXML file 'General.fxml'.";
        assert cmbClass != null : "fx:id=\"cmbClass\" was not injected: check your FXML file 'General.fxml'.";
        assert cmbTeacher != null : "fx:id=\"cmbTeacher\" was not injected: check your FXML file 'General.fxml'.";
        assert cmbLab != null : "fx:id=\"cmbLab\" was not injected: check your FXML file 'General.fxml'.";
        assert btnGenera != null : "fx:id=\"btnGenera\" was not injected: check your FXML file 'General.fxml'.";
        assert txtTimeProcess != null : "fx:id=\"txtTimeProcess\" was not injected: check your FXML file 'General.fxml'.";
        assert txtPercSuccess != null : "fx:id=\"txtPercSuccess\" was not injected: check your FXML file 'General.fxml'.";
        assert hbxProgressTime != null : "fx:id=\"hbxProgressTime\" was not injected: check your FXML file 'General.fxml'.";
        assert prgCreateTime != null : "fx:id=\"prgCreateTime\" was not injected: check your FXML file 'General.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model ;
		this.school = model.getSchool();
		this.teachers = model.getAllTeachers();
		this.labs = model.getAllLab();
		
		// Generali
		txtIdSchool.setText(school.getSchoolID());
		txtNameSchool.setText(school.getName());
		txtAddressSchool.setText(school.getAdress());
		txtStartSchool.setText(school.getStartLessons() + ":00");
		txtEndSchool.setText(school.getEndLessons() + ":00");
		txtDaysSchool.setText(String.valueOf(school.getWorkDays()));

		txtNumTeachers.setText(String.valueOf(teachers.size()));
		txtNumLabs.setText(String.valueOf(labs.size()));
		txtNumSubjects.setText(String.valueOf(model.getAllSubjects().size()));
		
		List<String> nameCourses = new ArrayList<>();
		for(Course c : model.getAllCourses())
			if(!nameCourses.contains(c.getName()))
				nameCourses.add(c.getName());

		this.classes = model.getAllClasses();
		txtNumClasses.setText(String.valueOf(classes.size()));
		txtNumCourses.setText(String.valueOf(nameCourses.size()));
		
		if(Integer.valueOf(txtNumClasses.getText()) > 0)
			pgbCompleteDB.setProgress(1);
		else if( Integer.valueOf(txtNumCourses.getText()) > 0)
			pgbCompleteDB.setProgress(0.7);
		else if( Integer.valueOf(txtNumTeachers.getText()) > (Integer.valueOf(txtNumTeachers.getText())/2))
			pgbCompleteDB.setProgress(0.5);
		else if( Integer.valueOf(txtNumSubjects.getText()) > 0)
			pgbCompleteDB.setProgress(0.25);
		else
			pgbCompleteDB.setProgress(0);
		
		txtPercDB.setText(String.valueOf(pgbCompleteDB.getProgress()*100)+"%");
		
		if(pgbCompleteDB.getProgress() == 1) {
			hbxAllertTimetable.setVisible(false);
			hbTimetable.setDisable(false);
		}
		
	}
}


