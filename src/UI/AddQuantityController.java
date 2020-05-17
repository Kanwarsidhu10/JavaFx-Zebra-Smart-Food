/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BO.Quantity;
import DA.QuantityDA;
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
public class AddQuantityController implements Initializable {

    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXTextField txtProductId;
    @FXML
    private JFXTextField txtQuantity;
    @FXML
    private JFXRadioButton rbAdd;
    @FXML
    private JFXRadioButton rbUpdateDelete;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    private void addQuantity(ActionEvent event) {
        Quantity quantity = new Quantity();
        quantity.setP_id(Integer.parseInt(txtProductId.getText()));
        quantity.setQty(Integer.parseInt(txtQuantity.getText()));
        QuantityDA.add(quantity);
    }

    @FXML
    private void updateQuantity(ActionEvent event) {
        Quantity quantity = new Quantity();
        quantity.setId(Integer.parseInt(txtId.getText()));
        quantity.setP_id(Integer.parseInt(txtProductId.getText()));
        quantity.setQty(Integer.parseInt(txtQuantity.getText()));
        QuantityDA.update(quantity);
    }

    @FXML
    private void deleteQuantity(ActionEvent event) {
        QuantityDA.delete(Integer.parseInt(txtId.getText()));
    }

    @FXML
    private void getById(ActionEvent event) {
        Quantity quantity=QuantityDA.getById(Integer.parseInt(txtId.getText()));
        txtProductId.setText(String.valueOf(quantity.getP_id()));
        txtQuantity.setText(String.valueOf(quantity.getQty()));
    }

    @FXML
    private void rbAddClick(ActionEvent event) { if (rbAdd.isSelected()==true)
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
