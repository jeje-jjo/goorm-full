package list;

import java.util.*;

public class GroupStudy {


    public void q1181(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];

        String temp = "";
        for(int i = 0; i < n; i++){
            arr[i] = sc.next();
            if(i > 0){
                for(int j = 0; j < i; j++ ){
                    if(arr[i].length() == arr[j].length()){
                        if(arr[i].compareTo(arr[j]) < 0){
                            temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }else if(arr[i].compareTo(arr[j]) == 0){
                            arr[j] = "";
                        }
                    }
                }
            }
        };

        //1. 길이가 짧은 순서대로 정렬
        Arrays.sort(arr, (String fst, String snd) -> fst.length() - snd.length());


        // 비어있는 값 제거 후 출력
        for(int i = 0; i < n; i++){
            if(arr[i] != ""){
                System.out.println(arr[i]);
            }
        }

    }

    public void q1931(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int count = 0;
        int end = 0;
        int temp = 0;

        for(int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        for(int i = 0; i < n; i ++){
            if(end <= arr[i][0]){
                end = arr[i][1];
                count++;
            }

        }

        System.out.println(count);
    }

    public void q1918(){
        Scanner sc = new Scanner(System.in);
        Deque<String> deq = new ArrayDeque<>();
        String me = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < me.length(); i++){
            char temp = me.charAt(i);

            // 문자일 경우
            if(Character.isLetter(temp)){
                sb.append(temp);

            // ( < 이 괄호면 스택에 넣고
            }else if(temp == '(') {
                deq.addFirst(String.valueOf(temp));

                // ) < 이 괄호면 전에 ( 괄호가 나왔던 곳까지 스택에서 출력해서 sb에 넣기
            }else if(temp == ')'){
                while(!deq.isEmpty() && deq.peek().charAt(0) != '('){
                    sb.append(deq.pop());
                }
                deq.pop(); // '(' 제거, 괄호 내부 연산자 처리 후 '(' 제거

            // 괄호를 제외한 연산자일 경우 스택에 쌓음, but 이전에 들어있는 연산자보다 우선순위가 높거나 같을 경우 빼기
            }else{
                while(!deq.isEmpty() && ck(deq.peek().charAt(0)) >= ck(temp)){
                    sb.append(deq.pop());
                }
                deq.addFirst(String.valueOf(temp));
            }
        }
        // 마지막에 쌓인 것 처리하기
        while(!deq.isEmpty()){
            sb.append(deq.pop());
        }
           System.out.println(sb);
    }
    static int ck(char item){
        if(item == '(') return 0;
        else if(item == '+' || item == '-') return 1;
        else return 2; // '*', '/'
    }
}

