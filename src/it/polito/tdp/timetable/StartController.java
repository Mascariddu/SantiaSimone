package it.polito.tdp.timetable;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.timetable.model.Model;
import it.polito.tdp.timetable.model.School;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;


public class StartController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxDB"
    private ComboBox<School> boxDB; // Value injected by FXMLLoader

    @FXML // fx:id="btnNext"
    private Button btnNext; // Value injected by FXMLLoader

    @FXML
    void doNewDB(ActionEvent event) {
    	Launcher.doNewSchool();
    }

    @FXML
    void openDB(ActionEvent event) {
    	School school = boxDB.getValue();
    	Launcher.openDB(school);
    }


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxDB != null : "fx:id=\"boxDB\" was not injected: check your FXML file 'Start.fxml'.";
        assert btnNext != null : "fx:id=\"btnNext\" was not injected: check your FXML file 'Start.fxml'.";

    }
	
	public void setModel(Model model) {
		this.model = model ;
		List<School> schools = model.getAllSchools();
		
		if(schools.isEmpty()) 
			boxDB.setDisable(true);
		else {
			boxDB.getItems().addAll(schools);
			boxDB.setValue(schools.get(0));
		}
	}
	
}
