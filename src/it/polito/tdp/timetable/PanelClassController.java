/**
 * Sample Skeleton for 'PanelClass.fxml' Controller Class
 */

package it.polito.tdp.timetable;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.timetable.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class PanelClassController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

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

    @FXML
    void addNewClass(ActionEvent event) {

    }

    @FXML
    void doClearClass(ActionEvent event) {

    }

    @FXML
    void doUpdateClass(ActionEvent event) {

    }

    @FXML
    void openTabCourse(ActionEvent event) {
    	Launcher.openTabCourse();
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
    void selectTeacherToSubject(ActionEvent event) {

    }

    @FXML
    void viewClass(ActionEvent event) {

    }

    @FXML
    void viewSubClass(MouseEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cmbClass != null : "fx:id=\"cmbClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert txtIdClass != null : "fx:id=\"txtIdClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert txtGradeCourse != null : "fx:id=\"txtGradeCourse\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert cmbCourseClass != null : "fx:id=\"cmbCourseClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert txtNumSubCourse != null : "fx:id=\"txtNumSubCourse\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert txtNumSubUnemployed != null : "fx:id=\"txtNumSubUnemployed\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert hbxAllertClass != null : "fx:id=\"hbxAllertClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert listSubClass != null : "fx:id=\"listSubClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert txtIdSubClass != null : "fx:id=\"txtIdSubClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert txtNameSubClass != null : "fx:id=\"txtNameSubClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert cmbTeacherSubClass != null : "fx:id=\"cmbTeacherSubClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert btnUpdateClass != null : "fx:id=\"btnUpdateClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert btnClearClass != null : "fx:id=\"btnClearClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert btnAddNewClass != null : "fx:id=\"btnAddNewClass\" was not injected: check your FXML file 'PanelClass.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model = model ;		
	}
}
