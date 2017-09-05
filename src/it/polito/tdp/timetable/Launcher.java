package it.polito.tdp.timetable;

import it.polito.tdp.timetable.model.Model;
import it.polito.tdp.timetable.model.School;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Launcher {
	
	private static Stage stage;
	
	public static void setStage(Stage primaryStage) {
		stage = primaryStage;
	}

    public static final void doNewSchool() {
    	try {
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("CreateSchool.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			CreateSchoolController controller = loader.getController() ;
			Model model = new Model();
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
			Model model = new Model();
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
    		FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("Panel.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			PanelController controller = loader.getController() ;
			Model model = new Model();
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

}
