package org.mjozwk.policy;

import java.util.List;

public interface BalancingPolicy {
    String getAppropriateNode(List<String> nodes);
}
