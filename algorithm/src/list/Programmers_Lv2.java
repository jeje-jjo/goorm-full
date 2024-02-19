package list;

import java.util.Arrays;

public class Programmers_Lv2 {

    public int t01(int n){
        int ans = 0;

        // 1. 앞으로 한 칸을 점프하거나, 현재까지 온 거리 x 2에 해당하는 위치로 순간이동 가능
        // 2. 앞으로 k 칸을 점프하면 k 만큼의 건전지 사용량이 듦.
        // 3. 순간이동을 하면 건전지 사용량이 들지 않음.
        // 4. 거리가 n이 될 때까지 최소한의 건전지 사용량을 구하라.

        while (n > 0){
            if (n % 2 == 0){
                n /= 2;
            } else {
                n -= 1;
                ans++;
            }
        }

        return ans;
    }

    public int t02(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int min = 0;

        for(int max = people.length - 1; min <= max; max--){
            if(people[min] + people[max] <= limit){
                min++;
            }
            answer++;
        }

        return answer;
    }

    public int t03(int[] arr) {
        int answer = arr[0];

        for(int i = 1; i < arr.length; i++){
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }


    public static int gcd(int a, int b){
        if (a % b == 0){
            return b;
        }
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b){
        return a * b / gcd(a, b);
    }

    public int t04(int n, int a, int b)
    {
        int answer = 0;

        while ( true ){
            if ( a == b ){
                break;
            }

            // 1 2 -> 1
            // 3 4 -> 2
            // 5 6 -> 3
            a = a/2 + a%2;
            b= b/2 + b%2;
            answer ++;
        }

        return answer;
    }

    public long t05(int n) {
        long answer = 0;

        long[] dp = new long[2001];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }

        return dp[n];
    }

    public int t06(int k, int[] tangerine) {
        int answer = 0;
wh
        Arrays.sort(tangerine);


        return answer;
    }

}
