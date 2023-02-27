package org.mjozwk;

import org.mjozwk.policy.BalancingPolicy;

import java.util.List;

public class LoadBalancer {

    private final IpStore ipStore;
    private final BalancingPolicy balancingPolicy;

    public LoadBalancer(IpStore ipStore, BalancingPolicy balancingPolicy) {
        this.ipStore = ipStore;
        this.balancingPolicy = balancingPolicy;
    }

    public String getNode() {
        List<String> ipList = ipStore.getIpList();
        return balancingPolicy.getAppropriateNode(ipList);
    }
}
