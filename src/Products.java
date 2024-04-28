import java.util.ArrayList;

public class Products {
    protected String name;
    protected String description;
    protected double price;
    protected int stock;
    static double totalPrice = 0;


    public Products(String name, String description, double price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    static ArrayList<Products> product = new ArrayList<>();
    static ArrayList<Products> myCart = new ArrayList<>();

    static ArrayList<Integer> adets = new ArrayList<>();
    //türkçe isimler denemek içindir(tuncay)

    static void addProduct(Products a){
        product.add(a);
    }

    static void listProducts(){
        int count = 1;
        for (Products a : product){
            System.out.printf("%d. product;%nName: %s%nDescription: %s%nPrice: %.2f TL%nStock: %d%n%n"
            , count, a.getName(), a.getDescription(), a.getPrice(),a.getStock());
            count++;
        }
    }

    static void addToCart(Products a, int adet){

        if ((a.stock - adet) >= 0){
            myCart.add(a);
            totalPrice += a.getPrice() * adet;
            a.setStock(a.stock - adet);
            adets.add(adet);}
        else {
            System.out.printf("Adet stocktan fazla olamaz!!!%nÜrün %s Stoğu: %d%nAdeti: %d%n%n",a.getName(), a.stock, adet);
        }
    }

    static void listCart(){

        System.out.println("Products on your cart:");
        int count = 0;
        for(Products a: myCart){

            System.out.printf("Name: %s%nAdet: %d%n%n", a.getName(),adets.get(count));
            count++;
        }
        System.out.printf("Total price: %.2f",totalPrice);
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
}
