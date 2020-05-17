/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BO.Customer;
import DA.CustomerDA;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author snehk_000
 */
public class AddLogicInController implements Initializable {

    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXTextField txtPassword;
    @FXML
    private JFXButton LOGIN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Login(ActionEvent event) {
        Customer customer =CustomerDA.getLogin(txtUsername.getText(),txtPassword.getText());
        if(customer == null) {
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Invalid Condentions");
            alert.showAndWait();
        }
        else {
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Login Successfully");
            alert.showAndWait();
            visuals.VISUALS.customer = customer;
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/UI/AddDashboard.fxml"));
                Scene scene = new Scene(root);
                Stage stage=new Stage();
                stage.setScene(scene);
                stage.show();
                } 
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
}
