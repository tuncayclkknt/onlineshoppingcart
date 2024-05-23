package App;

import DataBaseConnection.InsertData;
import DataBaseConnection.UpdataData;

import java.util.ArrayList;

public abstract class Cart{
    static double totalPrice = 0;

    // sepetteki ürünleri ve onların miktarlarını özdeş indexlerde tutar
    static ArrayList<Products> myCart = new ArrayList<>();
    static ArrayList<Integer> quantity = new ArrayList<>();


    // sepete 1 adet belirtilen üründen ekler
    static void addToCart(Products a){
        if (User.didLogin) {
            if ((a.stock - 1) >= 0) {

                myCart.add(a);
                quantity.add(1);
                totalPrice += a.getPrice() * quantity.get(myCart.indexOf(a));
                a.setStock(a.stock - 1);
                System.out.printf("%dx %s has been added your cart.%n", 1, a.getName().toLowerCase());

                InsertData insert = new InsertData();
                insert.insertCart(a,1);

                UpdataData update = new UpdataData();
                update.updateStockDataBase(a,a.getStock());

            } else {
                System.out.printf("We have only %d stocks for %s." +
                        "Please wait for updating stocks or change the quantities of the product", a.getStock(), a.getName().toLowerCase());
            }
        }else {
            System.out.println("You have to log in!!!");
        }
    }

    // sepete belirtilen üründen belirtilen miktar kadar ekler
    //Overloading
    static void addToCart(Products a, int Quantity){

        if (User.didLogin) {
            if ((a.stock - Quantity) >= 0) {

                myCart.add(a);
                quantity.add(Quantity);
                totalPrice += a.getPrice() * quantity.get(myCart.indexOf(a));
                a.setStock(a.stock - Quantity);
                System.out.printf("%dx %s has been added your cart.%n", Quantity,a.getName().toLowerCase());

                InsertData insert = new InsertData();
                insert.insertCart(a, Quantity);

                UpdataData update = new UpdataData();
                update.updateStockDataBase(a,a.getStock());

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
            System.out.println("App.Products on your cart:");
            int count = 0;
            for (Products a : myCart) {
                if (quantity.get(count) != 0) {
                    System.out.printf("Name: %s%nQuantities: %d%n%n", a.getName(), quantity.get(count));
                }
                count++;
            }
            System.out.printf("Total price: %.2f", totalPrice);
        }else {
            System.out.println("You have to log in!!!");
        }
    }
}
