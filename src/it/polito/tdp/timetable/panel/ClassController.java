/**
 * Sample Skeleton for 'PanelClass.fxml' Controller Class
 */

package it.polito.tdp.timetable.panel;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.timetable.model.Course;
import it.polito.tdp.timetable.model.Model;
import it.polito.tdp.timetable.model.Subject;
import it.polito.tdp.timetable.model.Teacher;
import it.polito.tdp.timetable.model.Class;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class ClassController {
	
	private Model model;
	private Map<String, String> mapSubjectTeacher;
	private Map<String, Integer> mapChange;
	private int numSubject;
	private int numSubjectUnemployed;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cmbClass"
    private ComboBox<Class> cmbClass; // Value injected by FXMLLoader

    @FXML // fx:id="cmbGrade"
    private ComboBox<Integer> cmbGrade; // Value injected by FXMLLoader

    @FXML // fx:id="cmbSez"
    private ComboBox<String> cmbSez; // Value injected by FXMLLoader

    @FXML // fx:id="cmbCourse"
    private ComboBox<Course> cmbCourse; // Value injected by FXMLLoader

    @FXML // fx:id="txtIdClass"
    private TextField txtIdClass; // Value injected by FXMLLoader

    @FXML // fx:id="txtGradeCourse"
    private TextField txtGradeCourse; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtHoursWeek"
    private TextField txtHoursWeek; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumSubCourse"
    private TextField txtNumSubCourse; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumSubUnemployed"
    private TextField txtNumSubUnemployed; // Value injected by FXMLLoader

    @FXML // fx:id="hbxAllertClass"
    private HBox hbxAllertClass; // Value injected by FXMLLoader

    @FXML // fx:id="listSubClass"
    private ListView<Subject> listSubjects; // Value injected by FXMLLoader

    @FXML // fx:id="txtIdSubClass"
    private TextField txtIdSubClass; // Value injected by FXMLLoader

    @FXML // fx:id="txtNameSubClass"
    private TextField txtNameSubClass; // Value injected by FXMLLoader

    @FXML // fx:id="cmbTeacherSubClass"
    private ComboBox<Teacher> cmbTeacherSubClass; // Value injected by FXMLLoader

    @FXML // fx:id="btnUpdateClass"
    private Button btnUpdateClass; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearClass"
    private Button btnClearClass; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddNewClass"
    private Button btnAddNewClass; // Value injected by FXMLLoader

    @FXML
    void addNewClass(ActionEvent event) {
    	
    	if(numSubjectUnemployed != 0 || listSubjects.getItems().isEmpty() || cmbSez.getSelectionModel().isEmpty()) {
    		hbxAllertClass.setVisible(true);
    		return;
    	}
    	
    	Class c = model.addNewClass(cmbGrade.getSelectionModel().getSelectedItem(), 
    			cmbSez.getSelectionModel().getSelectedItem(), 
    			cmbCourse.getSelectionModel().getSelectedItem().getCourseID(),
    			mapSubjectTeacher);
    	
    	model.getAllTeachers().clear();
    	model.getAllTeachers();
    	
    	model.getAllClasses().clear();
    	model.getAllClasses();
    	
    	cmbClass.getItems().clear();
    	cmbClass.getItems().addAll(model.getAllClasses());
    	
    	txtIdClass.setText(c.getClassID());
    	
    	btnAddNewClass.setDisable(true);
    	btnUpdateClass.setDisable(false);

    }

    @FXML
    void doClearClass(ActionEvent event) {
    	cmbClass.getSelectionModel().clearSelection();
    	txtIdClass.clear();
    	cmbGrade.getSelectionModel().clearSelection();
    	cmbSez.getSelectionModel().clearSelection();
    	cmbCourse.getItems().clear();
    	cmbCourse.setDisable(true);
    	
    	txtIdSubClass.clear();
    	txtNameSubClass.clear();
    	txtHoursWeek.clear();
    	cmbTeacherSubClass.getItems().clear();
    	
    	numSubject = 0;
    	txtNumSubCourse.setText(String.valueOf(numSubject));
    	
    	numSubjectUnemployed = 0;
    	txtNumSubUnemployed.setText(String.valueOf(numSubjectUnemployed));
    	
    	listSubjects.getItems().clear();
    	hbxAllertClass.setVisible(false);
    	
    	btnUpdateClass.setDisable(true);
    	btnAddNewClass.setDisable(false);
    }

    @FXML
    void doUpdateClass(ActionEvent event) {
    	if(numSubjectUnemployed != 0) {
    		hbxAllertClass.setVisible(true);
    		return;
    	}
    	
    	Class c = new Class(txtIdClass.getText(),
    			cmbGrade.getSelectionModel().getSelectedItem(),
    			cmbSez.getSelectionModel().getSelectedItem(),
    			cmbCourse.getSelectionModel().getSelectedItem().getCourseID(),
    			mapSubjectTeacher);
    	
    	model.updateClass(c, cmbClass.getSelectionModel().getSelectedItem());
    	
    	model.getAllTeachers().clear();
    	model.getAllTeachers();
    	
    	model.getAllClasses().clear();
    	model.getAllClasses();

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
    void openTabTeacher(ActionEvent event) {
    	Launcher.openTabTeacher();
    }

    @FXML
    void selectTeacherToSubject(ActionEvent event) {
    	    	
    	if(cmbTeacherSubClass.getSelectionModel().isEmpty()  )
    		return;
    	
    	/* if( mapSubjectTeacher.get(txtIdSubClass.getText()).compareTo(
    			cmbTeacherSubClass.getSelectionModel().getSelectedItem().getTeacherID() ) == 0)
    		return; */
    	
    	if(!mapSubjectTeacher.containsKey(txtIdSubClass.getText())) {
    		numSubjectUnemployed--;
    		txtNumSubUnemployed.setText(String.valueOf(numSubjectUnemployed));
    	}
    	 
    	if(mapChange.containsKey(mapSubjectTeacher.get(txtIdSubClass.getText())))
    		mapChange.put(mapSubjectTeacher.get(txtIdSubClass.getText()), 
    				mapChange.get(mapSubjectTeacher.get(txtIdSubClass.getText())) + Integer.valueOf(txtHoursWeek.getText()));
    	else
    		mapChange.put(mapSubjectTeacher.get(txtIdSubClass.getText()), 
    				+Integer.valueOf(txtHoursWeek.getText()));
    	
    	if(mapChange.containsKey(cmbTeacherSubClass.getSelectionModel().getSelectedItem().getTeacherID()))
    		mapChange.put(cmbTeacherSubClass.getSelectionModel().getSelectedItem().getTeacherID(), 
    				mapChange.get(cmbTeacherSubClass.getSelectionModel().getSelectedItem().getTeacherID()) - Integer.valueOf(txtHoursWeek.getText()));
    	else
    		mapChange.put(cmbTeacherSubClass.getSelectionModel().getSelectedItem().getTeacherID(), 
    				-Integer.valueOf(txtHoursWeek.getText()));
    
    	
    	// model.getAllTeachers().get(model.getAllTeachers().indexOf(new Teacher(
		//		mapSubjectTeacher.get(txtIdSubClass.getText())))).setHoursWork(+Integer.valueOf(txtHoursWeek.getText()));
		// cmbTeacherSubClass.getSelectionModel().getSelectedItem().setHoursWork(-Integer.valueOf(txtHoursWeek.getText()));
    	mapSubjectTeacher.put(txtIdSubClass.getText(), 
    							cmbTeacherSubClass.getSelectionModel().getSelectedItem().getTeacherID());
    	
    }
    
    @FXML
    void showSubjects(ActionEvent event) {
    	if(cmbCourse.getItems().isEmpty() || cmbCourse.getSelectionModel().isEmpty())
    		return;
    	
    	Course c = cmbCourse.getSelectionModel().getSelectedItem();
    	this.mapChange = new HashMap<>();
    	
    	this.mapSubjectTeacher = new HashMap<>();
    	numSubject = c.getListSubject().size();
    	numSubjectUnemployed = numSubject;
    	txtNumSubCourse.setText(String.valueOf(numSubject));
    	txtNumSubUnemployed.setText(String.valueOf(numSubjectUnemployed));
    	
    	listSubjects.getItems().clear();
    	
    	for(String s : c.getListSubject())
    		listSubjects.getItems().add(model.getAllSubjects().get(model.getAllSubjects().indexOf(new Subject(s))));
    }

    @FXML
    void viewClass(ActionEvent event) {
    	if(cmbClass.getItems().isEmpty() || cmbClass.getSelectionModel().isEmpty())
    		return;
    	    	
    	Class c = cmbClass.getSelectionModel().getSelectedItem();
    	
    	txtIdClass.setText(c.getClassID());
    	cmbGrade.getSelectionModel().select(c.getGrade()-1);
    	cmbSez.getSelectionModel().select(c.getSection());
    	cmbCourse.getSelectionModel().select(model.getAllCourses().get(model.getAllCourses().indexOf(new Course(c.getCourseID()))));
    	
    	listSubjects.getItems().clear();
    	
    	for(String subjectID : c.getMapSubjectTeacher().keySet())
    		listSubjects.getItems().add(model.getAllSubjects().get(model.getAllSubjects().indexOf(new Subject(subjectID))));
    	
    	mapSubjectTeacher = c.getMapSubjectTeacher();
    	
    	numSubject = cmbCourse.getSelectionModel().getSelectedItem().getMapSubject().size();
    	txtNumSubCourse.setText(String.valueOf(numSubject));
    	
    	numSubjectUnemployed = numSubject - mapSubjectTeacher.size();
    	txtNumSubUnemployed.setText(String.valueOf(numSubjectUnemployed));
    	    	
    	btnUpdateClass.setDisable(false);
    	btnAddNewClass.setDisable(true);
    }

    @FXML
    void viewSubClass(MouseEvent event) {
    	
    	if(listSubjects.getItems().isEmpty())
    		return;
    	
    	Subject s = (Subject) listSubjects.getSelectionModel().getSelectedItem();
    	txtIdSubClass.setText(s.getSubjectID());
    	txtNameSubClass.setText(s.getName());
    	txtHoursWeek.setText(String.valueOf(cmbCourse.getSelectionModel().getSelectedItem().getMapSubject().get(s.getSubjectID())[0]));
    	
    	cmbTeacherSubClass.getItems().clear();
    	for(Teacher t : model.getAllTeachers())
    		if(t.getEnablingSub().contains(s.getSubjectID()) && t.getHoursWork()>= Integer.valueOf(txtHoursWeek.getText()))
    			if(!mapChange.containsKey(t.getTeacherID()) )
    				cmbTeacherSubClass.getItems().add(t);
    			else if( (mapChange.get(t.getTeacherID()) + t.getHoursWork()) >= Integer.valueOf(txtHoursWeek.getText()))
    				cmbTeacherSubClass.getItems().add(t);

    	if(mapSubjectTeacher.containsKey(s.getSubjectID()))
    		cmbTeacherSubClass.getSelectionModel().select(model.getAllTeachers().get(model.getAllTeachers().indexOf(
    				new Teacher(mapSubjectTeacher.get(s.getSubjectID())))));

    } 

    @FXML
    void viewCourseByGrade(ActionEvent event) {
    	if(cmbGrade.getSelectionModel().isEmpty())
    		return;
    	
    	cmbCourse.getItems().clear();
    	cmbSez.getItems().clear();
		cmbSez.getItems().addAll("A","B","C","D","E","F","G","H","I","L","M","N","O","P","Q","R","S","T","U","V","Z");
    	
    	for(Course c : model.getAllCourses())
    		if(c.getGrade() == cmbGrade.getSelectionModel().getSelectedItem())
    			cmbCourse.getItems().add(c);

    	for(Class c : model.getAllClasses())
    		if(c.getGrade() == cmbGrade.getSelectionModel().getSelectedItem())
    			cmbSez.getItems().remove(c.getSection());
    	
    	if(!cmbCourse.getItems().isEmpty())
    		cmbCourse.setDisable(false);
    	else 
    		cmbCourse.setDisable(true);

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cmbClass != null : "fx:id=\"cmbClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert txtIdClass != null : "fx:id=\"txtIdClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert cmbGrade != null : "fx:id=\"cmbGrade\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert cmbSez != null : "fx:id=\"cmbSez\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert cmbCourse != null : "fx:id=\"cmbCourse\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert txtNumSubCourse != null : "fx:id=\"txtNumSubCourse\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert txtNumSubUnemployed != null : "fx:id=\"txtNumSubUnemployed\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert hbxAllertClass != null : "fx:id=\"hbxAllertClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert listSubjects != null : "fx:id=\"listSubClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert txtHoursWeek != null : "fx:id=\"txtHoursWeek\" was not injected: check your FXML file 'Class.fxml'.";
        assert txtIdSubClass != null : "fx:id=\"txtIdSubClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert txtNameSubClass != null : "fx:id=\"txtNameSubClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert cmbTeacherSubClass != null : "fx:id=\"cmbTeacherSubClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert btnUpdateClass != null : "fx:id=\"btnUpdateClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert btnClearClass != null : "fx:id=\"btnClearClass\" was not injected: check your FXML file 'PanelClass.fxml'.";
        assert btnAddNewClass != null : "fx:id=\"btnAddNewClass\" was not injected: check your FXML file 'PanelClass.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model = model ;
		this.mapSubjectTeacher = new HashMap<>();
		
		cmbClass.getItems().addAll(model.getAllClasses());
		cmbGrade.getItems().addAll(1,2,3,4,5,6,7);
		
		cmbCourse.setDisable(true);
		
	}
}
