package list;

import java.io.*;

public class Q13699 {

 //   static int num1;
 //   static int num2;

 //   static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] l = new long[n+1];


        l[0] = 1;
        l[1] = 1;
        l[2] = 2;



        for(int i = 1; i <= n ; i++){
            long sum = 0;



            for(int j = 0; j < i / 2 ; j++) {
                sum += l[j] * l[i - 1 - j];
            }

            sum *= 2;
            l[i] = i%2 == 0 ? sum : sum + l[i/2] * l[i/2];

        }

        bw.write(String.valueOf(l[n]));

        bw.flush();
        bw.close();
        br.close();
    }


}
