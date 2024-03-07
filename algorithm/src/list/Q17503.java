package list;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q17503 {

    static int n;          // 맥주 축제 열리는 기간
    static int m;         // 선호도의 합
    static int k;          // 마실 수 있는 맥주 총 개수


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[1] == o2[1]) return Integer.compare(o2[0], o1[0]);
                return Integer.compare(o1[1], o2[1]);
            }
        });

        for(int i = 0; i < k; i++){
           st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           que.offer(new int[] {a, b});
        }

        int sum = 0;
        int num = 0;
        int sums[] = new int[10];
        int sumIndex = 0;
        int max = 0;
        boolean ck = true;

        while(ck){

            for(int i = 0; i < n ; i++){
                sum = 0;

                //첫번째일 경우 꺼내서 지우기
                if(i == 0){
                    sum += que.poll()[1];

                // 마지막일 경우 최댓값이니까 max에 넣기
                }else if(i == n-1){
                    max = que.peek()[1];
                    sum += max;
                }else{
                    sum += que.peek()[1];
                }
            }

            // sum이 m보다 클 경우 바로 중단
            if(sum >= m){
                ck = false;

            // 마지막 인덱스 - n 임에도 끝나지 않을 경우 -1 리턴하고 중단
            }else if(num == k-n){
                max = -1;
                ck = false;
            }
            num++;
        }


        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
        br.close();


    }
}
