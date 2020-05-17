/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BO.Customer;
import DA.CustomerDA;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
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
public class AddCustomerController implements Initializable {

    @FXML
    private JFXRadioButton rbAdd;
    @FXML
    private JFXRadioButton rbUpdateDelete;
    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXTextField txtMobile_number;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextArea txtAddress;
    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXTextField txtPassword;
    @FXML
    private JFXTextField txtEmail;
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
        // TODO
        ToggleGroup tg = new ToggleGroup();
        rbAdd.setToggleGroup(tg);
        rbUpdateDelete.setToggleGroup(tg);
        
        Customer customer= visuals.VISUALS.customer;
        if(customer.getUsername().equals("admin123") && customer.getPassword().equals("admin123")){
            rbAdd.setSelected(true);
        addFunctionality();
        }
        else{
        rbUpdateDelete.setSelected(true);
        updateDeleteFunctionality();
        rbAdd.setDisable(true);
        txtId.setDisable(true);
        txtId.setText(String.valueOf(customer.getId()));
            populate(customer);
    }
         
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
    private void addCustomer(ActionEvent event) {
        Customer customer=new Customer();
        customer.setMobile_number(Long.parseLong(txtMobile_number.getText()));
        customer.setName(txtName.getText());
        customer.setAddress(txtAddress.getText());
        customer.setUsername(txtUsername.getText());
        customer.setPassword(txtPassword.getText());
        customer.setEmail(txtEmail.getText());
        CustomerDA.add(customer);
    }

    @FXML
    private void updateCustomer(ActionEvent event) {
        Customer customer=new Customer();
        customer.setMobile_number(Long.parseLong(txtMobile_number.getText()));
        customer.setName(txtName.getText());
        customer.setAddress(txtAddress.getText());
        customer.setUsername(txtUsername.getText());
        customer.setPassword(txtPassword.getText());
        customer.setEmail(txtEmail.getText());
        CustomerDA.update(customer);
    }

    @FXML
    private void deleteCustomer(ActionEvent event) {
        CustomerDA.delete(Integer.parseInt(txtId.getText()));
    }

    @FXML
    private void getById(ActionEvent event) {
        Customer customer= CustomerDA.getById(Integer.parseInt(txtId.getText()));
        populate(customer);
    }
    public void populate(Customer customer)
    {
        txtName.setText(customer.getName());
        txtMobile_number.setText(String.valueOf(customer.getMobile_number()));
        txtEmail.setText(customer.getEmail());
        txtAddress.setText(customer.getAddress());
        txtUsername.setText(customer.getUsername());
        txtPassword.setText(customer.getPassword());
    }

    @FXML
    private void rbAddClick(ActionEvent event) {
                if (rbAdd.isSelected()==true)
        {
            addFunctionality();
        }
        else
        {
            updateDeleteFunctionality();
        }
    }

    @FXML
    private void rbUpdateDeleteClick(ActionEvent event) {
                if (rbAdd.isSelected()==true)
        {
            addFunctionality();
        }
        else
        {
            updateDeleteFunctionality();
        }
    }
    
}
