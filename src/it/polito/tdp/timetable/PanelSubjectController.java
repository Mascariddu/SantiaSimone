/**
 * Sample Skeleton for 'PanelSubject.fxml' Controller Class
 */

package it.polito.tdp.timetable;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.timetable.model.Model;
import it.polito.tdp.timetable.model.Subject;
import it.polito.tdp.timetable.model.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PanelSubjectController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="listSubject"
    private ListView<Subject> listSubject; // Value injected by FXMLLoader

    @FXML // fx:id="hbxAllertSub"
    private HBox hbxAllertSub; // Value injected by FXMLLoader

    @FXML // fx:id="txtIdSub"
    private TextField txtIdSub; // Value injected by FXMLLoader

    @FXML // fx:id="txtNameSub"
    private TextField txtNameSub; // Value injected by FXMLLoader

    @FXML // fx:id="txtHoursSub"
    private TextField txtHoursSub; // Value injected by FXMLLoader

    @FXML // fx:id="checkLab"
    private CheckBox checkLab; // Value injected by FXMLLoader

    @FXML // fx:id="vbxLab"
    private VBox vbxLab; // Value injected by FXMLLoader

    @FXML // fx:id="txtHoursLab"
    private TextField txtHoursLab; // Value injected by FXMLLoader

    @FXML // fx:id="cmbLabSub"
    private ComboBox<String> cmbLabSub; // Value injected by FXMLLoader

    @FXML // fx:id="listTeachersSub"
    private ListView<Teacher> listTeachersSub; // Value injected by FXMLLoader

    @FXML // fx:id="btnUpdateSub"
    private Button btnUpdateSub; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearSub"
    private Button btnClearSub; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddNewSub"
    private Button btnAddNewSub; // Value injected by FXMLLoader

    @FXML
    void addNewSub(ActionEvent event) {
    	if(txtNameSub.getText().isEmpty() || txtHoursSub.getText().isEmpty() 
    			|| (checkLab.isSelected() && (txtHoursLab.getText().isEmpty() || cmbLabSub.getItems().isEmpty()))
    			|| (Integer.valueOf(txtHoursLab.getText()) > Integer.valueOf(txtHoursSub.getText()))) {
    		hbxAllertSub.setVisible(true);
    		return;
    	}
    	
    	Subject s;
    	
    	if(checkLab.isSelected())
    		s = model.addNewSubject(txtNameSub.getText(), Integer.valueOf(txtHoursSub.getText()), Integer.valueOf(txtHoursLab.getText()), cmbLabSub.getValue());
    	else {
    		s = model.addNewSubject(txtNameSub.getText(), Integer.valueOf(txtHoursSub.getText()), 0, null);
    		cmbLabSub.getSelectionModel().clearSelection();
    		txtHoursLab.clear();
    	}

    	listSubject.getItems().add(s);
    	
    	txtIdSub.setText(s.getSubjectID());
    	btnAddNewSub.setDisable(true);
    	btnUpdateSub.setDisable(false);
    }

    @FXML
    void clearSub(ActionEvent event) {
    	txtIdSub.clear();
    	txtNameSub.clear();
    	txtHoursSub.clear();
    	txtHoursLab.clear();
    	hbxAllertSub.setVisible(false);
    	cmbLabSub.getSelectionModel().clearSelection();
    	
    	btnUpdateSub.setDisable(true);
    	btnAddNewSub.setDisable(false);
    }

    @FXML
    void doUpdateSub(ActionEvent event) {
    	if(txtNameSub.getText().isEmpty() || txtHoursSub.getText().isEmpty() 
    			|| (checkLab.isSelected() && (txtHoursLab.getText().isEmpty() || cmbLabSub.getItems().isEmpty()))) {
    		hbxAllertSub.setVisible(true);
    		return;
    	}
    	
    	Subject s;
    	
    	if(checkLab.isSelected()) {
    		s = new Subject(txtIdSub.getText(), 
    					txtNameSub.getText(), 
    					Integer.valueOf(txtHoursSub.getText()), 
    					Integer.valueOf(txtHoursLab.getText()), 
    					cmbLabSub.getSelectionModel().getSelectedItem());
    	} else {
    		s = new Subject(txtIdSub.getText(), 
					txtNameSub.getText(), 
					Integer.valueOf(txtHoursSub.getText()), 
					0, 
					null);
    	}
    		
    	model.updateSubject(s);
    	
    	listSubject.getItems().clear();
    	listSubject.getItems().addAll(model.getAllSubjects());

    }

    @FXML
    void doVisibleLab(ActionEvent event) {
    	if(checkLab.isSelected())
    		vbxLab.setDisable(false);
    	else 
    		vbxLab.setDisable(true);
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
    void openTabTeacher(ActionEvent event) {
    	Launcher.openTabTeacher();
    }

    @FXML
    void viewSubject(MouseEvent event) {
    	if(listSubject.getItems().isEmpty())
    		return;
    	
    	Subject s = (Subject) listSubject.getSelectionModel().getSelectedItem();
    	txtIdSub.setText(s.getSubjectID());
    	txtNameSub.setText(s.getName());
    	txtHoursSub.setText(String.valueOf(s.getHoursWeek()));
    	listTeachersSub.getItems().addAll(s.getTeachers());
    	
    	if(s.getHoursLab() != 0 ) {
    		vbxLab.setDisable(false);
    		checkLab.setSelected(true);
    		txtHoursLab.setText(String.valueOf(s.getHoursLab()));
    		cmbLabSub.setValue(s.getTypeLab());
    	} else {
    		vbxLab.setDisable(true);
    		checkLab.setSelected(false);
    		txtHoursLab.clear();
    		cmbLabSub.getSelectionModel().clearSelection();
    	}
    	
    	btnUpdateSub.setDisable(false);
    	btnAddNewSub.setDisable(true);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert listSubject != null : "fx:id=\"listSubject\" was not injected: check your FXML file 'PanelSubject.fxml'.";
        assert hbxAllertSub != null : "fx:id=\"hbxAllertSub\" was not injected: check your FXML file 'PanelSubject.fxml'.";
        assert txtIdSub != null : "fx:id=\"txtIdSub\" was not injected: check your FXML file 'PanelSubject.fxml'.";
        assert txtNameSub != null : "fx:id=\"txtNameSub\" was not injected: check your FXML file 'PanelSubject.fxml'.";
        assert txtHoursSub != null : "fx:id=\"txtHoursSub\" was not injected: check your FXML file 'PanelSubject.fxml'.";
        assert checkLab != null : "fx:id=\"checkLab\" was not injected: check your FXML file 'PanelSubject.fxml'.";
        assert vbxLab != null : "fx:id=\"vbxLab\" was not injected: check your FXML file 'PanelSubject.fxml'.";
        assert txtHoursLab != null : "fx:id=\"txtHoursLab\" was not injected: check your FXML file 'PanelSubject.fxml'.";
        assert cmbLabSub != null : "fx:id=\"cmbLabSub\" was not injected: check your FXML file 'PanelSubject.fxml'.";
        assert listTeachersSub != null : "fx:id=\"listTeachersSub\" was not injected: check your FXML file 'PanelSubject.fxml'.";
        assert btnUpdateSub != null : "fx:id=\"btnUpdateSub\" was not injected: check your FXML file 'PanelSubject.fxml'.";
        assert btnClearSub != null : "fx:id=\"btnClearSub\" was not injected: check your FXML file 'PanelSubject.fxml'.";
        assert btnAddNewSub != null : "fx:id=\"btnAddNewSub\" was not injected: check your FXML file 'PanelSubject.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model = model ;
		
		// Materie
		listSubject.getItems().addAll(model.getAllSubjects());
		cmbLabSub.getItems().addAll(model.getAllTypeLaib());
		
		
	}
}


