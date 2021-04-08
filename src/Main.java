import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
  
    	String url = "jdbc:oracle:thin:system/oracle@localhost:49161:xe";
    	String user = "system";
    	String pass = "oracle";
    	Connection connexion = null;
    	try {
    		
    	    connexion = DriverManager.getConnection( url, user, pass );
    	    //Statement statement = connexion.createStatement();
    	    connexion.setAutoCommit(false);
    	    /* Requests to bdd will be here */
    	    //System.out.println("Bdd Connected");
    	    //displayDepartment(connexion);
    	    moveDepartment(connexion);
    	    //displayTable(connexion, "emp");
    	    connexion.commit();
    	    
    	    //statement.close();

    	} catch ( SQLException e ) {
    		e.printStackTrace();
    	} finally {
    	    if ( connexion != null )
    	        try {
    	            connexion.close();
    	        } catch ( SQLException ignore ) {
    	        	ignore.printStackTrace();
    	        }
    	}
    }
    
    
	public static void displayDepartment(Connection connexion) throws SQLException {
		Statement statement = connexion.createStatement();
		ResultSet resultat = statement.
				executeQuery( "SELECT deptno, dname, loc FROM dept" );
		
		while ( resultat.next() ) {
			int deptno = resultat.getInt( "deptno");
			String dname = resultat.getString( "dname" );
			String loc = resultat.getString( "loc" );
			
			System.out.println("Department " + deptno + " is for " 
					+ dname + " and located in " + loc);
		}
		resultat.close();
	}
	
	public static void moveDepartment(Connection connexion) throws SQLException {
		PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE emp SET deptno = ? WHERE empno = ?");
		
		Scanner sc = new Scanner(System.in);
		int empno = sc.nextInt();
		preparedStatement.setInt( 2, empno );
		int newDeptno = sc.nextInt();
		preparedStatement.setInt( 1, newDeptno );
		sc.close();

		ResultSet results = preparedStatement.executeQuery();
				
		System.out.println("Empno "+ empno+" has now been moved to " + newDeptno);

		results.close();
	}
	
	public static void displayTable(Connection connexion, String tableName) throws SQLException {
		Statement statement = connexion.createStatement();
		ResultSet resultat = statement.
				executeQuery( "SELECT * FROM "+ tableName);
		
		ResultSetMetaData metadata = resultat.getMetaData();
		int columnnumber = metadata.getColumnCount();
		String row = "\n";
		
		for(int i = 1; i <= columnnumber; i++) {
			System.out.print(metadata.getColumnName(i) + " | ");
		}
		
		while ( resultat.next() ) {
	        for(int i = 1; i <= columnnumber; i++){
	            row = row + resultat.getString(i) + " | ";
	        }
	        row = row + "\n";
		}
		System.out.println(row);
		
		resultat.close();
	}

	
}