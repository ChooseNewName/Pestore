package com.nf147.ssm_pet_spring.静态代理;

import java.util.Random;

//静态代理类
public class MathProxy implements IMath {

    //    被代理对象
    IMath math = new Math();

    //    加
    public int add(int n1, int n2) {
//        开始时间
        long start = System.currentTimeMillis();
        lazy();
        int result = math.add(n1, n2);
        Long span = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);

        return result;
    }

    //    减
    public int sub(int n1, int n2) {
//        开始时间
        long start = System.currentTimeMillis();
        lazy();
        int result = math.sub(n1, n2);
        Long span = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);
        return result;
    }

    //    乘
    public int mut(int n1, int n2) {
//        开始时间
        long start = System.currentTimeMillis();
        lazy();
        int result = math.mut(n1, n2);
        Long span = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);

        return result;
    }

    //    除
    public int div(int n1, int n2) {
//        开始时间
        long start = System.currentTimeMillis();
        lazy();
        int result = math.div(n1, n2);
        Long span = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);

        return result;
    }


    //    模拟延时
    public void lazy() {

        try {
            int n = (int) new Random().nextInt(500);
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
