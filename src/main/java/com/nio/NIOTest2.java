package com.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream=new FileInputStream("NIOTest2.txt");
        FileChannel fileChannel=fileInputStream.getChannel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(512);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();

        while(byteBuffer.remaining()>0){
            byte b=byteBuffer.get();
            System.out.println("Character："+(char)b);
        }
        fileInputStream.close();
    }
}
