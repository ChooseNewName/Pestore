package com.nf147.ssm_pet_spring.test;

import java.math.BigDecimal;

public class Test_suanfa {

    public static void main(String[] args) {

//        int aa[] = {18, 23, 52, 24, 7};
//
//        for (int i = 0; i < aa.length; i++) {
//            System.out.print(aa[i] + ",");
//
//        }
//        System.out.println();
//
////      冒泡排序
//        for (int i = 0; i < aa.length - 1; i++) {
//            for (int j = 0; j < aa.length - 1 - i; j++) {
//                if (aa[j] > aa[j + 1]) {
//                    int tamp = aa[j];
//                    aa[j] = aa[j + 1];
//                    aa[j + 1] = tamp;
//                }
//            }
//        }
//
//        for (int i = 0; i < aa.length; i++) {
//            System.out.print(aa[i]+",");
//
//        }
//        System.out.println();
//
//
//        System.out.println(Test_suanfa.findSum(1, 5));
        //avgNumber();
        suib();
    }


    public  static int findSum(int m, int n){
        int sum=0;
        for(int i=m;i<=n;i++){
            System.out.print("i:"+i+",");
            sum+=i;
            System.out.print("sum："+sum+",");
        }
        int nn = 0;
        System.out.println(nn+=1);
        return sum;
    }

    public static BigDecimal avgNumber(){
        BigDecimal bigDecimal = new BigDecimal(1);

        for (int i = 1;i<1001; i++) {
            bigDecimal = bigDecimal.multiply(new BigDecimal(i));
        }
        bigDecimal.scale();
        System.out.println(bigDecimal);

        return bigDecimal;
    }

    public static void suib(){
        Integer a = 12345;
        Integer b = 12345;
        System.out.println(a==b);
        int c =12345;
        System.out.println(a==c);
        System.out.println(a.equals(c));
    }
}
