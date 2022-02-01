package application.FXML;

import java.io.IOException;

import application.UserAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeController {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private Text message;

	public void setMessage(String message) {
		this.message.setText(message);
	}

	public void viewScheduleAction(ActionEvent e) throws IOException {
		if (UserAccount.getCourses() == null) {
			System.out.println("There are no courses in your account");
		} else {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewSchedulePage.FXML"));

			root = loader.load();

			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

			scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("./application.css").toExternalForm());
			stage.setScene(scene);

			stage.show();
		}
	}

	public void addCourseAction(ActionEvent e) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCoursePage.FXML"));

		root = loader.load();

//		AddCourseController addCon = loader.getController();
//		addCon.showCourses();

		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

		scene = new Scene(root);
//		scene.getStylesheets().add(getClass().getResource("./application.css").toExternalForm());
		stage.setScene(scene);

		stage.show();
	}

	public void logOutAction(ActionEvent e) throws IOException {
		UserAccount.clear();

		root = FXMLLoader.load(getClass().getResource("LoginPage.FXML"));

		scene = new Scene(root);

		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	public void displayCoursesAction(ActionEvent e) throws IOException {
		System.out.println(UserAccount.getCourses());
	}
}
