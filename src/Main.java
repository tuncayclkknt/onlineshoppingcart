import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserManager u1 = new UserManager("name","surname","username","password","mail@example.com");
        UserManager u2 = new UserManager("name","surname","username","password","mail@example.com");
        UserManager u3 = new UserManager("name","surname","username","password","mail@example.com");

        u1.register("Tuncay","Çelikkanat","tncy","şifre","tuncayclkknt@gmail.com");

        u1.login("tncy","şifre");
        System.out.println();

        System.out.println(u1.getUsername());
        System.out.println(u1.getPassword());
        System.out.println(u1.getEmail());
        System.out.println();

        u1.updateUsername("tncy","enes");

        u1.updatePassword("enes", "4321");

        u1.updateEmail("enescann");
        System.out.println();

        System.out.println(u1.getUsername());
        System.out.println(u1.getPassword());
        System.out.println(u1.getEmail() + "\n");

        System.out.println("-------------------------------------------------------------------");

        Products p1 = new Products("Kalem","yazıyor işte",120.99,10);
        Products p2 = new Products("Silgi","siliyor işte", 9.99,13);
        Products p3 = new Products("Kaset","çalıyor işte ama eski",999.10,1);

        Products.addProduct(p1);
        Products.addProduct(p2);
        Products.addProduct(p3);

        p1.discount(0.31);

        Products.updateStock(p1,12);

        Products.listProducts();

        Cart.addToCart(p1, 10);
        Cart.addToCart(p2, 12);
        Cart.addToCart(p3);

        System.out.println("---------------------------");
        for(Products x:Cart.myCart)
            System.out.println(x.getName()); // for control
        System.out.println("---------------------------");

        CartManager.changeItem(p1,5);
        CartManager.changeItem(p2,7);

        //CartManager.clearCart(); //çalışıyorr

        System.out.println("---------------------------");
        for(int x:Cart.quantity)
            System.out.println(x); //for control
        System.out.println("---------------------------");

        Cart.listCart();

        System.out.println();
        System.out.println();

        Products.listProducts();
    }
}
