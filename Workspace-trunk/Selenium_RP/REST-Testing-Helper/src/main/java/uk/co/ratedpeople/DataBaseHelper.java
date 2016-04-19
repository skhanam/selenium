package uk.co.ratedpeople;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseHelper {

	/**
	 * Use this method if you need to prepare data for testing. Remove, add, update only. If you want display data from database for testing don't do that ...
	 * you are lazy boy ;-).
	 * 
	 * @param query
	 *            as string
	 */
	private static final Logger LOGGER = Logger.getLogger(DataBaseHelper.class.getName());

	public static boolean executeQuery(String query) {
		try {
			Statement stat = getStatement();
			stat.execute(query);
			stat.close();
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, "DataBaseHelper", e);
			return false;
		}

		return true;
	}
	
	/**
	 * Use this method if you want to display a column from a query from the database for testing
	 * 
	 * @param query
	 *            as string
	 */
	public static String executeSelectQuery(String query) {
		String resultString=null;
		
		try {
			Statement stat = getStatement();
			ResultSet resultset = stat.executeQuery(query);
			while (resultset.next()) {
				resultString = resultset.getString(1); 
		    }
			
			stat.close();
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, "DataBaseHelper", e);
			return null;
		}

		return resultString;
	}
			
	private static Statement getStatement() throws Exception{
		return getConnection().createStatement();
	}
	
	private static Connection getConnection() throws Exception{
		Environment environment = Environment.getSystemEnvironmentWithDefault();
		String tokenDb = environment.getProperty("functional.test.host");
		if(tokenDb == null || tokenDb.isEmpty()) {
			tokenDb = "localhost";
		} else if(tokenDb.indexOf(".uk.ratedpeople") != -1) {
			tokenDb = tokenDb.split("\\.")[0];
		}
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + tokenDb + ":3306/rated_people", "ratedpeople", "ratedpeople");
		return conn;
	}
}
