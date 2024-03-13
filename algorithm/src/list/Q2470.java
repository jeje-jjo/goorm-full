package list;

import java.io.*;
import java.util.*;

public class Q2470 {

    static  List<Integer> pos;
    static  List<Integer> neg;

    static int fin = 1000000000;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        pos = new ArrayList<>();
        neg = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){

            int in = Integer.parseInt(st.nextToken());


            if(in > 0){
                pos.add(in);
            }
            else{
                neg.add(in);
            }

        }

        pos.sort(Comparator.naturalOrder());
        neg.sort((i1, i2) -> i2 - i1);

        rf(0, 0);


        bw.write(pos.toString() + "\n");
        bw.write(neg.toString() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void rf(int pidx, int nidx){

        int pnum = pos.get(pidx);
        int nnum = neg.get(nidx);

        System.out.println("현재 pnum : " + pnum + " |    현재 nnum : " + nnum + " |     현재 fin : " + fin + " |      두개 합 : " + (pnum+nnum ));

        // 인덱스 기준으로 두 값이 fin보다 0에 가깝다면 (양수로 변환해서 더 작은 값이라면)
        if( (pnum + nnum < 0 ? (pnum + nnum) * -1 : pnum+nnum )  < fin){
            fin = pnum + nnum;


        }

        // nidx의 마지막이 아니라면 nidx+1
        if(nidx < neg.size()-1){
            rf(pidx, nidx+1);
            // pidx의 마지막이 아니면서 nidx의 마지막이라면
        }else if(pidx < pos.size()-1 && nidx == neg.size()-1){
            rf(pidx+1 , 0);
            // 둘 다 아니라면 끝
        }else{
            System.out.println("순회끝!!!");
            System.out.println("fin : " + fin);
        }

    }
}
