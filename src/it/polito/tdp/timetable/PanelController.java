package it.polito.tdp.timetable;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.timetable.model.Model;
import it.polito.tdp.timetable.model.School;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtID != null : "fx:id=\"txtID\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtAddress != null : "fx:id=\"txtAddress\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtStart != null : "fx:id=\"txtStart\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtEnd != null : "fx:id=\"txtEnd\" was not injected: check your FXML file 'Panel.fxml'.";
        assert txtDays != null : "fx:id=\"txtDays\" was not injected: check your FXML file 'Panel.fxml'.";

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
	}
}
