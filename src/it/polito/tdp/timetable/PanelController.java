package it.polito.tdp.timetable;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.timetable.model.Model;
import it.polito.tdp.timetable.model.School;
import it.polito.tdp.timetable.model.Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
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

	    @FXML // fx:id="listSubject"
	    private ListView<Subject> listSubject; // Value injected by FXMLLoader

	    @FXML // fx:id="txtSubID"
	    private TextField txtSubID; // Value injected by FXMLLoader

	    @FXML // fx:id="txtNameSub"
	    private TextField txtNameSub; // Value injected by FXMLLoader

	    @FXML // fx:id="txtHoursSub"
	    private TextField txtHoursSub; // Value injected by FXMLLoader

	    @FXML // fx:id="txtTeachersSub"
	    private Label txtTeachersSub; // Value injected by FXMLLoader

	    @FXML // fx:id="listTeachersSub"
	    private ListView<?> listTeachersSub; // Value injected by FXMLLoader
	    
	    @FXML // fx:id="checkLab"
	    private CheckBox checkLab; // Value injected by FXMLLoader

	    @FXML // fx:id="vbxLab"
	    private VBox vbxLab; // Value injected by FXMLLoader
	    
	    @FXML // fx:id="txtHoursLab"
	    private TextField txtHoursLab; // Value injected by FXMLLoader

	    @FXML // fx:id="cmbLabSub"
	    private ComboBox<String> cmbLabSub; // Value injected by FXMLLoader

	    @FXML
	    void addSub(ActionEvent event) {

	    }

	    @FXML
	    void clearSub(ActionEvent event) {

	    }

	    @FXML
	    void doModifySub(ActionEvent event) {

	    }

	    @FXML
	    void doVisibleLab(ActionEvent event) {
	    	if(checkLab.isSelected())
	    		vbxLab.setDisable(false);
	    	else 
	    		vbxLab.setDisable(true);
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
	    		cmbLabSub.getItems().add(s.getTypeLab());
	    	} else {
	    		vbxLab.setDisable(true);
	    		checkLab.setSelected(false);
	    		txtHoursLab.clear();
	    		cmbLabSub.getItems().clear();
	    	}
	    		
	    	txtTeachersSub.setVisible(true);
	    	listTeachersSub.setVisible(true);

	    }

	    @FXML // This method is called by the FXMLLoader when initialization is complete
	    void initialize() {
	        assert txtID != null : "fx:id=\"txtID\" was not injected: check your FXML file 'Panel.fxml'.";
	        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'Panel.fxml'.";
	        assert txtAddress != null : "fx:id=\"txtAddress\" was not injected: check your FXML file 'Panel.fxml'.";
	        assert txtStart != null : "fx:id=\"txtStart\" was not injected: check your FXML file 'Panel.fxml'.";
	        assert txtEnd != null : "fx:id=\"txtEnd\" was not injected: check your FXML file 'Panel.fxml'.";
	        assert txtDays != null : "fx:id=\"txtDays\" was not injected: check your FXML file 'Panel.fxml'.";
	        assert listSubject != null : "fx:id=\"listSubject\" was not injected: check your FXML file 'Panel.fxml'.";
	        assert txtSubID != null : "fx:id=\"txtSubID\" was not injected: check your FXML file 'Panel.fxml'.";
	        assert txtNameSub != null : "fx:id=\"txtNameSub\" was not injected: check your FXML file 'Panel.fxml'.";
	        assert txtHoursSub != null : "fx:id=\"txtHoursSub\" was not injected: check your FXML file 'Panel.fxml'.";
	        assert checkLab != null : "fx:id=\"checkLab\" was not injected: check your FXML file 'Panel.fxml'.";
	        assert vbxLab != null : "fx:id=\"vbxLab\" was not injected: check your FXML file 'Panel.fxml'.";
	        assert txtHoursLab != null : "fx:id=\"txtHoursLab\" was not injected: check your FXML file 'Panel.fxml'.";
	        assert cmbLabSub != null : "fx:id=\"cmbLabSub\" was not injected: check your FXML file 'Panel.fxml'.";
	        assert txtTeachersSub != null : "fx:id=\"txtTeachersSub\" was not injected: check your FXML file 'Panel.fxml'.";
	        assert listTeachersSub != null : "fx:id=\"listTeachersSub\" was not injected: check your FXML file 'Panel.fxml'.";

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


