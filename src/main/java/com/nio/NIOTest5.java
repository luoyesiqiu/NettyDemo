package com.nio;

import java.nio.ByteBuffer;

public class NIOTest5 {
    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(64);
        buffer.putInt(15);
        buffer.putLong(60000000000000L);
        buffer.putDouble(3.14159);
        buffer.putChar('我');
        buffer.putShort((short)2);
        buffer.putChar('你');
        buffer.flip();
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getDouble());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
        System.out.println(buffer.getChar());
    }
}
