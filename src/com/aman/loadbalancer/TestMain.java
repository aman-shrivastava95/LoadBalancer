package com.aman.loadbalancer;

import com.aman.loadbalancer.Service.ConsistentHashing;
import com.aman.loadbalancer.api.Server;
import com.aman.loadbalancer.models.TestServer;

public class TestMain {
    public static void main(String[] args) {
        TestServer server1 = new TestServer("10.10.100.1") ;
        TestServer server2 = new TestServer("10.10.100.2") ;
        ConsistentHashing balancer = new ConsistentHashing() ;
        balancer.add(server1);
        balancer.add(server2) ;
        //this code will add them to the consistent hashing ring.

    }
}
