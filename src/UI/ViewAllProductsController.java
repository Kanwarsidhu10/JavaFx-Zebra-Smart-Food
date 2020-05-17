/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DA.ProductDA;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author snehk_000
 */
public class ViewAllProductsController implements Initializable {

    @FXML
    private TableView<?> tvAllProducts;
    @FXML
    private TableColumn<?, ?> tcName;
    @FXML
    private TableColumn<?, ?> tcCode;
    @FXML
    private TableColumn<?, ?> tcAmount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tcAmount.setCellValueFactory(new PropertyValueFactory("amount"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcCode.setCellValueFactory(new PropertyValueFactory("code"));
        tvAllProducts.getItems().addAll(ProductDA.getAll());
    }    
    
}
