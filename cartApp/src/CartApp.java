import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class CartApp {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String csvDirectory = "file/";
        List<String> csvFiles = new ArrayList<>();

        try{
            csvFiles = Files.walk(Paths.get(csvDirectory))
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .filter(f -> f.endsWith(".csv"))
                    .collect(Collectors.toList());
        } catch (IOException e){
            e.printStackTrace();
        }

        // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();

        for(String csvFile : csvFiles){
            System.out.println("Loading csv file: " + csvFile);
            productSet.addAll(loadCsv(csvFile));
        }


        // 상품 클래스를 생성해서 상품 목록에 넣기
        Product product1 = new Product("Apple", 10,1000);
        Product product2 = new Product("Banana", 10, 2000);
        Product product3 = new Product( "Cherry", 5, 3000);

        productSet.add(product1);
        productSet.add(product2);
        productSet.add(product3);

        // 상품 목록 확인
        System.out.println("고유 상품 목록");
        for(Product product : productSet){
            System.out.println(product.getName() + ", " + product.getPrice());
        }

        // 장바구니 생성
        Cart myCart = new Cart(productSet);

        // 상품을 장바구니에 추가
        myCart.addProduct("Banana", 1);
        myCart.addProduct("Apple", 2);
        myCart.addProduct("Cherry", 3);


        // 상품을 장바구니에서 제거
        myCart.removeProduct("Banana", 1);

        // 장바구니에 현재 담긴 상품들을 출력 (상품 이름, 각 상품의 갯수)
        myCart.printCart();

    }


   public static Set<Product> loadCsv(String filePath){
        Set<Product> set = new HashSet<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line = "";

            while((line = br.readLine()) != null) {
                Product product = Product.formCsv(line);
                set.add(product);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return set;
   }
}
























