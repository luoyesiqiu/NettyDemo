package com.netty.demo6;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class ProtoBufTestClientHandler extends SimpleChannelInboundHandler<DataInfo.Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Message msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        int randomInt =new Random().nextInt(3);
        DataInfo.Message message=null;
        if(0==randomInt){
            message= DataInfo.Message.newBuilder()
                    .setDataType(DataInfo.Message.DataType.PersonType)
                    .setPerson(DataInfo.Person.newBuilder()
                            .setName("张三")
                            .setAge(22)
                            .setAddress("北京朝阳区").build())
                    .build();
        }
        else if(1 == randomInt){
            message= DataInfo.Message.newBuilder()
                    .setDataType(DataInfo.Message.DataType.DogType)
                    .setDog(DataInfo.Dog.newBuilder()
                            .setName("二哈")
                            .setAge(22)
                            .build())
                    .build();
        }else{
            message= DataInfo.Message.newBuilder()
                    .setDataType(DataInfo.Message.DataType.CatType)
                    .setCat(DataInfo.Cat.newBuilder()
                            .setName("橘猫")
                            .setCity("南宁")
                            .build())
                    .build();

        }

        ctx.writeAndFlush(message);
    }
}
