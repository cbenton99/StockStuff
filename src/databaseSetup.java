
/////////////////////////////////////////
//Database setup script
//Run this class to create the database
//and populate it with csv files
////////////////////////////////////////
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class databaseSetup {
	public static void main(String args[]) {
		// create or connect to the db
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:stockStuff.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");

		// add our tables, StockData and
		Statement stmt = null;
		String sql = null;
		try {
			Class.forName("org.sqlite.JDBC");

			// StockData table
			stmt = c.createStatement();
			sql = "CREATE TABLE StockData " + "(ID INTEGER PRIMARY KEY 	 AUTOINCREMENT,"
					+ " SYMBOL         TEXT    NOT NULL, " + " DATE           TEXT    NOT NULL, "
					+ " OPEN           REAL    NOT NULL, " + " HIGH           REAL    NOT NULL, "
					+ " LOW            REAL    NOT NULL, " + " CLOSE          REAL    NOT NULL, "
					+ " VOLUME         REAL    NOT NULL, " + " ADJ_CLOSE      REAL    NOT NULL) ";
			stmt.executeUpdate(sql);
			stmt.close();

			// MainApp table
			stmt = c.createStatement();
			sql = "CREATE TABLE MainTable " + "(ID INT PRIMARY KEY     NOT NULL,"
					+ " LASTSYNC          TEXT    NOT NULL, " + " DATABASEVERSION   TEXT    NOT NULL, ";
			stmt.executeUpdate(sql);
			stmt.close();

			// SavedStocks table
			stmt = c.createStatement();
			sql = "CREATE TABLE SavedStocks " + "(ID INT PRIMARY KEY     NOT NULL,"
					+ " SYMBOL          TEXT    NOT NULL, ";
			stmt.executeUpdate(sql);
			stmt.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
}
