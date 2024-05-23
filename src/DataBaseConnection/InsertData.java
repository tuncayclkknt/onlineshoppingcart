package DataBaseConnection;

import java.sql.*;
import App.*;


public class InsertData {
    private Connection connect(){
        String url = "jdbc:sqlite:C:/Users/HUAWEİ/OneDrive/Masaüstü/cartDatabase/Deneme1";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertUsers(User u){
        String sql = "INSERT INTO Users(name, surname,username,password,email) VALUES(?,?,?,?,?)";
        try{
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,u.getName());
            pstmt.setString(2,u.getSurname());
            pstmt.setString(3,u.getUsername());
            pstmt.setString(4,u.getPassword());
            pstmt.setString(5,u.getEmail());
            pstmt.executeUpdate();
            System.out.println("User registered successfully");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void insertProduct(Products a){
        String sql = "INSERT INTO Products(productId,name, description, price, stock) VALUES(?,?,?,?,?)";
        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,a.getProductId());
            pstmt.setString(2,a.getName());
            pstmt.setString(3,a.getDescription());
            pstmt.setDouble(4,a.getPrice());
            pstmt.setInt(5,a.getStock());
            pstmt.executeUpdate();
            System.out.println("Product inserted successfully");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void insertCart(Products a, int quantity){
        String sql = "INSERT INTO Cart(productId ,productName, quantity, price) VALUES(?,?,?,?)";
        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,a.getProductId());
            pstmt.setString(2,a.getName());
            pstmt.setInt(3,quantity);
            pstmt.setDouble(4,a.getPrice() * quantity);
            pstmt.executeUpdate();
            System.out.println("Product inserted on cart successfully");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
