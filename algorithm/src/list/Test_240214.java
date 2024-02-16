package list;

import java.util.HashSet;

public class Test_240214 {

    public int[] t01(int n, String[] words) {
        int[] answer = {0, 0};
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < words.length; i++){

            // 첫번째 순서는 비교값이 없으므로 제외 && 전 순서의 마지막 글자와 현재 글자의 첫번째 순서가 다를 경우
            if(i != 0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                // 탈락자의 번호는  n의 배수에서 나머지 순서이므로 나머지를 구하고, 인덱스는 0으로 시작하기 때문에 +1
                // 탈락자의 순서는 n으로 나눈 몫에 +1
                answer[0] = i% n + 1;
                answer[1] = Math.round(((float) (i + 1) /n));
                break;
            }else{
                set.add(words[i].toString());
                if(set.size() != i+1){
                    answer[0] = i% n + 1;
                    answer[1] = Math.round(((float) (i + 1) /n));


                    break;
                }
            }

        }

        return answer;
    }
}
