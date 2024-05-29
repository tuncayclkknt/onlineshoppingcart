package DataBaseConnection;

import App.*;
import java.sql.*;


public class UpdataData {

    UserManager update = new UserManager("","","","","");

    private Connection connect(){
        String url = "jdbc:sqlite:C:/Users/HUAWEİ/OneDrive/Masaüstü/cartDatabase/Project";
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
    public void updateUsernameDatabase(String oldUsername, String newUsername){
        String sql = "UPDATE Users SET username = ? WHERE username = ?";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,newUsername);
            pstmt.setString(2,oldUsername);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.printf("Your username updated to \"%s\" from \"%s\"!%n", newUsername, oldUsername);
            } else {
                System.out.println("User not found.");
            }

        } catch(SQLException e){
            System.out.println("There is a mistake on username!");
        }
    }

    // database kayıtlı password updateler
    public void updatePasswordDatabase(String username, String newPassword){
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
            System.out.println("There is a mistake on password!");
        }
    }

    // database kayıtlı email updateler
    public void updateEmailDatabase(String newEmail){
        String sql = "UPDATE Users SET email = ? WHERE username = ?";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,newEmail);
            pstmt.setString(2,update.loggedInUsername[0]);


            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.printf("Your email updated to \"%s\"!%n", newEmail);
            } else {
                System.out.println("Email cannot change.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // database kayıtlı isim ve soyisim updateler
    public void updateNameAndSurnameDatabase(String newName, String newSurname){
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
                System.out.printf("Your name and surname updated as %s and %s%n", newName, newSurname);
            } else {
                System.out.println("Name and surname cannot change.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
//---------------------------- Products and Cart ----------------------------------------------------

    // database kayıtlı ürünün stoğunu updateler
    public void updateStockDatabase(Products a, int newQuantities){

        String sql = "UPDATE Products SET stock = ? WHERE productId = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,newQuantities );
            pstmt.setInt(2,a.getProductId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {

            } else {
                System.out.println("Stock cannot change.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

    // database kayıtlı ürünün açıklamısını updateler
    public void updateDescriptionDatabase(Products a, String desctiption){

        String sql = "UPDATE Products SET description = ? WHERE productId = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,desctiption );
            pstmt.setInt(2,a.getProductId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Description of the product updated successfully.");
            } else {
                System.out.println("Description cannot change.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // database kayıtlı ürünün ismini updateler
    public void updateNameDatabase(Products a, String name){

        String sql = "UPDATE Products SET name = ? WHERE productId = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name );
            pstmt.setInt(2,a.getProductId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Name of the product updated successfully.");
            } else {
                System.out.println("Name cannot change.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // database kayıtlı ürünün fiyatını updateler
    public void updatePriceDatabase(Products a, double price){

        String sql = "UPDATE Products SET price = ? WHERE productId = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1,price);
            pstmt.setInt(2,a.getProductId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Price of the product updated successfully.");
            } else {
                System.out.println("Price cannot change.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // database kayıtlı ürünün sepetteki miktarını updateler
    public void updateQuantityOnCartDatabase(Products a, int quantity){
        String sql = "UPDATE Cart SET quantity = ? WHERE productId = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1,quantity);
            pstmt.setInt(2,a.getProductId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {

            } else {
                System.out.println("Price cannot change.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /* database kayıtlı ürünün sepetteki fiyatı updateler, sepetteki ürün değişimlerinde
     fiyatı dengelemek için kullanıldı */
    public void updateCartPriceDatabase(Products a, int quantity){
        String sql = "UPDATE Cart SET price = ? WHERE productId = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1,a.getPrice() * quantity );
            pstmt.setInt(2,a.getProductId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {

            } else {
                System.out.println("Price cannot change.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
