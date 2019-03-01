package com.appache.hadoop.rpc.example;

import org.apache.hadoop.ipc.VersionedProtocol;

import java.io.IOException;

/**
 * 自定义的protocol协议,Hadoop中的protocal相当于定义一个接口
 */
public interface MyProtocol extends VersionedProtocol {

    public static final long versionID = 1L ;
    public String echo() throws IOException;

}