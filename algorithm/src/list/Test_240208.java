package list;

import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.Scanner;

public class Test_240208 {
    public void t11382(){
        // 꼬마 정민이는 이제 A + B 정도는 쉽게 계산할 수 있다. 이제 A + B + C를 계산할 차례이다!
        // 첫 번째 줄에 A, B, C (1 ≤ A, B, C ≤ 1012)이 공백을 사이에 두고 주어진다.
        // A+B+C의 값을 출력한다.
        Scanner sc = new Scanner(System.in);
        ArrayList numList = new ArrayList();
        long sum = 0;

        for(int i = 0; i <= 2; i++){
            numList.add(sc.nextLong());
            sum += Long.parseLong(numList.get(i).toString());
        }
        System.out.println(sum);
    }

    public void t25314(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int div = num / 4;
        String sum = "";

        for(int i = 0; i < div ; i ++){
            sum = sum + "long ";
        }

        sum = sum + "int";

        System.out.println(sum);
    }

    public void t10807() {
        // 총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.
        // 첫째 줄에 정수의 개수 N(1 ≤ N ≤ 100)이 주어진다. 둘째 줄에는 정수가 공백으로 구분되어져있다.
        // 셋째 줄에는 찾으려고 하는 정수 v가 주어진다. 입력으로 주어지는 정수와 v는 -100보다 크거나 같으며, 100보다 작거나 같다.
        // 첫째 줄에 입력으로 주어진 N개의 정수 중에 v가 몇 개인지 출력한다.
        Scanner sc = new Scanner(System.in);
        int leng = Integer.parseInt(sc.nextLine());
        String nums = sc.nextLine();
        int target = Integer.parseInt(sc.nextLine());
        int sum = 0;
        String[] numList = nums.split(" ");

        for(int i = 0; i < leng ; i ++){
            if(Integer.parseInt(numList[i]) == target){
                sum ++;
            }
        }
        System.out.println(sum);

    }



    public void t0001(){
        int answer = 0;
        int num = 3;
        Long [] res = new Long[num];
        int ret = 0;

        res[0] = 1L;
        res[1] = 1L;

        for(int i = 2; i < num; ++i){
            res[i] = (res[i-1] + res[i-2]) % 1234567;
        }
        ret = Math.toIntExact(res[num-1]);

        System.out.println(ret);
    }



}
