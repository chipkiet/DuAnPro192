package org.example.xikethuoc.dao;

import org.example.xikethuoc.context.DBContext;
import org.example.xikethuoc.model.Category;
import org.example.xikethuoc.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();

        String query = "select * from product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Category> getAllCategory(){
        List<Category> list  = new ArrayList<>();

        String query  = "select * from category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public List<Product> getProductByCID(String cid){
        List<Product> list  = new ArrayList<>();

        String query  = "select *from product where cateID = ?" ;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> searchByName(String txtSearch){
        List<Product> list  = new ArrayList<>();
        String query = "select * from product where name like ?";
        try{
            conn = new DBContext().getConnection();
            ps=conn.prepareStatement(query);
            ps.setString(1,"%" + txtSearch+"%");
            rs = ps.executeQuery();

            while(rs.next()){
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}