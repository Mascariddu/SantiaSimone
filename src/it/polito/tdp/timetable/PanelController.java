/**
 * Sample Skeleton for 'Panel.fxml' Controller Class
 */

package it.polito.tdp.timetable;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.timetable.model.Model;
import it.polito.tdp.timetable.model.School;
import it.polito.tdp.timetable.model.Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PanelController {

	private Model model; 
	private School school;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtID"
    private Label txtID; // Value injected by FXMLLoader

    @FXML // fx:id="txtName"
    private Label txtName; // Value injected by FXMLLoader

    @FXML // fx:id="txtAddress"
    private Label txtAddress; // Value injected by FXMLLoader

    @FXML // fx:id="txtStart"
    private Label txtStart; // Value injected by FXMLLoader

    @FXML // fx:id="txtEnd"
    private Label txtEnd; // Value injected by FXMLLoader

    @FXML // fx:id="txtDays"
    private Label txtDays; // Value injected by FXMLLoader

    @FXML // fx:id="cmbCourse"
    private ComboBox<?> cmbCourse; // Value injected by FXMLLoader

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
    private ListView<?> listSubCourse; // Value injected by FXMLLoader

    @FXML // fx:id="listSubCourseCheck"
    private ListView<?> listSubCourseCheck; // Value injected by FXMLLoader

    @FXML // fx:id="btnUpdateCourse"
    private Button btnUpdateCourse; // Value injected by FXMLLoader

    @FXML // fx:id="btnCleanCourse"
    private Button btnCleanCourse; // Value injected by FXMLLoader

    @FXML // fx:id="btnNewCourse"
    private Button btnNewCourse; // Value injected by FXMLLoader

    @FXML // fx:id="listSubject"
    private ListView<Subject> listSubject; // Value injected by FXMLLoader

    @FXML // fx:id="hbxAllertSub"
    private HBox hbxAllertSub; // Value injected by FXMLLoader

    @FXML // fx:id="txtSubID"
    private TextField txtSubID; // Value injected by FXMLLoader

    @FXML // fx:id="txtNameSub"
    private TextField txtNameSub; // Value injected by FXMLLoader

    @FXML // fx:id="txtHoursSub"
    private TextField txtHoursSub; // Value injected by FXMLLoader

    @FXML // fx:id="checkLab"
    private CheckBox checkLab; // Value injected by FXMLLoader

    @FXML // fx:id="vbxLab"
    private VBox vbxLab; // Value injected by FXMLLoader

    @FXML // fx:id="txtHoursLab"
    private TextField txtHoursLab; // Value injected by FXMLLoader

    @FXML // fx:id="cmbLabSub"
    private ComboBox<String> cmbLabSub; // Value injected by FXMLLoader

    @FXML // fx:id="listTeachersSub"
    private ListView<?> listTeachersSub; // Value injected by FXMLLoader

    @FXML // fx:id="btnUpdateSub"
    private Button btnUpdateSub; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearSub"
    private Button btnClearSub; // Value injected by FXMLLoader

    @FXML // fx:id="btnNewSub"
    private Button btnNewSub; // Value injected by FXMLLoader

    @FXML // fx:id="listTeachers"
    private ListView<?> listTeachers; // Value injected by FXMLLoader

    @FXML // fx:id="hbxAllertTeacher"
    private HBox hbxAllertTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="txtIdTeacher"
    private TextField txtIdTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="txtNameTeacher"
    private TextField txtNameTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="txtSurnameTeacher"
    private TextField txtSurnameTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="txtHoursTeacher"
    private TextField txtHoursTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="cmdFreeDayTeacher"
    private ComboBox<?> cmdFreeDayTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="listSubTeacher"
    private ListView<?> listSubTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddSubTeacher"
    private Button btnAddSubTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="btnUpdateTeacher"
    private Button btnUpdateTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearTeacher"
    private Button btnClearTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddNewTeacher"
    private Button btnAddNewTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="cmbClass"
    private ComboBox<?> cmbClass; // Value injected by FXMLLoader

    @FXML // fx:id="txtIdClass"
    private TextField txtIdClass; // Value injected by FXMLLoader

    @FXML // fx:id="txtGradeCourse"
    private TextField txtGradeCourse; // Value injected by FXMLLoader

    @FXML // fx:id="cmbCourseClass"
    private ComboBox<?> cmbCourseClass; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumSubCourse"
    private TextField txtNumSubCourse; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumSubUnemployed"
    private TextField txtNumSubUnemployed; // Value injected by FXMLLoader

    @FXML // fx:id="hbxAllertClass"
    private HBox hbxAllertClass; // Value injected by FXMLLoader

    @FXML // fx:id="listSubClass"
    private ListView<?> listSubClass; // Value injected by FXMLLoader

    @FXML // fx:id="txtIdSubClass"
    private TextField txtIdSubClass; // Value injected by FXMLLoader

    @FXML // fx:id="txtNameSubClass"
    private TextField txtNameSubClass; // Value injected by FXMLLoader

    @FXML // fx:id="cmbTeacherSubClass"
    private ComboBox<?> cmbTeacherSubClass; // Value injected by FXMLLoader

    @FXML // fx:id="btnUpdateClass"
    private Button btnUpdateClass; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearClass"
    private Button btnClearClass; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddNewClass"
    private Button btnAddNewClass; // Value injected by FXMLLoader

    @FXML // fx:id="listLab"
    private ListView<?> listLab; // Value injected by FXMLLoader

    @FXML // fx:id="hbxAllertLab"
    private HBox hbxAllertLab; // Value injected by FXMLLoader

    @FXML // fx:id="txtIdLab"
    private TextField txtIdLab; // Value injected by FXMLLoader

    @FXML // fx:id="txtNameLab"
    private TextField txtNameLab; // Value injected by FXMLLoader

    @FXML // fx:id="txtTypeLab"
    private TextField txtTypeLab; // Value injected by FXMLLoader

    @FXML // fx:id="btnUpdateLab"
    private Button btnUpdateLab; // Value injected by FXMLLoader

    @FXML // fx:id="btnCleanLab"
    private Button btnCleanLab; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddNewLab"
    private Button btnAddNewLab; // Value injected by FXMLLoader

    @FXML
    void addNewClass(ActionEvent event) {

    }

    @FXML
    void addNewCourse(ActionEvent event) {

    }

    @FXML
    void addNewLab(ActionEvent event) {

    }

    @FXML
    void addNewSub(ActionEvent event) {
    	if(checkLab.isSelected())
    		listSubject.getItems().add(model.addNewSubject(txtNameSub.getText(), Integer.valueOf(txtHoursSub.getText()), Integer.valueOf(txtHoursLab.getText()), cmbLabSub.getValue()));
    	else 
    		listSubject.getItems().add(model.addNewSubject(txtNameSub.getText(), Integer.valueOf(txtHoursSub.getText()), 0, null));
    	
    }

    @FXML
    void addNewTeacher(ActionEvent event) {

    }

    @FXML
    void addSubTeacher(ActionEvent event) {

    }

    @FXML
    void clearSub(ActionEvent event) {
    	txtSubID.clear();
    	txtNameSub.clear();
    	txtHoursSub.clear();
    	txtHoursLab.clear();
    	
    	btnUpdateSub.setDisable(true);
    	btnNewSub.setDisable(false);

    }

    @FXML
    void doCleanCourse(ActionEvent event) {

    }

    @FXML
    void doCleanLab(ActionEvent event) {

    }

    @FXML
    void doClearClass(ActionEvent event) {

    }

    @FXML
    void doClearTeacher(ActionEvent event) {

    }

    @FXML
    void doUpdateClass(ActionEvent event) {

    }

    @FXML
    void doUpdateCourse(ActionEvent event) {

    }

    @FXML
    void doUpdateLab(ActionEvent event) {

    }

    @FXML
    void doUpdateSub(ActionEvent event) {

    }

    @FXML
    void doUpdateTeacher(ActionEvent event) {

    }

    @FXML
    void doVisibleLab(ActionEvent event) {
    	if(checkLab.isSelected())
    		vbxLab.setDisable(false);
    	else 
    		vbxLab.setDisable(true);
    }

    @FXML
    void moveSubLeft(ActionEvent event) {

    }

    @FXML
    void moveSubRight(ActionEvent event) {

    }

    @FXML
    void selectTeacherToSubject(ActionEvent event) {

    }

    @FXML
    void viewClass(ActionEvent event) {

    }

    @FXML
    void viewCourse(ActionEvent event) {

    }

    @FXML
    void viewLab(MouseEvent event) {

    }

    @FXML
    void viewSubClass(MouseEvent event) {

    }

    @FXML
    void viewSubject(MouseEvent event) {
    	Subject s = (Subject) listSubject.getSelectionModel().getSelectedItem();
    	txtSubID.setText(s.getSubjectID());
    	txtNameSub.setText(s.getName());
    	txtHoursSub.setText(String.valueOf(s.getHoursWeek()));
    	
    	if(s.getHoursLab() != 0 ) {
    		vbxLab.setDisable(false);
    		checkLab.setSelected(true);
    		txtHoursLab.setText(String.valueOf(s.getHoursLab()));
    		// cmbLabSub.getItems().add(s.getTypeLab());
    	} else {
    		vbxLab.setDisable(true);
    		checkLab.setSelected(false);
    		txtHoursLab.clear();
    		cmbLabSub.getItems().clear();
    	}
    	
    	btnUpdateSub.setDisable(false);
    	btnNewSub.setDisable(true);
    		
    }

    @FXML
    void viewTeacher(MouseEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtID != null : "fx:id=\"txtID\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtAddress != null : "fx:id=\"txtAddress\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtStart != null : "fx:id=\"txtStart\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtEnd != null : "fx:id=\"txtEnd\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtDays != null : "fx:id=\"txtDays\" was not injected: check your FXML file 'Panel.fxml'.";
        assert cmbCourse != null : "fx:id=\"cmbCourse\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtIdCourse != null : "fx:id=\"txtIdCourse\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtNameCourse != null : "fx:id=\"txtNameCourse\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtHoursCourse != null : "fx:id=\"txtHoursCourse\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtHouresCourseUnemployed != null : "fx:id=\"txtHouresCourseUnemployed\" was not injected: check your FXML file 'Panel.fxml'.";
        assert hbxAllertCourse != null : "fx:id=\"hbxAllertCourse\" was not injected: check your FXML file 'Panel.fxml'.";
        assert listSubCourse != null : "fx:id=\"listSubCourse\" was not injected: check your FXML file 'Panel.fxml'.";
        assert listSubCourseCheck != null : "fx:id=\"listSubCourseCheck\" was not injected: check your FXML file 'Panel.fxml'.";
        assert btnUpdateCourse != null : "fx:id=\"btnUpdateCourse\" was not injected: check your FXML file 'Panel.fxml'.";
        assert btnCleanCourse != null : "fx:id=\"btnCleanCourse\" was not injected: check your FXML file 'Panel.fxml'.";
        assert btnNewCourse != null : "fx:id=\"btnNewCourse\" was not injected: check your FXML file 'Panel.fxml'.";
        assert listSubject != null : "fx:id=\"listSubject\" was not injected: check your FXML file 'Panel.fxml'.";
        assert hbxAllertSub != null : "fx:id=\"hbxAllertSub\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtSubID != null : "fx:id=\"txtSubID\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtNameSub != null : "fx:id=\"txtNameSub\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtHoursSub != null : "fx:id=\"txtHoursSub\" was not injected: check your FXML file 'Panel.fxml'.";
        assert checkLab != null : "fx:id=\"checkLab\" was not injected: check your FXML file 'Panel.fxml'.";
        assert vbxLab != null : "fx:id=\"vbxLab\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtHoursLab != null : "fx:id=\"txtHoursLab\" was not injected: check your FXML file 'Panel.fxml'.";
        assert cmbLabSub != null : "fx:id=\"cmbLabSub\" was not injected: check your FXML file 'Panel.fxml'.";
        assert listTeachersSub != null : "fx:id=\"listTeachersSub\" was not injected: check your FXML file 'Panel.fxml'.";
        assert btnUpdateSub != null : "fx:id=\"btnUpdateSub\" was not injected: check your FXML file 'Panel.fxml'.";
        assert btnClearSub != null : "fx:id=\"btnClearSub\" was not injected: check your FXML file 'Panel.fxml'.";
        assert btnNewSub != null : "fx:id=\"btnNewSub\" was not injected: check your FXML file 'Panel.fxml'.";
        assert listTeachers != null : "fx:id=\"listTeachers\" was not injected: check your FXML file 'Panel.fxml'.";
        assert hbxAllertTeacher != null : "fx:id=\"hbxAllertTeacher\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtIdTeacher != null : "fx:id=\"txtIdTeacher\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtNameTeacher != null : "fx:id=\"txtNameTeacher\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtSurnameTeacher != null : "fx:id=\"txtSurnameTeacher\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtHoursTeacher != null : "fx:id=\"txtHoursTeacher\" was not injected: check your FXML file 'Panel.fxml'.";
        assert cmdFreeDayTeacher != null : "fx:id=\"cmdFreeDayTeacher\" was not injected: check your FXML file 'Panel.fxml'.";
        assert listSubTeacher != null : "fx:id=\"listSubTeacher\" was not injected: check your FXML file 'Panel.fxml'.";
        assert btnAddSubTeacher != null : "fx:id=\"btnAddSubTeacher\" was not injected: check your FXML file 'Panel.fxml'.";
        assert btnUpdateTeacher != null : "fx:id=\"btnUpdateTeacher\" was not injected: check your FXML file 'Panel.fxml'.";
        assert btnClearTeacher != null : "fx:id=\"btnClearTeacher\" was not injected: check your FXML file 'Panel.fxml'.";
        assert btnAddNewTeacher != null : "fx:id=\"btnAddNewTeacher\" was not injected: check your FXML file 'Panel.fxml'.";
        assert cmbClass != null : "fx:id=\"cmbClass\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtIdClass != null : "fx:id=\"txtIdClass\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtGradeCourse != null : "fx:id=\"txtGradeCourse\" was not injected: check your FXML file 'Panel.fxml'.";
        assert cmbCourseClass != null : "fx:id=\"cmbCourseClass\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtNumSubCourse != null : "fx:id=\"txtNumSubCourse\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtNumSubUnemployed != null : "fx:id=\"txtNumSubUnemployed\" was not injected: check your FXML file 'Panel.fxml'.";
        assert hbxAllertClass != null : "fx:id=\"hbxAllertClass\" was not injected: check your FXML file 'Panel.fxml'.";
        assert listSubClass != null : "fx:id=\"listSubClass\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtIdSubClass != null : "fx:id=\"txtIdSubClass\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtNameSubClass != null : "fx:id=\"txtNameSubClass\" was not injected: check your FXML file 'Panel.fxml'.";
        assert cmbTeacherSubClass != null : "fx:id=\"cmbTeacherSubClass\" was not injected: check your FXML file 'Panel.fxml'.";
        assert btnUpdateClass != null : "fx:id=\"btnUpdateClass\" was not injected: check your FXML file 'Panel.fxml'.";
        assert btnClearClass != null : "fx:id=\"btnClearClass\" was not injected: check your FXML file 'Panel.fxml'.";
        assert btnAddNewClass != null : "fx:id=\"btnAddNewClass\" was not injected: check your FXML file 'Panel.fxml'.";
        assert listLab != null : "fx:id=\"listLab\" was not injected: check your FXML file 'Panel.fxml'.";
        assert hbxAllertLab != null : "fx:id=\"hbxAllertLab\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtIdLab != null : "fx:id=\"txtIdLab\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtNameLab != null : "fx:id=\"txtNameLab\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtTypeLab != null : "fx:id=\"txtTypeLab\" was not injected: check your FXML file 'Panel.fxml'.";
        assert btnUpdateLab != null : "fx:id=\"btnUpdateLab\" was not injected: check your FXML file 'Panel.fxml'.";
        assert btnCleanLab != null : "fx:id=\"btnCleanLab\" was not injected: check your FXML file 'Panel.fxml'.";
        assert btnAddNewLab != null : "fx:id=\"btnAddNewLab\" was not injected: check your FXML file 'Panel.fxml'.";
        

    }
    
	public void setModel(Model model) {
		this.model = model ;
		this.school = model.getSchool();
		
		txtID.setText(school.getSchoolID());
		txtName.setText(school.getName());
		txtAddress.setText(school.getAdress());
		txtStart.setText(school.getStartLessons() + ":00");
		txtEnd.setText(school.getEndLessons() + ":00");
		txtDays.setText(String.valueOf(school.getWorkDays()));
		
		listSubject.getItems().addAll(model.getAllSubjects());
	}
}


