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

public class ViewAvailableTripsController {
	static String selectedSource;
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
    void handleNextButton(ActionEvent event) {

    }
	void initialize(){
		
   }

}