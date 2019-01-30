package com.nio;

import java.nio.ByteBuffer;

public class NIOTest7 {
    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(10);
        System.out.println(buffer.getClass());
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);

        }
        //复制出来一个只读Buffer,其中的position,limit,capacity独立
        ByteBuffer readonlyBuffer=buffer.asReadOnlyBuffer();
        System.out.println(readonlyBuffer.getClass());
    }
}
