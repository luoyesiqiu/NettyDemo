package com.nio;

import java.nio.ByteBuffer;

public class NIOTest6 {

    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }
        buffer.position(2);
        buffer.limit(6);

        //创建快照，不会复制一份
        ByteBuffer sliceBuffer=buffer.slice();
        for (int i = 0; i < sliceBuffer.capacity(); i++) {
            byte b =sliceBuffer.get(i);
            b*=2;
            sliceBuffer.put(b);
        }

        buffer.position(0);
        buffer.limit(buffer.capacity());
        while(buffer.hasRemaining()){
            System.out.println(buffer.get());
        }
    }
}
