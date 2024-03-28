public interface CartService {
    void addProductToCart(String productName, int quantity);
    void removeProductFromCart(String productName, int quantity);
    void printCart();
}