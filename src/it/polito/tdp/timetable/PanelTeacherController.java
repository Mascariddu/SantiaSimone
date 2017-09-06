/**
 * Sample Skeleton for 'PanelTeacher.fxml' Controller Class
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

public class PanelTeacherController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

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

    @FXML
    void addNewTeacher(ActionEvent event) {

    }

    @FXML
    void addSubTeacher(ActionEvent event) {

    }

    @FXML
    void doClearTeacher(ActionEvent event) {

    }

    @FXML
    void doUpdateTeacher(ActionEvent event) {

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
    void viewTeacher(MouseEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert listTeachers != null : "fx:id=\"listTeachers\" was not injected: check your FXML file 'PanelTeacher.fxml'.";
        assert hbxAllertTeacher != null : "fx:id=\"hbxAllertTeacher\" was not injected: check your FXML file 'PanelTeacher.fxml'.";
        assert txtIdTeacher != null : "fx:id=\"txtIdTeacher\" was not injected: check your FXML file 'PanelTeacher.fxml'.";
        assert txtNameTeacher != null : "fx:id=\"txtNameTeacher\" was not injected: check your FXML file 'PanelTeacher.fxml'.";
        assert txtSurnameTeacher != null : "fx:id=\"txtSurnameTeacher\" was not injected: check your FXML file 'PanelTeacher.fxml'.";
        assert txtHoursTeacher != null : "fx:id=\"txtHoursTeacher\" was not injected: check your FXML file 'PanelTeacher.fxml'.";
        assert cmdFreeDayTeacher != null : "fx:id=\"cmdFreeDayTeacher\" was not injected: check your FXML file 'PanelTeacher.fxml'.";
        assert listSubTeacher != null : "fx:id=\"listSubTeacher\" was not injected: check your FXML file 'PanelTeacher.fxml'.";
        assert btnAddSubTeacher != null : "fx:id=\"btnAddSubTeacher\" was not injected: check your FXML file 'PanelTeacher.fxml'.";
        assert btnUpdateTeacher != null : "fx:id=\"btnUpdateTeacher\" was not injected: check your FXML file 'PanelTeacher.fxml'.";
        assert btnClearTeacher != null : "fx:id=\"btnClearTeacher\" was not injected: check your FXML file 'PanelTeacher.fxml'.";
        assert btnAddNewTeacher != null : "fx:id=\"btnAddNewTeacher\" was not injected: check your FXML file 'PanelTeacher.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model = model ;		
	}
}


