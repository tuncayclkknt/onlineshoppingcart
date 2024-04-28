
public class Main {
    public static void main(String[] args) {

        UserManager u1 = new UserManager("Tuncay","Çelikkanat","tncy","şifre");

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
        System.out.println(u1.getEmail());

        u1.toplamkisiler();
        System.out.println("-------------------------------------------------------------------");

        Products p1 = new Products("Kalem","yazıyor işte",120.99,10);
        Products p2 = new Products("Silgi","siliyor işte", 9.99,13);
        Products p3 = new Products("Kaset","çalıyor işte ama eski",999.10,1);

        Products.addProduct(p1);
        Products.addProduct(p2);
        Products.addProduct(p3);

        Products.listProducts();

        Cart.addToCart(p1, 10);
        Cart.addToCart(p2, 12);

        CartManager.changeItem(p1,1);
        CartManager.changeItem(p2,0);
        //sepetteki "p1" ürününün adetini güncellemeye yarıyor.

        //CartManager.clearCart(); çalışıyorr

        Cart.listCart();

        System.out.println();
        System.out.println();

        Products.listProducts();

        //sepete eklenen adet kısmında sorun var // hallettimmmm(tuncay)

    }
}
