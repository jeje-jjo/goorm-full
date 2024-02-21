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
        Stack<String> st = new Stack<>();
        String me = sc.nextLine();
        String ch = "";
        String[] arr = new String[me.length()];
        for(int i = 0; i < me.length(); i++){
            ch = String.valueOf(me.charAt(i));
            System.out.println(ch + " >> " + (int)me.charAt(i));
            // '(' 괄호가 있을 경우 선처리
            if((int)me.charAt(i) == 40){
                arr[i] = String.valueOf(me.charAt(i+1));
                arr[i+1] = String.valueOf(me.charAt(i+3));
                arr[i+2] = String.valueOf(me.charAt(i+2));
                i += 4;
            }else if(d){
                arr[i] = String.valueOf(me.charAt(i));
            }
        }

        System.out.println(Arrays.toString(arr));


    //    System.out.println();

    }
}

