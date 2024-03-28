import java.util.Set;

public class ProductServiceImpl implements ProductService {
    private Set<Product> productSet;

    public ProductServiceImpl(Set<Product> productSet) {
        this.productSet = productSet;
    }

    @Override
    public void addProduct(String productName, int quantity, int price) {
        productSet.add(new Product(productName, quantity, price));
    }

    @Override
    public void removeProduct(String productName) {
        productSet.removeIf(product -> product.getName().equals(productName));
    }

    @Override
    public void printProducts() {
        for (Product product : productSet) {
            System.out.println("Product Name: " + product.getName() + ", Quantity: " + product.getQuantity() + ", Price: " + product.getPrice());
        }
    }
}