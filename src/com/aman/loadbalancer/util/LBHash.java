package com.aman.loadbalancer.util;

import com.aman.loadbalancer.api.HashFunction;

public class LBHash implements HashFunction {
    @Override
    public Integer hash(String toHash) {
        //TODO:implement with a real hash function
        return null;
    }
}
