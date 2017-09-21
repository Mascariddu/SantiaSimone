/**
 * Sample Skeleton for 'Timetable.fxml' Controller Class
 */

package it.polito.tdp.timetable.panel;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.timetable.model.Class;
import it.polito.tdp.timetable.model.Model;
import it.polito.tdp.timetable.model.TimetableGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class Timetable {
	
	private Model model;
	private TimetableGenerator timetable;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="tbTimetable"
    private BorderPane tbTimetable; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert tbTimetable != null : "fx:id=\"tbTimetable\" was not injected: check your FXML file 'Timetable.fxml'.";

    }
    
    public void setModel(Model model, String[][] timetable) {
    	this.model = model;
    	String time = "";
    	
    	for(int r = 0; r < model.getHoursDaySchool(); r++) {
    		for(int c = 0; c< model.getSchool().getWorkDays(); c++)
    			time += timetable[r][c] + " | ";
    		time += "\n";
    	}
    	
    	
    	
    }
    
    
}
