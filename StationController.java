package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class StationController {

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
    void handleusername(ActionEvent event) {
       username = usernameText.getText();
    }
    @FXML
    void handleLogin(ActionEvent event) {

    }
}
