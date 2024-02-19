import list.Programmers_Lv2;
import list.Test_240208;
import list.Test_240213;
import list.Test_240214;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Test_240208 t01 = new Test_240208();
        Test_240213 t02 = new Test_240213();
        Test_240214 t03 = new Test_240214();
        Programmers_Lv2 p = new Programmers_Lv2();

        // t01.t11382();
        // t01.t25314();
        // t01.t10807();
        // t01.t0001();

        //System.out.println(Arrays.toString(t02.t03(24, 24)));
        //System.out.println(Arrays.toString(t03.t01(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        // System.out.println(p.t02(new int[]{ 70, 50, 80}, 100));
        System.out.println(p.t03(new int[]{2, 6, 8, 14}));
    }

}



/*
제출용
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
 */