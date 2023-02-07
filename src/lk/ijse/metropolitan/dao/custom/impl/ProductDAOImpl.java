package lk.ijse.metropolitan.dao.custom.impl;

import lk.ijse.metropolitan.dao.custom.ProductDAO;
import lk.ijse.metropolitan.dto.CrudUtil;
import lk.ijse.metropolitan.entity.Employee;
import lk.ijse.metropolitan.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAOImpl implements ProductDAO {
    String sql =null;
    @Override
    public ArrayList<Product> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Product> allProducts =new ArrayList<>();
        sql= "SELECT * FROM product;";
        ResultSet rst = CrudUtil.execute(sql);

        while (rst.next()){
            Product product= new Product(rst.getString("prId"),rst.getString("type")
                    ,rst.getString("brand"),rst.getString("description"),rst.getDouble("buyingPrice")
                    ,rst.getDouble("sellingPrice"),rst.getDouble("qtyOnHand"));

            allProducts.add(product);
        }

        return allProducts;
    }

    @Override
    public boolean add(Product p) throws SQLException, ClassNotFoundException {
        sql="INSERT INTO product VALUES (?,?,?,?,?,?,?);";
        return  CrudUtil.execute(sql, p.getPrId(),p.getType(),p.getBrand(),p.getDescription()
                ,p.getBuyingPrice(),p.getSellingPrice(),p.getQtyOnHand());

    }

    @Override
    public boolean update(Product p) throws SQLException, ClassNotFoundException {
        sql="UPDATE product SET type=?,brand=?,description=?,buyingPrice=?,sellingPrice=?,qtyOnHand=? WHERE prId=?;";
        return CrudUtil.execute(sql,p.getType(),p.getBrand(),p.getDescription()
                ,p.getBuyingPrice(),p.getSellingPrice(),p.getQtyOnHand(), p.getPrId());


    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        sql="SELECT prId FROM product WHERE prId=?;";
        ResultSet rst = CrudUtil.execute(sql, id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT prId FROM product ORDER BY prId DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("prId");
            int newEmployeeId = Integer.parseInt(id.replace("P00-", "")) + 1;
            return String.format("P00-%03d", newEmployeeId);
        } else {
            return "P00-001";
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        sql="DELETE FROM product WHERE prId =?;";
        return  CrudUtil.execute(sql,id);
    }

    @Override
    public Product search(String id) throws SQLException, ClassNotFoundException {
        sql="SELECT * FROM product WHERE prId = ?; ";
        ResultSet rst=CrudUtil.execute(sql,id);
        rst.next();
        Product product = new Product(rst.getString("prId"),rst.getString("type")
                ,rst.getString("brand"),rst.getString("description"),rst.getDouble("buyingPrice")
                ,rst.getDouble("sellingPrice"),rst.getDouble("qtyOnHand"));
        return product;
    }
}
