package DataBaseConnection;

import java.sql.*;

public class DeleteData {

    private Connection connect(){
        String url = "jdbc:sqlite:Project";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // kullanıcı tablosundan belirtilen kullanıcıyı siler
    public void deleteUser(String username){
        String sql = "DELETE FROM Users WHERE username = ?";
        try{
            Connection conn= this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            int deletedUser = pstmt.executeUpdate();
            if(deletedUser > 0){
                System.out.println("User "+ username+" has deleted");
            } else {
                System.out.println("There is no user with such username and password");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // ürün tablosundan belirtilen ürünü siler
    public void deleteProduct(int productId){
        String sql = "DELETE FROM Products WHERE productId = ?";
        try{
            Connection conn= this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,productId);
            int deletedUser = pstmt.executeUpdate();
            if(deletedUser > 0){
                System.out.println("The product that has an id: "+ productId +" has deleted.");
            } else {
                System.out.println("There is no product with such id");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // belirtilen tabloyu siler
    public void dropTable(String tableName) {
        String sql = "DROP TABLE IF EXISTS " + tableName;

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("Table " + tableName + " has been dropped.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // ürün tablosunun içeriğini siler, clearCart methodu için kullanıldı
    public void deleteCartItems(){
        String sql = "DELETE FROM Cart;\n";
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
