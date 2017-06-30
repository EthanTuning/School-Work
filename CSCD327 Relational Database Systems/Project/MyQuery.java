/*****************************
Query the Crime Database
*****************************/
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.CallableStatement;
import java.util.Date;
import java.lang.String;

public class MyQuery {

    private Connection conn = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
    
    public MyQuery(Connection c)throws SQLException
    {
        conn = c;
        statement = conn.createStatement();
    }
    
	//Query 0: this is a sample query provided by Dr. Li
	public void findChargeDate() throws SQLException
    {
        String query  = "SELECT crime_id, date_charged " +
                            "FROM crimes " + 
                            "WHERE date_charged <= \'2008-10-22\';";

        resultSet = statement.executeQuery(query);
    }
    
    public void printChargeDate() throws IOException, SQLException
    {
		System.out.println("******** Query 0 ********");
		System.out.println("Crime_ID\t"+"Charge_Date");

        while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getString(2);
			int crime_id = resultSet.getInt(1);
			Date charge_date = resultSet.getDate("date_charged");
			System.out.println(crime_id+"\t\t"+charge_date);
		}        
    }

	 //Query 1
    public void findBestOfficer() throws SQLException
    {
    	String query =  "SELECT first, last, COUNT(first) AS cnt " +
    					"FROM officers o1 JOIN crime_officers o2 ON(o1.officer_id = o2.officer_id) " +
    					"GROUP BY o1.officer_id " +
    					"HAVING COUNT(*) = (SELECT COUNT(*) FROM crime_officers GROUP BY officer_id ORDER BY 1 DESC LIMIT 1);";
    	resultSet = statement.executeQuery(query);
    	
	}
    
    public void printBestOfficer() throws IOException, SQLException
    {
		System.out.println("******** Query 1 ********");
		System.out.println("First\t\t"+"Last\t\t"+"Count");
		
		while(resultSet.next()){
			String first = resultSet.getString("first");
			String last = resultSet.getString("last");
			int count = resultSet.getInt("cnt");
			System.out.println(first+"\t\t"+last+"\t\t"+count);
		}
	}


	 //Query 2
    public void findCrimeCharge() throws SQLException
    {
    	String query = "SELECT charge_id " +
    				   "FROM crime_charges " +
    				   "WHERE fine_amount > (SELECT AVG(fine_amount) FROM crime_charges) AND amount_paid < (SELECT AVG(amount_paid) FROM crime_charges);";
    	resultSet = statement.executeQuery(query);
    }

    public void printCrimeCharge() throws IOException, SQLException
    {
		System.out.println("******** Query 2 ********");
		System.out.println("Charge ID");
		
		while(resultSet.next()){
			int charge_id = resultSet.getInt("charge_id");
			System.out.println(charge_id);
		}
    }


	 //Query 3
    public void findCriminal() throws SQLException
    {
    	String query = "SELECT DISTINCT first, last " +
    			       "FROM crimes NATURAL JOIN crime_charges NATURAL JOIN criminals " +
    			       "WHERE crime_code IN (SELECT crime_code FROM crimes NATURAL JOIN crime_charges WHERE crime_id = '10089');";
    	resultSet = statement.executeQuery(query);
    }

    public void printCriminal() throws IOException, SQLException
    {
		System.out.println("******** Query 3 ********");
		System.out.println("First\t\tLast");

		while(resultSet.next()){
			String first = resultSet.getString("first");
			String last = resultSet.getString("last");
			System.out.println(first+"\t\t"+last);
		}
    }


	 //Query 4
    public void findCriminalSentence() throws SQLException
    {
    	String query = "SELECT criminal_id, first, last, COUNT(sentence_id) AS sentence_count " +
    				   "FROM criminals NATURAL JOIN sentences " +
    				   "GROUP BY criminal_id " +
    				   "HAVING COUNT(sentence_id) > 1;";
    	resultSet = statement.executeQuery(query);
    }

    public void printCriminalSentence() throws IOException, SQLException
    {
		System.out.println("******** Query 4 ********");
		System.out.println("Criminal_ID\tFirst\t\tLast\t\tSentence Count");
		
		while(resultSet.next()){
			int id = resultSet.getInt("criminal_id");
			String first = resultSet.getString("first");
			String last = resultSet.getString("last");
			int cnt = resultSet.getInt("sentence_count");
			System.out.println(id+"\t\t"+first+"\t\t"+last+"\t\t"+cnt);
		}
    }


	 //Query 5
    public void findChargeCount() throws SQLException
    {
    	String query = "SELECT precinct, COUNT(charge_id) AS count " +
    				   "FROM crime_charges NATURAL JOIN crime_officers NATURAL JOIN officers " +
    			       "WHERE charge_status='GL' " +
    				   "GROUP BY precinct " +
    			       "HAVING COUNT(charge_id) >= 7;";
    	resultSet = statement.executeQuery(query);
    }

    public void printChargeCount() throws IOException, SQLException
    {
		System.out.println("******** Query 5 ********");
		System.out.println("Precinct\tCharge Count");
		
		while(resultSet.next()){
			String precinct = resultSet.getString("precinct");
			int cnt = resultSet.getInt("count");
			System.out.println(precinct+"\t\t"+cnt);
		}
    }
	 
	 
	 //Query 6
	public void findEarliestLatest() throws SQLException
    {
		String query = "SELECT criminal_id, first, last, MIN(start_date) AS earliest_start_date, MAX(end_date) AS latest_end_date " +
					   "FROM sentences NATURAL JOIN criminals " +
					   "GROUP BY criminal_id " +
					   "HAVING MIN(start_date) AND MAX(end_date);";
		resultSet = statement.executeQuery(query);
    }

    public void printEarliestLatest() throws IOException, SQLException
    {
		System.out.println("******** Query 6 ********");
		System.out.println("Criminal ID\tFirst\tLast\t\tEarliest Start Date\tLatest End Date");
		
		while(resultSet.next()){
			int id = resultSet.getInt("criminal_id");
			String first = resultSet.getString("first");
			String last = resultSet.getString("last");
			Date start = resultSet.getDate("earliest_start_date");
			Date end = resultSet.getDate("latest_end_date");
			System.out.println(id+"\t\t"+first+"\t"+last+"\t\t"+start+"\t\t"+end);
		}
    }
	

	 //Query 7
    public void findCrimeCounts() throws SQLException
    {
		System.out.println("******** Query 7 ********");	
		InputStreamReader istream = new InputStreamReader(System.in) ;
		BufferedReader bufRead = new BufferedReader(istream) ;
		
		try{
            System.out.print("Please enter the officer_id for the query: ");
			int id = Integer.parseInt(bufRead.readLine());
			CallableStatement cStmt = conn.prepareCall("{CALL getNumber(?,?)}");
			cStmt.setInt(1, id);
			cStmt.registerOutParameter(2, java.sql.Types.INTEGER);
			cStmt.execute();
			int cnt = cStmt.getInt(2);
            System.out.println("Officer " +id+" has reported "+cnt+" crimes.");
	   }			
		catch (IOException err) {
            System.out.println("Error reading line");
           }
    }
}
