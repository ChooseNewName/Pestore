package com.nf147.ssm_pet_spring.test;

public class Test {

    public void aaa(Object o){
        System.out.println("Object");
    }

    public void  aaa(String string){
        System.out.println("String");
    }
    public static void main(String[] args) {


        new Test().aaa(null);

//        Integer a = new Integer(3);
//        Integer b = 3;  // 将3自动装箱成Integer类型
//        int c = 3;
//        System.out.println(a == b);// false 两个引用没有引用同一对象
//        System.out.println(a == c);// true  a自动拆箱成int类型再和c比较
//
//
//        Integer f1 = 127, f2 = 127, f3 = 150, f4 = 150;
//
//        System.out.println(f1 == f2);
//        System.out.println(f3 == f4);
//
//        int[] arr = {6, 3, 8, 2, 9, 1};
//        System.out.println("排序前数组为：");
//        for (int num : arr) {
//            System.out.print(num + " ");
//        }
//        for (int i = 0;i < arr.length - 1; i++) {//外层循环控制排序趟数
//            for (int j = 0; j < arr.length - 1 - i; j++) {//内层循环控制每一趟排序多少次
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//        System.out.println();
//        System.out.println("排序后的数组为：");
//        for (
//                int num : arr) {
//            System.out.print(num + " ");
//        }
    }
}
