package App;

import DataBaseConnection.*;

public class Main {
    public static void main(String[] args) {
        User u1 = new UserManager("name","surname","username","password","mail@example.com");
        User u2 = new UserManager("name","surname","username","password","mail@example.com");
        User u3 = new UserManager("name","surname","username","password","mail@example.com");

//        Create.createNewDatabase("Project");
//        Create.createUserTable();
//        Create.createProductTable();
//        Create.createCartTable();

//        u1.register("Tuncay","Çelikkanat","tncy","şifre","tuncayclkknt@gmail.com");
//        u2.register("Fatih","Sarıkoç","ffatih","ABC","fsarıkoç@gmail.com");

        u1.login("enes","1234");
//        u1.logout();

//        u1.updateUsername("tncy","enes");
//        u1.updatePassword("enes","1234");
//        u1.updateEmail("enescan@gmail.com");
//        u1.updateNameAndSurname("Enes Can", "Uğurtepe");

        Products p1 = new Products("Pencil","You can write everything you want",10.99,100);
        Products p2 = new Products("Book","An interesting story",150.50,30);
        Products p3 = new Products("Smart Phone","8 gb RAM and 128 gb ROM",549.99,350);

        Products.updateName(p1,"Pen");
        Products.updateDescription(p1,"Tittle writing");
        Products.updatePrice(p1,5);
        Products.updateStock(p1,55);
//        Products.listProducts();

        Cart.addToCart(p1,10);
        Cart.addToCart(p2,3);
        Cart.addToCart(p3);
//        Cart.listCart();
        CartManager.changeQuantityOfItem(p1,5);
        Cart.listCart();

    }
}
