package it.polito.tdp.timetable;

import it.polito.tdp.timetable.model.Model;
import it.polito.tdp.timetable.model.School;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Launcher {
	
	private static Stage stage;
	private static Model model;
	
	public static void setStage(Stage primaryStage) {
		stage = primaryStage;
	}

    public static final void doNewSchool() {
    	try {
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("CreateSchool.fxml")) ;
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
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("PanelGeneral.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			PanelGeneralController controller = loader.getController() ;
			model = new Model();
			model.setSchool(school);
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Launcher.class.getResource("application.css").toExternalForm());
			stage.close();
			
			stage = new Stage();
			stage.setTitle("Timetable School Creator - " + school.getName());
			stage.setScene(scene);
			stage.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public static final void openTabSubject() {
    	try {
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("PanelSubject.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			PanelSubjectController controller = loader.getController() ;
			
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
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("PanelTeacher.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			PanelTeacherController controller = loader.getController() ;
			
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
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("PanelClass.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			PanelClassController controller = loader.getController() ;
			
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
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("PanelCourse.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			PanelCourseController controller = loader.getController() ;
			
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Launcher.class.getResource("application.css").toExternalForm());

			stage.setScene(scene);
			stage.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public static final void openTabLab() {
    	try {
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("PanelLab.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			PanelLabController controller = loader.getController() ;
			
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
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("PanelGeneral.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			PanelGeneralController controller = loader.getController() ;
			
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Launcher.class.getResource("application.css").toExternalForm());

			stage.setScene(scene);
			stage.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }

}
