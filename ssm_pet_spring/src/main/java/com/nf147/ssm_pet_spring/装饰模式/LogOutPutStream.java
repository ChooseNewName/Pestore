package com.nf147.ssm_pet_spring.装饰模式;

import java.io.IOException;
import java.io.OutputStream;

public class LogOutPutStream extends OutputStream {

    private OutputStream outputStream;

    public LogOutPutStream(OutputStream outputStream){

        this.outputStream = outputStream;
    }

    @Override
    public void write(int b) throws IOException {
        //this.outputStream.write(b);

    }

    @Override
    public void write(byte[] b) throws IOException {
        System.out.println("开始了啊》》》》》");
        super.write(b);
        System.out.println("结束了啊！！！！");
    }
}
