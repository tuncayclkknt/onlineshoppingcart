package App;

import DataBaseConnection.InsertData;
import DataBaseConnection.SelecetData;
import DataBaseConnection.UpdataData;

import java.util.ArrayList;

public class Products{
    protected String name;
    protected String description;
    protected double price;
    protected int stock;

    // ürünler için benzersiz idler oluşturur
    private static int nextID = 1;
    private int productId;

    // ürünlerin başlangıç stoklarını tutar, bazı kısımlarda lazım oluyor
    static ArrayList<Integer> InitialStocks = new ArrayList<>();
    // ürünleri başlangıç stoklarıyla özdeğer indexlerde tutar
    static ArrayList<Products> product = new ArrayList<>();

    public Products(String name, String description, double price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        InitialStocks.add(stock);
        this.productId = nextID++;
        product.add(this);

        InsertData insert = new InsertData();
        insert.insertProduct(productId,name,description,price,stock);
    }

    // ürünün kayıtlı olan yerlerden adını günceller
    static void updateName(Products a, String name){
        a.setName(name);

        UpdataData updata = new UpdataData();
        updata.updateNameDatabase(a,name);
    }

    // ürünün kayıtlı olan yerlerden açıklamasını günceller
    static void updateDescription(Products a, String description){
        a.setDescription(description);

        UpdataData updata = new UpdataData();
        updata.updateDescriptionDatabase(a,description);
    }

    // ürünün kayıtlı olan yerlerden fiyatını günceller
    static void updatePrice(Products a, double price){
        a.setPrice(price);

        UpdataData update = new UpdataData();
        update.updatePriceDatabase(a,price);
    }

    // ürünün kayıtlı olan yerlerden stoğunu günceller
    static void updateStock(Products a, int newQuantities){
        a.setStock(newQuantities);
        InitialStocks.set(product.indexOf(a),newQuantities);
        System.out.printf("Stock of %s has been updated to %d!%n",a.getName().toLowerCase(), newQuantities);
        UpdataData updata = new UpdataData();
        updata.updateStockDatabase(a,newQuantities);
    }


    // ürünleri listelemeye yarar
    static void listProducts(){
        SelecetData select = new SelecetData();
        select.selectProducts();
    }


    //------------------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
