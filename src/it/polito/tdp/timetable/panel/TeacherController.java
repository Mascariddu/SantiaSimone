/**
 * Sample Skeleton for 'PanelTeacher.fxml' Controller Class
 */

package it.polito.tdp.timetable.panel;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.timetable.model.Model;
import it.polito.tdp.timetable.model.Subject;
import it.polito.tdp.timetable.model.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class TeacherController {
	
	private Model model;
	private List<Subject> subjectsList;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="listTeachers"
    private ListView<Teacher> listTeachers; // Value injected by FXMLLoader

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
    private ComboBox<String> cmdFreeDayTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="listSubTeacher"
    private ListView<Subject> listSubTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="listSub"
    private ListView<Subject> listSub; // Value injected by FXMLLoader

    @FXML // fx:id="btnUpdateTeacher"
    private Button btnUpdateTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearTeacher"
    private Button btnClearTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddNewTeacher"
    private Button btnAddNewTeacher; // Value injected by FXMLLoader

    @FXML
    void addNewTeacher(ActionEvent event) {
    	
    	if(txtNameTeacher.getText().isEmpty() || txtSurnameTeacher.getText().isEmpty() ||  
    			txtHoursTeacher.getText().isEmpty() || listSubTeacher.getItems().isEmpty()) {
    		hbxAllertTeacher.setVisible(true);
    		return;
    	}
    	
    	Teacher t = model.addNewTeacher(txtNameTeacher.getText(), txtSurnameTeacher.getText(),
    			Integer.valueOf(txtHoursTeacher.getText()),cmdFreeDayTeacher.getSelectionModel().getSelectedIndex(), listSubTeacher.getItems());
    	listTeachers.getItems().clear();
    	listTeachers.getItems().addAll(model.getAllTeachers());
    	txtIdTeacher.setText(t.getTeacherID());
    	
    	btnUpdateTeacher.setDisable(false);
    	btnAddNewTeacher.setDisable(true);
    	
    }

    @FXML
    void doClearTeacher(ActionEvent event) {
    	
    	listTeachers.getSelectionModel().clearSelection();
    	txtIdTeacher.clear();
    	txtNameTeacher.clear();
    	txtSurnameTeacher.clear();
    	txtHoursTeacher.clear();
    	
    	listSubTeacher.getItems().clear();
    	listSub.getItems().clear();
    	listSub.getItems().addAll(subjectsList);
    	
    	hbxAllertTeacher.setVisible(false);
    	
    	btnUpdateTeacher.setDisable(true);
    	btnAddNewTeacher.setDisable(false);

    }

    @FXML
    void doUpdateTeacher(ActionEvent event) {
    	
    	if(txtNameTeacher.getText().isEmpty() || txtSurnameTeacher.getText().isEmpty() ||  
    			txtHoursTeacher.getText().isEmpty() || listSubTeacher.getItems().isEmpty()) {
    		hbxAllertTeacher.setVisible(true);
    		return;
    	}
    	
    	List<String> subjectIDList = new ArrayList<>();
    	
    	for(Subject s : listSubTeacher.getItems())
    		subjectIDList.add(s.getSubjectID());
    	
    	Teacher c = new Teacher(txtIdTeacher.getText(), 
    					txtNameTeacher.getText(),
    					txtSurnameTeacher.getText(),
    					Integer.valueOf(txtHoursTeacher.getText()), 
    					cmdFreeDayTeacher.getSelectionModel().getSelectedIndex(),
    					subjectIDList);
    	c.setHoursWork(listTeachers.getSelectionModel().getSelectedItem().getHoursWork() - c.getHoursWeek());
    	model.updateTeacher(c, listTeachers.getSelectionModel().getSelectedItem());
    	
    	listTeachers.getItems().clear();
    	listTeachers.getItems().addAll(model.getAllTeachers());

    }

    @FXML
    void moveSubDown(ActionEvent event) {

    	if(listSubTeacher.getSelectionModel().isEmpty())
    		return; 
    	
    	Subject s = listSubTeacher.getSelectionModel().getSelectedItem();
    	 		
    	listSubTeacher.getItems().remove(s);
    	listSub.getItems().add(s);
    }

    @FXML
    void moveUpSub(ActionEvent event) {
    	
    	if(listSub.getSelectionModel().isEmpty())
    		return; 
    	
    	Subject s = listSub.getSelectionModel().getSelectedItem();

    	listSub.getItems().remove(s);
    	listSubTeacher.getItems().add(s);
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
    void viewTeacher(MouseEvent event) {
    	if(listTeachers.getItems().isEmpty())
    		return;
    	
    	Teacher t = listTeachers.getSelectionModel().getSelectedItem();
    	txtIdTeacher.setText(t.getTeacherID());
    	txtNameTeacher.setText(t.getName());
    	txtSurnameTeacher.setText(t.getSurname());
    	txtHoursTeacher.setText(String.valueOf(t.getHoursWeek()));
    	cmdFreeDayTeacher.getSelectionModel().select(t.getFreeDay());
    	
    	listSubTeacher.getItems().clear();
    	listSub.getItems().clear();
    	listSub.getItems().addAll(subjectsList);
    	
    	for(String subjectID : t.getEnablingSub()) {
    		listSubTeacher.getItems().add(subjectsList.get(subjectsList.indexOf(new Subject(subjectID))));
    		listSub.getItems().remove(new Subject(subjectID));
    	}
    	
    	btnUpdateTeacher.setDisable(false);
    	btnAddNewTeacher.setDisable(true);

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
        assert listSub != null : "fx:id=\"listSub\" was not injected: check your FXML file 'PanelTeacher.fxml'.";
        assert btnUpdateTeacher != null : "fx:id=\"btnUpdateTeacher\" was not injected: check your FXML file 'PanelTeacher.fxml'.";
        assert btnClearTeacher != null : "fx:id=\"btnClearTeacher\" was not injected: check your FXML file 'PanelTeacher.fxml'.";
        assert btnAddNewTeacher != null : "fx:id=\"btnAddNewTeacher\" was not injected: check your FXML file 'PanelTeacher.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model = model ;	
		this.subjectsList = model.getAllSubjects();
		
		listTeachers.getItems().addAll(model.getAllTeachers());
		listSub.getItems().addAll(subjectsList);
		cmdFreeDayTeacher.getItems().addAll("Lunedi","Martedi","Mercoledi","Giovedi","Venerdi","Sabato","Domenica");
	}
}


