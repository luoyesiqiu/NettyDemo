package com.netty.demo6;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtoBufTestServerHandler extends SimpleChannelInboundHandler<DataInfo.Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Message msg) throws Exception {

        if(msg.getDataType()== DataInfo.Message.DataType.PersonType){
            System.out.println(msg.getPerson().getName());
            System.out.println(msg.getPerson().getAge());
            System.out.println(msg.getPerson().getAddress());
        }
        else if(msg.getDataType()== DataInfo.Message.DataType.DogType) {
            System.out.println(msg.getDog().getName());
            System.out.println(msg.getDog().getAge());
        }
        else{
            System.out.println(msg.getCat().getName());
            System.out.println(msg.getCat().getCity());
        }
    }
}
