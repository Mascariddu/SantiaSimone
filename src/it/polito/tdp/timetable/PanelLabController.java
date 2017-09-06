/**
 * Sample Skeleton for 'PanelLab.fxml' Controller Class
 */

package it.polito.tdp.timetable;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.timetable.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class PanelLabController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

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
    void addNewLab(ActionEvent event) {

    }

    @FXML
    void doCleanLab(ActionEvent event) {

    }

    @FXML
    void doUpdateLab(ActionEvent event) {

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
    void openTabSubject(ActionEvent event) {
    	Launcher.openTabSubject();
    }

    @FXML
    void openTabTeacher(ActionEvent event) {
    	Launcher.openTabTeacher();
    }

    @FXML
    void viewLab(MouseEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert listLab != null : "fx:id=\"listLab\" was not injected: check your FXML file 'PanelLab.fxml'.";
        assert hbxAllertLab != null : "fx:id=\"hbxAllertLab\" was not injected: check your FXML file 'PanelLab.fxml'.";
        assert txtIdLab != null : "fx:id=\"txtIdLab\" was not injected: check your FXML file 'PanelLab.fxml'.";
        assert txtNameLab != null : "fx:id=\"txtNameLab\" was not injected: check your FXML file 'PanelLab.fxml'.";
        assert txtTypeLab != null : "fx:id=\"txtTypeLab\" was not injected: check your FXML file 'PanelLab.fxml'.";
        assert btnUpdateLab != null : "fx:id=\"btnUpdateLab\" was not injected: check your FXML file 'PanelLab.fxml'.";
        assert btnCleanLab != null : "fx:id=\"btnCleanLab\" was not injected: check your FXML file 'PanelLab.fxml'.";
        assert btnAddNewLab != null : "fx:id=\"btnAddNewLab\" was not injected: check your FXML file 'PanelLab.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model = model ;
    }
}
