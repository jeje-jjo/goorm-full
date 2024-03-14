package list;

import java.io.*;
import java.util.*;

public class Q1916 {

    static boolean[] barr;
    static int[] order;

    static int start;
    static int sum;
    static int end;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        start = 0;
        end = 0;
        sum = 0;

        barr = new boolean[n];
        order = new int[n];

        List<int[]> list = new ArrayList<>();
        //Map<Integer, int[]> map = new HashMap<>();
        TreeMap<Integer, TreeMap<Integer, Integer>> map = new TreeMap<>();

        for(int i = 0; i <= m ; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            if(i == m){
                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
            }else{
                // 맵에 넣기
                map.computeIfAbsent(Integer.parseInt(st.nextToken()), k  -> new TreeMap<>()).put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
        }




        bw.write("start : " + start + " |     end :" + end );

        for (Map.Entry<Integer, TreeMap<Integer, Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            TreeMap<Integer, Integer> innerMap = entry.getValue();
            System.out.println("Key: " + key);
            for (Map.Entry<Integer, Integer> innerEntry : innerMap.entrySet()) {
                System.out.println("    b: " + innerEntry.getKey() + ", c: " + innerEntry.getValue());
            }
        }




        bw.flush();
        bw.close();
        br.close();
    }

    public static void test(int idx){

        // barr 배열에 현재 값을 false 처리함
        // 연산 수행
        // end와 같다면 기존값과 비교, 작다면 sum을 현재 값으로 교체
        // end보다 크다면 다음 연산 수행
        // end 값과 같다면 start의 다음 키로

        barr[idx] = true;
        


    }
}
