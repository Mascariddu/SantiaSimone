/**
 * Sample Skeleton for 'PanelLab.fxml' Controller Class
 */

package it.polito.tdp.timetable.panel;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.timetable.model.Lab;
import it.polito.tdp.timetable.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class LabController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="listLab"
    private ListView<Lab> listLab; // Value injected by FXMLLoader

    @FXML // fx:id="hbxAllertLab"
    private HBox hbxAllertLab; // Value injected by FXMLLoader

    @FXML // fx:id="txtIdLab"
    private TextField txtIdLab; // Value injected by FXMLLoader

    @FXML // fx:id="txtNameLab"
    private TextField txtNameLab; // Value injected by FXMLLoader

    @FXML // fx:id="cmbTypeLab"
    private ComboBox<String> cmbTypeLab; // Value injected by FXMLLoader

    @FXML // fx:id="btnUpdateLab"
    private Button btnUpdateLab; // Value injected by FXMLLoader

    @FXML // fx:id="btnCleanLab"
    private Button btnCleanLab; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddNewLab"
    private Button btnAddNewLab; // Value injected by FXMLLoader

    @FXML
    void addNewLab(ActionEvent event) {
    	if(txtNameLab.getText().isEmpty() || cmbTypeLab.getSelectionModel().isEmpty()) {
    		hbxAllertLab.setVisible(true);
    		return;
    	}
    	
    	Lab l = model.addNewLab(txtNameLab.getText(),  cmbTypeLab.getSelectionModel().getSelectedIndex());
    	listLab.getItems().add(l);
    	
    	txtIdLab.setText(l.getLabID());
    	btnAddNewLab.setDisable(true);
    	btnUpdateLab.setDisable(false);
    }

    @FXML
    void doCleanLab(ActionEvent event) {
    	txtIdLab.clear();
    	txtNameLab.clear();
    	cmbTypeLab.getSelectionModel().clearSelection();
    	
    	hbxAllertLab.setVisible(false);
    	
    	btnUpdateLab.setDisable(true);
    	btnAddNewLab.setDisable(false);
    }

    @FXML
    void doUpdateLab(ActionEvent event) {
    	if(txtNameLab.getText().isEmpty() || cmbTypeLab.getSelectionModel().isEmpty()) {
    		hbxAllertLab.setVisible(true);
    		return;
    	}
    	
    	Lab l = new Lab(txtIdLab.getText(), 
    					txtNameLab.getText(), 
    					cmbTypeLab.getSelectionModel().getSelectedIndex());
    		
    	model.updateLab(l);
    	
    	listLab.getItems().clear();
    	listLab.getItems().addAll(model.getAllLab());

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
    	
    	if(listLab.getItems().isEmpty())
    		return;
    	
    	Lab l = listLab.getSelectionModel().getSelectedItem();
    	txtIdLab.setText(l.getLabID());
    	txtNameLab.setText(l.getName());
    	cmbTypeLab.getSelectionModel().clearAndSelect(l.getType());
    	
    	btnUpdateLab.setDisable(false);
    	btnAddNewLab.setDisable(true);
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert listLab != null : "fx:id=\"listLab\" was not injected: check your FXML file 'PanelLab.fxml'.";
        assert hbxAllertLab != null : "fx:id=\"hbxAllertLab\" was not injected: check your FXML file 'PanelLab.fxml'.";
        assert txtIdLab != null : "fx:id=\"txtIdLab\" was not injected: check your FXML file 'PanelLab.fxml'.";
        assert txtNameLab != null : "fx:id=\"txtNameLab\" was not injected: check your FXML file 'PanelLab.fxml'.";
        assert cmbTypeLab != null : "fx:id=\"cmbTypeLab\" was not injected: check your FXML file 'Lab.fxml'.";
        assert btnUpdateLab != null : "fx:id=\"btnUpdateLab\" was not injected: check your FXML file 'PanelLab.fxml'.";
        assert btnCleanLab != null : "fx:id=\"btnCleanLab\" was not injected: check your FXML file 'PanelLab.fxml'.";
        assert btnAddNewLab != null : "fx:id=\"btnAddNewLab\" was not injected: check your FXML file 'PanelLab.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model = model ;
		
		listLab.getItems().addAll(model.getAllLab());
		cmbTypeLab.getItems().addAll(model.getAllTypeLaib());
		
    }
}
