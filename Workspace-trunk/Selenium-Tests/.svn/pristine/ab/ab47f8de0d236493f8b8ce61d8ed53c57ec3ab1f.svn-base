package uk.co.ratedpeople.test.functional.selenium.requestCallBackAndRating;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TMDataBaseHelper {
	//public static final String JDBC_DRIVER_URL = "jdbc:mysql://paris:3306/rated_people" ;
	public static final String JDBC_DRIVER_URL = "jdbc:mysql://db.preprod:3306/rated_people";
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_USER_NAME = "ratedpeople";  
	public static final String DB_PWD = "ratedpeople";
	/*public static final  String DELETE_RAL_MESSAGEBOX_TPWEB = "delete from tm_accepted_message where user_id = 392724";
	public static final  String DELETE_RAL_MESSAGEBOX_TMMOBILE = "delete from tm_accepted_message where user_id = 374316";*/
		
public static boolean executeQuery(String query) {

	try {
		Connection con = DriverManager.getConnection(JDBC_DRIVER_URL, DB_USER_NAME, DB_PWD);
		Statement stat = con.createStatement();
		stat.execute(query);
		stat.close();
		}catch (Exception e) {
			System.err.println("e.getMessage()" + e);
			return false;
			}
		return true;   
	}
}
