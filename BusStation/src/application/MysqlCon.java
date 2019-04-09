package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlCon {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/ourdatabase";
	static final String USER = "root";
	   static final String PASS = "Stay_Strong1";
	public static void main(String[] args) {
		   Connection conn = null;
		   Statement stmt = null;
		   try{
			   
		       Class.forName("com.mysql.cj.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      StationController station = new StationController();

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
              String sql="";
              ResultSet rs;
              if(station.isPassenger) 
                  sql="SELECT * FROM riders";
              if(station.isDriver)
            	  sql="SELECT * FROM drivers";
              if(station.isManager)
            	  sql="SELECT * FROM managers";
               rs = stmt.executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         String first = rs.getString("name");
		         String last = rs.getString("password");

		         //Display values
		         System.out.print("id: " + id);
		         System.out.print(", name: " + first);
		         System.out.println(", password: " + last);
		      }
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources 
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}//end main
		//end FirstExample
}