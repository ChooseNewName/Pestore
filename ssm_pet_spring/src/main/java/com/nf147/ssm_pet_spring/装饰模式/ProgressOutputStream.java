package com.nf147.ssm_pet_spring.装饰模式;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ProgressOutputStream extends OutputStream {
    private OutputStream outputStream;

    public ProgressOutputStream (FileOutputStream fileOutputStream){
        this.outputStream = fileOutputStream;
    }

    @Override
    public void write(int b) throws IOException {
        System.out.println(">>>>>>>");
        this.outputStream.write(b);
    }
}
