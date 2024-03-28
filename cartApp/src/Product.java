import java.util.Objects;

public class Product implements Comparable<Product>{

    private static int nextKey = 1;
    private int key;
    private String name;
    private int price;
    private int quantity;

    // 생성자에서 상품 이름, 수량, 가격을 받아 초기화
    public Product(String name, int quantity, int price){
        this.key = nextKey++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // 각 필드에 대한 getter, setter 메서드
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // equals 및 hashCode 메서드 구현
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return key == product.key && price == product.price && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, price);
    }

    // Comparable 인터페이스 구현
    @Override
    public int compareTo(Product otherProduct) {
        return Integer.compare(this.key, otherProduct.key);
    }

    // CSV 파일의 한 줄을 받아 Product 객체를 생성하는 메서드
    public static Product formCsv(String csvLine){
        String[] fields = csvLine.split(",");
        String name = fields[0];
        int quantity = Integer.parseInt(fields[1]);
        int price = Integer.parseInt(fields[2]);
        return new Product(name, quantity, price);
    }

    // 상품 재고가 있는지 확인하는 메서드
    public boolean hasStock(){
        return this.quantity > 0;
    }

    public int getQuantity() {
        return quantity;
    }
}