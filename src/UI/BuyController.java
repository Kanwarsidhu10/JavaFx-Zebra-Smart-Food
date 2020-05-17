/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BO.Customer;
import BO.Order;
import BO.Product;
import DA.OdrDA;
import DA.ProductDA;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author snehk_000
 */
public class BuyController implements Initializable {

    @FXML
    private JFXComboBox<?> cbCategory;
    @FXML
    private JFXComboBox<?> cbProductName;
    @FXML
    private JFXTextField txtQuantity;
    @FXML
    private TableView<?> tvProducts;
    @FXML
    private TableColumn<?, ?> tcName;
    @FXML
    private TableColumn<?, ?> tcCategory;
    @FXML
    private TableColumn<?, ?> tcCode;
    @FXML
    private TableColumn<?, ?> tcAmount;
    @FXML
    private TableColumn<?, ?> tcOty;
    @FXML
    private TableColumn<?, ?> tcTotal;
    @FXML
    private Label lblCode;
    @FXML
    private Label lblDescription;
    @FXML
    private JFXButton btnAddToCart;
    @FXML
    private Label lblAmount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcAmount.setCellValueFactory(new PropertyValueFactory("amount"));
        tcCategory.setCellValueFactory(new PropertyValueFactory("p_category"));
        tcCode.setCellValueFactory(new PropertyValueFactory("p_code"));
        tcName.setCellValueFactory(new PropertyValueFactory("p_name"));
        tcOty.setCellValueFactory(new PropertyValueFactory("quantity"));
        tcTotal.setCellValueFactory(new PropertyValueFactory("total"));
        
        // TODO
        ArrayList list=new ArrayList();
        list.add("Product 1");
        list.add("Product 2");
        list.add("Product 3");
        list.add("Product 4");
        list.add("Product 5");
        cbCategory.getItems().addAll(list);
    }    

    @FXML
    private void populateProducts(ActionEvent event) {
        cbProductName.getItems().clear();
        String category=(String) cbCategory.getSelectionModel().getSelectedItem();
        ArrayList products = ProductDA.getAllByCategory(category);
        cbProductName.getItems().addAll(products);
    }

    @FXML
    private void populateDetails(ActionEvent event) {
        Product product=(Product) cbProductName.getSelectionModel().getSelectedItem();
        lblAmount.setText(String.valueOf(product.getAmount()));
        lblCode.setText(product.getCode());
        lblDescription.setText(product.getDescription());
   }
    @FXML
    private void addToCart(ActionEvent event) {
        Product product=(Product) cbProductName.getSelectionModel().getSelectedItem();
        Customer customer = visuals.VISUALS.customer;
        Order order = new Order();
        order.setAmount(product.getAmount());
        order.setC_id(customer.getId());
        order.setDate_of_delievery(LocalDate.now().plusDays(10));
        order.setDate_of_order(LocalDate.now());
        order.setId(visuals.VISUALS.order_id);
        order.setP_category(product.getCategory());
        order.setP_code(product.getCode());
        order.setP_id(product.getId());
        order.setP_name(product.getName());
        order.setQuantity(Integer.parseInt(txtQuantity.getText()));
        int total = Integer.parseInt(txtQuantity.getText())*product.getAmount();
        order.setTotal(total);
        
        ArrayList orders = new ArrayList();
        orders.add(order);
        
        tvProducts.getItems().addAll(orders);
    }

    @FXML
    private void confirmOrder(ActionEvent event) {
        for(int i=0;i<tvProducts.getItems().size();i++){
            Order order=(Order) tvProducts.getItems().get(i);
            
            OdrDA.add(order);
        }
        visuals.VISUALS.order_id++;
        txtQuantity.getScene().getWindow().hide();
    }

    
}
