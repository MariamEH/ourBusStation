package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.*;

public  class StationController implements Initializable {

	String username;
	String password;
	boolean isPassenger = false;
	boolean isDriver = false;
	boolean isManager = false;
    @FXML
    private TextField usernameText;
    @FXML
    private Text mText;

    @FXML
    private TextField passwordText;

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

    @FXML
    void handlePassword(ActionEvent event) {
       password = passwordText.getText();
    }

    @FXML
    void handleusername( ActionEvent event) {
       username = usernameText.getText();
    }
    @FXML
    void handleLogin(ActionEvent event) throws IOException {
          Parent home_page_parent =FXMLLoader.load(getClass().getResource("PassengerScreen.fxml"));
          Scene home_page_scene = new Scene (home_page_parent);
          Stage appStage =(Stage)(((Node) event.getSource()).getScene().getWindow());
          appStage.hide();
          appStage.setScene(home_page_scene);
          appStage.show();
    }


	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {


	}

}
