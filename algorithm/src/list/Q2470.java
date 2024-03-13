package list;

import java.io.*;
import java.util.*;

public class Q2470 {
    static  List<Integer> pos;
    static  List<Integer> neg;

    static int fin = 0;

    static int p = 0;
    static int ne = 0;


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


        // 양수가 비었다면 음수
        if(pos.isEmpty()){
            bw.write(neg.get(1) + " " + neg.get(0));
        }else if(neg.isEmpty()){
            bw.write(pos.get(0) + " " + pos.get(1));
        }else if(!pos.isEmpty() && !neg.isEmpty()){

            if(neg.size() > 1 && pos.size() > 1) {
                // 음수보다 양수가 클 경우
                if ((neg.get(0) + neg.get(1)) * -1 < pos.get(0) + pos.get(1)) {
                    ne = neg.get(1);
                    p = neg.get(0);
                    fin = neg.get(0) + neg.get(1);
                } else {
                    ne = pos.get(0);
                    p = pos.get(1);
                    fin = pos.get(0) + pos.get(1);
                }
            }

            if(pos.size() < 2){
                if( (fin < 0 ? fin * -1 : fin) > (neg.get(0) + neg.get(1) < 0 ? neg.get(0) + neg.get(1) * -1 : neg.get(0) + neg.get(1) ) ){
                    ne = neg.get(1);
                    p = neg.get(0);
                    fin = ne + p;
                }
            }else if(neg.size() < 2){
                if( (fin < 0 ? fin * -1 : fin) > (pos.get(0) + pos.get(1) < 0 ? pos.get(0) + pos.get(1) * -1 : pos.get(0) + pos.get(1) ) ){
                    ne = pos.get(0);
                    p = pos.get(1);
                    fin = ne + p;
                }
            }
            rf(0, 0);
            bw.write(ne + " " + p);

        }


        bw.flush();
        bw.close();
        br.close();
    }

    public static void rf(int pidx, int nidx){

        int pnum = pos.get(pidx);
        int nnum = neg.get(nidx);



        int pChange = pnum + nnum < 0 ? (pnum + nnum) * -1 : pnum+nnum;

        if(pnum + nnum == 0){
            fin = pnum + nnum;
            p = pnum;
            ne = nnum;


        }else {

            // 인덱스 기준으로 두 값이 fin보다 0에 가깝다면 (양수로 변환해서 더 작은 값이라면)
            if (pChange < (fin < 0 ? fin * -1 : fin)) {
                fin = pnum + nnum;
                p = pnum;
                ne = nnum;
            }

            // 합계가 0보다 크면 양수이동
            if (pidx < pos.size() - 1 && pnum + nnum < 0) {
                rf(pidx+1, nidx);
            } else if (nidx < neg.size() - 1 && pnum + nnum > 0) {
                rf(pidx, nidx + 1);
            } else {


            }


        }
    }
}
