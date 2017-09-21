package it.polito.tdp.timetable.panel;

import java.util.List;

import it.polito.tdp.timetable.CreateSchoolController;
import it.polito.tdp.timetable.StartController;
import it.polito.tdp.timetable.model.Course;
import it.polito.tdp.timetable.model.Model;
import it.polito.tdp.timetable.model.School;
import it.polito.tdp.timetable.model.Subject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Launcher {
	
	private static Stage stage;
	private static Stage popup;
	private static Model model;
	
	public static void setStage(Stage primaryStage) {
		stage = primaryStage;
		popup = new Stage();
	}

    public static final void doNewSchool() {
    	try {
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("../CreateSchool.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			CreateSchoolController controller = loader.getController() ;
			model = new Model();
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Launcher.class.getResource("application.css").toExternalForm());

			stage.setScene(scene);
			stage.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public static final void returnStart() {
    	try {
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("Start.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			StartController controller = loader.getController() ;
			model = new Model();
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Launcher.class.getResource("application.css").toExternalForm());

			stage.setScene(scene);
			stage.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public static final void openDB(School school) {
    	try {
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("General.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			GeneralController controller = loader.getController() ;
			model = new Model();
			model.setSchool(school);
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Launcher.class.getResource("application.css").toExternalForm());
			stage.close();
			
			stage = new Stage();
			stage.setTitle("Timetable School Creator - " + school.getName());
			stage.getIcons().add(new Image(Launcher.class.getResourceAsStream("../icon.png")));
			stage.setScene(scene);
			stage.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public static final void openTabSubject() {
    	try {
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("Subject.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			SubjectController controller = loader.getController() ;
			
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Launcher.class.getResource("application.css").toExternalForm());

			stage.setScene(scene);
			stage.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public static final void openTabTeacher() {
    	try {
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("Teacher.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			TeacherController controller = loader.getController() ;
			
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Launcher.class.getResource("application.css").toExternalForm());

			stage.setScene(scene);
			stage.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public static final void openTabClass() {
    	try {
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("Class.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			ClassController controller = loader.getController() ;
			
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Launcher.class.getResource("application.css").toExternalForm());

			stage.setScene(scene);
			stage.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public static final void openTabCourse() {
    	try {
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("Course.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			CourseController controller = loader.getController() ;
			
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Launcher.class.getResource("application.css").toExternalForm());

			if(popup.isShowing())
				popup.close();
			
			stage.setScene(scene);
			stage.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public static final void openTabLab() {
    	try {
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("Lab.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			LabController controller = loader.getController() ;
			
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Launcher.class.getResource("application.css").toExternalForm());

			stage.setScene(scene);
			stage.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public static final void openTabGeneral() {
    	try {
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("General.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			GeneralController controller = loader.getController() ;
			
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Launcher.class.getResource("application.css").toExternalForm());

			stage.setScene(scene);
			stage.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }

	public static void openCreateNewCourse(String nameCourse, int grade, List<Subject> items) {
    	try {
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("CreateNewCourse.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			CreateNewCourseController controller = loader.getController() ;
			
			controller.setModel(model, nameCourse, grade, items);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Launcher.class.getResource("application.css").toExternalForm());
			
			popup = new Stage();
			popup.setScene(scene);
			popup.setTitle("Assegnazione ore per ogni materia - " + nameCourse);
			popup.getIcons().add(new Image(Launcher.class.getResourceAsStream("../icon.png")));
			popup.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void openUpdateCourse(Course c, List<Subject> items) {
    	try {
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("UpdateCourse.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			UpdateCourseController controller = loader.getController() ;
			
			controller.setModel(model, c, items);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Launcher.class.getResource("application.css").toExternalForm());
			
			popup = new Stage();
			popup.setScene(scene);
			popup.setTitle("Assegnazione ore per ogni materia - " + c.getName());
			popup.getIcons().add(new Image(Launcher.class.getResourceAsStream("../icon.png")));
			popup.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void openTimetable(String[][] timetable) {
    	try {
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("Timetable.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			Timetable controller = loader.getController() ;
			
			controller.setModel(model, timetable);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Launcher.class.getResource("application.css").toExternalForm());
			
			popup = new Stage();
			popup.setScene(scene);
			popup.getIcons().add(new Image(Launcher.class.getResourceAsStream("../icon.png")));
			popup.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
