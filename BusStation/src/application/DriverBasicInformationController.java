package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class DriverBasicInformationController {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/ourdatabase";
	static final String USER = "root";
	static final String PASS = "Stay_Strong1";
    static String username ;

	public static String getUsername() {
		return username;
	}


	public static void setUsername(String username) {
		DriverBasicInformationController.username = username;
	}


	@FXML
    private Text nameText;

    @FXML
    private Text ageText;

    @FXML
    private Text vehicleText;

    @FXML
    private Button backButton;

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {

    	Parent home_page_parent =FXMLLoader.load(getClass().getResource("DriverScreen.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage appStage =(Stage)(((Node) event.getSource()).getScene().getWindow());
        appStage.hide();
        appStage.setScene(home_page_scene);
        appStage.show();
    }


    @FXML
    void initialize(){
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
        String sql ;
            sql="SELECT * FROM drivers";
         rs = stmt.executeQuery(sql);
         username=getUsername();
         System.out.println("name :"+username);
 	      //STEP 5: Extract data from result set
 	      while(rs.next()){
 	         //Retrieve by column name
 	         String name = rs.getString("name");
 	         String age =rs.getString("Age");
 	         String vehichle =rs.getString("Vehichle");

 	         //Display values
 	         if(name.equals(getUsername())){
 	        	nameText.setText(name);
 	        	ageText.setText(age);
 	        	vehicleText.setText(vehichle);
 	        	
 	         }
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
