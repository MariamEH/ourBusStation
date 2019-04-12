package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.*;

public  class StationController implements StationInterface {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/ourdatabase";
	static final String USER = "root";
	static final String PASS = "nevermindmh1890-";
	String sql;
    String username;
	String password;
	boolean isPassenger = false;
	boolean isDriver = false;
	boolean isManager = false;
	boolean found ;
	public String test ;
	DriverBasicInformationController info = new DriverBasicInformationController();
	DriverTripsController dtrip =new DriverTripsController();
	ViewAvailableTripsController pview = new ViewAvailableTripsController();
	PassnegerChooseEditTripController etrip = new PassnegerChooseEditTripController();
	
    @FXML
    private TextField usernameText;
    @FXML
    private Text mText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private RadioButton passengerButton;

    @FXML
    private RadioButton driverButton;

    @FXML
    private RadioButton managerButton;

    @FXML
    private Button loginButton;

    @FXML
    void handleDriver(ActionEvent event) {
       isPassenger = false;
       isDriver = true;
       isManager = false;
    }


    @FXML
    void handleManager(ActionEvent event) {
    	isPassenger = false;
        isDriver = false;
        isManager = true;
    }

    @FXML
    void handlePassenger(ActionEvent event) {
    	isPassenger = true;
        isDriver = false;
        isManager = false;
    }
    public boolean checkPassenger() {
    	if(isPassenger)
    		return true ;
    	return false ;
    }
    public boolean checkDriver() {
    	if(isDriver)
    		return true ;
    	return false ;
    }
    public boolean checkManager() {
    	if(isManager)
    		return true ;
    	return false ;
    }

    

    @FXML
    void handleLogin(ActionEvent event) throws IOException {
    	username = usernameText.getText();
        password = passwordText.getText();
       test=";hello";
        
         if(isPassenger==false && isDriver==false && isManager==false){
        	mText.setText("please choose a radio button!");
        }
        

        else {
    	  connect();
    	  if (found) {
    		  if(isPassenger){
    		  Parent home_page_parent =FXMLLoader.load(getClass().getResource("PassengerScreen.fxml"));
    	        Scene home_page_scene = new Scene (home_page_parent);
    	        Stage appStage =(Stage)(((Node) event.getSource()).getScene().getWindow());
    	        appStage.hide();
    	        appStage.setScene(home_page_scene);
    	        appStage.show();
    		  }
    		  else if(isDriver){
    			  Parent home_page_parent =FXMLLoader.load(getClass().getResource("DriverScreen.fxml"));
      	        Scene home_page_scene = new Scene (home_page_parent);
      	        Stage appStage =(Stage)(((Node) event.getSource()).getScene().getWindow());
      	        appStage.hide();
      	        appStage.setScene(home_page_scene);
      	        appStage.show();
      	        
      	      
    		  }
    		  else {
    			  Parent home_page_parent =FXMLLoader.load(getClass().getResource("ManagerScreen.fxml"));
      	        Scene home_page_scene = new Scene (home_page_parent);
      	        Stage appStage =(Stage)(((Node) event.getSource()).getScene().getWindow());
      	        appStage.hide();
      	        appStage.setScene(home_page_scene);
      	        appStage.show();
    		  }

    }
    	  
    	  else {
    		  mText.setText("Wrong Username or Password");
    	     
    		  
    	  }

    }
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
       if(checkPassenger())
           sql="SELECT * FROM riders";
       if(checkDriver())
     	  sql="SELECT * FROM drivers";
       if(checkManager())
     	  sql="SELECT * FROM managers";

        rs = stmt.executeQuery(sql);


	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         String first = rs.getString("name");
	         String last = rs.getString("password");

	         //Display values
	         if(first.equals(username)&&last.equals(password)){
	        	 found=true ;
	        	 if(checkDriver()) {
	        		 DriverBasicInformationController.setUsername(first);
                     DriverTripsController.setUsername(first);
	        	 }
	        	 else if(checkPassenger()) {
	        		 ViewAvailableTripsController.setUsername(first);
	        		 PassnegerChooseEditTripController.setUsername(first);
  
	         }
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


@Override
public void remove() {
	// TODO Auto-generated method stub
	
}

}