package lk.ijse.metropolitan.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.metropolitan.bo.BOFactory;
import lk.ijse.metropolitan.bo.custom.ProductBO;
import lk.ijse.metropolitan.dto.ProductDTO;
import lk.ijse.metropolitan.view.tm.ProductTM;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductFormController {
    public Button btnClear;
    public TableView<ProductTM> tblProduct;
    public TableColumn colPid;
    public TableColumn colType;
    public TableColumn colBrand;
    public TableColumn colDesc;
    public TableColumn colQty;
    public TableColumn colBuy;
    public TableColumn colSell;
    public TableColumn colDel;
    public TextField txtPID;
    public TextField txtType;
    public TextField txtBrand;
    public TextField txtDesc;
    public TextField txtQty;
    public Button btnAdd;
    public TextField txtSearch;
    public TextField txtBuy;
    public TextField txtSell;
    public AnchorPane paneProduct;

    ProductBO productBO = (ProductBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PRODUCT);

    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {
        colPid.setCellValueFactory(new PropertyValueFactory<>("prID"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        colBuy.setCellValueFactory(new PropertyValueFactory<>("buyingPrice"));
        colSell.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));


        initUI();
        loadAllProduct();

    }

    private void initUI() {
        txtPID.clear();
        txtType.clear();
        txtBrand.clear();
        txtDesc.clear();
        txtQty.clear();
        txtBuy.clear();
        txtSell.clear();

        txtPID.setDisable(true);
        txtType.setDisable(true);
        txtBrand.setDisable(true);
        txtDesc.setDisable(true);
        txtQty.setDisable(true);
        txtBuy.setDisable(true);
        txtSell.setDisable(true);

        btnAdd.setText("Add");
    }

    private void loadAllProduct() throws SQLException, ClassNotFoundException {
        ArrayList<ProductDTO> productList = productBO.getAllProducts();
        ObservableList allPrducts = FXCollections.observableArrayList();
        for (ProductDTO p : productList){
            ProductTM tm = new ProductTM(p.getpId(),p.getType(),p.getBrand(),p.getDesc(),Double.parseDouble(p.getQtyOnHand())
            ,Double.parseDouble(p.getBuyingPrice()),Double.parseDouble(p.getSellingPrice()));
        }

        tblProduct.setItems(allPrducts);
    }


    public void addOnAction(ActionEvent actionEvent) {
        txtPID.setDisable(false);
        txtType.setDisable(false);
        txtBrand.setDisable(false);
        txtDesc.setDisable(false);
        txtQty.setDisable(false);
        txtBuy.setDisable(false);
        txtSell.setDisable(false);

        if (btnAdd.getText().equals("Add")) {
            try {
                txtPID.setText(productBO.generateNextId());
                btnAdd.setText("Save");
                //variables to save data from text fields

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } else if (btnAdd.getText().equalsIgnoreCase("Update")){

            boolean isUpdate = false;
            try {
                //variables to save data from text fields
                String pId = txtPID.getText();
                String type = txtType.getText();
                String brand = txtBrand.getText();
                String desc = txtDesc.getText();
                String qtyOnHand = txtQty.getText();
                String buy = txtBuy.getText();
                String sell = txtSell.getText();

                ProductDTO prduct = new ProductDTO(pId, type, brand, desc, qtyOnHand, buy, sell);
                isUpdate = productBO.updateProduct(prduct);
                if (isUpdate) {
                    new Alert(Alert.AlertType.INFORMATION, "Product Updated Successfully").show();
                    btnAdd.setText("Add");
                    initUI();
                    tblProduct.refresh();
                } else {
                    new Alert(Alert.AlertType.INFORMATION, "Product Adding Failed").show();
                    btnAdd.setText("Add");
                    initUI();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }else if (btnAdd.getText().equalsIgnoreCase("Save")){
            String pId = txtPID.getText();
            String type = txtType.getText();
            String brand = txtBrand.getText();
            String desc = txtDesc.getText();
            String qtyOnHand = txtQty.getText();
            String buy = txtBuy.getText();
            String sell = txtSell.getText();

            ProductDTO product = new ProductDTO(pId, type, brand, desc, qtyOnHand, buy, sell);
            boolean isAdded = false;
            try {
                isAdded = productBO.addProduct(product);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (isAdded) {
                new Alert(Alert.AlertType.INFORMATION, "Product Added Successfully").show();
                btnAdd.setText("Add");
                initUI();
                tblProduct.getItems().add(new ProductTM(pId, type, brand, desc, Double.parseDouble(qtyOnHand)
                        , Double.parseDouble(buy), Double.parseDouble(sell)));
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Product Adding Failed").show();
                btnAdd.setText("Add");
                initUI();
            }
        }
    }

    public void searchOnChanges(InputMethodEvent inputMethodEvent) {

    }


    public void clearOnAction(ActionEvent actionEvent) {


        if (btnClear.getText().equals("Delete")) {
            boolean isDeleted = false;
            try {
                isDeleted = productBO.deleteProduct(txtPID.getText());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Product Deleted Successfully");
                btnAdd.setText("Add");
                btnClear.setText("Clear");
                initUI();
                tblProduct.refresh();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Product Deletion failed");
                btnAdd.setText("Add");
                btnClear.setText("Clear");
                initUI();
            }
        } else {
            try {
                txtPID.setText(productBO.generateNextId());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            txtPID.clear();
            txtType.clear();
            txtBrand.clear();
            txtDesc.clear();
            txtQty.clear();
            txtBuy.clear();
            txtSell.clear();
        }


    }

    public void typeOnAction(ActionEvent actionEvent) {
        txtBrand.requestFocus();
    }

    public void brandOnAction(ActionEvent actionEvent) {
        txtDesc.requestFocus();
    }

    public void descOnAction(ActionEvent actionEvent) {
        txtQty.requestFocus();
    }

    public void qtyOnAction(ActionEvent actionEvent) {
        txtBuy.requestFocus();
    }

    public void buyingOnAction(ActionEvent actionEvent) {
        txtSell.requestFocus();
    }

    public void sellingOnAction(ActionEvent actionEvent) {
        btnAdd.fire();
    }

    public void searchOnAction(ActionEvent actionEvent) {

        boolean isExists = false;
        try {
            isExists = productBO.exist(txtSearch.getText());
            if (isExists) {
                ProductDTO prDTO = productBO.searchProduct(txtSearch.getText());
                btnAdd.setText("Update");
                btnClear.setText("Delete");

                txtPID.setDisable(false);
                txtType.setDisable(false);
                txtBrand.setDisable(false);
                txtDesc.setDisable(false);
                txtQty.setDisable(false);
                txtBuy.setDisable(false);
                txtSell.setDisable(false);

                txtPID.setText(prDTO.getpId());
                txtType.setText(prDTO.getType());
                txtBrand.setText(prDTO.getBrand());
                txtDesc.setText(prDTO.getDesc());
                txtQty.setText(prDTO.getQtyOnHand());
                txtBuy.setText(prDTO.getBuyingPrice());
                txtSell.setText(prDTO.getSellingPrice());

                btnClear.setDisable(false);
                btnAdd.setDisable(false);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

