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

}
