import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class DatabaseHelper {
	
	public static ArrayList<String> GetSavedSymbols()
	{
		ArrayList<String> savedSymbols = new ArrayList<String>();
		String query = String.format("SELECT SYMBOL FROM SavedStocks");
		
		Connection c = getDBConnection();
		
		try (Statement stmt  = c.createStatement();
	             ResultSet rs    = stmt.executeQuery(query)){
	            
	            // loop through the result set and collect all of our symbols
	            while (rs.next()) {
	            	savedSymbols.add(rs.getString("SYMBOL"));
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		
		return savedSymbols;
	}
	
	public static void addSymbol(String symbol)
	{
		Connection c = getDBConnection();
		String sql = "INSERT INTO SavedStocks(SYMBOL) VALUES(?)";
		 
        try (PreparedStatement pstmt = c.prepareStatement(sql)) {
            pstmt.setString(1, symbol);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public static Connection getDBConnection()
	{
		Connection c = null;
		try {
			
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:stockStuff.db");
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		return c;
	}

}