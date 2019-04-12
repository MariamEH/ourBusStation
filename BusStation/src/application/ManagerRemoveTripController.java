package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

public class ManagerRemoveTripController {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/ourdatabase?allowMultiQueries=true";
	static final String USER = "root";
	static final String PASS = "Stay_Strong1";
	int i =1 ;
	@FXML
    private Text tripsText;

    @FXML
    private ComboBox<?> numBox;

    @FXML
    private Button backButton;

    @FXML
    private Button removeButton;

    @FXML
    private Text msgText;

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {

    	Parent home_page_parent =FXMLLoader.load(getClass().getResource("ManagerScreen.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage appStage =(Stage)(((Node) event.getSource()).getScene().getWindow());
        appStage.hide();
        appStage.setScene(home_page_scene);
        appStage.show();
    }

    @FXML
    void handleRemoveButton(ActionEvent event) {
    	see();
    }

    public void see() {
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
              String sql;
              int x;
             sql= "DELETE FROM inner_trips WHERE id= "+i;
              x=stmt.executeUpdate(sql);
       if(x>0)
    	   System.out.println("Succefully deleted element of id : "+i);
       else 
    	   System.out.println("There is no element of id : "+i);
       

    	    //STEP 6: Clean-up environment
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
