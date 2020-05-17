/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author snehk_000
 */
public class AddDashboardController implements Initializable {

    @FXML
    private JFXButton btnAddCustomer;
    @FXML
    private JFXButton btnAddProduct;
    @FXML
    private JFXButton btnAddOrder;
    @FXML
    private JFXButton btnAddQuantity;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void customerClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/UI/AddCustomer.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void productClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/UI/AddProduct.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void orderClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/UI/AddOrder.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void quantityClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/UI/AddQuantity.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void buy(ActionEvent event) {
    try {
            Parent root = FXMLLoader.load(getClass().getResource("/UI/Buy.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

}
