package com.appache.hadoop.rpc.example;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

public class Server {

    public Server() throws HadoopIllegalArgumentException, IOException {
        Configuration conf = new Configuration() ;
        org.apache.hadoop.ipc.RPC.Server server = new RPC.Builder(conf).
                                setProtocol(MyProtocol.class).setInstance(new MyProtocolImpl()).
                                setBindAddress("localhost").setPort(9000).setNumHandlers(5).build() ;
        server.start(); 
    }

    public static void main(String[] args) throws HadoopIllegalArgumentException, IOException {
        new Server() ;
    }
}