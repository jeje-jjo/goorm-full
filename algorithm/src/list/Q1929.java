package list;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Q1929 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();

        Arrays.setAll(arr, num -> num+1);
        list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        int sett = 2;

        while(true){

            int num = list.get(sett);

            //arr = Arrays.stream(arr).filter(num -> num % finalSett != 0 && num > 3).toArray();
            list.removeIf(item -> item % num == 0 && item != num);

            if(list.size()-1 > sett){
                sett++;
            }else{
                break;
            }

        }

        System.out.println(Arrays.toString(arr));


        for(int i = 2; i <= n; i++){

            // 리스트에 아무 값이 없다면 넣기
            if(list.isEmpty()){
                list.add(i);
            }else{
                // 제곱근 구하기
                for(int j = 0; j < list.size(); j++){

                    // i % list.get(j) 가 0이라면 배수이므로 빠져나감
                    if( i % list.get(j) == 0){
                        break;
                    }else{
                        // j가 list의 마지막인지 확인 후 list에 add
                        if(j == list.size()-1 ){
                            list.add(i);
                        }
                    }
                }
            }
        }


        for(int num : list){
            if(num >= m )bw.write(num + "\n");
        }


        //bw.write(Arrays.toString(arr));


        bw.flush();
        bw.close();
        br.close();
    }
}
