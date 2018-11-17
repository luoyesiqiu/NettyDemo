package com.netty.demo6;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtoBufTestClientHandler extends SimpleChannelInboundHandler<DataInfo.Person> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Person msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        DataInfo.Person person=DataInfo.Person.newBuilder()
                .setName("李明")
                .setAge(23)
                .setAddress("南宁")
                .build();
        ctx.writeAndFlush(person);

    }
}
