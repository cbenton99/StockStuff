import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.IOException;

public class syncStocks {
	
	public static void start(String args[]) {

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
			
			System.out.println("Opened git puldatabase successfully, starting sync.");

			syncData(c); // sync that data!

		} else {
			System.out.print("The db doesn't exist. Run the database setup script first.");
		}
	}

	private static void syncData(Connection c) {
		
		pullStockData(); //start by making sure we are up to date
		
		//get list of saved symbols
		
		//loop through each symbol and check for latest entry
		
		//try to unpackDay() and addDayToDB() for every day since latest entry in db
		
		//done!

	}
	
	private static void unpackDay() {

	}
	
	private static void addDayToDB() {
		
	}
	
	private static void pullStockData() {
		//execute the git submodule update command to get the latest from pystockdata
		String cmd = "git submodule update --recursive --remote";
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
