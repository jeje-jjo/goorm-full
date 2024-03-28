public class CartServiceImpl implements CartService {
    private Cart cart;

    public CartServiceImpl(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void addProductToCart(String productName, int quantity) {
        cart.addProduct(productName, quantity);
    }

    @Override
    public void removeProductFromCart(String productName, int quantity) {
        cart.removeProduct(productName, quantity);
    }

    @Override
    public void printCart() {
        cart.printCart();
    }
}