import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart implements CartInterface {
    private Map<String, Integer> products;
    private Set<Product> productSet;

    public Cart(Set<Product> productSet){
        this.products = new HashMap<>();
        this.productSet = productSet;
    }

    public void addProduct(String pName, int quantity){
        Product productToAdd = null;
        for (Product product : productSet) {
            if (product.getName().equals(pName)) {
                productToAdd = product;
                break;
            }
        }

        if (productToAdd == null) {
            System.out.println("상품 목록에 존재하지 않습니다. 해당하지 않는 상품 : " + pName);
            return;
        }

        if (!productToAdd.hasStock()){
            System.out.println("상품의 재고가 존재하지 않습니다. 해당하지 않는 상품 : " + pName);
        }

        this.products.put(productToAdd.getName(), this.products.getOrDefault(productToAdd.getName(), 0) + quantity);
    }

    public void removeProduct(String pName, int quantity) {
        if (!this.products.containsKey(pName)) {
            System.out.println("장바구니에 해당 상품이 존재하지 않습니다. 해당하지 않는 상품 : " + pName);
            return;
        }

        int currentQuantity = this.products.get(pName);
        if (currentQuantity > quantity) {
            this.products.put(pName, currentQuantity - quantity);
        } else {
            this.products.remove(pName);
        }
    }

    @Override
    public void printCart() {
        for(Map.Entry<String, Integer> entry : this.products.entrySet()) {
            System.out.println("Product Name: " + entry.getKey() + ", Quantity: " + entry.getValue());
        }
    }
}