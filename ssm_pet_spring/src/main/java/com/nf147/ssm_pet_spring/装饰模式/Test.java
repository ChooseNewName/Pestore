package com.nf147.ssm_pet_spring.装饰模式;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        FileOutputStream foustream = new FileOutputStream("E:/aaa.txt");
        ProgressOutputStream progressOutputStream = new ProgressOutputStream(foustream);
        LogOutPutStream logOutPutStream = new LogOutPutStream(progressOutputStream);

        logOutPutStream.write("Hello.wrold+444".getBytes());
    }

}
