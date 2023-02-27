package org.mjozwk.policy;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

public class RandomPolicy implements BalancingPolicy {
    private final Random rand = SecureRandom.getInstanceStrong();

    public RandomPolicy() throws NoSuchAlgorithmException {
    }

    @Override
    public String getAppropriateNode(List<String> nodes) {
        int nodeIndex = rand.nextInt(nodes.size());
        return nodes.get(nodeIndex);
    }
}
