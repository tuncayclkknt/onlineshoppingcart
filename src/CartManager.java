public abstract class CartManager extends Cart{

    public CartManager(String name, String surname, String username, String password, String email) {
        super(name, surname, username, password, email);
    }

    static void changeItem(Products a, int newQuantity){

        if (myCart.contains(a)) {
            int indexOfProduct = myCart.indexOf(a);
            //totalPrice += quantity.get(indexOfProduct) * a.price;

            if (newQuantity != 0)
                totalPrice -= (quantity.get(indexOfProduct) - newQuantity) * a.price;
            else {
                totalPrice -= quantity.get(indexOfProduct) * a.price;
            }

            quantity.set(indexOfProduct, newQuantity);
            a.setStock(Products.InitialStocks.get(indexOfProduct) - newQuantity);
        }else {
            System.out.printf("%s is not found on your cart!!!%n",a.getName());
        }
    }


    static void clearCart(){
        myCart.clear();
        quantity.clear();
        Cart.totalPrice = 0;
        System.out.println("Your Cart Has Been Cleared!\n");
    }
}
