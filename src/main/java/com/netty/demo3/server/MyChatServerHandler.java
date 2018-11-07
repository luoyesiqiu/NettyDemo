package com.netty.demo3.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {
    private  static  ChannelGroup channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        Channel channel=channelHandlerContext.channel();

        channelGroup.forEach(ch -> {
            if(channel!=ch){
                ch.writeAndFlush("["+channel.remoteAddress()+"]"+"发来的消息："+s+"\r\n");

            }
            else{
                ch.writeAndFlush("【自己】"+s+"\r\n");
            }
        });
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush("客户端["+ctx.channel().remoteAddress().toString()+"]加入\n");
        channelGroup.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush("客户端["+ctx.channel().remoteAddress().toString()+"]离开\n");
    }
}
