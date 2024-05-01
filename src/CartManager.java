public abstract class CartManager extends Cart{

    static void changeItem(Products a, int newQuantity){

        int indexOfProduct = myCart.indexOf(a);
        totalPrice -= quantity.get(indexOfProduct) * a.price;
        quantity.add(indexOfProduct, newQuantity);
        totalPrice += quantity.get(indexOfProduct) * a.price;
    }

    static void clearCart(){
        myCart.clear();
        Cart.totalPrice = 0;
        System.out.println("Your Cart Has Been Cleared!\n");
    }
}
