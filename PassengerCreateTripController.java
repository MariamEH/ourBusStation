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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PassengerCreateTripController implements StationInterface {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/ourdatabase";
	static final String USER = "root";
	static final String PASS = "nevermindmh1890-";
	String sql;
	ViewAvailableTripsController pview = new ViewAvailableTripsController();
	ObservableList<String> tripBoxlist = FXCollections.observableArrayList("nonstop","one-stop","many stops");
	ObservableList<String> ticketBoxlist = FXCollections.observableArrayList("one way","round");
	ObservableList<String> vehicleBoxlist = FXCollections.observableArrayList("bus","train","plane","ship","car");
	ObservableList<String> sourceBoxlist = FXCollections.observableArrayList();
	ObservableList<String> destinationBoxlist = FXCollections.observableArrayList();

	boolean external= false;
	boolean internal= false;

	@FXML
    private TextField numTicketText;

	@FXML
    private Button externalButton;

    @FXML
    private Button internalButton;

    @FXML
    private ComboBox<String> sourceBox;

    @FXML
    private ComboBox<String> destinationBox;


    @FXML
    private ChoiceBox<String> ticketBox;


    @FXML
    private ChoiceBox<String> vehicleBox;

    @FXML
    private ChoiceBox<String> tripBox;

    @FXML
    private Button nextButton;

    @FXML
    private Button backButton;

    @FXML
    void initialize(){
    	tripBox.setItems(tripBoxlist);
    	ticketBox.setItems(ticketBoxlist);
    	vehicleBox.setItems(vehicleBoxlist);
    	sourceBox.setItems(sourceBoxlist);
    	sourceBox.setMaxHeight(30);
    	destinationBox.setItems(destinationBoxlist);
    	destinationBox.setMaxHeight(30);

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

    @FXML
    void handleExternalButton(ActionEvent event) {
    	sourceBoxlist.removeAll(sourceBoxlist);
    	destinationBoxlist.removeAll(destinationBoxlist);
    	external = true;
    	internal = false;
    	ViewAvailableTripsController.setExternal(external);
    	ViewAvailableTripsController.setInternal(internal);
    	connect();
    }

    @FXML
    void handleInternalButton(ActionEvent event) {

    	sourceBoxlist.removeAll(sourceBoxlist);
    	destinationBoxlist.removeAll(destinationBoxlist);
    	external = false;
    	internal = true;
    	ViewAvailableTripsController.setExternal(external);
    	ViewAvailableTripsController.setInternal(internal);
    	connect();
    }

    @FXML
    void handleNextButton(ActionEvent event) throws IOException {

    	Parent home_page_parent =FXMLLoader.load(getClass().getResource("ViewAvailableTrips.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage appStage =(Stage)(((Node) event.getSource()).getScene().getWindow());
        appStage.hide();
        appStage.setScene(home_page_scene);
        appStage.show();
        ViewAvailableTripsController.setSelectedSource(sourceBox.getSelectionModel().getSelectedItem());
    	ViewAvailableTripsController.setSelectedDestination(destinationBox.getSelectionModel().getSelectedItem());
    	ViewAvailableTripsController.setSelectedVehicle(vehicleBox.getSelectionModel().getSelectedItem());
    	ViewAvailableTripsController.setSelectedTicket(ticketBox.getSelectionModel().getSelectedItem());
    	ViewAvailableTripsController.setSelectedTrip(tripBox.getSelectionModel().getSelectedItem());
        System.out.println(ViewAvailableTripsController.selectedSource + ViewAvailableTripsController.selectedTrip );
        System.out.println(ViewAvailableTripsController.selectedDestination + ViewAvailableTripsController.selectedTicket );
        System.out.println(ViewAvailableTripsController.selectedVehicle);
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

           if(external)
               sql="SELECT * FROM externaltrips";
           if(internal)
         	  sql="SELECT * FROM internaltrips";

            rs = stmt.executeQuery(sql);


    	      //STEP 5: Extract data from result set
    	      while(rs.next()){
    	         //Retrieve by column name

    	         sourceBoxlist.add(rs.getString("source"));
    	         destinationBoxlist.add(rs.getString("destination"));

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