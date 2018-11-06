package com.netty.demo1;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class NettyInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    public void initChannel(SocketChannel serverSocketChannel) throws Exception {
        ChannelPipeline pipeline=serverSocketChannel.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new DataInHandler());
    }
}
