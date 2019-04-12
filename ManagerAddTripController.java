package application;

import java.io.IOException;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ManagerAddTripController implements StationInterface {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/ourdatabase";
	static final String USER = "root";
	static final String PASS = "nevermindmh1890-";
	ObservableList<String> tripBoxlist = FXCollections.observableArrayList("nonstop","one-stop","many stops");
	ObservableList<String> ticketBoxlist = FXCollections.observableArrayList("one way","round");
	ObservableList<String> vehicleBoxlist = FXCollections.observableArrayList("bus","train","plane","ship","car");
	String selectedTicket;
	String selectedTrip;
	String selectedVehicle;
	String id;
	String source;
	String destination;



	 
	@FXML
    private TextField tripIdText;

    @FXML
    private TextField sourceText;

    @FXML
    private TextField destinationText;

    @FXML
    private ChoiceBox<String> ticketBox;

    @FXML
    private ChoiceBox<String> tripBox;

    @FXML
    private ChoiceBox<String> vehicleBox;

    @FXML
    private Text msgText;


    @FXML
    private Button addButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField priceText;

    @FXML
    private RadioButton externalButton;

    @FXML
    private RadioButton internalButton;
    boolean isExternal = false;
    boolean isInternal = false;
    @FXML
    void handleInternalButton(ActionEvent event) {

    	isExternal=false;
    	isInternal=true;
    }

    @FXML
    void handleexternalButton(ActionEvent event) {

    	isExternal=true;
    	isInternal=false;
    }
    @FXML
    void initialize(){
    	tripBox.setItems(tripBoxlist);
    	ticketBox.setItems(ticketBoxlist);
    	vehicleBox.setItems(vehicleBoxlist);


    }


    @FXML
    void handleAddButton(ActionEvent event) {
    	selectedVehicle = vehicleBox.getSelectionModel().getSelectedItem();
    	selectedTicket = ticketBox.getSelectionModel().getSelectedItem();
    	selectedTrip = tripBox.getSelectionModel().getSelectedItem();
    	id = tripIdText.getText();
    	source =sourceText.getText();
    	destination =destinationText.getText();
    	connect();


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
           String query = "insert into externaltrips(id,source,destination,ticket,trip,vehicle,price)values(?,?,?,?,?,?,?)";
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setString(1,tripIdText.getText());
           ps.setString(2,sourceText.getText());
           ps.setString(3,destinationText.getText());
           ps.setString(4,ticketBox.getSelectionModel().getSelectedItem());
           ps.setString(5, tripBox.getSelectionModel().getSelectedItem());
           ps.setString(6,vehicleBox.getSelectionModel().getSelectedItem());
           ps.setString(7,priceText.getText());
           ps.execute();
           stmt.executeUpdate(query);
           System.out.println("done successfuly");
           msgText.setText("Done adding ");

    	    //STEP 6: Clean-up environment

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
