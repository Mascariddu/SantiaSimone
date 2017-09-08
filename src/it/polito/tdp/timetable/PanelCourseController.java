/**
 * Sample Skeleton for 'PanelCourse.fxml' Controller Class
 */

package it.polito.tdp.timetable;

import java.net.URL;
import java.util.List;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class PanelCourseController {
	
	private Model model;
	private List<Subject> subjectsList;
	private int numSubjectSelected;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cmbCourse"
    private ComboBox<Course> cmbCourse; // Value injected by FXMLLoader  

    @FXML // fx:id="cmbGradeSelect"
    private ComboBox<Integer> cmbGradeSelect; // Value injected by FXMLLoader

    @FXML // fx:id="txtIdCourse"
    private TextField txtIdCourse; // Value injected by FXMLLoader

    @FXML // fx:id="cmbGrade"
    private ComboBox<Integer> cmbGrade; // Value injected by FXMLLoader

    @FXML // fx:id="txtNameCourse"
    private TextField txtNameCourse; // Value injected by FXMLLoader

    @FXML // fx:id="txtSubjectCount"
    private TextField txtSubjectCount; // Value injected by FXMLLoader

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
    
    @FXML // fx:id="bpCourse"
    private BorderPane bpCourse; // Value injected by FXMLLoader

    @FXML
    void addNewCourse(ActionEvent event) {
    	
    	if(txtNameCourse.getText().isEmpty() || cmbGrade.getSelectionModel().isEmpty()) {
    		hbxAllertCourse.setVisible(true);
    		return;
    	}
    	/*
    	Course c = model.addNewCourse(txtNameCourse.getText().toUpperCase(),
    			cmbGrade.getSelectionModel().getSelectedItem(),listSubCourseCheck.getItems());
    	cmbCourse.getItems().clear();
    	cmbCourse.getItems().addAll(model.getAllCourses());
    	txtIdCourse.setText(c.getCourseID());
    	
    	btnUpdateCourse.setDisable(false);
    	btnNewCourse.setDisable(true);
    	*/
    	bpCourse.setDisable(true);
    	Launcher.openCreateNewCourse(txtNameCourse.getText(), cmbGrade.getSelectionModel().getSelectedItem(), listSubCourseCheck.getItems());
    }

    @FXML
    void doCleanCourse(ActionEvent event) {
    	
    	cmbCourse.getSelectionModel().clearSelection();
    	txtIdCourse.clear();
    	txtNameCourse.clear();
    	
    	numSubjectSelected = 0;
    	txtSubjectCount.setText(String.valueOf(numSubjectSelected));
    	
    	listSubCourseCheck.getItems().clear();
    	listSubCourse.getItems().clear();
    	listSubCourse.getItems().addAll(subjectsList);
    	hbxAllertCourse.setVisible(false);
    	
    	btnUpdateCourse.setDisable(true);
    	btnNewCourse.setDisable(false);

    }

    @FXML
    void doUpdateCourse(ActionEvent event) {
    	Launcher.openUpdateCourse(new Course(txtIdCourse.getText(), cmbGrade.getSelectionModel().getSelectedItem(), txtNameCourse.getText(),cmbCourse.getSelectionModel().getSelectedItem().getMapSubject()), 
    			listSubCourseCheck.getItems());
    }

    @FXML
    void moveSubLeft(ActionEvent event) {
    	
    	if(listSubCourseCheck.getSelectionModel().isEmpty() || listSubCourseCheck.getItems().isEmpty())
    		return; 
    	
    	Subject s = listSubCourseCheck.getSelectionModel().getSelectedItem();
    	
    	numSubjectSelected--;
    	txtSubjectCount.setText(String.valueOf(numSubjectSelected));
    	
    	listSubCourseCheck.getItems().remove(s);
    	listSubCourse.getItems().add(s);
    }

    @FXML
    void moveSubRight(ActionEvent event) {
    	 
    	if(numSubjectSelected == model.getHoursWeekSchool() || listSubCourse.getSelectionModel().isEmpty() || 
    			listSubCourse.getItems().isEmpty()) {
    		return;
    	}
    	
    	Subject s = listSubCourse.getSelectionModel().getSelectedItem();
    	
    	numSubjectSelected++;
    	txtSubjectCount.setText(String.valueOf(numSubjectSelected));
    	
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
    	
    	if(cmbCourse.getItems().isEmpty() || cmbCourse.getSelectionModel().isEmpty())
    		return;
    	
    	Course c = cmbCourse.getSelectionModel().getSelectedItem();
    	txtIdCourse.setText(c.getCourseID());
    	txtNameCourse.setText(c.getName());
    	cmbGrade.setValue(c.getGrade());
    	
    	numSubjectSelected = c.getListSubject().size();
    	txtSubjectCount.setText(String.valueOf(numSubjectSelected));
    	
    	listSubCourseCheck.getItems().clear();
    	listSubCourse.getItems().clear();
    	listSubCourse.getItems().addAll(subjectsList);
    	
    	for(String subjectID : c.getListSubject()) {
    		listSubCourseCheck.getItems().add(subjectsList.get(subjectsList.indexOf(new Subject(subjectID))));
    		listSubCourse.getItems().remove(new Subject(subjectID));
    	}
    	
    	btnUpdateCourse.setDisable(false);
    	btnNewCourse.setDisable(true);
    }
    
    @FXML
    void viewCoursesByGrade(ActionEvent event) {
    	if(cmbGradeSelect.getSelectionModel().isEmpty())
    		return;
    	
    	cmbCourse.getItems().clear();
    	
    	for(Course c : model.getAllCourses())
    		if(c.getGrade() == cmbGradeSelect.getSelectionModel().getSelectedItem())
    			cmbCourse.getItems().add(c);

    	if(!cmbCourse.getItems().isEmpty())
    		cmbCourse.setDisable(false);
    	else 
    		cmbCourse.setDisable(true);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert bpCourse != null : "fx:id=\"bpCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert cmbGradeSelect != null : "fx:id=\"cmbGradeSelect\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert cmbCourse != null : "fx:id=\"cmbCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert txtIdCourse != null : "fx:id=\"txtIdCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert cmbGrade != null : "fx:id=\"cmbGrade\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert txtNameCourse != null : "fx:id=\"txtNameCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert txtSubjectCount != null : "fx:id=\"txtSubjectCount\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert hbxAllertCourse != null : "fx:id=\"hbxAllertCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert listSubCourse != null : "fx:id=\"listSubCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert listSubCourseCheck != null : "fx:id=\"listSubCourseCheck\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert btnUpdateCourse != null : "fx:id=\"btnUpdateCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert btnCleanCourse != null : "fx:id=\"btnCleanCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";
        assert btnNewCourse != null : "fx:id=\"btnNewCourse\" was not injected: check your FXML file 'PanelCourse.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model = model ;
		this.subjectsList = model.getAllSubjects();
		
		listSubCourse.getItems().addAll(subjectsList);
		cmbCourse.setDisable(true);
		cmbGrade.getItems().addAll(1,2,3,4,5,6,7);
		cmbGradeSelect.getItems().addAll(1,2,3,4,5,6,7);
		
		numSubjectSelected = 0;
		txtSubjectCount.setText(String.valueOf(numSubjectSelected));;
		
	}
}

