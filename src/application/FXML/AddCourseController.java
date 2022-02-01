package application.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import application.Course;
import application.SystemCourses;
import application.UserAccount;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class AddCourseController implements Initializable {

	public Stage stage;
	public Scene scene;
	public Parent root;

	@FXML
	private Text message;
	@FXML
	private TableView<Course> coursesDisplay;

	@FXML
	private TableColumn<Course, String> code;
	@FXML
	private TableColumn<Course, String> name;
	@FXML
	private TableColumn<Course, String> desc;
	@FXML
	private TableColumn<Course, String> sTime;
	@FXML
	private TableColumn<Course, String> eTime;
	@FXML
	private TableColumn<Course, String> prof;
	@FXML
	private TableColumn<Course, String> sDate;
	@FXML
	private TableColumn<Course, String> eDate;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		SystemCourses.setSystemCourses();

		ObservableList<Course> list = FXCollections.observableArrayList(SystemCourses.getSystemCourses());

		code.setCellValueFactory(new PropertyValueFactory<Course, String>("courseCode"));
		name.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));
		desc.setCellValueFactory(new PropertyValueFactory<Course, String>("description"));
		sTime.setCellValueFactory(new PropertyValueFactory<Course, String>("startTime"));
		eTime.setCellValueFactory(new PropertyValueFactory<Course, String>("endTime"));
		prof.setCellValueFactory(new PropertyValueFactory<Course, String>("professor"));
		sDate.setCellValueFactory(new PropertyValueFactory<Course, String>("startDate"));
		eDate.setCellValueFactory(new PropertyValueFactory<Course, String>("endDate"));

		coursesDisplay.setItems(list);
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

	public void addCourseAction(ActionEvent e) throws IOException, InterruptedException {
		Course c = coursesDisplay.getSelectionModel().getSelectedItem();
		System.out.println(c);

		FadeTransition ft = new FadeTransition(Duration.millis(3000));
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setNode(message);

		if (UserAccount.getCourses().contains(c)) {
			message.setFill(Color.RED);
			message.setText("This course is already in your schedule");
			ft.play();

		} else if (UserAccount.getCourses().size() >= 6) {
			message.setFill(Color.RED);
			message.setText("You can not have more than 6 courses");
			ft.play();

		} else {
			UserAccount.addCourse(c);
			message.setFill(Color.GREEN);
			message.setText("Added");
			ft.play();

		}
	}

}
