package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ManagerController {

	@FXML
    private Button viewTripsButton;

    @FXML
    private Button addTripsButton;

    @FXML
    private Button removeTripsButton;

    @FXML
    private Button assignButton;

    @FXML
    private Button logoutButton;
    
    @FXML
    void handleAddTrips(ActionEvent event) throws IOException {
    	Parent home_page_parent =FXMLLoader.load(getClass().getResource("ManagerAddTrip.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage appStage =(Stage)(((Node) event.getSource()).getScene().getWindow());
        appStage.hide();
        appStage.setScene(home_page_scene);
        appStage.show();

    }

    @FXML
    void handleAssignButton(ActionEvent event) throws IOException {
    	Parent home_page_parent =FXMLLoader.load(getClass().getResource("ManagerAssign.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage appStage =(Stage)(((Node) event.getSource()).getScene().getWindow());
        appStage.hide();
        appStage.setScene(home_page_scene);
        appStage.show();

    }

    @FXML
    void handleRemoveTrips(ActionEvent event) throws IOException {
    	Parent home_page_parent =FXMLLoader.load(getClass().getResource("ManagerRemoveTrip.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage appStage =(Stage)(((Node) event.getSource()).getScene().getWindow());
        appStage.hide();
        appStage.setScene(home_page_scene);
        appStage.show();
    }

    @FXML
    void handleViewTrips(ActionEvent event) throws IOException {

    	Parent home_page_parent =FXMLLoader.load(getClass().getResource("ManagerViewTrips.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage appStage =(Stage)(((Node) event.getSource()).getScene().getWindow());
        appStage.hide();
        appStage.setScene(home_page_scene);
        appStage.show();
    }
    @FXML
    void handleLogoutButton(ActionEvent event) throws IOException {

    	Parent home_page_parent =FXMLLoader.load(getClass().getResource("BusStation.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage appStage =(Stage)(((Node) event.getSource()).getScene().getWindow());
        appStage.hide();
        appStage.setScene(home_page_scene);
        appStage.show();
    }
}