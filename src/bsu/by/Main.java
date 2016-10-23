package bsu.by;


import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BooleanVector a[] = new BooleanVector [4];
        for(int i = 0; i<4; i++){
            a[i] = new BooleanVector(8);
        }
        try {
            System.out.println(Arrays.toString(a));
            BooleanVector con = a[0].conunc(a[2]);
            System.out.println("Conunction a[0] and a[2]: ");
            System.out.println(con);
            BooleanVector diz = a[2].dizunc(a[1]);
            System.out.println("dizunction a[2] and a[1]: ");
            System.out.println(diz);
            BooleanVector inverse = a[3].inverse();
            System.out.println("inverse a[3]: ");
            System.out.println(inverse);
            System.out.println("False's values in a[0]: " + a[0].get0());
            System.out.println("True's values in a[1]: " + a[1].get1());
        }
        catch(ErrorSize e){
            System.out.println("ERROR");
        }
    }
}

