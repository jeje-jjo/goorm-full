public interface CartInterface {
    // 상품을 장바구니에 추가하는 메서드
    void addProduct(String pName, int quantity);
    // 상품을 장바구니에서 제거하는 메서드
    void removeProduct(String pName, int quantity);
    // 장바구니에 담긴 상품과 수량을 출력하는 메서드
    void printCart();
}