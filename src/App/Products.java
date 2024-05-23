package App;

import DataBaseConnection.InsertData;
import DataBaseConnection.UpdataData;

import java.util.ArrayList;

public class Products implements IDiscount {
    protected String name;
    protected String description;
    protected double price;
    protected int stock;

    private static int nextID = 1;
    private int productId;

    static ArrayList<Integer> InitialStocks = new ArrayList<>();

    public Products(String name, String description, double price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        InitialStocks.add(stock);
        this.productId = nextID++;
    }

    static ArrayList<Products> product = new ArrayList<>();

    static void addProduct(Products a){
        product.add(a);
        InsertData insert = new InsertData();
        insert.insertProduct(a);
    }

    static void updateName(Products a, String name){
        a.setName(name);

        UpdataData updata = new UpdataData();
        updata.updateNameDataBase(a,name);
    }

    static void updateDescription(Products a, String description){
        a.setDescription(description);

        UpdataData updata = new UpdataData();
        updata.updateDescriptionDataBase(a,description);
    }

    static void updatePrice(Products a, double price){
        a.setPrice(price);

        UpdataData update = new UpdataData();
        update.updatePriceDataBase(a,price);
    }

    static void updateStock(Products a, int newQuantities){
        a.setStock(newQuantities);
        InitialStocks.set(product.indexOf(a),newQuantities);
        System.out.printf("Stock of %s has been updated to %d!%n",a.getName().toLowerCase(), newQuantities);

        UpdataData updata = new UpdataData();
        updata.updateStockDataBase(a,newQuantities);
    }

    @Override
    public void discount(double discountRate){
        setPrice(getPrice() * discountRate);
        System.out.printf("There is %.1f percent discount on %s.%n%n",discountRate*100, getName().toLowerCase());
    }

    static void listProducts(){
        int count = 1;
        for (Products a : product){
            System.out.printf("%d. product;%nName: %s%nDescription: %s%nPrice: %.2f TL%nStock: %d%n%n"
            , count, a.getName(), a.getDescription(), a.getPrice(),a.getStock());
            count++;
        }
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
