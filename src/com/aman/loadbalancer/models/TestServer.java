package com.aman.loadbalancer.models;

import com.aman.loadbalancer.api.Server;

//servers that we will need to add in the consisten hashing ring.
public class TestServer implements Server {


    private String ip ;

    public TestServer(String ip) {
        this.ip = ip;
    }
    public String getIp() {
        return ip;
    }
    @Override
    public void service() {
        System.out.println("test method service method running.");
    }
}
