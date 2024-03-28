public interface CartInterface {
    void addProduct(String pName, int quantity);
    void removeProduct(String pName, int quantity);
    void printCart();
}
