package com.appache.hadoop.rpc.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Client {
    private static Log logger = LogFactory.getLog(Client.class);

    public Client() throws IOException {
        InetSocketAddress addr = new InetSocketAddress("localhost", 9000) ;
        MyProtocol proxy = RPC.getProxy(MyProtocol.class, MyProtocol.versionID, addr,
                                                new Configuration()) ;
        logger.info("收到服务端消息："+proxy.echo());
    }

    public static void main(String[] args) throws IOException {
        new Client() ;
    }

}