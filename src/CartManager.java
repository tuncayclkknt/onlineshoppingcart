public abstract class CartManager extends Cart{

    static void changeItem(Products a, int newQuantity){

        if (User.didLogin) {
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

                System.out.printf("Quantity of %s has been changed to %d.%n",a.getName().toLowerCase(),newQuantity);
            } else {
                System.out.printf("%s is not found on your cart!!!%n", a.getName().toLowerCase());
            }
        }else{
            System.out.println("You have to log in!!!");
        }
    }


    static void clearCart(){
        if (User.didLogin){
            myCart.clear();
            quantity.clear();
            Cart.totalPrice = 0;
            System.out.println("Your Cart Has Been Cleared!\n");
        }else {
            System.out.println("You have to log in!!!");
        }
    }
}
