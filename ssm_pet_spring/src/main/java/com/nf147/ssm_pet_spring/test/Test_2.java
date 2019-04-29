package com.nf147.ssm_pet_spring.test;

import org.testng.annotations.Test;

public class Test_2 {

//    {
//        System.out.println("父类代码块");
//    }
    static {
        System.out.println("父类静态代码块！");
    }
    public Test_2(){
        System.out.println("父类构造器。");
    }



    @Test
    public void test_2(){
        String a ="12";
        String b="123";
        if (a.equals(b)){
            System.out.println("值相等");
        }else{
            System.out.println("salfjal");
        }
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

}
