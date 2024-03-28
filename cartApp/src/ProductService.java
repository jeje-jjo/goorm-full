public interface ProductService {
    void addProduct(String productName, int quantity, int price);
    void removeProduct(String productName);
    void printProducts();
}