package com.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest4 {
    public static void main(String[] args) throws  Exception {
        FileInputStream inputStream=new FileInputStream("input.txt");
        FileOutputStream fileOutputStream=new FileOutputStream("output.txt");
        FileChannel inputChannel=inputStream.getChannel();
        FileChannel outputChannel=fileOutputStream.getChannel();
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        while (true){
            /*
             * 这个clear非常重要
             * 如果这里用flip可不可以呢？
             * 先来看看flip和clear的本质区别：
             * clear:
             *      position = 0;
             *      limit = capacity;
             * flip:
             *      limit = position;
             *      position = 0;
             * 如果一开始就调用flip
             * flip中limit==position==0
             * 导致Buffer limit一直是零，读不进数据
             */
            buffer.clear();
            int read=inputChannel.read(buffer);
            System.out.println("read:"+read);
            if(-1==read){
                break;
            }
            buffer.flip();
            outputChannel.write(buffer);

        }

        inputChannel.close();
        outputChannel.close();
    }
}
