package application;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class CourseSelectionMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			

			
			
//-------------------------------------------------------------------
			Parent root = FXMLLoader.load(getClass().getResource("./FXML/LoginPage.FXML"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Course Selection Application");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		launch(args);
	}

}
