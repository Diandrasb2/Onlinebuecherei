package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQL {

	static Connection connection = null;
	private static final String host = "localhost";
	private static final String port = "3306";
	private static final String database = "benutzerdatabase";
	private static final String username = "Timm";
	private static final String password = "passwort1912";
		
	public static boolean isConnected() {
		
			return (connection == null ? false : true);
	}
	
	public static void connect() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		if(!isConnected()) {
			
			try {
						
				Class.forName("com.mysql.cj.jdbc.Driver");
		
				connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
				System.out.println("MySQL ist Verbunden");
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}
	
	public static void disconnect() {
		if(isConnected()) {
			try {
				connection.close();
				System.out.println("MySQL ist nicht mehr Verbunden");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void update (String qry) {
		try {
			PreparedStatement ps = connection.prepareStatement(qry);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

	/*public int registriereBenutzer(Benutzer benutzer) throws ClassNotFoundException {
        String BenutzerHinzufuegen = "INSERT INTO benutzer" +
            "  (id, nameNachname, email, passwort) VALUES " +
            " (?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement(Benutzerhinzufuegen)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, benutzer.getNameNachname());
            preparedStatement.setString(3, benutzer.getEmail());
            preparedStatement.setString(4, benutzer.getPasswort());

            System.out.println(preparedStatement);
      
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {

            printSQLException(e);
        }
        return result;*/
