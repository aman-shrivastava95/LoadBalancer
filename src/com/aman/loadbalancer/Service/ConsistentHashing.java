package com.aman.loadbalancer.Service;

import com.aman.loadbalancer.api.HashFunction;
import com.aman.loadbalancer.api.Server;
import com.aman.loadbalancer.models.TestServer;
import com.aman.loadbalancer.util.LBHash;

import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing {
    private int numberOfReplicas = 3;
    private final LBHash hashFunction = new LBHash();
    private final SortedMap<Integer, Server> circle = new TreeMap<>();//circular hash table

    //method to add all the replicas in the circle
    //other strategies can also be used to have different hash keys for same IP
    public void add(TestServer server) {
        for (int i = 0; i < numberOfReplicas; i++) {
            Integer serverKey = hashFunction.hash(server.getIp() + i);
            circle.put(serverKey, server);
        }
    }

    //method to add in the circle
    public void remove(TestServer server) {
        for (int i = 0; i < numberOfReplicas; i++) {
            Integer serverKey = hashFunction.hash(server.getIp() + i);
            circle.remove(serverKey);
        }
    }

    //merthod to get the server when the request comes with key mapped to the hash Search space
    public Server get(Integer key) {
        if (circle.isEmpty())
            return null;
        Integer hash = hashFunction.hash(key.toString()) ;
        if(!circle.containsKey(hash)){
            //tailMap used to get all the keys whose value si greater than the key provided
            SortedMap<Integer, Server> tailmap = circle.tailMap(hash) ;
            hash = tailmap.isEmpty()?circle.firstKey():tailmap.firstKey() ;
        }
        return circle.get(hash) ;
    }
}

