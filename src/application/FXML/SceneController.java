package application.FXML;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.UserAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//login page controller
public class SceneController {

	public Stage stage;
	public Scene scene;
	public Parent root;

	@FXML
	private TextField user;
	@FXML
	private PasswordField password;
	@FXML
	private Text loginErrorText;
	@FXML
	private Button closeButton;



	public void loginButton(ActionEvent e) throws IOException, SQLException {

		try (Connection conn = DriverManager.getConnection(DatabaseInfo.CONNECTIONSTRING);

				Statement st = conn.createStatement();) {

			if (user.getText().isBlank() && password.getText().isBlank()) {
				loginErrorText.setText("You need to enter something in");
			} else {

				ResultSet rs = st
						.executeQuery("select * from " + DatabaseInfo.TABLE_USERS + " where Username = '" + user.getText() + "'");

				if (rs.isBeforeFirst()) {

					UserAccount.setName(rs.getString("Name"));

					FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.FXML"));

					root = loader.load();

					HomeController homCon = loader.getController();
					homCon.setMessage(UserAccount.getName());

					stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

					scene = new Scene(root);
					// scene.getStylesheets().add(getClass().getResource("./application.css").toExternalForm());
					stage.setScene(scene);

					stage.show();

					rs.close();
				} else {
					loginErrorText.setText("Invalid username and/or password");
				}

			}
		}

	}

	public void registerButtonAction(ActionEvent e) throws IOException, SQLException {
		DatabaseInfo.createDB();
		
		root = FXMLLoader.load(getClass().getResource("RegisterPage.FXML"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

	public void closeButtonAction(ActionEvent e) throws IOException {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
		System.out.println("Bye");
	}



}
