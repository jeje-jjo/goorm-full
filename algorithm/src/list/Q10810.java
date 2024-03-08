package list;

import java.io.*;
import java.util.Arrays;

public class Q10810 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        int fin = 0;

        for(int i = 0; i < n ; i++){
            if(ck(br.readLine())) fin++;
        }


        bw.write(String.valueOf(fin));

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean ck(String s){
        boolean[] bl = new boolean[26];
        int dumm = 0;

        for(int i = 0; i < s.length() ; i++){
            int ask = s.charAt(i);

            if(dumm != ask){
                if(bl[ask-97] == false) {
                    bl[ask - 97] = true;
                    dumm = ask;
                }else{
                    return false;
                }
            }else{
                continue;
            }
        }
        return true;
    }
}

