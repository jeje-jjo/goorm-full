package list;

import java.io.*;
import java.util.*;

public class Q20115 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deq = new ArrayDeque<>();
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        for(int num : nums){
            deq.add(num);
        }

        double fin = 0;
        int intFin = 0;

        while(!deq.isEmpty()){

            // 제일 앞의 값을 뺌
            double fst = deq.pollFirst();

            // fin이 0이라면 첫번재 순서니까 제일 뒤랑 비교
            if(fin == 0){
                double last = deq.pollLast();
                fin = (fst/2) + last;

            // 아니라면 fin과 fst를 비교해서 작은 값 % 2
            }else{

                fin = (fst > fin) ? (fin/2) + fst : (fst/2) + fin;
            }

        }

        intFin = (int) fin;
        if((double)intFin == fin){
            bw.write(String.valueOf(intFin));
        }else{
            bw.write(String.valueOf(fin));
        }




        bw.flush();
        bw.close();
        br.close();
    }
}
