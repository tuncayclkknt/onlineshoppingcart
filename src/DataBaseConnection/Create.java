package DataBaseConnection;

import java.sql.*;

public class Create {

    // yeni bir database oluşturur
    public static void createNewDatabase(String fileName){
        String url = "jdbc:sqlite:C:/Users/HUAWEİ/OneDrive/Masaüstü/cartDatabase/" + fileName;

        try {
            Connection conn = DriverManager.getConnection(url);
            if (conn != null){
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // kullanıcı tablosu oluşturur
    public static void createUserTable(){
        String url = "jdbc:sqlite:C:/Users/HUAWEİ/OneDrive/Masaüstü/cartDatabase/Project";
        String sql = "CREATE TABLE IF NOT EXISTS Users (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " name VARCHAR(10),\n"
                + " surname VARCHAR(12),\n"
                + " username VARCHAR(16) UNIQUE,\n"
                + " password VARCHAR(10),\n"
                + " email VARCHAR(30) UNIQUE\n"
                + ");";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("User table has been created.");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // ürün tablosu oluşturur
    public static void createProductTable(){
        String url = "jdbc:sqlite:C:/Users/HUAWEİ/OneDrive/Masaüstü/cartDatabase/Project";
        String sql = "CREATE TABLE IF NOT EXISTS Products (\n"
                + " productId INTEGER PRIMARY KEY,\n"
                + " name VARCHAR(10),\n"
                + " description VARCHAR(250),\n"
                + " price REAL,\n"
                + " stock INTEGER\n"
                + ");";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Product table has been created.");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // sepet tablosu oluşturur
    public static void createCartTable(){
        String url = "jdbc:sqlite:C:/Users/HUAWEİ/OneDrive/Masaüstü/cartDatabase/Project";
        String sql = "CREATE TABLE IF NOT EXISTS Cart (\n"
                + " productID INTEGER PRIMARY KEY,\n"
                + " productName VARCHAR(20),\n"
                + " quantity INTEGER,\n"
                + " price DOUBLE, \n"
                + " FOREIGN KEY(productID) REFERENCES Products(productId)\n"
                + ");";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Cart table has been created.");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
