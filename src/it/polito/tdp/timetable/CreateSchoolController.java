package it.polito.tdp.timetable;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.timetable.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class CreateSchoolController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtName"
    private TextField txtName; // Value injected by FXMLLoader

    @FXML // fx:id="txtAddress"
    private TextField txtAddress; // Value injected by FXMLLoader

    @FXML // fx:id="startLesson"
    private ComboBox<Integer> startLesson; // Value injected by FXMLLoader

    @FXML // fx:id="endLesson"
    private ComboBox<Integer> endLesson; // Value injected by FXMLLoader

    @FXML // fx:id="workDays"
    private ComboBox<Integer> workDays; // Value injected by FXMLLoader

    @FXML // fx:id="txtError"
    private HBox txtError; // Value injected by FXMLLoader


    @FXML
    void doNewSchool(ActionEvent event) {
    	if(txtName.getText().isEmpty() || txtAddress.getText().isEmpty() || 
    			startLesson.getValue() >= endLesson.getValue()) {
    		txtError.setVisible(true);
    		return;
    	}
    	
    		
    	model.addSchool(txtName.getText(), txtAddress.getText(), startLesson.getValue(), endLesson.getValue(), workDays.getValue());
    	Launcher.returnStart();
    }

    @FXML
    void returnStart(ActionEvent event) {
    	Launcher.returnStart();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	  assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'CreateSchool.fxml'.";
          assert txtAddress != null : "fx:id=\"txtAddress\" was not injected: check your FXML file 'CreateSchool.fxml'.";
          assert startLesson != null : "fx:id=\"startLesson\" was not injected: check your FXML file 'CreateSchool.fxml'.";
          assert endLesson != null : "fx:id=\"endLesson\" was not injected: check your FXML file 'CreateSchool.fxml'.";
          assert workDays != null : "fx:id=\"workDays\" was not injected: check your FXML file 'CreateSchool.fxml'.";
          assert txtError != null : "fx:id=\"txtError\" was not injected: check your FXML file 'CreateSchool.fxml'.";
        
        startLesson.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23);
        startLesson.setValue(8);
        endLesson.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23);
        endLesson.setValue(13);
        workDays.getItems().addAll(1,2,3,4,5,6);
        workDays.setValue(5);
    }

	public void setModel(Model model) {
		this.model = model;
		
	}


}


