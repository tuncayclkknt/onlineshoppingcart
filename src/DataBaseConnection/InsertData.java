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

    // kullanıcı tablsuna kullanıcı girdisi yapar
    public void insertUsers(String name, String surname, String username, String password, String email){
        String sql = "INSERT INTO Users(name, surname,username,password,email) VALUES(?,?,?,?,?)";
        try{
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,surname);
            pstmt.setString(3,username);
            pstmt.setString(4,password);
            pstmt.setString(5,email);
            pstmt.executeUpdate();
            System.out.println("User registered successfully");
        } catch (SQLException e){
            System.out.println("Username or email has already taken");
        }
    }

    // ürün tablsuna ürün girdisi yapar
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

    // sepet tablosuna ürün girdisi yapar
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
