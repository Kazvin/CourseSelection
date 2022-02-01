package application.FXML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInfo {
	final public static String DBNAME = "/Users.db",
			CONNECTIONSTRING = "jdbc:sqlite:" + "./" + DBNAME,
			TABLE_USERS = "Users";
	
	
	public String getDBNAME  () 
	{ return DBNAME; }
	
	public String getCONNECTIONSTRING  () 
	{ return CONNECTIONSTRING; }
	
	public String getTABLE_USERS  () 
	{ return TABLE_USERS; }
	
	
	public static void createDB() throws SQLException {

		try (Connection conn = DriverManager.getConnection(DatabaseInfo.CONNECTIONSTRING);

				Statement st = conn.createStatement();) {

			st.execute("create table if not exists " + DatabaseInfo.TABLE_USERS + "(" 
					+ "ID INTEGER constraint ID_PK Primary key AUTOINCREMENT,"
					+ "Username	TEXT not null unique," 
					+ "Password TEXT not null ," 
					+ "Name TEXT )"
					);

		}

	}
}
