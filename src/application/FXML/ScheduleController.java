package application.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Course;
import application.UserAccount;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScheduleController implements Initializable {

	private Parent root;
	private Scene scene;
	private Stage stage;

	@FXML
	private Text errorMessage;
	
	@FXML
	private FlowPane mySchedule;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		if (UserAccount.getCourses() != null) {
			for (Course c : UserAccount.getCourses()) {
				VBox container = new VBox();
				Label desc = new Label(c.getDescription());
				desc.setWrapText(true);
				
				String cssLayout = "-fx-border-color: green;\n" +
		                   "-fx-border-insets: 5;\n" +
		                   "-fx-border-width: 3;\n" +
		                   "-fx-border-style: dashed;\n";
				container.setStyle(cssLayout);
				
				Button removeButton = new Button("Remove");
				removeButton.setOnAction(e -> {
					UserAccount.getCourses().remove(c);
					mySchedule.getChildren().remove(container);
					});
				
				container.getChildren().addAll(new Label(c.getCourseCode()), new Label(c.getName()), new Label(c.getProfessor()), new Label(String.valueOf(c.getStartTime())), new Label(String.valueOf(c.getEndTime())), 
						new Label(String.valueOf(c.getStartDate())), new Label(String.valueOf(c.getEndDate())), desc, removeButton);

				
				container.setMaxWidth(145);
				container.setMinWidth(145);
				mySchedule.getChildren().add(container);
			}

		} else {
			
			errorMessage.setText("There is nothing here");

//			mySchedule.getChildren().removeAll();
//			mySchedule.getChildren().add(temp);
		}

	}

	public void backAction(ActionEvent e) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.FXML"));

		root = loader.load();

		HomeController homCon = loader.getController();
		homCon.setMessage(UserAccount.getName());

		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

		scene = new Scene(root);
//		scene.getStylesheets().add(getClass().getResource("./application.css").toExternalForm());
		stage.setScene(scene);

		stage.show();
	}
	
}
