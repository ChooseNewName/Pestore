//package com.nf147.ssm_pet_spring.动态代理;
//
//
//import java.lang.reflect.Method;
//import java.util.Random;
//
//public class DynamicProxy implements MethodInterceptor {
//
//    //    被代理对象
//    Object object;
//
//    //    动态生成一个新的类
//    public Object getProxyObject(Object object) {
//        this.object = object;
////        增强器，动态代码生成器
//        Enhancer enhancer = new Enhancer();
////        回调方法
//        enhancer.setCallback(this);
////        设置生成类的父类类型
//        enhancer.setSuperclass(object.getClass());
////        动态生成字节码并返回代理对象
//        return enhancer.create();
//    }
//
//    //    拦截方法
//    @Override
//    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
////        被植入的横切内容，开始时间 before
//        long start = System.currentTimeMillis();
//        lazy();
//
////        调用方法
//
//        Object result = methodProxy.invoke(object, objects);
//
////        被植入的横切内容，结束时间
//        Long span = System.currentTimeMillis() - start;
//        System.out.println("共用时：" + span);
//        return result;
//    }
//
//    //    模拟延时
//    public void lazy() {
//
//        try {
//            int n =(int) new Random().nextInt(500);
//            Thread.sleep(n);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
