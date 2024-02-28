    package list;

    import java.util.*;

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
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int item : tangerine){
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));

        int i = 0;
        while (k > 0){
            k -= map.get(list.get(i));
            i++;
        }

        return answer;
    }


    public int t07(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        int cnt = 1;

        // 우선 카운트를 순회하면서 나가기
        while(cnt <= elements.length){

            //첫번째부터 el의 길이만큼 순차로 순회하면서 더하기
            for(int i = 0; i < elements.length; i++){
                int sum = 0;
                for(int j = i; j < i + cnt; j++){
                    sum += elements[j%elements.length];
                }
                set.add(sum);
                cnt++;

            }
        }

        answer = set.size();


        return answer;
    }

    public int t08(int[] elements) {
        int answer = 0;
        // 중복허용 안 되도록
        HashSet<Integer> hs = new HashSet<>();

        int s = 1;
        while(s <= elements.length){

            for(int i = 0; i < elements.length; i ++){
                int sum = 0;
                for(int j = i ; j < i + s ; j++){
                    sum += elements[j % elements.length];
                }
                hs.add(sum);
            }
            s++;
        }

        return hs.size();
    }

    public int t09(String s){
        int answer = 0;

        for(int i = 0 ; i < s.length() ; i ++){
            String next = s.substring(i, s.length()) + s.substring(0, i);
            Deque<Character> deq = new ArrayDeque<>();


            for(int j = 0; j <next.length(); j ++){
                char c = next.charAt(j);
                if(deq.isEmpty()){
                    deq.push(c);
                }else if(c == ')' && deq.peek() == '('){
                    deq.pop();
                }else if(c == ']' && deq.peek() == '['){
                    deq.pop();
                }else if(c == '}' && deq.peek() == '{'){
                    deq.pop();
                }else {
                    deq.push(c);
                }
            }
            if(deq.isEmpty()){
                answer++;
            }
        }
        return answer;
    }


    public int t10(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> hs = new HashMap<>();


        // 키는 want, number는 val
        // num은 변경될 예정
        for(int i = 0; i < want.length; i++){
            hs.put(want[i], number[i]);
        }

        // 이제 discount를 돌면서 값을 똑같이 hashmap에 넣기
        // 계속해서 새로 체크할 것이기 때문에 내부에 hashmap 넣음
        for(int i = 0; i <= discount.length - 10; i++){
            HashMap<String, Integer> dis = new HashMap<>();
            boolean isTrue = true;

            for(int j = i ; j < i + 10; j++){
                dis.put(discount[j], dis.getOrDefault(discount[j], 0) + 1);
            }

            // 이제 for을 돌면서 key로 매칭하여 같은 값이 존재하는지 보면 끝
            for(String key : hs.keySet()){
                // hs의 값이 더 크면 x
                if(dis.getOrDefault(key, 0)  < hs.get(key)){
                    isTrue = false;
                    break;
                }
            }
            if(isTrue) answer++;
        }
        return answer;
    }

    public int[] t11(int n, long left, long right) {
        // 결과 배열의 크기 계산
        int[] answer = new int[(int) (right - left) + 1];

        // 범위 내의 각 인덱스에 대해 값을 계산
        for (long i = left; i <= right; i++) {
            // 현재 인덱스에 해당하는 행렬의 행과 열 계산
            int row = (int) (i / n);
            int col = (int) (i % n);

            // 행렬의 값 계산: 각 위치에서의 값은 최대(row + 1, col + 1)
            answer[(int) (i - left)] = Math.max(row, col) + 1;
        }

        return answer;
    }

    public int t12(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i ++){
            int h = citations.length - i;

            if(citations[i] >= h){
                answer = h;
                break;
            }
        }
        return answer;
    }

    public int[][] t13(int[][] arr1, int[][] arr2) {
        int[][] answer = {};

        return answer;
    }


    public int t14(String[][] clothes) {
        int answer = 0;
        HashMap<String, String> hm = new HashMap<>();

        for(int i = 0; i < clothes.length; i++){
            hm.put(clothes[i][0], clothes[i][1]);
        }


        return answer;
    }


}
