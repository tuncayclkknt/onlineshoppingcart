import java.util.ArrayList;

public abstract class Cart extends User {
    static double totalPrice = 0;

    static ArrayList<Products> myCart = new ArrayList<>();
    static ArrayList<Integer> quantity = new ArrayList<>();

    public Cart(String name, String surname, String username, String password, String email) {
        super(name, surname, username, password, email);
    }

    static void addToCart(Products a, int adet){

        if (didLogin) {
            if ((a.stock - adet) >= 0) {

                myCart.add(a);
                quantity.add(adet);
                totalPrice += a.getPrice() * quantity.get(myCart.indexOf(a));
                a.setStock(a.stock - adet);
            } else {
                System.out.printf("Adet stocktan fazla olamaz!!!%nÜrün %s Stoğu: %d%nAdeti: %d%n%n", a.getName(), a.stock, adet);
            }
        }else{
            System.out.println("You have to log in!!!");
        }
    }

    static void listCart(){

        if (didLogin) {
            System.out.println("Products on your cart:");
            int count = 0;
            for (Products a : myCart) {
                if (quantity.get(count) != 0) {
                    System.out.printf("Name: %s%nAdet: %d%n%n", a.getName(), quantity.get(count));
                }
                count++;
            }
            System.out.printf("Total price: %.2f", totalPrice);
        }else {
            System.out.println("You have to log in!!!");
        }
    }
}
