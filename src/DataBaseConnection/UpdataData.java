package DataBaseConnection;

import App.*;
import java.sql.*;


public class UpdataData {

    UserManager update = new UserManager("","","","","");

    private Connection connect(){
        String url = "jdbc:sqlite:C:/Users/HUAWEİ/OneDrive/Masaüstü/cartDatabase/Deneme1";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    //---------------------------- User Manager ----------------------------------------------------

    // database kayıtlı username updateler
    public void updateUsernameDataBase(String oldUsername, String newUsername){
        String sql = "UPDATE Users SET username = ? WHERE username = ?";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,newUsername);
            pstmt.setString(2,oldUsername);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Username updated successfully.");
            } else {
                System.out.println("User not found.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // database kayıtlı password updateler
    public void updatePasswordDataBase(String username, String newPassword){
        String sql = "UPDATE Users SET password = ? WHERE username = ?";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,newPassword);
            pstmt.setString(2,username);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Password updated successfully.");
            } else {
                System.out.println("Password cannot change.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // database kayıtlı email updateler
    public void updateEmailDataBase(String newEmail){
        String sql = "UPDATE Users SET email = ? WHERE username = ?";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,newEmail);
            pstmt.setString(2,update.loggedInUsername[0]);


            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Email updated successfully.");
            } else {
                System.out.println("Email cannot change.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // database kayıtlı isim ve soyisim updateler
    public void updateNameAndSurnameDataBase(String newName, String newSurname){
        String sql = "UPDATE Users\n" +
                "SET name = ?, surname = ?\n" +
                "WHERE username = ?;";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,newName);
            pstmt.setString(2,newSurname);
            pstmt.setString(3,update.loggedInUsername[0]);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Name and surname updated successfully.");
            } else {
                System.out.println("Name and surname cannot change.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
//---------------------------- Products and Cart ----------------------------------------------------

    // database kayıtlı ürünün stoğunu updateler
    public void updateStockDataBase(Products a, int newQuantities){

        String sql = "UPDATE Products SET stock = ? WHERE productId = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,newQuantities );
            pstmt.setInt(2,a.getProductId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Stock updated successfully.");
            } else {
                System.out.println("Stock cannot change.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

    // database kayıtlı ürünün açıklamısını updateler
    public void updateDescriptionDataBase(Products a, String desctiption){

        String sql = "UPDATE Products SET description = ? WHERE productId = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,desctiption );
            pstmt.setInt(2,a.getProductId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Description updated successfully.");
            } else {
                System.out.println("Description cannot change.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // database kayıtlı ürünün ismini updateler
    public void updateNameDataBase(Products a, String name){

        String sql = "UPDATE Products SET name = ? WHERE productId = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name );
            pstmt.setInt(2,a.getProductId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Name updated successfully.");
            } else {
                System.out.println("Name cannot change.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // database kayıtlı ürünün fiyatını updateler
    public void updatePriceDataBase(Products a, double price){

        String sql = "UPDATE Products SET price = ? WHERE productId = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1,price);
            pstmt.setInt(2,a.getProductId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Price updated successfully.");
            } else {
                System.out.println("Price cannot change.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // database kayıtlı ürünün sepetteki miktarını updateler
    public void updateQuantityOnCartDataBase(Products a, int quantity){
        String sql = "UPDATE Cart SET quantity = ? WHERE productId = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1,quantity);
            pstmt.setInt(2,a.getProductId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Price updated successfully.");
            } else {
                System.out.println("Price cannot change.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /* database kayıtlı ürünün sepetteki fiyatı updateler, sepetteki ürün değişimlerinde
     fiyatı dengelemek için kullanıldı */
    public void updateCartPriceDataBase(Products a, int quantity){
        String sql = "UPDATE Cart SET price = ? WHERE productId = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1,a.getPrice() * quantity );
            pstmt.setInt(2,a.getProductId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Price updated successfully.");
            } else {
                System.out.println("Price cannot change.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
