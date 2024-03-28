import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart implements CartInterface {
    // 상품 이름을 키로, 상품 수량을 값으로 가지는 Map
    private Map<String, Integer> products;
    // 상품 정보를 담고 있는 Set
    private Set<Product> productSet;

    // 생성자에서 상품 정보 Set을 받아 초기화
    public Cart(Set<Product> productSet){
        this.products = new HashMap<>();
        this.productSet = productSet;
    }

    // 상품을 장바구니에 추가하는 메서드
    public void addProduct(String pName, int quantity){
        // 추가할 상품을 찾기 위해 상품 정보 Set을 순회
        Product productToAdd = null;
        for (Product product : productSet) {
            if (product.getName().equals(pName)) {
                productToAdd = product;
                break;
            }
        }

        // 상품 정보 Set에 해당 상품이 없는 경우 메시지 출력 후 종료
        if (productToAdd == null) {
            System.out.println("상품 목록에 존재하지 않습니다. 해당하지 않는 상품 : " + pName);
            return;
        }

        // 상품 재고가 없는 경우 메시지 출력 후 종료
        if (!productToAdd.hasStock()){
            System.out.println("상품의 재고가 존재하지 않습니다. 해당하지 않는 상품 : " + pName);
        }

        // 장바구니에 상품 추가 (이미 있는 상품인 경우 수량 증가)
        this.products.put(productToAdd.getName(), this.products.getOrDefault(productToAdd.getName(), 0) + quantity);
    }

    // 상품을 장바구니에서 제거하는 메서드
    public void removeProduct(String pName, int quantity) {
        // 장바구니에 해당 상품이 없는 경우 메시지 출력 후 종료
        if (!this.products.containsKey(pName)) {
            System.out.println("장바구니에 해당 상품이 존재하지 않습니다. 해당하지 않는 상품 : " + pName);
            return;
        }

        // 장바구니에서 상품 제거 (제거 후 수량이 0이면 상품 정보 자체를 제거)
        int currentQuantity = this.products.get(pName);
        if (currentQuantity > quantity) {
            this.products.put(pName, currentQuantity - quantity);
        } else {
            this.products.remove(pName);
        }
    }

    // 장바구니에 담긴 상품과 수량을 출력하는 메서드
    @Override
    public void printCart() {
        for(Map.Entry<String, Integer> entry : this.products.entrySet()) {
            System.out.println("Product Name: " + entry.getKey() + ", Quantity: " + entry.getValue());
        }
    }
}