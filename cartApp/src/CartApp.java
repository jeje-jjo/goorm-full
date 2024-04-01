import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class CartApp {
    public static void main(String[] args) {

        // CSV 파일들이 있는 디렉토리 지정
        String csvDirectory = "file/";
        // CSV 파일들의 경로를 저장할 리스트 생성
        List<String> csvFiles = new ArrayList<>();

        try{
            // 지정된 디렉토리를 탐색하여 모든 파일을 찾음
            csvFiles = Files.walk(Paths.get(csvDirectory))
                    // 일반 파일만 선택
                    .filter(Files::isRegularFile)
                    // 파일의 경로를 문자열로 변환
                    .map(Path::toString)
                    // .csv 확장자를 가진 파일만 선택
                    .filter(f -> f.endsWith(".csv"))
                    // 선택된 파일들의 경로를 리스트로 수집
                    .collect(Collectors.toList());
        } catch (IOException e){
            // 파일 탐색 중 오류가 발생하면 오류 메시지 출력
            e.printStackTrace();
        }

        // 상품 목록을 저장할 Set 생성
        Set<Product> productSet = new HashSet<>();

        // 각 CSV 파일을 순회하며 상품 목록을 불러옴
        for(String csvFile : csvFiles){
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

    // CSV 파일에서 상품 목록을 불러오는 메서드
    public static Set<Product> loadCsv(String filePath){
        // 상품 목록을 저장할 Set 생성
        Set<Product> set = new HashSet<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line = "";

            // 파일의 각 줄을 읽어옴
            while((line = br.readLine()) != null) {
                // 각 줄을 Product 객체로 변환
                Product product = Product.formCsv(line);
                // Product 객체를 Set에 추가
                set.add(product);
            }
        } catch (IOException e){
            // 파일 읽기 중 오류가 발생하면 오류 메시지 출력
            e.printStackTrace();
        }

        // 상품 목록 반환
        return set;


    }
}