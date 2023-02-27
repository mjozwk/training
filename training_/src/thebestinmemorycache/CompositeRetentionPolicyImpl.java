package thebestinmemorycache;

import java.util.ArrayList;
import java.util.List;

class CompositeRetentionPolicyImpl implements CompositeRetentionPolicy {
    private List<RetentionPolicy> policies;

    public CompositeRetentionPolicyImpl() {
        this.policies = new ArrayList<>();
    }

    @Override
    public void addRetentionPolicy(RetentionPolicy policy) {
        policies.add(policy);
    }

    @Override
    public boolean shouldRemove(CacheItem item, long currentTime) {
        for (RetentionPolicy policy : policies) {
            if (policy.shouldRemove(item, currentTime)) {
                return true;
            }
        }
        return false;
    }
}
