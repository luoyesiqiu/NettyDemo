package com.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream("NIOTest3.txt");
        FileChannel fileChannel=fileOutputStream.getChannel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(512);
        byte[] msg="hello world".getBytes();
        for (int i = 0; i < msg.length ;i++) {
            byteBuffer.put(msg[i]);
        }
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}
