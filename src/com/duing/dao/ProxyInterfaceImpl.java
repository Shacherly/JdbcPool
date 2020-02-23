package com.duing.dao;

public class ProxyInterfaceImpl implements ProxyInterface {
    @Override
    public void doSmothing(String things) {
        System.out.println("I have told u, I " + things);
    }
}
