package application.FXML;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistrationController {
	

	public Stage stage;
	public Scene scene;
	public Parent root;
	

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private Text registerErrorText;

    @FXML
    private TextField username;

    @FXML
    void registerAction(ActionEvent e) throws SQLException {
    	System.out.println("Registering Name: " + name.getText() + " username: " + username.getText());
    	
    	if(name.getText().isBlank() || password.getText().isBlank() || username.getText().isBlank()) 
    	{
    		registerErrorText.setText("You must fill in all fields");
    	} else {

		try (Connection conn = DriverManager.getConnection(DatabaseInfo.CONNECTIONSTRING);

				Statement st = conn.createStatement();) {
    	

    	
    	ResultSet rs = st.executeQuery("select * from " + DatabaseInfo.TABLE_USERS + " where Username = '" + username.getText() + "'");
		if(rs.isBeforeFirst())
		{
			registerErrorText.setText("This user already exists");
		} else {
//			st.execute("insert into " + DatabaseInfo.TABLE_USERS + " (Username, Password, Name) "
//					+ "values ( '" + username.getText() + "', '" + password.getText() + "', " + name.getText() + "')" ); 
					
			String temp = "insert into " + DatabaseInfo.TABLE_USERS + " (Username, Password, Name) "
					+ "values ('" + username.getText() + "', '" + password.getText() + "', '" + name.getText() + "')" ;
			st.execute(temp);
					
			registerErrorText.setText("User registered");

		}
		
		}
		
    	}
    	
    	

    }
    
    @FXML
    void backAction(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.FXML"));
		root = loader.load();
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

}
