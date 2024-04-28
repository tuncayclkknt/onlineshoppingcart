public class CartManager extends Cart{

    static void changeItem(Products a, int sayı){

        int b = myCart.indexOf(a);
        totalPrice -= adets.get(b) * a.price;
        adets.add(b, sayı);
        totalPrice += adets.get(b) * a.price;
    }

    static void clearCart(){
        myCart.clear();
        Cart.totalPrice = 0;
    }
}
