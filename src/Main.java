import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserManager u1 = new UserManager("name","surname","username","password","mail@example.com");

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

        u1.toplamkisiler();
        System.out.println("-------------------------------------------------------------------");

        Products p1 = new Products("Kalem","yazıyor işte",120.99,10);
        Products p2 = new Products("Silgi","siliyor işte", 9.99,13);
        Products p3 = new Products("Kaset","çalıyor işte ama eski",999.10,1);

        Products.addProduct(p1);
        Products.addProduct(p2);
        Products.addProduct(p3);

        Products.updateStock(p1,12);

        Products.listProducts();

        Cart.addToCart(p1, 10);
        Cart.addToCart(p2, 12);
        //adet stocktan fazla olduğunda hata veriyor try cath yapılacak (bir şeyler yaptım gerek kalmadı ama neden bilmiyorum)

        for(Products x:Cart.myCart)
            System.out.println(x.getName()); // for control

        CartManager.changeItem(p1,5);
        CartManager.changeItem(p2,7);
        //sepetteki "p1" ürününün adetini güncellemeye yarıyor.
        // if else eklenecek eğer sepetteyse adet değiştir diye (eklendi ) enes

        // totalprice değişimleri ayarlandı ama stock değişimleri AYARLANMADI (tuncay)(sıkıldığım için) //ayarlandı (enes)

        //CartManager.clearCart(); //çalışıyorr

        for(int x:Cart.quantity)
            System.out.println(x); //for control

        Cart.listCart();

        System.out.println();
        System.out.println();

        Products.listProducts();
        //sepete eklenen adet kısmında sorun var // hallettimmmm(tuncay)
    }
}
