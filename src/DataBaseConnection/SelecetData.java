package DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;


public class SelecetData {

    private Connection connect(){
        String url = "jdbc:sqlite:C:/Users/HUAWEİ/OneDrive/Masaüstü/cartDatabase/Project";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // kullanıcı tablosundaki herkesi yazdırır
    public void selectUser(){
        String sql = "SELECT * FROM Users";

        try{
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("surname") + "\t" +
                        rs.getString("username")+ "\t" +
                        rs.getString("password")+ "\t" +
                        rs.getString("email"));
            }
            conn.close();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private ArrayList<String> userData = new ArrayList<>();

    public boolean selectUser(String username, String password){
        String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";

        boolean doesUserExists = false;
        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                doesUserExists = true;
                userData.add(rs.getString("name"));
                userData.add(rs.getString("surname"));
                userData.add(rs.getString("username"));
                userData.add(rs.getString("password"));
                userData.add(rs.getString("email"));
            } else {
                doesUserExists = false;
            }
            conn.close();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return doesUserExists;
    }

    // ürün tablsoundaki her şeyi yazdırır
    public void selectProducts(){
        String sql = "SELECT * FROM Products";

        try{
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                System.out.println(rs.getInt("productId") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("description") + "\t" +
                        rs.getDouble("price") + "\t" +
                        rs.getInt("stock"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // sepet tablsoundaki her şeyi yazdırır
    public void selectProductsOnCart(){
        String sql = "SELECT * FROM Cart";

        try{
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                System.out.println(rs.getInt("productId") + "\t" +
                        rs.getString("productName") + "\t" +
                        rs.getInt("quantity") + "\t" +
                        rs.getDouble("price"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> getUserData() {
        return userData;
    }
}
