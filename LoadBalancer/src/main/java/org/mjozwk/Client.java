package org.mjozwk;

import org.mjozwk.policy.BalancingPolicy;
import org.mjozwk.policy.HashCodePolicy;
import org.mjozwk.policy.RandomPolicy;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Client {



    public static void main(String[] args) throws NoSuchAlgorithmException {
        var ipStore = new IpStore();

//        var hashPolicy = new HashCodePolicy("192.168.0.1");
        var randomPolicy = new RandomPolicy();

//        List<BalancingPolicy> balancingPolicies = List.of(hashPolicy, randomPolicy);
        LoadBalancer loadBalancer = new LoadBalancer(ipStore, randomPolicy);
        for (int i = 0; i < 10; i++) {
            String server = loadBalancer.getNode();
            System.out.println("select server: "+server);
        }
    }
}