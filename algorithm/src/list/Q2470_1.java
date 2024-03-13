package list;

import java.io.*;
import java.util.*;

public class Q2470_1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int minSum = Integer.MAX_VALUE;
        int num1 = 0, num2 = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                num1 = arr[left];
                num2 = arr[right];
            }

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                // 합이 0이면 더 이상 탐색할 필요가 없음
                break;
            }
        }

        bw.write(num1 + " " + num2 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
