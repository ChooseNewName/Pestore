package com.nf147.ssm_pet_spring.test;


import org.testng.annotations.Test;

import java.io.*;

public class Test_3 {

    public static void main(String[] args) throws IOException {
//      列出一个目录下的所有文件
        File f = new File("E:\\");
        for (File temp : f.listFiles()) {
            if (temp.isFile()) {
                System.out.println(temp);
            }
        }

    }


    //  字符流读取一个文件的内容
    @Test
    public void fileRead() throws IOException {
        char[] c = new char[500];       // 设置一个足够大的数组
        FileReader fileReader = new FileReader("E://aaa.txt");
        int num = fileReader.read(c);       // 读取文件里的内容到数组里，并返回读取的长度
        String str = new String(c);         // 把数组转为字符串
        System.out.println("读取的字符个数为：" + num + ",其内容如下：" + str);
        fileReader.close();                 // 关闭流
    }

    //  字节输出流读取一个文件的内容
    @Test
    public void inputStream() throws IOException {
        byte[] c = new byte[500];               // 定义一个字节数组存内容
        File file = new File("E://aaa.txt");    // 获取文件路径
        FileInputStream fileInputStream = new FileInputStream(file);    // 创建一个字节流
        int num = fileInputStream.read(c);          // 读取文件内容，并把读取到内容存到数组里
        String str = new String(c);                 // 把数组转为字符串
        System.out.println("读取到的内容长度为：" + num);
        System.out.println("读取到的内容：" + str);
        fileInputStream.close();                    // 关闭流
    }

    //   字符输入流把内容写入文件里面
    @Test
    public void fileWrite() throws IOException {
        String str = "追加把";        // 准备好需要需要写入的内容
//      如果不想覆盖掉原来文件的内容，则在路径后加一个参数，
//      该参数是否追加在原内容后面，默认为 false
        FileWriter fileWriter = new FileWriter("E://aaa.txt", true);
        fileWriter.write(str);
        fileWriter.append("我想追加啊");
        fileWriter.close();
        fileRead();
    }

    //  字节输入流把内容写入文件里面
    @Test
    public void fileOutputStream() throws IOException {
        byte[] a = {'a', 's', 'd', 'f', 'g'};       // 创建一个字节数组
        // 如果不想覆盖掉原来文件的内容，则在路径后加一个参数,
        // 该参数是否追加在原内容后面，默认为 false
        FileOutputStream outputStream = new FileOutputStream("E://aaa.txt",true);    // 创建一个字节输入流
        outputStream.write(a);                        // 把内容写到文件里
        outputStream.close();                       // 关闭流
        inputStream();                                // 调用字节输出流查看内容
    }
}
