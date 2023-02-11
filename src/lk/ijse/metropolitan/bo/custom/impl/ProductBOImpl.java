package lk.ijse.metropolitan.bo.custom.impl;

import lk.ijse.metropolitan.bo.custom.ProductBO;
import lk.ijse.metropolitan.dao.DAOFactory;
import lk.ijse.metropolitan.dao.custom.ProductDAO;
import lk.ijse.metropolitan.dto.ProductDTO;
import lk.ijse.metropolitan.entity.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductBOImpl implements ProductBO {
    ProductDAO productDAO = (ProductDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCT);


    @Override
    public ArrayList<ProductDTO> getAllProducts() throws SQLException, ClassNotFoundException {
        ArrayList<Product> all = productDAO.getAll();
        ArrayList<ProductDTO> allProducts = new ArrayList<>();
        for (Product p : all) {
            ProductDTO productDTO = new ProductDTO(p.getPrId(), p.getType(), p.getBrand(), p.getDescription()
                    , String.valueOf(p.getQtyOnHand()), String.valueOf(p.getBuyingPrice())
                    , String.valueOf(p.getSellingPrice()));
            allProducts.add(productDTO);
        }

        return allProducts;
    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return productDAO.generateNewID();
    }

    @Override
    public boolean addProduct(ProductDTO pr) throws SQLException, ClassNotFoundException {
        return productDAO.add(new Product(pr.getpId(), pr.getType(), pr.getBrand(), pr.getDesc(), Double.parseDouble(pr.getBuyingPrice())
                , Double.parseDouble(pr.getSellingPrice()), Double.parseDouble(pr.getQtyOnHand())));
    }

    @Override
    public boolean updateProduct(ProductDTO pr) throws SQLException, ClassNotFoundException {
        return productDAO.update(new Product(pr.getpId(), pr.getType(), pr.getBrand(), pr.getDesc(), Double.parseDouble(pr.getBuyingPrice())
                , Double.parseDouble(pr.getSellingPrice()), Double.parseDouble(pr.getQtyOnHand())));
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return productDAO.exist(id);
    }

    @Override
    public ProductDTO searchProduct(String id) throws SQLException, ClassNotFoundException {
        Product pr = productDAO.search(id);

        return new ProductDTO(pr.getPrId(), pr.getType(), pr.getBrand(), pr.getDescription()
                , String.valueOf(pr.getQtyOnHand()), String.valueOf(pr.getBuyingPrice())
                , String.valueOf(pr.getSellingPrice()));
    }

    @Override
    public boolean deleteProduct(String id) throws SQLException, ClassNotFoundException {
        return productDAO.delete(id);
    }
}
