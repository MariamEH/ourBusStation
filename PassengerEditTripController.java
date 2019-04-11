package application;

import java.io.IOException;

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

public class PassengerEditTripController {

	 @FXML
	    private Text tripsText;

	  @FXML
	    private ComboBox<?> numBox;


	    @FXML
	    private Button nextButton;

	    @FXML
	    private Button backButton;

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
	    void handleNextButton(ActionEvent event) throws IOException {

	    	 Parent home_page_parent =FXMLLoader.load(getClass().getResource("PassengerCreateTrip.fxml"));
   	        Scene home_page_scene = new Scene (home_page_parent);
   	        Stage appStage =(Stage)(((Node) event.getSource()).getScene().getWindow());
   	        appStage.hide();
   	        appStage.setScene(home_page_scene);
   	        appStage.show();
	    }
}
