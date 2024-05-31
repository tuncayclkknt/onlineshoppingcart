package App;

import DataBaseConnection.InsertData;
import DataBaseConnection.SelecetData;
import DataBaseConnection.UpdataData;
import java.util.ArrayList;

public abstract class Cart{
    static double totalPrice = 0;

    // sepetteki ürünleri ve onların miktarlarını özdeş indexlerde tutar
    static ArrayList<Products> myCart = new ArrayList<>();
    static ArrayList<Integer> quantities = new ArrayList<>();

    // sepete 1 adet belirtilen üründen ekler
    static void addToCart(Products a){
        if (User.didLogin) {
            if ((a.stock - 1) >= 0) {

                myCart.add(a);
                quantities.add(1);
                totalPrice += a.getPrice() * quantities.get(myCart.indexOf(a));
                a.setStock(a.stock - 1);
                System.out.printf("%dx %s has been added your cart.%n", 1, a.getName().toLowerCase());

                InsertData insert = new InsertData();
                insert.insertCart(a,1);

                UpdataData update = new UpdataData();
                update.updateStockDatabase(a,a.getStock());

            } else {
                System.out.printf("We have only %d stocks for %s. " +
                        "Please wait for updating stocks or change the quantities of the product.%n", a.getStock(), a.getName().toLowerCase());
            }
        }else {
            System.out.println("You have to log in!!!");
        }
    }

    // sepete belirtilen üründen belirtilen miktar kadar ekler
    //Overloading
    static void addToCart(Products a, int quantity){

        if (User.didLogin) {
            if ((a.stock - quantity) >= 0) {

                myCart.add(a);
                quantities.add(quantity);
                totalPrice += a.getPrice() * quantities.get(myCart.indexOf(a));
                a.setStock(a.stock - quantity);
                System.out.printf("%dx %s has been added your cart.%n", quantity,a.getName().toLowerCase());

                InsertData insert = new InsertData();
                insert.insertCart(a, quantity);

                UpdataData update = new UpdataData();
                update.updateStockDatabase(a,a.getStock());

            } else {
                System.out.printf("We have only %d stocks for %s." +
                        "Please wait for updating stocks or change the quantities of the product", a.getStock(), a.getName().toLowerCase());
            }
        }else{
            System.out.println("You have to log in!!!");
        }
    }

    // sepetteki ürünleri listeler
    static void listCart(){

        if (User.didLogin) {
            System.out.println("Products on your cart:");
            SelecetData selecet = new SelecetData();
            selecet.selectProductsOnCart();

            System.out.printf("Total price: %.2f", totalPrice);
        }else {
            System.out.println("You have to log in!!!");
        }
    }
}
