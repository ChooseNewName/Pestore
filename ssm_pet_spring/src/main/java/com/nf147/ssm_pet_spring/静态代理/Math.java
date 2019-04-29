package com.nf147.ssm_pet_spring.静态代理;

public class Math implements IMath {
    @Override
    public int add(int n1, int n2) {
        int result = n1 + n2;
        System.out.println(n1 + "+" + n2 + "=" + result);
        return result;
    }

    @Override
    public int sub(int n1, int n2) {
        int result = n1 - n2;
        System.out.println(n1 + "-" + n2 + "=" + result);
        return result;
    }

    @Override
    public int mut(int n1, int n2) {
        int result = n1 * n2;
        System.out.println(n1 + "*" + n2 + "=" + result);
        return result;
    }

    @Override
    public int div(int n1, int n2) {
        int result = n1 / n2;
        System.out.println(n1 + "/" + n2 + "=" + result);
        return 0;
    }



}
