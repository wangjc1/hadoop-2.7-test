package com.appache.hadoop.rpc.example;

import org.apache.hadoop.ipc.ProtocolSignature;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyProtocolImpl implements MyProtocol {

    @Override
    public long getProtocolVersion(String protocol, long clientVersion) throws IOException {
        return MyProtocol.versionID;
    }

    @Override
    public ProtocolSignature getProtocolSignature(String protocol, long clientVersion,
                                                  int clientMethodsHash)
            throws IOException {
        return new ProtocolSignature(MyProtocol.versionID, null);
    }

    @Override
    public String echo() throws IOException {   
        Calendar cal = Calendar.getInstance() ;
        Date date = cal.getTime() ;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss") ;
        return sdf.format(date) ;
    }

}