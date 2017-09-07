/**
 * Sample Skeleton for 'PanelCourse.fxml' Controller Class
 */

package it.polito.tdp.timetable;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.timetable.model.Course;
import it.polito.tdp.timetable.model.Model;
import it.polito.tdp.timetable.model.Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class PanelCourseController {
	
	private Model model;
	private int hoursDisponible;
	private int hoursNotUsed;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cmbCourse"
    private ComboBox<Course> cmbCourse; // Value injected by FXMLLoader

    @FXML // fx:id="txtIdCourse"
    private TextField txtIdCourse; // Value injected by FXMLLoader

    @FXML // fx:id="txtNameCourse"
    private TextField txtNameCourse; // Value injected by FXMLLoader

    @FXML // fx:id="txtHoursCourse"
    private TextField txtHoursCourse; // Value injected by FXMLLoader

    @FXML // fx:id="txtHouresCourseUnemployed"
    private TextField txtHouresCourseUnemployed; // Value injected by FXMLLoader

    @FXML // fx:id="hbxAllertCourse"
    private HBox hbxAllertCourse; // Value injected by FXMLLoader

    @FXML // fx:id="listSubCourse"
    private ListView<Subject> listSubCourse; // Value injected by FXMLLoader

    @FXML // fx:id="listSubCourseCheck"
    private ListView<Subject> listSubCourseCheck; // Value injected by FXMLLoader

    @FXML // fx:id="btnUpdateCourse"
    private Button btnUpdateCourse; // Value injected by FXMLLoader

    @FXML // fx:id="btnCleanCourse"
    private Button btnCleanCourse; // Value injected by FXMLLoader

    @FXML // fx:id="btnNewCourse"
    private Button btnNewCourse; // Value injected by FXMLLoader

    @FXML
    void addNewCourse(ActionEvent event) {
    	if(txtNameCourse.getText().isEmpty() || txtHoursCourse.getText().isEmpty() || hoursNotUsed>0) {
    		hbxAllertCourse.setVisible(true);
    		return;
    	}
    	
    	Course c = model.addNewCourse(txtNameCourse.getText(),Integer.valueOf(txtHoursCourse.getText()),listSubCourseCheck.getItems());
    	cmbCourse.getItems().clear();
    	cmbCourse.getItems().addAll(model.getAllCourses());
    	txtIdCourse.setText(c.getCourseID());
    	
    	btnUpdateCourse.setDisable(false);
    	btnNewCourse.setDisable(true);
    }

    @FXML
    void doCleanCourse(ActionEvent event) {
    	
    	cmbCourse.getSelectionModel().clearSelection();
    	txtIdCourse.clear();
    	txtNameCourse.clear();
    	txtHoursCourse.setText(String.valueOf(hoursDisponible));;
    	
    	hoursNotUsed = hoursDisponible;
    	txtHouresCourseUnemployed.setText(String.valueOf(hoursDisponible));
    	
    	listSubCourseCheck.getItems().clear();
    	listSubCourse.getItems().clear();
    	listSubCourse.getItems().addAll(model.getAllSubjects());
    	hbxAllertCourse.setVisible(false);
    	
    	btnUpdateCourse.setDisable(true);
    	btnNewCourse.setDisable(false);

    }

    @FXML
    void doUpdateCourse(ActionEvent event) {
    	if(txtNameCourse.getText().isEmpty() || txtHoursCourse.getText().isEmpty() || hoursNotUsed>0) {
    		hbxAllertCourse.setVisible(true);
    		return;
    	}
    	
    	Course c = new Course(txtIdCourse.getText(), 
    					txtNameCourse.getText(), 
    					Integer.valueOf(txtHoursCourse.getText()), 
    					listSubCourseCheck.getItems());
    		
    	model.updateCourse(c, cmbCourse.getSelectionModel().getSelectedItem());
    	
    	cmbCourse.getItems().clear();
    	cmbCourse.getItems().addAll(model.getAllCourses());
    }

    @FXML
    void moveSubLeft(ActionEvent event) {
    	
    	if(listSubCourseCheck.getSelectionModel().isEmpty())
    		return; 
    	
    	Subject s = listSubCourseCheck.getSelectionModel().getSelectedItem();
    	
    	hoursNotUsed += s.getHoursWeek();
    	txtHouresCourseUnemployed.setText(String.valueOf(hoursNotUsed));
    	 		
    	listSubCourseCheck.getItems().remove(s);
    	listSubCourse.getItems().add(s);
    }

    @FXML
    void moveSubRight(ActionEvent event) {
    	 
    	if(hoursNotUsed == 0 && listSubCourseCheck.getItems().isEmpty()) {
    		hoursNotUsed = Integer.valueOf(txtHoursCourse.getText());
    	}
    	
    	if(listSubCourse.getSelectionModel().isEmpty())
    		return; 
    	
    	Subject s = listSubCourse.getSelectionModel().getSelectedItem();
    	
    	if(s.getHoursWeek()>hoursNotUsed || hoursNotUsed == 0)
    		return;
    	
    	hoursNotUsed -= s.getHoursWeek();
    	txtHouresCourseUnemployed.setText(String.valueOf(hoursNotUsed));
    	listSubCourse.getItems().remove(s);
    	listSubCourseCheck.getItems().add(s);
    }

    @FXML
    void openTabClass(ActionEvent event) {
    	Launcher.openTabClass();
    }

    @FXML
    void openTabGeneral(ActionEvent event) {
    	Launcher.openTabGeneral();
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
    void viewCourse(ActionEvent event) {
    	
    	if(cmbCourse.getItems().isEmpty())
    		return;
    	
    	Course c = cmbCourse.getSelectionModel().getSelectedItem();
    	txtIdCourse.setText(c.getCourseID());
    	txtNameCourse.setText(c.getName());
    	txtHoursCourse.setText(String.valueOf(c.getHoursWeek()));
    	
    	listSubCourseCheck.getItems().clear();
    	listSubCourseCheck.getItems().addAll(c.getListSubject());
    	
    	for(Subject s : c.getListSubject())
    		listSubCourse.getItems().remove(s);
    	
    	hoursNotUsed = 0;
    	
    	txtHouresCourseUnemployed.setText(String.valueOf(hoursNotUsed));
    	
    	btnUpdateCourse.setDisable(false);
    	btnNewCourse.setDisable(true);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cmbCourse != null : "fx:id=\"cmbCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert txtIdCourse != null : "fx:id=\"txtIdCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert txtNameCourse != null : "fx:id=\"txtNameCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert txtHoursCourse != null : "fx:id=\"txtHoursCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert txtHouresCourseUnemployed != null : "fx:id=\"txtHouresCourseUnemployed\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert hbxAllertCourse != null : "fx:id=\"hbxAllertCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert listSubCourse != null : "fx:id=\"listSubCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert listSubCourseCheck != null : "fx:id=\"listSubCourseCheck\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert btnUpdateCourse != null : "fx:id=\"btnUpdateCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert btnCleanCourse != null : "fx:id=\"btnCleanCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert btnNewCourse != null : "fx:id=\"btnNewCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model = model ;		
		
		listSubCourse.getItems().addAll(model.getAllSubjects());
		cmbCourse.getItems().addAll(model.getAllCourses());
		
		hoursDisponible = model.getHoursWeekSchool();
		hoursNotUsed = hoursDisponible;
		txtHouresCourseUnemployed.setText(String.valueOf(hoursNotUsed));
		txtHoursCourse.setText(String.valueOf(hoursDisponible));;
		
	}
}

