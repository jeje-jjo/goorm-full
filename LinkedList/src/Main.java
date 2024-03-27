

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(11);
        list.add(2);
        list.add(3);

        list.delete(1);

        // for-each 루프를 이용한 순회
        for (int num : list) {
            System.out.println(num);
        }
    }
}