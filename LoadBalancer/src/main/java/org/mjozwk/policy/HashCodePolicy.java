package org.mjozwk.policy;

import java.util.List;

public class HashCodePolicy implements BalancingPolicy {

    private final String clientIp;

    public HashCodePolicy(String clientIp) {
        this.clientIp = clientIp;
    }

    @Override
    public String getAppropriateNode(List<String> nodes) {
        int hashCode = getClientIp().hashCode();
        int index = hashCode % nodes.size();
        return nodes.get(index);
    }

    private String getClientIp() {
        return clientIp;
    }
}
