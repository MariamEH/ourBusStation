package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class ManagerAssignController implements StationInterface{

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/ourdatabase";
	static final String USER = "root";
	static final String PASS = "nevermindmh1890-";
	String driver ;

	ObservableList<String> tripBoxlist = FXCollections.observableArrayList();
	ObservableList<String> driverBoxlist = FXCollections.observableArrayList();
	String selectedTrip;
	String selectedDriver;
	int tripid ;
	int x;
	@FXML
    void initialize(){

		connect();
    	tripBox.setItems(tripBoxlist);
    	tripBox.setMaxHeight(30);
    	driverBox.setItems(driverBoxlist);
    	driverBox.setMaxHeight(30);

    }
	@FXML
    private ComboBox<String> tripBox;

    @FXML
    private ComboBox<String> driverBox;

    @FXML
    private Button backButton;

    @FXML
    private Button assignButton;

    @FXML
    private Text msgText;

    @FXML
    void handleAssignButton(ActionEvent event) {
    	remove();
    }

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {

    	Parent home_page_parent =FXMLLoader.load(getClass().getResource("ManagerScreen.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage appStage =(Stage)(((Node) event.getSource()).getScene().getWindow());
        appStage.hide();
        appStage.setScene(home_page_scene);
        appStage.show();
    }
    public void connect() {
    	Connection conn = null;
    	   Statement stmt = null;
    	   try{
    	       Class.forName("com.mysql.cj.jdbc.Driver");
    	      //STEP 3: Open a connection
    	      System.out.println("Connecting to database...");
    	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
    	      //STEP 4: Execute a query
    	      System.out.println("Creating statement...");
    	      stmt = conn.createStatement();
              ResultSet rs;
              String sql;
         	  sql="SELECT * FROM internaltrips";
              rs = stmt.executeQuery(sql);
    	      //STEP 5: Extract data from result set
    	      while(rs.next()){
    	         //Retrieve by column name
    	         tripBoxlist.add(rs.getString("id"));
    	      }
         	  sql="SELECT * FROM externaltrips";
               rs = stmt.executeQuery(sql);
    	      //STEP 5: Extract data from result set
    	      while(rs.next()){
    	         //Retrieve by column name
    	         tripBoxlist.add(rs.getString("id"));
    	      }
              sql="SELECT * FROM drivers";
               rs = stmt.executeQuery(sql);
   	      //STEP 5: Extract data from result set
   	      while(rs.next()){
   	         //Retrieve by column name
   	    	  driverBoxlist.add(rs.getString("name"));
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
    public void remove() {
    	Connection conn = null;
 	   Statement stmt = null;
 	   try{

 	       Class.forName("com.mysql.cj.jdbc.Driver");

 	      //STEP 3: Open a connection
 	      System.out.println("Connecting to database...");

 	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
 	      //STEP 4: Execute a query
 	      System.out.println("Creating statement...");
 	      stmt = conn.createStatement();
 	     ResultSet rs;
        
     	selectedTrip = tripBox.getSelectionModel().getSelectedItem();
     	selectedDriver = driverBox.getSelectionModel().getSelectedItem();
     	tripid=Integer.parseInt(selectedTrip);
        String sql ;
        sql ="SELECT * FROM externaltrips";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
	         //Retrieve by column name
	    	 int id=rs.getInt("id");
	         String drivername =rs.getString("driver");
	         if(id==tripid)
	        	 driver=drivername;
	         }
        sql ="SELECT * FROM internaltrips";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
	         //Retrieve by column name
	    	 int id=rs.getInt("id");
	         String drivername =rs.getString("driver");
	         if(id==tripid)
	        	 driver=drivername;
	         }
        sql =  "UPDATE outer_trips set driver = '" + selectedDriver +  "' WHERE id = '" +tripid+ "' AND driver = '" + driver + "'"; 
         x = stmt.executeUpdate(sql);
         sql = "UPDATE inner_trips set driver = '" + selectedDriver +  "' WHERE id = '" +tripid+ "' AND driver = '" + driver + "'";  
         x= stmt.executeUpdate(sql);
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