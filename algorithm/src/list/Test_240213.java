package list;

import java.util.Stack;

public class Test_240213 {

    public int t01(String s){

        // 1. 같은 알파벳이 2개 붙어 있는 짝을 찾는다.
        // 2. 그 짝을 제거한다.
        // 3. 앞뒤로 문자열을 이어 붙인다.
        // 4. 1~3을 반복한다.
        // 5. 문자열 제거가 성공적으로 이루어졌을 경우 1, 아닐 경우 0을 리턴한다.

        int answer = -1;
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1:0;
    }


    public int[] t03(int brown, int yellow){
        int[] answer = {0, 0};
        int sum = brown + yellow;


        for(int i = 3 ; i <= sum/3 ; i ++){
            answer[0] = sum/i;

            if(answer[0] >= i && (i-2) * (answer[0] -2) == yellow ){
                answer[1] = i;
                break;
            }
        }        return answer;
    }


}
