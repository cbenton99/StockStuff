import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class syncStocks {
	public static void main(String args[]) {

		File file = new File("stockStuff.db");
		Connection c = null;
		// check if the db exists before we try to sync
		if (file.exists()) {
			try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:stockStuff.db");
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
			System.out.println("Opened database successfully, starting sync.");

			syncData(c); // sync that data!

		} else {
			System.out.print("The db doesn't exist. Run the database setup script first.");
		}

	}

	private static void syncData(Connection c) {

	}
	
	private static void unpackDay() {

	}
	
	private static void gitPull() {

	}
}
