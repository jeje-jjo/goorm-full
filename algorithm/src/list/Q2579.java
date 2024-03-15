package list;

import java.io.*;
import java.util.Arrays;

public class Q2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];


        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int dp[] = new int[n+1];

        if(n == 1){
            bw.write(Integer.toString(arr[1]));
        }else if(n == 2){
            bw.write(Integer.toString(arr[1] + arr[2]));
        }else{

            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];

            for(int i = 3; i <= n; i++){
                dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];

                System.out.println("dp[" + i + "] = " + dp[i]);
            }
        }

        bw.write(Integer.toString(dp[n]));

        bw.flush();
        bw.close();
        br.close();
    }
}
