package com.nf147.ssm_pet_spring.静态代理;

public class Test {
    //    实例化一个DynamicProxy 代理对象
    //    通过 getProxyObject 方法获得被代理对象后
    IMath math = new MathProxy();

    //@org.junit.Test
    public void test01() {
        int n1 = 577,n2 = 3;
        math.add(n1,n2);
        math.sub(n1,n2);
        math.mut(n1,n2);
        math.div(n1,n2);

    }
}
