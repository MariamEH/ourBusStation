package application;

import java.io.IOException;

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

public class ManagerAddTripController {
	@FXML
    private TextField tripIdText;

    @FXML
    private TextField sourceText;

    @FXML
    private TextField destinationText;

    @FXML
    private ChoiceBox<?> ticketBox;

    @FXML
    private ChoiceBox<?> tripBox;

    @FXML
    private ChoiceBox<?> vehicleBox;
    
    @FXML
    private Text msgText;


    @FXML
    private Button addButton;

    @FXML
    private Button backButton;
    
    @FXML
    private RadioButton externalButton;

    @FXML
    private RadioButton internalButton;
    
    @FXML
    void handleInternalButton(ActionEvent event) {

    }

    @FXML
    void handleexternalButton(ActionEvent event) {

    }


    @FXML
    void handleAddButton(ActionEvent event) {

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

}
