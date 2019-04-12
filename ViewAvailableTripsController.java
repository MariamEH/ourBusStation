package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewAvailableTripsController implements StationInterface{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/ourdatabase";
	static final String USER = "root";
	static final String PASS = "nevermindmh1890-";
	static String selectedSource;
	String sql ;
    private String text=" ";
	ObservableList<String> tripsBoxlist = FXCollections.observableArrayList();
    static String price ;
    static String driver ;
    static int tripid;

    @FXML
    private Text msgText;

    @FXML
    private Button viewButton;

	public static String getSelectedSource() {
		return selectedSource;
	}

	public static void setSelectedSource(String selectedSource) {
		ViewAvailableTripsController.selectedSource = selectedSource;
	}
	static String selectedDestination;

	public static String getSelectedDestination() {
		return selectedDestination;
	}

	public static void setSelectedDestination(String selectedDestination) {
		ViewAvailableTripsController.selectedDestination = selectedDestination;
	}
	static String selectedTicket;

	public static String getSelectedTicket() {
		return selectedTicket;
	}

	public static void setSelectedTicket(String selectedTicket) {
		ViewAvailableTripsController.selectedTicket = selectedTicket;
	}
	static String selectedTrip;

	public static String getSelectedTrip() {
		return selectedTrip;
	}

	public static void setSelectedTrip(String selectedTrip) {
		ViewAvailableTripsController.selectedTrip = selectedTrip;
	}
	static String selectedVehicle;

	public static String getSelectedVehicle() {
		return selectedVehicle;
	}

	public static void setSelectedVehicle(String selectedVehicle) {
		ViewAvailableTripsController.selectedVehicle = selectedVehicle;
	}
	static String username ;

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		ViewAvailableTripsController.username = username;
	}
	static boolean external ;
	static boolean internal ;


	public static boolean isExternal() {
		return external;
	}

	public static void setExternal(boolean external) {
		ViewAvailableTripsController.external = external;
	}

	public static boolean isInternal() {
		return internal;
	}

	public static void setInternal(boolean internal) {
		ViewAvailableTripsController.internal = internal;
	}
	boolean avaTrips = false;
	@FXML
    private Text tripsText;

	 @FXML
	    private ComboBox<String> numBox;

	 String selectednum;

    @FXML
    private Button nextButton;

    @FXML
    private Button backButton;
    @FXML
    void handleviewButton(ActionEvent event) {

    	connect();
    	tripsText.setText(text);
    	numBox.setItems(tripsBoxlist);
    	numBox.setMaxHeight(30);
    	if(!avaTrips)
    		tripsText.setText("No available trips");
    }



    @FXML
    void handleBackButton(ActionEvent event) throws IOException {

    	Parent home_page_parent =FXMLLoader.load(getClass().getResource("PassengerScreen.fxml"));
	        Scene home_page_scene = new Scene (home_page_parent);
	        Stage appStage =(Stage)(((Node) event.getSource()).getScene().getWindow());
	        appStage.hide();
	        appStage.setScene(home_page_scene);
	        appStage.show();
    }

    boolean next = false;
    @FXML
    void handleNextButton(ActionEvent event) {
	selectednum=numBox.getSelectionModel().getSelectedItem();
    }
    boolean connection = false;



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
	           if(isInternal())
	               sql="SELECT * FROM internaltrips";
	           else if(isExternal())
	        	   sql="SELECT * FROM externaltrips";
	               rs = stmt.executeQuery(sql);
	    	      //STEP 5: Extract data from result set
	    	      while(rs.next()){
	    	         //Retrieve by column name
	    	    	  int id=rs.getInt("id");
	    	         String source = rs.getString("source");
	    	         String dest =rs.getString("destination");
	    	         String ticket =rs.getString("ticket");
	    	         String trip =rs.getString("trip");
	    	         String veh =rs.getString("vehicle");
	    	         String priceval =rs.getString("price");
	    	         String drivername =rs.getString("driver");
	    	         if(source.equals(getSelectedSource())&&dest.equals(getSelectedDestination())&&veh.equals(getSelectedVehicle())&&trip.equals(getSelectedTrip())&&ticket.equals(getSelectedTicket())) {
	    	        	 price=priceval;
	    	        	 driver=drivername;
	    	        	 tripid=id;
	    	        	 text=text+id+"-"+source+"-"+dest+"-"+ticket+"-"+trip+"-"+veh+"-"+price+"-"+driver+"\n";
	        	         tripsBoxlist.add(rs.getString("id"));
	    	        	 avaTrips = true;
	    	         }
	    	         }
	    	      sql="insert into passengertrips values("+tripid+"', '"+getUsername()+"', '"+getSelectedSource()+"', '"+getSelectedDestination()+"', '"+getSelectedTicket()+"', '"+getSelectedTrip()+"', '"+price+"', '"+driver+ ")";
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