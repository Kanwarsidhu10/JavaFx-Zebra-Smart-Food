/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BO.Product;
import DA.ProductDA;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
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
public class AddProductController implements Initializable {

    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXTextField txtCode;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXComboBox cbCategory;
    @FXML
    private JFXTextField txtAmount;
    @FXML
    private JFXRadioButton rbAdd;
    @FXML
    private JFXRadioButton rbUpdateDelete;
    @FXML
    private JFXTextArea txtDescription;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnAdd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList list = new ArrayList();
        list.add("Product 1");
        list.add("Product 2");
        list.add("Product 3");
        list.add("Product 4");
        list.add("Product 5");
        cbCategory.getItems().addAll(list);

        ToggleGroup tg = new ToggleGroup();
        rbAdd.setToggleGroup(tg);
        rbUpdateDelete.setToggleGroup(tg);

        rbAdd.setSelected(true);
        addFunctionality();

    }

    public void addFunctionality() {
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        txtId.setDisable(true);
        btnAdd.setDisable(false);
    }

    public void updateDeleteFunctionality() {
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);
        txtId.setDisable(false);
        btnAdd.setDisable(true);
    }

    @FXML
    private void addProduct(ActionEvent event) {
        Product product = new Product();
        product.setAmount(Integer.parseInt(txtAmount.getText()));
        product.setCategory(cbCategory.getSelectionModel().getSelectedItem().toString());
        product.setCode(txtCode.getText());
        product.setDescription(txtDescription.getText());
        product.setName(txtName.getText());
        ProductDA.add(product);
    }

    private void updateProduct(ActionEvent event) {
        Product product = new Product();
        product.setAmount(Integer.parseInt(txtAmount.getText()));
        product.setCategory(cbCategory.getSelectionModel().getSelectedItem().toString());
        product.setCode(txtCode.getText());
        product.setDescription(txtDescription.getText());
        product.setId(Integer.parseInt(txtId.getText()));
        product.setName(txtName.getText());
        ProductDA.update(product);
    }

    @FXML
    private void deleteProduct(ActionEvent event) {
        ProductDA.delete(Integer.parseInt(txtId.getText()));

    }

    @FXML
    private void getById(ActionEvent event) {
        Product product = ProductDA.getById(Integer.parseInt(txtId.getText()));
        txtName.setText(product.getName());
        txtAmount.setText(String.valueOf(product.getAmount()));
        txtCode.setText(product.getCode());
        txtDescription.setText(product.getDescription());
        cbCategory.getSelectionModel().select(product.getCategory());
    }

    @FXML
    private void rbAddClick(ActionEvent event) {
        if (rbAdd.isSelected() == true) {
            addFunctionality();
        } else {
            updateDeleteFunctionality();
        }
    }

    @FXML
    private void rbUpdateDelete(ActionEvent event) {
        if (rbAdd.isSelected() == true) {
            addFunctionality();
        } else {
            updateDeleteFunctionality();
        }
    }

}
