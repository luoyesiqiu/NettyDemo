package com.netty.demo2.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println("Client channelRead0:" + channelHandlerContext.channel().remoteAddress()+",data:"+s);
        ByteBuf byteBuf=Unpooled.copiedBuffer("Hello from client", CharsetUtil.UTF_8);

        channelHandlerContext.writeAndFlush(byteBuf);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        ByteBuf byteBuf=Unpooled.copiedBuffer("hello", CharsetUtil.UTF_8);
        int i=0;
        while(i++<1){
            ctx.writeAndFlush(byteBuf);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
