/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BO.Order;
import DA.OdrDA;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author snehk_000
 */
public class AddOrderController implements Initializable {

    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXRadioButton rbAdd;
    @FXML
    private JFXRadioButton rbUpdateDelete;
    @FXML
    private JFXTextField txtDateoforder;
    @FXML
    private JFXTextField txtDateofdelievery;
    @FXML
    private JFXTextField txtProductId;
    @FXML
    private JFXTextField txtQuantity;
    @FXML
    private JFXTextField txtAmount;
    @FXML
    private JFXTextField txtCustomerId;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnUpdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ToggleGroup tg = new ToggleGroup();
        rbAdd.setToggleGroup(tg);
        rbUpdateDelete.setToggleGroup(tg);
        
        rbAdd.setSelected(true);
        addFunctionality();
        
        
    }   
    public void addFunctionality()
    {
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        txtId.setDisable(true);
        btnAdd.setDisable(false);
    }
    public void updateDeleteFunctionality()
    {
        btnUpdate.setDisable(false); 
        btnDelete.setDisable(false);
        txtId.setDisable(false);
        btnAdd.setDisable(true);
    }    

    @FXML
    private void addOrder(ActionEvent event) {
        Order order = new Order();
        
        order.setAmount(Integer.parseInt(txtAmount.getText()));
        order.setC_id(Integer.parseInt(txtCustomerId.getText()));
        order.setP_id(Integer.parseInt(txtProductId.getText()));
        order.setQuantity(Integer.parseInt(txtQuantity.getText()));
        OdrDA.add(order);
    }

    @FXML
    private void deleteOrder(ActionEvent event) {
        OdrDA.delete(Integer.parseInt(txtId.getText()));
    }

    @FXML
    private void updateOrder(ActionEvent event) {
        Order order = new Order();
        order.setId(Integer.parseInt(txtId.getText()));
        order.setAmount(Integer.parseInt(txtAmount.getText()));
        order.setC_id(Integer.parseInt(txtCustomerId.getText()));
        order.setP_id(Integer.parseInt(txtProductId.getText()));
        order.setQuantity(Integer.parseInt(txtQuantity.getText()));
        OdrDA.update(order);
    }

    @FXML
    private void getById(ActionEvent event) {
        Order order=OdrDA.getById(Integer.parseInt(txtId.getText()));
        txtProductId.setText(String.valueOf(order.getP_id()));
        txtAmount.setText(String.valueOf(order.getAmount()));
        txtCustomerId.setText(String.valueOf(order.getC_id()));
        txtQuantity.setText(String.valueOf(order.getQuantity()));
        
    }

    @FXML
    private void rbaAddClick(ActionEvent event) { if (rbAdd.isSelected()==true)
        {
            addFunctionality();
        }
        else
        {
            updateDeleteFunctionality();
        }
    }

    @FXML
    private void rbUpdateDeleteClick(ActionEvent event) { if (rbAdd.isSelected()==true)
        {
            addFunctionality();
        }
        else
        {
            updateDeleteFunctionality();
        }
    }
    
}
