/**
 * Sample Skeleton for 'Timetable.fxml' Controller Class
 */

package it.polito.tdp.timetable.panel;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.timetable.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class Timetable {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="tbTimetable"
    private BorderPane tbTimetable; // Value injected by FXMLLoader

    @FXML // fx:id="twHour"
    private TableView<String> twHour; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert tbTimetable != null : "fx:id=\"tbTimetable\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert twHour != null : "fx:id=\"twHour\" was not injected: check your FXML file 'Timetable.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	List<TableView<String>> columns = new LinkedList<>();
    	
    	ObservableList<Integer> hours = FXCollections.observableArrayList();
    	for(int h=model.getSchool().getStartLessons(); h <= model.getSchool().getEndLessons(); h++)
    		hours.add(h);
    	
    }
    
    
}
