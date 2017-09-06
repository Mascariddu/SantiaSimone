/**
 * Sample Skeleton for 'PanelGeneral.fxml' Controller Class
 */

package it.polito.tdp.timetable;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.timetable.model.Model;
import it.polito.tdp.timetable.model.School;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PanelGeneralController {
	
	private Model model;
	private School school;

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

    @FXML // fx:id="txtPercDB"
    private Label txtPercDB; // Value injected by FXMLLoader

    @FXML // fx:id="pgbCompleteDB"
    private ProgressBar pgbCompleteDB; // Value injected by FXMLLoader

    @FXML // fx:id="hbxAllertTimetable"
    private HBox hbxAllertTimetable; // Value injected by FXMLLoader

    @FXML // fx:id="txtTimeProcess"
    private Label txtTimeProcess; // Value injected by FXMLLoader

    @FXML // fx:id="txtPercSuccess"
    private Label txtPercSuccess; // Value injected by FXMLLoader

    @FXML // fx:id="btnViewTimetable"
    private VBox btnViewTimetable; // Value injected by FXMLLoader

    @FXML // fx:id="btnGenera"
    private Button btnGenera; // Value injected by FXMLLoader

    @FXML // fx:id="hbxProgressTime"
    private HBox hbxProgressTime; // Value injected by FXMLLoader

    @FXML // fx:id="prgCreateTime"
    private ProgressBar prgCreateTime; // Value injected by FXMLLoader

    @FXML
    void doGeneraTimetable(ActionEvent event) {

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
    void viewTimetableClass(ActionEvent event) {

    }

    @FXML
    void viewTimetableLab(ActionEvent event) {

    }

    @FXML
    void viewTimetableTeacher(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtIdSchool != null : "fx:id=\"txtIdSchool\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert txtNameSchool != null : "fx:id=\"txtNameSchool\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert txtAddressSchool != null : "fx:id=\"txtAddressSchool\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert txtStartSchool != null : "fx:id=\"txtStartSchool\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert txtEndSchool != null : "fx:id=\"txtEndSchool\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert txtDaysSchool != null : "fx:id=\"txtDaysSchool\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert txtNumCourses != null : "fx:id=\"txtNumCourses\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert txtNumTeachers != null : "fx:id=\"txtNumTeachers\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert txtNumSubjects != null : "fx:id=\"txtNumSubjects\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert txtNumClasses != null : "fx:id=\"txtNumClasses\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert txtPercDB != null : "fx:id=\"txtPercDB\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert pgbCompleteDB != null : "fx:id=\"pgbCompleteDB\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert hbxAllertTimetable != null : "fx:id=\"hbxAllertTimetable\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert txtTimeProcess != null : "fx:id=\"txtTimeProcess\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert txtPercSuccess != null : "fx:id=\"txtPercSuccess\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert btnViewTimetable != null : "fx:id=\"btnViewTimetable\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert btnGenera != null : "fx:id=\"btnGenera\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert hbxProgressTime != null : "fx:id=\"hbxProgressTime\" was not injected: check your FXML file 'PanelGeneral.fxml'.";
        assert prgCreateTime != null : "fx:id=\"prgCreateTime\" was not injected: check your FXML file 'PanelGeneral.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model ;
		this.school = model.getSchool();
		
		// Generali
		txtIdSchool.setText(school.getSchoolID());
		txtNameSchool.setText(school.getName());
		txtAddressSchool.setText(school.getAdress());
		txtStartSchool.setText(school.getStartLessons() + ":00");
		txtEndSchool.setText(school.getEndLessons() + ":00");
		txtDaysSchool.setText(String.valueOf(school.getWorkDays()));
		
	}
}


