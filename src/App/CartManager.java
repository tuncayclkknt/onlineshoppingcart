package App;

import DataBaseConnection.DeleteData;
import DataBaseConnection.UpdataData;

public abstract class CartManager extends Cart{

    // sepetteki ürünün miktarını ve gerekli değişimleri yapar, toplam fiyat, stok...
    static void changeItem(Products a, int newQuantity){
        if (User.didLogin) {
            if (myCart.contains(a)) {
                int indexOfProduct = myCart.indexOf(a);

                if (newQuantity != 0)
                    totalPrice -= (quantity.get(indexOfProduct) - newQuantity) * a.price;
                else {
                    totalPrice -= quantity.get(indexOfProduct) * a.price;
                }

                quantity.set(indexOfProduct, newQuantity);
                System.out.println(Products.InitialStocks.get(indexOfProduct));
                a.setStock(Products.InitialStocks.get(indexOfProduct) - newQuantity);
                System.out.printf("Quantity of %s has been changed to %d.%n",a.getName().toLowerCase(),newQuantity);

                UpdataData update = new UpdataData();
                update.updateStockDataBase(a,a.getStock());
                update.updateQuantityOnCartDataBase(a,newQuantity);
                update.updateCartPriceDataBase(a,newQuantity);

            } else {
                System.out.printf("%s is not found on your cart!!!%n", a.getName().toLowerCase());
            }
        }else{
            System.out.println("You have to log in!!!");
        }
    }

    // sepeti boşaltır
    static void clearCart(){
        if (User.didLogin){
            myCart.clear();
            quantity.clear();
            Cart.totalPrice = 0;
            System.out.println("Your App.Cart Has Been Cleared!\n");

            DeleteData delete = new DeleteData();
            delete.deleteCartItems();

            UpdataData updata = new UpdataData();

            for (int i=0; i<Products.product.size(); i++){
                Products.product.get(i).setStock(Products.InitialStocks.get(i));

                updata.updateStockDataBase(Products.product.get(i),Products.InitialStocks.get(i));
            }

        }else {
            System.out.println("You have to log in!!!");
        }
    }
}
